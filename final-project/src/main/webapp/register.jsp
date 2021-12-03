<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>dinosaur</title>
    <link rel = "icon" href = "./icon_web/2073.jpg" type = "image/x-icon">
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
                <input  type="email" name="email" placeholder="Email" class= "box text-box" required/>
                <input  type="password" name="password" placeholder="Password" class="box text-box" 
				    oninvalid="this.setCustomValidity('Password must be 8 characters including at least 1 uppercase letter, and numeric characters')"
				   	oninput="this.setCustomValidity('')"
					title="Password must be 8 characters including 1 uppercase letter, 1 lowercase letter and numeric characters" 
					pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required/>
                <input 
					type="password" name="2password" placeholder="Password" class="box text-box" required/>
                <p><i class="inform-message">${message}</i></p>

				<button type = "submit" class="cssbuttons-io-button"> Login
				  <div class="icon">
					<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24">
						<path fill="none" d="M0 0h24v24H0z"></path>
						<path fill="currentColor" d="M16.172 11l-5.364-5.364 1.414-1.414L20 12l-7.778 7.778-1.414-1.414L16.172 13H4v-2z"></path>
					</svg>
				  </div>
				</button>
            </form>
            <a href="./login.jsp" class="register box">I already have an account</a>
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
