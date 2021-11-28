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
    <link rel="stylesheet" href="./Components/footer/footer.css">
    <link rel="stylesheet" href="./Components/products/list-product.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="./Components/js/searchProductByName.js"></script>
    <script src="./Components/js/loadMoreProduct.js"></script>
    <title>Document</title>
</head>
<body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file = "./header.jsp"%>
    
    <div class="product-container">
        <div class="include">
        <div class="main-board">
            <form class="type-board">
                <div class="plants-title ">
                    <h1 id = "plant-title">Plants</h1>
                </div>
                
                <div class="type-section check-list">
                    <div class="filter-title">
                        <h1 class="check-title">TYPE</h1>
                    </div>
                    
                    <div class="type-lists">
                        <select class=" fill-type select_type">
                            <option class="option-box"><c:out value= "${selection}"></c:out> All</option>
                            <c:forEach var = "p" items = "${listKinds}" >
                                <option class="option-box" value="${p}"><c:out value= "${p}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                    <div class="brand-section check-list ">
                        <div class="filter-title ">
                            <h1 class="check-title">BRAND</h1>
                            <select class=" fill-type select_brand">
                                <option class="option-box">All</option>
                                <c:forEach var = "b" items = "${listBrands}" >
                                    <option class="option-box" value="${b}"><c:out value= "${b}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                        
                        <div class="filter-container" >
                            <div class="filter-container-btn">
                                <button type="submit" class="filter-btn">Filter</button>
                            </div>
                            <form action="" class="filter-container-btn">
                                <input type="hidden" name="action" value = "filter">
                                <button type="submit" class="filter-btn">Clear</button>
                            </form>
                        </div>
                    </div>
            </form>
    
            <div class="product-board">
                <div class="choose-board">
                    <div class="sort-container">
                        <label for="sort-by">Sort By</label>
                        <select name="" id="sort-by" >
                            <a href="./index.jsp"><option value="popularity">Popularity</option></a>
                            <option value="newest">Newest</option>
                            <option value="lowToHigh">Price Low to High</option>
                            <option value="highToLow">Price High to Low</option>
                        </select>
                    </div>
                </div>
                <div id="content" class="products-board" >
                    <c:forEach var = "p" items = "${listTrees}" >
                        <div class="products-board-container tree">
                        <div class="items-box">
                            <a href="itemsDetail?itemId=${p.getTreeid()} " class="img-item-container">
                                <img src="${p.getTreeImg()}" alt="" class="item-img">
                            </a>
                            <div class="items-box-content">
                                <h1 class="items-name"><c:out value = "${p.treeName}"/></h1>
                                <div class="items-box-bottom">
                                    <span class="item-price"><c:out value = "${p.price}"/>$</span>
                                    <a href="addToCart?itemId=${p.getTreeid()}" class="btn-add-container">
                                        <img src="./icon_web/cart-plus-solid.svg" alt="" class="btn-add-cart-logo">
                                    </a>
                                </div>
                            </div>
                        </div>
                        </div>
                    </c:forEach>
                </div>
                <button class="loadMore-btn" onclick="loadMoreProducts()">Load More</button>
            </div>
        </div>
        </div>
        </div>
    </div>
    <%@ include file = "./footer.jsp"%>
</body>
</html>
