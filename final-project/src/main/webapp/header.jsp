 <div class="header">
    <div class="container">
        <div class="first-section">
            <div class="btn-change-shopping-container">
                <div class="btn-change-shopping">
                    <span  class="strike"></span>
                    <span  class="strike"></span>
                    <span class="strike"></span>

                    <div class="plant-change">
                        <a href = "salingProduct">Plants</a>
                    </div>
                </div>

            </div>

            <div class="group-logo">
                <a href="./index.jsp" class="logo-link">
                    <img src="icon_web/2073.jpg" alt="Group logo" id = "logo-img"/>
                <span id = "group-name">DINOSAUR</span>  
                </a>
            </div>
        </div>
        <div class="nav-contents">
            <div class="list-nav">
                <ul class="list-contain">
                    <li class ="list-content"><a href="./index.jsp">HOME</a></li>
                    <li class = "list-content"><a href="./index.jsp#categories">CATEGORIES</a></li>
                    <li class = "list-content"><a href="./index.jsp#featured">PRODUCTS</a></li>
                    <li class = "list-content"><a href="./index.jsp#service">SERVICE</a></li>
                </ul>
            </div>
            <form action="salingProduct" class="input-container">
                <input oninput="searchProductByName(this)" name="searchName" type="text" id="search-header" list="search-list" placeholder="Search" class = "input-search" size="25"/>
                <datalist id = "search-list">
                </datalist>
                <input type="hidden" name="action" value="searchItem">
				<input type="image" class="search-btn" src="./icon_web/loupe.png"  alt="Submit">
            </form>
			<c:choose>
				<c:when test = "${sessionScope.user != null}">
					<a href="Cartlist" class="icon-link">
						<div class="cart-container nav-icon-container">
							<img src="icon_web/shopping-cart.png" alt="shopping cart" class = "nav-icon">
						</div>
					</a>
					<div href="#" class="icon-link " id = "user-login">
						<div class="user-container nav-icon-container ">
							<img src="icon_web/user.png" alt="User" class = "nav-icon">
							<div class="user-control" id = "user-control">
								<a href="personalInformation" class="user-control-content">Personal Information</a>
								<a class="user-control-content">Purchase History</a>
							<c:if test = "${sessionScope.user.admin == 1}">
								<a href="productManagement" class="user-control-content">Manage Product</a>
							</c:if> 
							<a class="user-control-content" href="logout">Log Out</a>
							</div>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="login-container">
					<a href="./login.jsp" class="login">Login</a>
					<span>&nbsp; / &nbsp;</span> 
					<a href="./register.jsp" class="login">SignUp</a>
				</div>
				</c:otherwise>
			</c:choose>

        </div>
        
        <!--left nav-->
            <input type = "checkbox" id = "nav-input" class="nav__input">
            <label for="nav-input">
            <div class = "open-nav-logo">
                <div class="line"></div>
                <div class="line"></div>
                <div class="line"></div>
            </div></label>

            <label for = "nav-input" class = "overplayed"></label>
            <!--Nav left-->
            <div class = "left-nav">
                <div id = "nav-header">
                    <label for="nav-input">
                    <div class = "close-nav">
                        <div class="line" id = "line1"></div>
                        <div class="line" id = "line2"></div>
                    </div></label>
                   
                </div>
                <div class="nav-content">

                    <div class="list-nav mobile">
                        <form action="" class="input-container">
                            <input type="text" id="search-header" placeholder="Search" class = "input-search" size="25" oninput="searchProductByName(this)"/>
                            <datalist id = "search-header">
                            </datalist> 
                            <button type="submit" class="search-btn">*</button>
                        </form>
                        <ul class="list-contain moblie">
                            <li class ="list-content"><a href="./index.jsp">HOME</a></li>
                            <li class = "list-content"><a href="./index.jsp#categories">CATEGORIES</a></li>
                            <li class = "list-content"><a href="./index.jsp#featured">PRODUCTS</a></li>
                            <li class = "list-content"><a href="./index.jsp#service">SERVICE</a></li>
                        </ul>
                        
                    </div>
                </div>
            </div>
            <!--end left nav-->
        </div>
    </div>
</div>
