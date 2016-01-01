<?php
    include("../smarty/libs/Smarty.class.php");
    // create object
    $smarty = new Smarty;
    $smarty->setCaching(true);
    
    $smarty->display('../tpl/login.tpl');
?>