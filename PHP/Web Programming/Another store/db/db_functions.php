<?php

# =================================================================== #
#                       GET_DB_CONNECTION                             #
#                                                                     #
# Purpose: Establishes connection to the database                     #
# Returns: database handler                                           #
# =================================================================== #

function get_db_connection(){
    $servername = getenv('IP');
    $username = getenv('C9_USER');
    $password = "";
    $database = "c9";
    $dbport = 3306;

# ------------------------ Create db connection ------------------------ #
    $db = new mysqli($servername, $username, $password, $database, $dbport);
    return $db;
}

# =================================================================== #
#                        VALIDATE_USER                                #
#                                                                     #
# Purpose: Check if user credentials are valid                        #
# Returns: true/false                                                 #
# =================================================================== #

function validate_user($email, $pass) {
    $valid=false;

# ------------------------ Get the database connection ------------------------ #
    $db = get_db_connection();
    if ($db->connect_error) 
        throw new Exception ($db->connect_error." source:validate_user");    
    
# ------------------------ Search database for credentials ------------------------ #
    $sql = "select id from users where email=? and password=?";
    if (! $sth = $db->prepare($sql))
        throw new Exception($db->error." source:validate_user"); 

    $sth->bind_result($id);
    if(! $sth-> bind_param("ss", $email, $pass))
        throw new Exception ("Bind Param Failed: ".__LINE__." source:validate_user");
       
     if(! $sth-> execute())
        throw new Exception ($db->error.__LINE__." source:validate_user"); 
    $sth->store_result();
    
# ------------------------ Credentials valid if a row is returned ------------------------ #    
    if($sth->num_rows != 0)
        $valid=true;
    
    return $valid;
# ------------------------ Close handlers ------------------------ #
    $sth->close();
    $db->close();
}


# =================================================================== #
#                          CREATE_PRODUCT                             #
#                                                                     #
# Purpose: Inserts new product into database                          #
# Pre-Condition: name not already registered                          #
# Returns: true/false                                                 #
# =================================================================== #

function create_product($pName, $pDecr, $pImage, $pPrice){
    $new=false;
    
# ------------------------ Get database connection ------------------------ #
        $db = get_db_connection();
        if ($db-> connect_error) 
            throw new Exception ($db->connect_error." source:new_product"); 
         
# ------------------------ Check if name is already registered ------------------------ #            
        $sql = "select count(*) from products where name=?";
         if (! $sth = $db->prepare($sql))
             throw new Exception($db->error." source:new_product"); 
        
        if (! $sth->bind_param("s", $pName))
            throw new Exception ("Bind Param Failed: ".__LINE__." source:new_product");
        if (! $sth->bind_result($r))
            throw new Exception ("Bind Result Failed: ".__LINE__." source:new_product");
        if (! $sth->execute())
            throw new Exception ($db->error." source:new_product");  

        while ($sth->fetch()){
            $row['count'] = $r;
        }
        
# ------------------------ Create product if row count is 0 ------------------------ #        
            if($row['count'] == 0){
                $sql = "insert into products (name, descr, image, price)
                        values (?, ?, ?, ?)";
            if (! $sth = $db->prepare($sql))
               throw new Exception($db->error." source:new_product"); 
            
            if (! $sth->bind_param("sssd", $pName, $pDecr, $pImage, $pPrice))
                 throw new Exception ("Bind Param Failed: ".__LINE__." source:new_product");
            if (! $sth->execute())
                throw new Exception ($db->error." source:new_product");
            
            $new=true;
        }
        
# ------------------------ Close handlers ------------------------ #         
        $sth->close();
        $db->close();
        
    return $new;
}


# =================================================================== #
#                          CREATE_USER                                #
#                                                                     #
# Purpose: Inserts new user to database                               #
# Pre-Condition: Email not already registered                         #
# Returns: true/false                                                 #
# =================================================================== #

function create_user($email, $pass, $fname, $lname, $birth, $gender){
    $new=false;
    
# ------------------------ Get database connection ------------------------ #
        $db = get_db_connection();
        if ($db-> connect_error) 
            throw new Exception ($db->connect_error." source:new_user"); 
         
# ------------------------ Check if email is already registered ------------------------ #            
        $sql = "select count(*) from users where email=?";
         if (! $sth = $db->prepare($sql))
             throw new Exception($db->error." source:new_user"); 
        
        if (! $sth->bind_param("s", $email))
            throw new Exception ("Bind Param Failed: ".__LINE__." source:new_user");
        if (! $sth->bind_result($r))
            throw new Exception ("Bind Result Failed: ".__LINE__." source:new_user");
        if (! $sth->execute())
            throw new Exception ($db->error." source:new_user");  

        while ($sth->fetch()){
            $row['count'] = $r;
        }
        
# ------------------------ Create user if row count is 0 ------------------------ #        
            if($row['count'] == 0){
                $sql = "insert into users (email, password, fName, lName, birth, gender)
                        values (?, ?, ?, ?, ?, ?)";
            if (! $sth = $db->prepare($sql))
               throw new Exception($db->error." source:new_user"); 
            
            if (! $sth->bind_param("ssssss", $email, $pass, $fname, $lname, $birth, $gender))
                 throw new Exception ("Bind Param Failed: ".__LINE__." source:new_user");
            if (! $sth->execute())
                throw new Exception ($db->error." source:new_user");
            
            $new=true;
        }
        
# ------------------------ Close handlers ------------------------ #         
        $sth->close();
        $db->close();
        
    return $new;
}
# =================================================================== #
#                          GET_PRODUCTS                               #
#                                                                     #
# Purpose: Retrieves data from products table                         #
# Inputs:                                                             #
#   - page=>page of results the user wishes to see                    #
#   - size=>items per page to be displayed                            #
#   - filter=>string, matches to name and description of item         #
# Returns: Associative array containing a page of products            #
# =================================================================== #

function get_products($page, $size, $filter){
    $products = array();
    $db = get_db_connection();
    $count = 0;
    
    $db_size;
    $db_id;
    $db_name;
    $db_descr;
    $db_price;
    $db_image;
    
# ------------------------ Get number of products in database ------------------------ #  

    $db_size = _get_count();    
    
# ------------------------ Decide which products are wanted ------------------------ #  
    
    $limit = _get_limits($page, $size, $db_size);
    $sql;
        
# ------------------------ Retrieve products within limits ------------------------ #  

        $sql = "select id, name, price, descr, image from products limit ? offset ?";
        if(! $sth = $db->prepare($sql))
            throw new Exception($db->error." source:get_products"); 
        
        if(! $sth->bind_param("ii", $limit[1], $limit[0]))
            throw new Exception ("Bind Param Failed: ".__LINE__." source:get_products");
        
        $sth->bind_result($db_id, $db_name, $db_price, $db_descr, $db_image);
        
        if(! $sth->execute())
            throw new Exception ($db->error.__LINE__." source:get_products"); 
            
# ------------------------ Populate array with products ------------------------ #  

    while($sth->fetch()){
         $products[$count]["id"] = $db_id;
         $products[$count]["name"] = $db_name;
         $products[$count]["descr"] = $db_descr;
         $products[$count]["price"] = $db_price;
         $products[$count++]["image"] = $db_image;
    }
    
    $sth->close();
    $db->close();
    
    return $products;
}

function _get_count(){
# ------------------------ Connect to database ------------------------ #  
    
    $db_count;
    $db = get_db_connection();
    $sql = "select count(id) from products";
    
    if(! $sth = $db->prepare($sql))
        die ("Prepare failed");
        
    $sth->bind_result($db_count);
    
    if(! $sth->execute())
        die ("Execute failed"); 
    
    $sth->fetch();
    $sth->close();
    $db->close();
    
    return $db_count;
}

# =================================================================== #
#                           _GET_LIMITS                               #
#                                                                     #
# Purpose: Returns limits of search (start and end)                   #
# Inputs                                                              #
# - page: page number of search (if not numeric, 1 assumed)           #
# - size: how many products to take from database                     #
# Returns prods array. prods[0]: 
# =================================================================== #


function _get_limits($page, $size, $max){
        $data = array();
    
# ------------------------ Get the desired page ------------------------ #  
        
        if(is_numeric($page)){
            if($page > 0)
                $data[0] = floor($page);
            else if($page == 0){    // Select all products in db
                $data[0] = 0;
                $data[1] = $max;
                return $data;
            }
            else
                $data[0] = 1;
        }
        else
            $data[0] = 1;
    
# ------------------------ Get number of desired products ------------------------ #  
            
        if(is_numeric($size)){
            if($size > 0)
                $data[1] = floor($size);
            else
                $data[1] = 10; // Default page size is 10
        }
        else
            $data[1] = 10; // Default page size is 10
            
# ------------------------ Get number of products in database ------------------------ #  

        $max = _get_count();     

# ------------------------ Get the first product in the list ------------------------ # 
        
        $firstProd = ($data[0] * $data[1]) - $data[1];
        
        if($firstProd > $max){
            $data[0] = $max - $data[1];
        }
        else
            $data[0] = $firstProd;
            
        return $data;
}


# =================================================================== #
#                            RESET_DATA                               #
#                                                                     #
# Purpose: Remove all test data from database                         #
# =================================================================== #


function _reset_product_data(){
# ------------------------ Delete test data from product table (name starts with test) ------------------------ # 
    $db = get_db_connection();
    
    if ($db-> connect_error)
        die( "Could not connect: " . $db->connect_error. "\n");
        
    $sql = "delete from products where name like 'test%'";
    
    if (! $sth = $db->prepare($sql))
        die("SQL ($sql) failed: ".$db->error."\n");
        
    if (! $sth->execute())
        die("Execute failed: ". $db->error . "\n");
        
# ------------------------ Get the last none test id ------------------------ #  

    $sql = "select coalesce(max(id), 1) from products where name not like 'test%'";
    $db_id;
    $id;
    if (! $sth = $db->prepare($sql))
        die("SQL ($sql) failed: ".$db->error."\n");
        
    if(! $sth->bind_result($db_id))
        die ("Bind parameter failed, line ".__LINE__."\n");
        
    if (! $sth->execute())
        die("Execute failed: ". $db->error . "\n");

    while($sth->fetch()){
        $id=$db_id;
    }
    
# ------------------------ Reset the id auto_increment ------------------------ # 

    $sql = "alter table products auto_increment=$id";
    if (! $sth = $db->prepare($sql))
        die("SQL ($sql) failed: ".$db->error."\n");
        
    if (! $sth->execute())
        die("Execute failed: ". $db->error . "\n");
            
    $sth->close();
    $db->close();

}

?>