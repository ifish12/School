$("#reg").on("click", validate_inputs);

/*******************************************************************************************
    VALIDATE_INPUTS
    
    Purpose: Validates all user inputs.
    Output: On validation error, fields will be flagged as incorrect.
*******************************************************************************************/

function validate_inputs(){
    
    // ------------------ Get user inputs ------------------
    var fname = $('#fname').val();
    var lname = $('#lname').val();
    var email = $('#user').val();
    var pass = $('#pass').val();
    var cpass = $('#cpass').val();
    var gender = $("input:radio[name=gender]:checked").val();
    var dob = $('#DOBYear').val() + "-" + $('#DOBMonth').val() + "-" + $('#DOBDay').val();
    var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    var valid = true;
    
    
    // ------------------ Validate Fname (no special characters/spaces/shorter 25 chars max) ------------------
    if (fname.length == 0){
        $('#fError').html("Field is required.");
        valid = false;
    }
    else if (fname.length > 25 || fname.indexOf(" ") != -1 || /^[a-zA-Z0-9- ]*$/.test(fname) == false){ 
       $('#fError').html("First name cannot be longer than 25 characters or have any special characters.");
        valid = false;
    }
    else
         $('#fError').html("");
    
    // ------------------  Validate Lname (no special characters/spaces/shorter 25 chars max) ------------------ 
    if (lname.length == 0){
        $('#lError').html("Field is required.");
        valid = false;   
    }
    else if (lname.length > 25 || lname.indexOf(" ") != -1 || /^[a-zA-Z0-9- ]*$/.test(lname) == false){ 
       $('#lError').html("Last name cannot be longer than 25 characters or have any special characters.");
        valid = false;
    }
    else
         $('#lError').html("");
    
    // ------------------ Validate Email (contains @/.com/.ca/etc, 40 chars max) ------------------     
    if (email.length == 0){
        $('#eError').html("Field is required.");
        valid = false;   
    }
    else if (email.length > 40 || email.indexOf(" ") != -1 || regex.test(email) == false){
         $('#eError').html("Must be a valid email address and cannot exceed 40 characters.");
        valid = false;    
    }
    else
         $('#eError').html("");
    
    // ------------------ Validate Pass (no spaces, 20 chars max) ------------------     
    if (pass.length == 0){
        $('#pError').html("Field is required.");
        valid = false;   
    }
    else if (pass.length > 20 || pass.indexOf(" ") != -1){
        $('#pError').html("Password cannot exceed 20 characters or contain spaces.");
        valid = false;   
    }
    else
         $('#pError').html("");
    
    // ------------------ Validate Cpass (confirmed password must match password field) ------------------
    if (cpass != pass){
        $('#cpError').html("Passwords don't match.");
        valid = false;   
    }
    else
         $('#cpError').html("");
    
    // ------------------ Post data to createuser.php to insert in database ------------------
    if(valid){
        $.post (
                 "createuser.php",
                 {"email": email, "pass": pass, "cpass": cpass, "fname": fname, "lname": lname, "gender": gender, "birth": dob},
                     validate_register
                 );
    }
}

/*******************************************************************************************
    VALIDATE_REGISTER
    
    Purpose: Check whether or not the user was created
    Output: User created/input errors
*******************************************************************************************/

function validate_register(data, status){
    
    // ------------------ Parse json object ------------------
    var results = JSON.parse(data);
    var errors = results.errors;
    
    // ------------------ Print any errors that have occured ------------------
    if(results.status == ""){
        if(results.exception == ""){
            if(errors[0] == 1)
                 $('#eError').html("Must be a valid email and cannot exceed 40 characters.");
            else if (errors[0] == 2)
                 $('#eError').html("Email already in use.");
                 
            if(errors[1] == 1)
                $('#pError').html("Password cannot be blank or exceed 20 characters.");
            
            if(errors[2] == 1)
                $('#cpError').html("Field cannot be blank or exceed 20 characters.");
            else if(errors[2] == 2)
                $('#cpError').html("Passwords do not match.");
            
            if(errors[3] == 1)
                $('#fError').html("First name cannot be longer than 25 characters or have any special characters.");
            
            if(errors[4] == 1)
                $('#lError').html("Last name cannot be longer than 25 characters or have any special characters.");
        }
        else
            alert(results.exception);
    }
    else
        alert(results.status);
        
        
}