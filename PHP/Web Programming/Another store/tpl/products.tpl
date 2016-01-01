<table>
{foreach $products as $product}
{strip}
   <tr bgcolor="{cycle values="#aaaaaa,#bbbbbb"}">
      <td>{$product.id}</td>
      <td>{$product.name}</td>
      <td>{$product.descr}</td>
      <td>{$product.price}</td>
      <td>{$product.image}</td>
   </tr>
{/strip}
{/foreach}
</table>