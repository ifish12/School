<html>
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
</html>