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
  'cache_lifetime' => 3600,
  'version' => 'Smarty-3.1.21-dev',
  'unifunc' => 'content_5643a43daf6e10_05411114',
  'has_nocache_code' => false,
),true); /*/%%SmartyHeaderCode%%*/?>
<?php if ($_valid && !is_callable('content_5643a43daf6e10_05411114')) {function content_5643a43daf6e10_05411114($_smarty_tpl) {?><!DOCTYPE html>
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
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="../js/products.js"></script>

    </div>
</body>

</html>
<?php }} ?>
