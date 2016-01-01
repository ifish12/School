<?php /* Smarty version Smarty-3.1.21-dev, created on 2015-11-11 20:25:33
         compiled from "../tpl/products_table.tpl" */ ?>
<?php /*%%SmartyHeaderCode:214160775256424810d06f45-94041770%%*/if(!defined('SMARTY_DIR')) exit('no direct access allowed');
$_valid = $_smarty_tpl->decodeProperties(array (
  'file_dependency' => 
  array (
    'ef0b19df9bf3a68847f3921a42dd7f35fe6eb716' => 
    array (
      0 => '../tpl/products_table.tpl',
      1 => 1447273532,
      2 => 'file',
    ),
  ),
  'nocache_hash' => '214160775256424810d06f45-94041770',
  'function' => 
  array (
  ),
  'cache_lifetime' => 3600,
  'version' => 'Smarty-3.1.21-dev',
  'unifunc' => 'content_56424810e42435_39371582',
  'has_nocache_code' => false,
),false); /*/%%SmartyHeaderCode%%*/?>
<?php if ($_valid && !is_callable('content_56424810e42435_39371582')) {function content_56424810e42435_39371582($_smarty_tpl) {?><!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>

<body>

    <div id="header">
        <strong>HEADER!!!!!</strong>
        <center>
            <img src="../images/logo.png" alt="Sick Logo" style="width:400px;height:100px;">
        </center>
    </div>

    <div id="sidebar">
        <p><strong>CART</strong></p>
        <ul>
            <li><a href="#">Link Item 1</a></li>
            <li><a href="#">Link Item 2</a></li>
            <li><a href="#">Link Item 3</a></li>
            <li><a href="#">Link Item 4</a></li>
        </ul>
    </div>

    <div id="content">
        <h1>This a test for the products table stuff</h1>

        <label>Page Size: </label>

        <input type="text" id='size'> </br>

        <button id="previous">previous</button>
        <button id="next">next</button>
        <div id='normal'></div>
        <p>current count from database:</p>
        <div id='countDB'></div>
        <div id='tableDisplay'></div>
        <?php echo '<script'; ?>
 src="//ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"><?php echo '</script'; ?>
>
        <?php echo '<script'; ?>
 type="text/javascript" src="../js/products.js"><?php echo '</script'; ?>
>

    </div>
</body>

</html>
<?php }} ?>
