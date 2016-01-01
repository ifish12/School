<?php
require("../db/db_functions.php");

$status["status"] =""; 
$status["error"] = "";
# ============================================================================
# validate inputs exists
# ============================================================================

if ( ! isset($_POST['email']) || $_POST['email'] == "") {
      $status["error"] = "Missing username";
      echo json_encode($status);
      exit;
}

if ( ! isset($_POST['pass']) ||  $_POST['pass'] == "") {
      $status["error"] = "Missing password";
      echo json_encode($status);
      exit;
}

$rc = false;
$exception = false;
 # ------------------------ Try to insert data into database ------------------------ #
try {
      $rc = validate_user($_POST['email'],$_POST['pass']);
}
catch (Exception $e) {
      error_log($e->getMessage()."\n", 3, "../errors/error.log");
      $exception = true;
}
if ($exception) {
      $status['error'] = "There is an issue with the server. Please try again later";
}
else {
      if ($rc) {
            $status['status'] = "User validated";
      }
      else {
            $status['error'] = "Invalid username or password.";
      }
      
}
echo json_encode($status);
?>