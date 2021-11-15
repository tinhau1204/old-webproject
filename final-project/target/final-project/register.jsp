<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./Components/reset.css">
    <link rel="stylesheet" href="./Components/global.css">
    <link rel="stylesheet" href="./Components/login/login.css">
    <link rel="stylesheet" href="./Components/login/register.css">
</head>
<body>
    <div class="background">
        <div class="main-container">
            <h1 class="title">Sign Up</h1>
            <form action="register" method="post" class="login-container">
                <input type="hidden" name="register" value = "register">
                <input  type="text" name="email" placeholder="Email" class= "box text-box" required/>
                <input  type="password" name="password" placeholder="Password" class="box text-box" title="Password must be 8 characters including 1 uppercase letter, 1 lowercase letter and numeric characters" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required/>
                <input  type="password" name="2password" placeholder="Password" class="box text-box" title="Password must be 8 characters including 1 uppercase letter, 1 lowercase letter and numeric characters" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required/>
                <p><i class="inform-message">${message}</i></p>

                <button type="submit"  class="btn-login box">Register</button>
            </form>
            <a href="./login.jsp" class="register box">I have already have account</a>
        </div>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
        
        <c:if test = "${message == 'login'}">
        <div class="overplay">
            <div class="confirmation-box">
                <h1 class = "content">Thank for join with us</h1>
            <form action="register" method = "post" class="form-action">
                <input type="hidden" name = "action" value = "backtologin">
                <button type="submit" class="back-to-login-btn">Login</button>
            </form>
            </div>
        </div>
        </c:if>
    </div>
</body>
</html>