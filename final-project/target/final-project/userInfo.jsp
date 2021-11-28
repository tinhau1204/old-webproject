<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./Components/reset.css">
    <link rel="stylesheet" href="./Components/global.css">
    <link rel="stylesheet" href="./Components/userinfo/userinfo.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Document</title>
</head>
<body>
    
        <div class="container">
           <div  class="back-btn"> <svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="times" class="svg-inline--fa fa-times fa-w-11" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 352 512">
                <a href="index.jsp" class="back-btn-link">
                     <path fill="black" 
                    d="M242.72 256l100.07-100.07c12.28-12.28 12.28-32.19 0-44.48l-22.24-22.24c-12.28-12.28-32.19-12.28-44.48 0L176 189.28 75.93 89.21c-12.28-12.28-32.19-12.28-44.48 0L9.21 111.45c-12.28 12.28-12.28 32.19 0 44.48L109.28 256 9.21 356.07c-12.28 12.28-12.28 32.19 0 44.48l22.24 22.24c12.28 12.28 32.2 12.28 44.48 0L176 322.72l100.07 100.07c12.28 12.28 32.2 12.28 44.48 0l22.24-22.24c12.28-12.28 12.28-32.19 0-44.48L242.72 256z"></path></svg>
                </a>
            </div>
            <div class="wrapper">
                <div class="main-box">
                    <div class="box-header">
                        <h2 class="title">Personal Information</h2>
                    </div>
                    <div class="box-body">
                        <form action="personalInformation" class = "main-content">
                            
                            <div class="line">
                                <div class="name">First Name</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input type="text" class="input-style"  value = "${userInfo.getFirstName()}" name="firstName" required>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="line">
                                <div class="name">Last Name</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input type="text" class="input-style" value="${userInfo.getLastName()}" name="lastName" required>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="line">
                                <div class="name">Phone</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input type="number" class="input-style" value="${requestScope.userInfo.phone}" name="phone" required>
                                    </div>
                                </div>
                            </div>
                            <div class="line">
                                <div class="name">Address</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input type="text" class="input-style" value="${requestScope.userInfo.address}" name="address" required>
                                    </div>
                                </div>
                            </div>



                            <div class="line">
                                <div class="name ">Email</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input type="text" class="input-style email" value="${sessionScope.user.email}">
                                    </div>
                                </div>
                            </div>
                                <input type="hidden" name="action" value="updateInfo">
                                <button class = "update-btn" type="submit">Update</button>
                            
                        </form>
                    </div>
                </div>
            </div>
        </div>
    
</body>
</html>