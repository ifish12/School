<?php
    # =====================================================================
    # Testing getproducts.php
    # =====================================================================
    
    # Note: don't need to explicitly test if JSON string is returned,
    #       because if it isn't, this test program would crash,
    #       indicating an error
    
    test_get_products();

    function test_get_products(){
        print_r("get_product tests\n");
        # ---------------------------------------------------------------------
        # Test 1 -> valid username/password
        # ---------------------------------------------------------------------
        $result = get_products_post(array('page' => 2, 'size' => 3));
        
      

        # Expected Result:
        #    status: not a null string,
        #    error: null string
        
        $obj=json_decode($result,true);
        print_pass_fail (1, $obj,
            count($obj)==3,
            'page size 3, full page'
        );
        
    }
       
    # =====================================================================
    # post to my php page for testing
    # =====================================================================
    function get_products_post ($data) {
        
        $url = 'https://store-ifish12.c9.io/php/getproduct.php';
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
            var_dump($obj); #print it to give a hint as to what went wrong
        }
        else {
            print "test $tc FAILED\t$descr\n";
            var_dump($obj); #print it to give a hint as to what went wrong
        }
    }
?>