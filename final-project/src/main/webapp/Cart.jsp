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
    <link rel="stylesheet" href="./Components/Cart/cart.css">
    <title>Document</title>
</head>
<body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file = "./header.jsp"%>
    <div class="cart-section">
        <div class="cart-container">
            <div class="cart">
                <form action="smallCartFuct" class="my-cart-top">
                    <span class="title">My Cart</span>
                    <input type="hidden" name="action" value="clearCart">
                    <button class="clear-btn"> Clear Cart</button>
                </form>
                
                <div class="my-cart-body-title">
                    <div class="my-cart-tilte item-detail">Item(s) Details</div>
                    <div class="my-cart-title item-quality title-quality" >Quanlity</div>
                    <div class="my-cart-title total">Total</div>
                </div>
                <c:forEach var = "p" items = "${listItems}" varStatus="status">
                <div class="my-cart-body">
                    <div class="item-detail">
                        <div class="item-img-container">
                            <img src="${listTrees[status.index].getTreeImg()}" alt="" class="item-img">
                        </div>
                        <div class="item-description">
                            <a href="#" class = "item-link"><div class="item-title"><c:out value = "${listTrees[status.index].getTreeName()}"/></div></a>
                            <span class = "item-title price"><c:out value = "${listTrees[status.index].getPrice()}"></c:out> $</span>
                            <a href="smallCartFuct?itemId=${p.getId()}" class = "item-label">&#10006;   REMOVE</a>
                        </div>
                    </div>
                    <div class="item-quality">
                    <div  id="Quality"  >
                        <span class="amount"><c:out value = "${p.getQuality()}"></c:out></span>
                        <form action="smallCartFuct?itemId=${p.getId()}">
                            <input type="hidden" name="action" value="minus">
                            <input type="hidden" name = "inputvalue" value="${p.getId()}">
                            <button class="changeQuantity minus" type = "submit">-</button>
                        </form>
                        <form action="smallCartFuct?itemId=${p.getId()}">
                            <input type="hidden" name="action" value="plus">
                            <input type="hidden" name = "inputvalue" value="${p.getId()}">
                            <button class="changeQuantity plus" type = "submit">+</button>
                        </form>
                    </div>
                </div>
                <div class="total">
                    <span ><c:out value = "${p.getPrice()}"/> $</span>
                </div>
                </div>
                </c:forEach>
                <form action="salingProduct" method="get" class="continue-container">
                    <button class="btn-continue">CONTINUE SHOPPING</button>
                </form>
    
            </div>
            <div class="payment-section">
                <div class="payment-box">
                    <div class="total-items-container content-font">
                        <span class="payment-content payments">Items(s) Total</span>
                        <span class="item-payment payments"><c:out value = "${total}"></c:out></span>
                    </div>
                    <div class="delivery-container content-font">
                        <span class="payment-content delivery ">Approx. Delivery Charge</span>
                        <span class="item-payment delivery"> Free  </span>
                    </div>
                    <div class=" content-font total-payment-container">
                        <span class="payment-content total-payment">Amount Payable</span>
                        <span class="item-payment total-payment"> <c:out value = "${total}"></c:out> </span>
                    </div>
                    <div class="btn-checkout-container">
                        <button class="btn-checkout">CHECKOUT</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
   
    

</body>
</html>