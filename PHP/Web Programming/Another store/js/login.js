$("#login").on("click", validate_inputs);

/*******************************************************************************************
    VALIDATE_INPUTS
    
    Purpose: Validates all user inputs.
    Output: On validation error, fields will be flagged as incorrect.
*******************************************************************************************/

function validate_inputs(){
    
    // ------------------ Get inputs from user ------------------
    var email = $('#email').val();
    var pass = $('#pass').val();
    var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    var valid = true;
    
    // ------------------ Email valid (contains @ and .com/ca/etc)? ------------------
    if (email.length == 0){
        $('#eError').html("Field is required");
        valid = false;   
    }
    else if (regex.test(email) == false || email.length > 40){
        $('#eError').html("Must be a valid email address and cannot exceed 40 characters.");
        valid = false;    
    }
     else
         $('#eError').html("");
    
    // ------------------ Password valid (correct length, no spaces)? ------------------    
    if (pass.length == 0){
        $('#pError').html("Password can't be blank.");
        valid = false;    
    }
    else if(pass.length > 20 || pass.indexOf(" ") != -1){
        $('#pError').html("Password cannot exceed 20 characters or contain spaces.");
        valid = false;    
    }
     else
         $('#pError').html("");

    // ------------------ Post data to validateuser.php to login ------------------     
    if(valid)
         $.post (
                 "validateuser.php",
                 {"email": email, "pass": pass},
                     validate_login
                 );
}

/*******************************************************************************************
    VALIDATE_LOGIN
    
    Purpose: Check whether or not the user has logged in.
    Output: User created/invalid password or username.
*******************************************************************************************/

function validate_login(data, status){
    // ------------------ Parse json object -----------------
    var results = JSON.parse(data);

    //  ------------------ Was there any errors? ------------------
    if(results.status == ""){
        $('#logError').html(results.error);
        
    }
    
    else
        alert(results.status);
}