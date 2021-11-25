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
    <link rel="stylesheet" href="./Components//detail//detail.css">
    <link rel="stylesheet" href="./Components/footer/footer.css">
    <title>Document</title>
</head>
<body>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file = "./header.jsp"%>

    <div class="product-detail-section">
        <div class="box-container">
            <div class="img-section">
                <div class="img-container">
                    <img src="${tree.getTreeImg()}" alt="" class="product-img">
                </div>
            </div>
            <div class="description-section">
                <div class="saling-section">
                    <h1 class="product-name sale"><c:out value = "${tree.treeName}"/></h1>
                    <span class="price sale"><c:out value = "${tree.price}"/>$</span>
                    <div class="btn-saling sale">
                        <form action="addToCartDetail" method="get">
                            <input type="hidden" name = "action" value = "addToCart">
                            <input type="hidden" name="itemId" value="${tree.getTreeid()}">
                            <button class="add-to-cart btn-product " type="submit">
                                ADD TO CART
                            </button>
                        </form>
                        <form action="addToCartDetail">
                            <input type="hidden" name="action" value="buyNow">
                            <input type="hidden" name="itemId" value="${tree.getTreeid()}">
                            <button class="btn-buy-now btn-product" type="submit"> BUY NOW</button>
                        </form>
                    </div>
                    <span class="product-name sale">Specifications</span>
                </div>
                <div class="detail-product">
                    <div class="brand-section detail">
                        <span class="brand title detail-style"> Brand</span>
                        <span class="brand info detail-style"> <c:out value = "${tree.getTreeBrand()}"/></span>
                    </div>
                    <div class="type-section detail">
                        <spand class="type title detail-style">Type</spand>
                        <span class="type info detail-style"><c:out value = "${tree.getTreeKind()}"/></span>
                    </div>
                </div>
            </div>
    
        </div>
    </div>

    <%@ include file = "./footer.jsp"%>
</body>
</html>