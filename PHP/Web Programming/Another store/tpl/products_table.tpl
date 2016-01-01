<!DOCTYPE html>
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
