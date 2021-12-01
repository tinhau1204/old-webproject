<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./Components/reset.css">
    <link rel="stylesheet" href="./Components/global.css">
    <link rel="stylesheet" href="./Components/login/login.css">
    <title>dinosaur</title>
		<link rel = "icon" href = "./icon_web/2073.jpg" type = "image/x-icon">
</head>
<body>
    <div class="background">
        <div class="main-container">
            <h1 class="title">Login to continue</h1>
            <form action="login" method="post" class="login-container">
                <input  type="text" name="email" placeholder="Email" class= "box text-box" required/>
                <input  type="password" name="password" placeholder="Password" class="box text-box" required/>
				<button type = "submit" class="cssbuttons-io-button"> Login
				  <div class="icon">
					<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24">
						<path fill="none" d="M0 0h24v24H0z"></path>
						<path fill="currentColor" d="M16.172 11l-5.364-5.364 1.414-1.414L20 12l-7.778 7.778-1.414-1.414L16.172 13H4v-2z"></path>
					</svg>
				  </div>
				</button>
            </form>
            <p><i class="inform-message">${message}</i></p>
            <a href="./register.jsp" class="register box">or sign up </a>
        </div>
    </div>
</body>
</html>
