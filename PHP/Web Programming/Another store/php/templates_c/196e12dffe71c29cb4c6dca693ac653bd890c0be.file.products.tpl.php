<?php /* Smarty version Smarty-3.1.21-dev, created on 2015-11-02 21:12:15
         compiled from "/home/ubuntu/workspace/tpl/products.tpl" */ ?>
<?php /*%%SmartyHeaderCode:13968252645637d1afaf2158-72916424%%*/if(!defined('SMARTY_DIR')) exit('no direct access allowed');
$_valid = $_smarty_tpl->decodeProperties(array (
  'file_dependency' => 
  array (
    '196e12dffe71c29cb4c6dca693ac653bd890c0be' => 
    array (
      0 => '/home/ubuntu/workspace/tpl/products.tpl',
      1 => 1446497879,
      2 => 'file',
    ),
  ),
  'nocache_hash' => '13968252645637d1afaf2158-72916424',
  'function' => 
  array (
  ),
  'variables' => 
  array (
    'products' => 0,
    'product' => 0,
  ),
  'has_nocache_code' => false,
  'version' => 'Smarty-3.1.21-dev',
  'unifunc' => 'content_5637d1afb8bd10_19899489',
),false); /*/%%SmartyHeaderCode%%*/?>
<?php if ($_valid && !is_callable('content_5637d1afb8bd10_19899489')) {function content_5637d1afb8bd10_19899489($_smarty_tpl) {?><?php if (!is_callable('smarty_function_cycle')) include '/home/ubuntu/workspace/smarty/libs/plugins/function.cycle.php';
?><table>
<?php  $_smarty_tpl->tpl_vars['product'] = new Smarty_Variable; $_smarty_tpl->tpl_vars['product']->_loop = false;
 $_from = $_smarty_tpl->tpl_vars['products']->value; if (!is_array($_from) && !is_object($_from)) { settype($_from, 'array');}
foreach ($_from as $_smarty_tpl->tpl_vars['product']->key => $_smarty_tpl->tpl_vars['product']->value) {
$_smarty_tpl->tpl_vars['product']->_loop = true;
?>
<tr bgcolor="<?php echo smarty_function_cycle(array('values'=>"#aaaaaa,#bbbbbb"),$_smarty_tpl);?>
"><td><?php echo $_smarty_tpl->tpl_vars['product']->value['id'];?>
</td><td><?php echo $_smarty_tpl->tpl_vars['product']->value['name'];?>
</td><td><?php echo $_smarty_tpl->tpl_vars['product']->value['descr'];?>
</td><td><?php echo $_smarty_tpl->tpl_vars['product']->value['price'];?>
</td><td><?php echo $_smarty_tpl->tpl_vars['product']->value['image'];?>
</td></tr>
<?php } ?>
</table><?php }} ?>
