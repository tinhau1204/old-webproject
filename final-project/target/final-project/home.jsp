<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./Components/reset.css">
    <link rel="stylesheet" href="./Components/global.css">
    <link rel="stylesheet" href="./Components/Header/nav-pc.css">
    <link rel="stylesheet" href="./Components/Header/left-nav.css">
    <link rel="stylesheet" href="./Components/mainpage/slide.css">
    <link rel="stylesheet" href="./Components/mainpage/categlories.css">
    <link rel="stylesheet" href="./Components/mainpage/product.css">
    <link rel="stylesheet" href="./Components/footer/footer.css">
    <link rel="stylesheet" type = "text/css" href="./Components/mainpage/slider/lightslider.css">
    <link rel="stylesheet" href="./Components/mainpage/service.css">
    <script type="text/javascript" src="./Components/mainpage/slider/JQuery.js"></script>
    <script type = "text/javascript" src = "./Components/mainpage/slider/lightslider.js"></script>
    <script type = "text/javascript" src = "./Components/mainpage/slider/script.js"></script>
    <script type="text/javascript" src="./Components/js/slide-img.js"></script>
    <title>Document</title>
</head>

<body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file = "./header.jsp"%>
    <div class="slide-section">
    <div class="slider">
        <div class="slides">
            <!-- radio buttons start-->
            <input type="radio" name = "radio-btn" id = "radio1">
            <input type="radio" name = "radio-btn" id = "radio2">
            <input type="radio" name = "radio-btn" id = "radio3">
            <input type="radio" name = "radio-btn" id = "radio4">
            <!--radio buttons end-->
            <!-- slide img start-->
            <div class="slide first">
            <a href="#">
                <img src = "./picture/1.jpg" alt="" class = " slide-img">
            </a>
            </div>
            <div class="slide">
                <a href="#">
                    <img src="./picture/2.jpg" alt="" class = "slide-img">
                </a>
            </div>
            <div class="slide">
                <a href="#">
                    <img src="./picture/3.jpg   " alt="" class = "slide-img">
                </a>
            </div>
            <div class="slide">
                <a href="#">
                    <img src="./picture/4.jpg" alt="" class = "slide-img">
                </a>
            </div>
            <!-- slide img end-->
            
            <!-- automatic navigation start-->
            <div class="navigation-auto">
                <div class="auto-btn1"></div>
                <div class="auto-btn2"></div>
                <div class="auto-btn3"></div>
                <div class="auto-btn4"></div>
            </div>
            <!-- automatic navigation end-->

        </div>
            <!--manual navigation start-->
            <div class="navigation-manual">
                <label for="radio1" class="manual-btn"></label>
                <label for="radio2" class="manual-btn"></label>
                <label for="radio3" class="manual-btn"></label>
                <label for="radio4" class="manual-btn"></label>
            </div>
            <!--manual navigation end-->
    </div>
</div>

<!--categories-section-->
<h1 class = "section-title" id = "categories">Categories</h1>
    <div class="categories-section">

        <a href="#" class="catergories-link">
        <div class="categories-container">
            <div class="catergories-img-container">
                <img src="./picture/cactus.jpg" alt="" class="categories-img">  
            </div>
            <span class="categories-name">Cactus & Succulents</span>
            <div class="categories-content">
                <p class = "categories-content">Buy the largest collection of cactus and succulents plants online.Our cactus and succulent plants are a true delight for the cactus plants collectors</p>
            </div>
        </div>
        </a>

        <a href="#" class="catergories-link">
        <div class="categories-container">
            <div class="catergories-img-container">
                <img src="./picture/flower.jpg" alt="" class="categories-img">   
            </div>
            <span class="categories-name">Flowering Plants</span>
            <div class="categories-content">
                <p class = "con">Buy flowering plants, largest online nursery for flowering plants including all flowering plants, lilies n bulbous plants, orchids, plumeria plants.</p>
            </div>
        </div>
        </a>

        <a href="#" class="catergories-link">
        <div class="categories-container">
            <div class="catergories-img-container">
                <img src="./picture/bonsai.jpg" alt="" class="categories-img">  
            </div>
            <span class="categories-name">Bonsai Plants</span>
            <div class="categories-content">
                <p class = "con">Browse from a wide variety of bonsai plants which purify the air around you and creates a positive environment.</p>
            </div>
        </div>
        </a>

        <a href="#" class="catergories-link">
        <div class="categories-container">
            <div class="catergories-img-container">
                <img src="./picture/climber.jpg" alt="" class="categories-img">  
            </div>
            <span class="categories-name">Climbers & Creepers</span>
            <div class="categories-content">
                <p class = "con">Opt for climbing plants as they add color to dull fences, walls or trellises, we are offering online services for buying climbers and creeper plants.</p>
            </div>
        </div>
        </a>

       
    </div> 
<!--end categories section-->
<!--Featured Plants-->
<h1 class = "section-title" id = "featured">Featured Plants</h1>
<div class="featured-plants-section">

   <ul id="autoWidth" class = "css-hidden">
       <c:forEach var = "p" items = "${listTrees}">
       <li class="item-a">
        <div class = "box-cate">
            <div class = "slide-img-cate">
                <img src="${p.getTreeImg()}" alt="1">
                <div class="overplay-cate">
                    <a href="addToCartDetail?itemId=${p.getTreeid()}"" class="buy-btn">Buy Now</a>
                </div>
            </div>
            <div class="detail-box-cate">
                <div class="type-cate">
                    <a href="itemsDetail?itemId=${p.getTreeid()}"><c:out value = "${p.treeName}"/></a>
                </div>
                <a href="itemsDetail?itemId=${p.getTreeid()}" class="price">$<c:out value = "${p.price}"/></a>
            </div>
        </div>
       </li>
    </c:forEach>
        
    </ul>

</div>
<!-- End Featured Plants-->

<!--Service start-->
<div class="section-title" id = "service">Service</div>
<div class="service-section">
    <div class="service-section-container">

        <a href="#" class="service-link">
            <div class="box-service">
                <div class="img-service-container">
                    <img src="./picture/supply-service.jpg" alt="plant-serivce" class="img-service">
                </div>
                <div class="service-box-content">    
                    <h1 class="service-name">Plant Supplying Service</h1>
                    <p class="categories-content">Our skilled and experienced team offers a wide range of plants and saplings to out reputed clients as per their requirements and at affordable rates</p>
                </div>
            </div>
        </a>
    

    
        <a href="#" class="service-link">
            <div class="box-service">
                <div class="img-service-container">
                    <img src="./picture/nurse-service.jpg" alt="plant-serivce" class="img-service">
                </div>
                <div class="service-box-content">    
                    <h1 class="service-name">Nursery Service</h1>
                    <p class="categories-content">Using the vast industrial knowledge, which we have amassed over the years, we constantly provide various nursery services to our clients as and when requested.</p>
                </div>
            </div>
        </a>
    

   
        <a href="#" class="service-link">
            <div class="box-service">
                <div class="img-service-container">
                    <img src="./picture/landscape.jpg" alt="plant-serivce" class="img-service">
                </div>
                <div class="service-box-content">    
                    <h1 class="service-name">Landspcape Design</h1>
                    <p class="categories-content">Looking for beautiful landscape ideas? Count on our plants, garden flowers to be healthy and thriving. We bring you stunning examples of garden design from properties around the world.</p>
                </div>
            </div>
        </a>
    

    
        <a href="#" class="service-link">
            <div class="box-service">
                <div class="img-service-container">
                    <img src="./picture/garden-design.jpg" alt="plant-serivce" class="img-service">
                </div>
                <div class="service-box-content">    
                    <h1 class="service-name">Garden Maintenance</h1>
                    <p class="categories-content">Create the perfect background for your life to happen with the perfect selection of houseplants, home decor, home fragrance and gift items for everyone you know.</p>
                </div>
            </div>
        </a>
    </div>

</div>
<!--Service end-->
<%@ include file = "./footer.jsp"%>
</body>
