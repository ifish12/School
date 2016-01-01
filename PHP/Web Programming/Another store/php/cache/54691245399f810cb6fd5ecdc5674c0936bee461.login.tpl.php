<?php /*%%SmartyHeaderCode:138256501856118a8e6a72d1-49798612%%*/if(!defined('SMARTY_DIR')) exit('no direct access allowed');
$_valid = $_smarty_tpl->decodeProperties(array (
  'file_dependency' => 
  array (
    '54691245399f810cb6fd5ecdc5674c0936bee461' => 
    array (
      0 => '../tpl/login.tpl',
      1 => 1444089691,
      2 => 'file',
    ),
  ),
  'nocache_hash' => '138256501856118a8e6a72d1-49798612',
  'cache_lifetime' => 3600,
  'version' => 'Smarty-3.1.21-dev',
  'unifunc' => 'content_56146f130f3fb2_91434673',
  'has_nocache_code' => false,
),true); /*/%%SmartyHeaderCode%%*/?>
<?php if ($_valid && !is_callable('content_56146f130f3fb2_91434673')) {function content_56146f130f3fb2_91434673($_smarty_tpl) {?><html>
    <head>
        <title>Login</title>
            
    </head>
    
    <body>
        <table>
            <tr>
                <td>
                    <label>Email: </label>
                </td>
                <td>
                    <input type="text" id="email" autofocus>
                </td>
                <td>
                    <p id="eError"></p>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Password: </label>
                </td>
                <td>
                    <input type="password" id="pass">
                </td>
                <td>
                   <p id="pError"></p> 
                </td>
            </tr>
        </table>
        <button id="login">Login</button> or <a href="register.php">Register</a><br><br>
        <p id="logError"></p>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="../js/login.js"></script>
    </body>
</html><?php }} ?>
