<?php
$dir = dirname(__FILE__);
require("../db/db_functions.php");

include("$dir/../smarty/libs/Smarty.class.php");



// create object
$smarty = new Smarty;

$dir = dirname(__FILE__);


$status["status"] =""; 
$status["error"] = "";
$status["table"] = "";
$status["currSize"] = "";
# ============================================================================
# validate inputs exists
# ============================================================================

if ( ! isset($_POST['page']) || ! is_numeric($_POST['page'])) { // making sure page is set and a number, if not we return an error
      $status["error"] = "Invalid page"; 
      echo json_encode($status);
      exit;
}

if ( ! isset($_POST['size']) || ! is_numeric($_POST['size'])) { // making sure page size is set and a number,  if not we return an error
      $status["error"] = "Invalid size";
      echo json_encode($status);
      exit;
}


$exception = false;
 # ------------------------ Try to pull data from the database ------------------------ #
try {
      $rc = get_products($_POST['page'],$_POST['size'], ""); // get our items from the database
}
catch (Exception $e) {
      error_log($e->getMessage()."\n", 3, "../errors/error.log"); // log error message
      $exception = true;
}

 # ------------------------ Checking if we got an error from the database ------------------------ #
if ($exception) {
      $status['error'] = "There is an issue with the server. Please try again later"; // set error so user isn't confused
}
else { # no error. check if we got products
      if (count($rc)==0) { // no products to show
            $status['status'] = "No products to show"; 
      }
      else {
            $status['status'] = "Got products";
            $smarty->assign("products", $rc); // fill products.tpl will our data
            $table = $smarty->fetch("$dir/../tpl/products.tpl"); // get the table and store the html in a string
            $status['table'] = $table; // put the string in our json 
            $status['currSize'] = count($rc);
      }
      
}
echo json_encode($status);
?>