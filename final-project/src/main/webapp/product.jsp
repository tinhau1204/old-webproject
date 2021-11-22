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
    <title>Document</title>
</head>
<body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file = "./header.jsp"%>
    
    <div class="product-container">
        <div class="include">
        <div class="main-board">
            <div class="type-board">
                <div class="plants-title ">
                    <h1 id = "plant-title">Plants</h1>
                </div>
                
                <div class="type-section check-list">
                    <div class="filter-title">
                        <h1 class="check-title">TYPE</h1>
                    </div>
                    
                    <ul class="type-lists">
                        <li class="type-elements">
                            <input type="checkbox" class="type-check" value = "" id = "1">
                            <label for="1">Air Purifying Plant</label>
                        </li>
                        
                        <li class="type-elements">
                            <input type="checkbox" class="type-check" value = "" id = "2">
                            <label for="2">Bonsai</label>
                        </li>
                        
                        <li class="type-elements">
                            <input type="checkbox" class="type-check" value = "" id = "3">
                            <label for="3">Cactus & Succulents</label>
                        </li>
                        
                        <li class="type-elements">
                            <input type="checkbox" class="type-check" value = "" id = "4">
                            <label for="4">Climbers & Creepers</label>
                        </li>
                        
                        <li class="type-elements">
                            
                            <input type="checkbox" class="type-check" value = "" id = "5">
                            <label for="5">Flowering</label>
                        </li>
                        <li class="type-elements">
                            <input type="checkbox" class="type-check" value = "" id = "6">
                            <label for="6">Foliage Plant</label>
                        </li>
                        
                        <li class="type-elements">
                            <input type="checkbox" class="type-check" value = "" id = "7">
                            <label for="7">Money Plant</label>
                        </li>
                    </ul>
                        
                </div>
                    
    
                    <div class="price-section check-list ">
                        <div class="filter-title">
                            <h1 class="check-title" id = "price">PRICE</h1>
                        </div>
                        <ul class="price-list">
                            <li class="type-elements">
                                <input type="checkbox" class="type-check" value = "" id = "below250">
                                <label for="below250">Below 250</label>
                            </li>
    
                            <li class="type-elements">
                                <input type="checkbox" class="type-check" value = "" id = "251-500">
                                <label for="251-500">251 - 500</label>
                            </li>
    
                            <li class="type-elements">
                                <input type="checkbox" class="type-check" value = "" id = "500-1000">
                                <label for="500-1000">501 - 1000</label>
                            </li>
                        </ul>
                    </div>
    
                    <div class="brand-section check-list ">
                        <div class="filter-title ">
                            <h1 class="check-title">BRAND</h1>
                        </div>
                        <ul class="brand-list">
                            <li class="type-elements">
                                <input type="checkbox" class="type-check" value = "" id = "bunny">
                                <label for="bunny">Bunny</label>
                            </li>
    
                            <li class="type-elements">
                                <input type="checkbox" class="type-check" value = "" id = "columnar">
                                <label for="columnar">Columnar</label>
                            </li>
    
                            <li class="type-elements">
                                <input type="checkbox" class="type-check" value = "" id = "egrow">
                                <label for="egrow">Egrow</label>
                            </li>
    
                            <li class="type-elements">
                                <input type="checkbox" class="type-check" value = "" id = "Huernia">
                                <label for="Huernia">Huernia</label>
                            </li>
    
                            <li class="type-elements">
                                <input type="checkbox" class="type-check" value = "" id = "jade">
                                <label for="jade">jade</label>
                            </li>
    
                            <li class="type-elements">
                                <input type="checkbox" class="type-check" value = "" id = "jasminum">
                                <label for="jasminum">jasminum</label>
                            </li>
    
                        </ul>
                    </div>
            </div>
    
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
                <div class="products-board">
                    <c:forEach var = "p" items = "${listItems}" varStatus = "status">
                        <div class="products-board-container">
                        <div class="items-box">
                            <a href="#" class="img-item-container">
                                <img src="${listTrees[status.index].getTreeImg()}" alt="" class="item-img">
                            </a>
                            <div class="items-box-content">
                                <h1 class="items-name"><c:out value = "${listTrees[status.index].treeName}"/></h1>
                                <div class="items-box-bottom">
                                    <span class="item-price"><c:out value = "${p.price}"/>$</span>
                                    <a href="#" class="btn-add-container">
                                        <img src="./icon_web/cart-plus-solid.svg" alt="" class="btn-add-cart-logo">
                                    </a>
                                </div>
                            </div>
                        </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
    
            
        </div>
        </div>
        </div>
    </div>
    <%@ include file = "./footer.jsp"%>
</body>
</html>