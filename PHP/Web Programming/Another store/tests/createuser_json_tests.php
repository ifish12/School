<?php
# =========================================================================
# Testing createuser.php
# =========================================================================
    require("db/db_functions.php");
    
# ------------------------ Remove test data from table ------------------------ #
    _reset_data();
    test_create_user();
    
# =================================================================== #
#                       TEST_CREATE_USER                              #
#                                                                     #
# Purpose: Test createuser.php and data restrictions                  #
# Output: Test#, pass/fail, short description of test.                #
#         On fail, dump json object                                   #
# =================================================================== #

    function test_create_user(){
        print_r("create_user tests\n");
        $passed = true;
        # ---------------------------------------------------------------------
        # Test 1 -> valid email/ valid password 
        # ---------------------------------------------------------------------
        $result = new_user_post(array('email' => 'testSerena', 'pass' => 'hunter.2', 
                    'cpass' => 'hunter.2', 'fname' => 'Serena', 'lname' => 'Shapiro',
                    'birth' => '1996-05-21', 'gender' => 'F'));
        
        # Expected Result:
        #    status: anything,
        #    errors: all 0
        
        $obj=json_decode($result,true);
        for($i = 0; $i < 6; $i++)
            if ($obj['errors'][$i] > 0)
               $passed = false;
               
        print_pass_fail (1, $passed, $obj, 'valid email, valid password');
        
        # ---------------------------------------------------------------------
        # Test 2 -> email already exists/ valid password 
        # ---------------------------------------------------------------------
        $passed = true;
        $result = new_user_post(array('email' => 'testSerena', 'pass' => 'hunter', 
                    'cpass' => 'hunter', 'fname' => 'Serena', 'lname' => 'Shapiro',
                    'birth' => '1996-05-21', 'gender' => 'F'));
        
        # Expected Result:
        #    status: anything,
        #    errors[0]=>2
        
        $obj=json_decode($result,true);
        if($obj['errors'][0] == 2){
            for($i = 1; $i < 6; $i++)
                if ($obj['errors'][$i] > 0)
                   $passed = false;
        }
        else
            $passed = false;
        
               
        print_pass_fail (2, $passed, $obj, 'email already exists, valid password'); 
        
        # ---------------------------------------------------------------------
        # Test 3 -> empty email/ valid password 
        # ---------------------------------------------------------------------
        $passed = true;
        $result = new_user_post(array('email' => '', 'pass' => 'hunter', 
                    'cpass' => 'hunter', 'fname' => 'Serena', 'lname' => 'Shapiro',
                    'birth' => '1996-05-21', 'gender' => 'F'));
        
        # Expected Result:
        #    status: anything,
        #    errors[0]=>1
        
        $obj=json_decode($result,true);
        if($obj['errors'][0] == 1){
            for($i = 1; $i < 6; $i++)
                if ($obj['errors'][$i] > 0)
                   $passed = false;
        }
        else
            $passed = false;
        
               
        print_pass_fail (3, $passed, $obj, 'empty email, valid password'); 
        
        # ---------------------------------------------------------------------
        # Test 4 -> valid email/ invalid password/ passwords don't match 
        # ---------------------------------------------------------------------
        $passed = true;
        $result = new_user_post(array('email' => 'testRyan', 'pass' => 'hun ter', 
                    'cpass' => 'hunter', 'fname' => 'Serena', 'lname' => 'Shapiro',
                    'birth' => '1996-05-21', 'gender' => 'F'));
        
        # Expected Result:
        #    status: anything,
        #    errors[1]=>1, errors[2]=>2
        
        $obj=json_decode($result,true);
        if($obj['errors'][1] == 1){
            if($obj['errors'][2] == 2)
            for($i = 0; $i < 6; $i++)
                if ($obj['errors'][$i] > 0 && $i != 1 && $i != 2)
                   $passed = false;
        }
        else
            $passed = false;
        
               
        print_pass_fail (4, $passed, $obj, 'valid email, invalid password, passwords do not match'); 
        
        # ---------------------------------------------------------------------
        # Test 5-> valid email/ password/ fname too long 
        # ---------------------------------------------------------------------
        $passed = true;
        $result = new_user_post(array('email' => 'testRyan', 'pass' => 'hunter', 
                    'cpass' => 'hunter', 'fname' => 'Serenaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', 'lname' => 'Shapiro',
                    'birth' => '1996-05-21', 'gender' => 'F'));
        
        # Expected Result:
        #    status: anything,
        #    errors[3]=>1
        
        $obj=json_decode($result,true);
        if($obj['errors'][3] == 1){
            for($i = 0; $i < 7; $i++)
                if ($obj['errors'][$i] > 0 && $i != 3)
                   $passed = false;
        }
        else
            $passed = false;
        
               
        print_pass_fail (5, $passed, $obj, 'valid email, valid password, fname too long');
    }

# =================================================================== #
#                       NEW_USER_POST                                 #
#                                                                     #
# Purpose: Post test data to createuser.php                           #
# =================================================================== #

    function new_user_post($data){
        $url = 'https://test-superdogy92.c9.io/php/createuser.php';
        $options = array(
            'http' => array(
            'header'  => "Content-type: application/x-www-form-urlencoded\r\n",
            'method'  => 'POST',
            'content' => http_build_query($data),
            ),
        );
        
        $context  = stream_context_create($options);	#reading from options
        $result = file_get_contents($url, false, $context);	#same as doing a post in the browser
        return $result;
    }    
    
# ====================================================================
# function to print pass or fail info:
# Inputs:  test case number, pass/fail, associative array, test description
# ====================================================================

    function print_pass_fail ($tc, $true, $obj, $descr) {
        if ($true) {
            print "test $tc passed\t$descr\n";
        }
        else {
            print "test $tc FAILED\t$descr\n";
            var_dump($obj); #print it to give a hint as to what went wrong
        }
    }    
?>