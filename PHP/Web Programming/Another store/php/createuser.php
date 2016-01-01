<?php
session_start();
require ("../db/db_functions.php");


$status["status"] = ""; 
$status["errors"] = array(); # array of exit codes for registration
$status["exception"] = "";

for ($i = 0; $i < 6; $i++)
      $status["errors"][$i] = 0;

# ============================================================================ #
# valid_input                                                                  #
#                                                                              #
# Purpose: validates inputs are both valid and exist                           #
# Outputs: returns true/false based on validity of posted variables            #
#                                                                              #
# Possible exit codes:                                                         #
# - 0: everything was perfect, no issues                                       #
# - 1: field was either blank, too long or had invalid characters              # 
# - 2(passwords only): cpass and pass do not match                             #
# indeces parallel to order of validations                                     #
# (e.g. 0=>email, 1=>password, 2=>cpass, 3=>first name, etc.)                  #
# ============================================================================ #

function valid_input(){
      $valid = true;
      global $status;
      
      # ------------------------ Check if inputs exist and are valid ------------------------ #
      
      if ( ! isset($_POST['email']) || $_POST['email'] == "" || strpos($_POST['email'], " ") !== false || strlen($_POST['email']) > 20) 
            $status["errors"][0] = 1;
      
      if ( ! isset($_POST['pass']) || $_POST['pass'] == "" || strpos($_POST['pass'], " ") !== false|| strlen($_POST['pass']) > 20) 
            $status["errors"][1] = 1;
      
      if ( ! isset($_POST['cpass']) || $_POST['cpass'] == "" || strpos($_POST['cpass'], " ") !== false || strlen($_POST['cpass']) > 20) 
            $status["errors"][2] = 1;
            
      if ($_POST['pass'] != $_POST['cpass'])
            $status["errors"][2] = 2;
      
      if ( ! isset($_POST['fname']) || $_POST['fname'] == "" || strpos($_POST['fname'], " ") !== false || strlen($_POST['fname']) > 25) 
            $status["errors"][3] = 1;
      
      if ( ! isset($_POST['lname']) || $_POST['lname'] == "" || strpos($_POST['lname'], " ") !== false || strlen($_POST['lname']) > 25) 
            $status["errors"][4] = 1;
      
      if ( ! isset($_POST['birth']) || $_POST['birth'] == "") 
            $status["errors"][5] = 1;
      
      if ( ! isset($_POST['gender']) || $_POST['gender'] == "") 
            $status["errors"][6] = 1;
      
      for ($i = 0; $i < 6; $i++)
            if ($status["errors"][$i] != 0){
                  $valid = false;
                  break;
            }
      
      return $valid;
      
}

# ============================================================================ #
# Exite codes(email only):                                                     #
# - 0: everything was ok                                                       #
# - 2: email already being used                                                #
# ============================================================================ #

if (valid_input()) {
      $rc = false;
      $exception = false;
      
       # ------------------------ Try to insert data into database ------------------------ #
      try {
            $rc = create_user($_POST['email'],$_POST['pass'],$_POST['fname'], $_POST['lname'], $_POST['birth'], $_POST['gender']);
      }
      catch (Exception $e){
            error_log($e->getMessage()."\n", 3, "../errors/error.log");
            $exception = true;
      }
      if ($exception) 
            $status['exception']="There is an issue with the server. Please try again later";
      else {
            if ($rc) 
                  $status['status'] = "New user created";
            else 
                  $status['errors'][0] = 2;
      }
}
echo json_encode($status);
?>