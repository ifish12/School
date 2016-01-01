<?php
    # =====================================================================
    # Testing validateuser.php
    # =====================================================================
    
    # Note: don't need to explicitly test if JSON string is returned,
    #       because if it isn't, this test program would crash,
    #       indicating an error
    
    test_authenticate_user();

    function test_authenticate_user(){
        print_r("authenticate_user tests\n");
        # ---------------------------------------------------------------------
        # Test 1 -> valid username/password
        # ---------------------------------------------------------------------
        $result = authenticate_user_post(array('email' => 'testSerena', 'pass' => 'hunter.2'));
        # Expected Result:
        #    status: not a null string,
        #    error: null string
        
        $obj=json_decode($result,true);
        print_pass_fail (1, $obj,
            isset($obj['status']) && $obj['status'] && isset($obj['error']) && ! $obj['error'],
            'valid username, valid password'
        );
        
        # ---------------------------------------------------------------------
        # Test 2 -> valid username/ invalid password
        # ---------------------------------------------------------------------
        $result = authenticate_user_post(array('email' => 'testSerena', 'pass' => 'hunter'));
        
        # Expected Result:
        #    status: anything,
        #    error: not a null string
        
        $obj=json_decode($result,true);
        print_pass_fail (2, $obj,
            isset($obj['status']) && isset($obj['error']) && $obj['error'],
            'valid username, invalid password'
        );
        
        # ---------------------------------------------------------------------
        # Test 3 -> invalid username/ valid password 
        # ---------------------------------------------------------------------
        $result = authenticate_user_post(array('email' => 'test', 'pass' => 'hunter.2'));
        
        # Expected Result:
        #    status: anything,
        #    error: not a null string
        
        $obj=json_decode($result,true);
        print_pass_fail (3, $obj,
            isset($obj['status']) && isset($obj['error']) && $obj['error'],
            'invalid username, valid password'
        );
        
        # ---------------------------------------------------------------------
        # Test 4 -> empty username
        # ---------------------------------------------------------------------
        $result = authenticate_user_post(array('email' => '', 'pass' => 'hunter.2'));
        
        # Expected Result:
        #    status: anything,
        #    error: not a null string
        
        $obj=json_decode($result,true);
        print_pass_fail (4, $obj,
            isset($obj['status']) && isset($obj['error']) && $obj['error'],
            'empty username'
        );
        
        # ---------------------------------------------------------------------
        # Test 5 -> empty password 
        # ---------------------------------------------------------------------
        $result = authenticate_user_post(array('email' => 'testSerena', 'pass' => ''));
        
        # Expected Result:
        #    status: anything,
        #    error: not a null string
        
        $obj=json_decode($result,true);
        print_pass_fail (5, $obj,
            isset($obj['status']) && isset($obj['error']) && $obj['error'],
            'empty password'
        );
    }
    
    # =====================================================================
    # post to my php page for testing
    # =====================================================================
    function authenticate_user_post ($data) {
        
        $url = 'https://test-superdogy92.c9.io/php/validateuser.php';
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
    # Inputs:  test case number, associative array, pass/fail, test description
    # ====================================================================
    function print_pass_fail ($tc, $obj, $true, $descr) {
        if ($true) {
            print "test $tc passed\t$descr\n";
        }
        else {
            print "test $tc FAILED\t$descr\n";
            var_dump($obj); #print it to give a hint as to what went wrong
        }
    }
?>