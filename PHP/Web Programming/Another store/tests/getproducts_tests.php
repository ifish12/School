<?php
    error_reporting(E_ALL);
    require("db/db_functions.php");
//return empty row on stupid filter
    setup_db();
    tests();
    function setup_db(){
        _reset_product_data();
        create_product("test1",  "mediocre bedsheets",     "", 1.5);
        create_product("test2",  "This is product2",     "", 2.5);
        create_product("test3",  "This is product3",     "", 3.5);
        create_product("test4",  "cool camera",          "", 4.5);
        create_product("test5",  "This is product5",     "", 5.5);
        create_product("test6",  "gucci bedsheets",      "", 6.5);
        create_product("test7",  "This is product7",     "", 7.5);
        create_product("test8",  "radical sunglasses",   "", 8.5);
        create_product("test9",  "cheap camera",     "", 9.5);
        create_product("test10", "This is product10",    "", 10.5);
    }
    
    function tests(){
        # ---------------------------------------------------------------------
        # Test 1 -> get page 2, with page size of 3
        # expected result: expecting 3 items, the names being test[4-6]
        # ---------------------------------------------------------------------
        
        $page_data = get_products(2, 3, '');
        
        print_pass_fail(1.1,  # test case number
                        $page_data, # object we are testing
                        count($page_data)==3, # condition expected
                        'page size 3, full page' # test description
                        );
                        
         print_pass_fail(1.2,  # test case number
                        $page_data, # object we are testing
                        $page_data[0]['name']=='test4'&& $page_data[2]['name']=='test6', # test condition (start/end of page)
                        'page 2, size 3, first and last products' # test description
                        );
        
        print_pass_fail(1.3,  # test case number
                        $page_data, # object we are testing
                        $page_data[1]['name']=='test5', # test condition (middle of page)
                        'page 2, size 3, middle product' # test description
                        );
        
     
        
        # ---------------------------------------------------------------------
        # Test 2 -> get page 2, with page size of 5
        # expected result: expecting 5 items. page 2 should be test6-10
        # ---------------------------------------------------------------------
        $page_data = get_products(2, 5, '');
        
        print_pass_fail( 2.1, # test case number
                        $page_data, # object that we are testing
                        count($page_data)==5, # test condition
                        'page size 5, full page' # test description
                        );
        
        print_pass_fail( 2.2, # test case number
                        $page_data, # object that we are testing
                        $page_data[0]['name']=='test6'&&$page_data[4]['name']=='test10', # test condition (start/end of page)
                        'page 2, size 5, first and last products' # test description
                        );
                        
        print_pass_fail( 2.3, # test case number
                        $page_data, # object that we are testing
                        $page_data[2]['name']=='test8', # test condition (middle of page)
                        'page 2, size 5, middle product' # test description
                        );
                        
        # ---------------------------------------------------------------------
        # Test 3 -> get all products, 
        # expected result: expecting 10 items
        # ---------------------------------------------------------------------
        $page_data = get_products(0, 0, '');
        
        print_pass_fail( 3.1, # test case number
                        $page_data, # object that we are testing
                        count($page_data)==10, # test condition()
                        'get all items' # test description
                        );
        print_pass_fail( 3.2, # test case number
                        $page_data, # object that we are testing
                        $page_data[0]['name']=='test1' && $page_data[9]['name']=='test10', # test condition(start / end of page)
                        'get all items' # test description
                        );
        print_pass_fail( 3.3, # test case number
                        $page_data, # object that we are testing
                        $page_data[3]['name']=='test4' && $page_data[6]['name']=='test7', # test condition(start / end of page)
                        'get item 4 and 5' # test description
                        );
        
        # ---------------------------------------------------------------------
        # Test 4 -> get cameras, 
        # expected result: expecting 2 items, cool camera(test4) and cheap camera(test9)
        # ---------------------------------------------------------------------
        
        $page_data = get_products(0, 0, 'camera');
        
        print_pass_fail( 4.1, # test case number
                        $page_data, # object that we are testing
                        count($page_data)==2, # test condition()
                        'get all cameras' # test description
                        );
                        
        print_pass_fail( 4.2, # test case number
                        $page_data, # object that we are testing
                        $page_data[1]['name']=='test9' && $page_data[1]['descr']=='cheap camera', # test condition()
                        'get cheap camera' # test description
                        );
        print_pass_fail( 4.3, # test case number
                        $page_data, # object that we are testing
                        $page_data[0]['name']=='test4' && $page_data[0]['descr']=='cool camera', # test condition()
                        'get cool camera' # test description
                        );
                        
        # ---------------------------------------------------------------------
        # Test 5 -> get items that cost $10.5, 
        # expected result: expecting one item. The item is test10
        # ---------------------------------------------------------------------
        $page_data = get_products(0, 0, '10.50');
      
        print_pass_fail( 5.1, # test case number
                        $page_data, # object that we are testing
                        count($page_data)==1, # test condition()
                        'get one item' # test description
                        );
                        
        print_pass_fail( 5.2, # test case number
                        $page_data, # object that we are testing
                        $page_data[0]['name']=='test10' && $page_data[0]['price']=='10.50', # test condition()
                        'get test10' # test description
                        );
    }
    
   function print_pass_fail ($tc, $obj, $true, $descr) {
        if ($true) {
            print "test $tc passed\t$descr\n";
        }
        else {
            print "test $tc FAILED\t$descr\n";
            var_dump($obj);
        }
   }
?>