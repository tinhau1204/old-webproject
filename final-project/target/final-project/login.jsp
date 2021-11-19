<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./Components/reset.css">
    <link rel="stylesheet" href="./Components/global.css">
    <link rel="stylesheet" href="./Components/login/login.css">
    <title>Document</title>
</head>
<body>
    <div class="background">
        <div class="main-container">
            <h1 class="title">Login to continue</h1>
            <form action="login" method="post" class="login-container">
                <input  type="text" name="email" placeholder="Email" class= "box text-box" required/>
                <input  type="password" name="password" placeholder="Password" class="box text-box" required/>
                <button type="submit" class="btn-login box">Login</button>

            </form>
            <p><i class="inform-message">${message}</i></p>
            <a href="./register.jsp" class="register box">or sign up </a>
        </div>
    </div>
</body>
</html>