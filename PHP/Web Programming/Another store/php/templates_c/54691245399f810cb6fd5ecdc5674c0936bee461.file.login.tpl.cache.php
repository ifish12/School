<?php /* Smarty version Smarty-3.1.21-dev, created on 2015-10-06 00:01:33
         compiled from "../tpl/login.tpl" */ ?>
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
  'function' => 
  array (
  ),
  'cache_lifetime' => 3600,
  'version' => 'Smarty-3.1.21-dev',
  'unifunc' => 'content_56118a8e79fce5_54284001',
  'has_nocache_code' => false,
),false); /*/%%SmartyHeaderCode%%*/?>
<?php if ($_valid && !is_callable('content_56118a8e79fce5_54284001')) {function content_56118a8e79fce5_54284001($_smarty_tpl) {?><html>
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
        <?php echo '<script'; ?>
 src="//ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"><?php echo '</script'; ?>
>
        <?php echo '<script'; ?>
 type="text/javascript" src="../js/login.js"><?php echo '</script'; ?>
>
    </body>
</html><?php }} ?>
