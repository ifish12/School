<?php
    error_reporting(E_ALL);
    require("db/db_functions.php");
    _reset_data();
    test_create_user();
    test_validate_user();

# =================================================================== #
# test_create_user                                                    #
#                                                                     #
# Purpose: Check if users are created and restrictions are working    #
# =================================================================== #

function test_create_user(){
//*************************Test create_user success*****************************

    print_r("Testing valid user creation\n");

    if(create_user("testSerena", "hunter.2", "Serena", "IDGAF", "1337-04-20", "D"))
        print_r("Test 1 passed\n");
    else
        print_r("Test 1 failed\n");
    
     if(create_user("testRyan", "testpass", "Ryan", "Carrier", "2345-03-31", "M"))
         print_r("Test 2 passed\n");
     else
         print_r("Test 2 failed\n");
        
     if(create_user("testGeorge", "hunter.3", "George", "Moniz", "1996-08-14", "C"))
         print_r("Test 3 passed\n");
     else
         print_r("Test 3 failed\n");
        
     if(create_user("testu2", "testpass2", "Test", "User2", "1367-03-27", "F"))
         print_r("Test 4 passed\n");
     else
         print_r("Test 4 failed\n");
        
     if(create_user("testu3", "testpass3", "Test", "User3", "0001-01-01", "G"))
         print_r("Test 5 passed\n");
     else
         print_r("Test 5 failed\n");
        
    print_r("\n");
    sleep(2);
    
//******************************************************************************

//*************************Test create_user failure*****************************

     print_r("Testing Invalid User Creation\n");
    # ---------------------------------------------------------------------
    # Test 1 -> Spaces in last name
    # ---------------------------------------------------------------------
     if(create_user("test1", "hunter.2", "Ryan", "Car rier", "1923-05-23", "U"))
         print_r("Test 1 failed\n");
     else
         print_r("Test 1 passed\n");
         
    # ---------------------------------------------------------------------
    # Test 2 -> Spaces in first name
    # ---------------------------------------------------------------------  
    
     if(create_user("test_1", "password", "Ry an", "Carrier", "1923-05-23", "U"))
         print_r("Test 2 failed\n");
     else
         print_r("Test 2 passed\n");
         
    # ---------------------------------------------------------------------
    # Test 3 -> Empty Username
    # ---------------------------------------------------------------------
    
     if(create_user("", "pass", "Danny", "Sexbang", "3425-12-21", "S"))
         print_r("Test 3 failed\n");
     else
         print_r("Test 3 passed\n");
         
    # ---------------------------------------------------------------------
    # Test 4 -> Empty first name
    # ---------------------------------------------------------------------         

     if(create_user("test_4", "hunter.3", "", "Last", "1916-02-03", "X"))
         print_r("Test 4 failed\n");
     else
         print_r("Test 4 passed\n");
         
    # ---------------------------------------------------------------------
    # Test 5 -> Empty last name
    # ---------------------------------------------------------------------         
    
     if(create_user("test_5", "testpass", "First", "", "2038-09-23", "W"))
         print_r("Test 5 failed\n");
     else
         print_r("Test 5 passed\n");
         
    # ---------------------------------------------------------------------
    # Test 6 -> Empty password
    # ---------------------------------------------------------------------
        
     if(create_user("testHitler", "", "Adolf", "Hitler", "1945-04-20", "D"))
         print_r("Test 6 failed\n");
     else
         print_r("Test 6 passed\n");
        
    # ---------------------------------------------------------------------
    # Test 7 -> Empty dob
    # ---------------------------------------------------------------------

     if(create_user("testu2", "testpass2", "Jesus", "Nails", "", "L"))
         print_r("Test 7 failed\n");
     else
         print_r("Test 7 passed\n");
    
    # ---------------------------------------------------------------------
    # Test 8 -> Empty Gender
    # ---------------------------------------------------------------------    
        
    if(create_user("testu3", "testpass3", "Our", "Lord", "1850-01-01", " "))
         print_r("Test 8 failed\n");
     else
         print_r("Test 8 passed\n");

    # ---------------------------------------------------------------------
    # Test 9 -> User already exists
    # ---------------------------------------------------------------------

     if(create_user("testSerena", "testpass4", "Whatevs", "Name", "1933-06-15", "D"))
         print_r("Test 9 failed\n");
     else
         print_r("Test 9 passed\n");

    # ---------------------------------------------------------------------
    # Test 10 -> Case insensitive email/user already exists
    # ---------------------------------------------------------------------

     if(create_user("TESTSERENA", "testpass5", "Test", "Data", "2045-11-23", "T"))
         print_r("Test 10 failed\n");
     else
         print_r("Test 10 passed\n");
        
        
    print_r("\n");
    sleep(2);
    
//******************************************************************************
}

# =================================================================== #
# test_validate_user                                                  #
#                                                                     #
# Purpose: Check if users can login and restrictions are working      #
# =================================================================== #

function test_validate_user(){
//*************************Test validate_user success***************************

    print_r("Testing validate user with good data\n");

    if(validate_user("testSerena", "hunter.2"))
        print_r("Test 1 passed\n");
    else
        print_r("Test 1 failed\n");
        
    if(validate_user("testRyan", "testpass"))
        print_r("Test 2 passed\n");
    else
        print_r("Test 2 failed\n");
        
    if(validate_user("testGeorge", "hunter.3"))
        print_r("Test 3 passed\n");
    else
        print_r("Test 3 failed\n");
        
    if(validate_user("testu2", "testpass2"))
        print_r("Test 4 passed\n");
    else
        print_r("Test 4 failed\n");
        
    if(validate_user("testu3", "testpass3"))
        print_r("Test 5 passed\n");
    else
        print_r("Test 5 failed\n");
        
    print_r("\n");
    sleep(2);
        
//******************************************************************************

//*************************Test validate_user failure***************************

    print_r("Testing Invalid Login\n");

    # ---------------------------------------------------------------------
    # Test 1 -> Empty email
    # ---------------------------------------------------------------------

    if(validate_user("", "testpass8"))
        print_r("Test 1 failed.\n");
    else
        print_r("Test 1 passed\n");
        
    # ---------------------------------------------------------------------
    # Test 2 -> Empty password
    # ---------------------------------------------------------------------        
        
    if(validate_user("testSerena", ""))
        print_r("Test 2 failed\n");
    else
        print_r("Test 2 passed\n");
        
    # ---------------------------------------------------------------------
    # Test 3 -> Valid email/ invalid passowrd
    # ---------------------------------------------------------------------
        
    if(validate_user("testSerena", "testy"))
        print_r("Test 3 failed\n");
    else
        print_r("Test 3 paased\n");
        
    # ---------------------------------------------------------------------
    # Test 4 -> Invalid email/ valid password
    # ---------------------------------------------------------------------
        
    if(validate_user("burt", "hunter.2"))
        print_r("Test 4 failed\n");
    else
        print_r("Test 4 passed\n");
    
    # ---------------------------------------------------------------------
    # Test 5 -> Empty email and password
    # ---------------------------------------------------------------------
        
    if(validate_user("", ""))
        print_r("Test 5 failed\n");
    else
        print_r("Test 5 passed\n");
        
//******************************************************************************
}
?>