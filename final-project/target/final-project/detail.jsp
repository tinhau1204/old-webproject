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
                    <img src="./picture/Beautiful-Yellow-Daffodils_1499169127126.jpg" alt="" class="product-img">
                </div>
            </div>
            <div class="description-section">
                <div class="saling-section">
                    <h1 class="product-name sale">Bonsai Wild Plant With Pot</h1>
                    <span class="price sale">999$</span>
                    <div class="btn-saling sale">
                        <button class="add-to-cart btn-product ">
                            ADD TO CART
                        </button>
                        <button class="btn-buy-now btn-product"> BUY NOW</button>
                    </div>
                    <span class="product-name sale">Specifications</span>
                </div>
                <div class="detail-product">
                    <div class="brand-section detail">
                        <span class="brand title detail-style"> Brand</span>
                        <span class="brand info detail-style"> Hyperboles</span>
                    </div>
                    <div class="type-section detail">
                        <spand class="type title detail-style">Type</spand>
                        <span class="type info detail-style"> Bonsai</span>
                    </div>
                </div>
            </div>
    
        </div>
    </div>

    <%@ include file = "./footer.jsp"%>
</body>
</html>