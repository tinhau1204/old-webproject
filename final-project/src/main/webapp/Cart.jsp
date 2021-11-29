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
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="./Components/js/searchProductByName.js"></script>
		<script src="./Components/js/paypal.js"></script>
		<script src="https://www.paypal.com/sdk/js?client-id=Ac168FfjHNa-SERjcKvfUyowKz5w5_6q5yc9w7CEU-7PnbgqXalljT3oXhE1dulK63sHHoC90ZXC7As8&currency=USD"></script>
		<title>dinosaur</title>
		<link rel = "icon" href = "./icon_web/2073.jpg" type = "image/x-icon">
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
							<span id="total-amount" class="item-payment total-payment"> <c:out value = "${total}"></c:out> </span>
						</div>
						<div class="btn-checkout-container">
							<c:choose>
								<c:when test="${userInfo != null}">
									<button onclick="showPayment()" id="checkout-btn" class="btn-checkout">CHECKOUT</button>
								</c:when>
								<c:otherwise>
									<span class="warning-payment">You need to fill all your information before making purchase</span>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
			<div id="payment-overlay" class="payment-overlay">
				<div class="main-box">
					<div class="box-header">
						<h2 class="title">Payment Information</h2>
					</div>
					<div class="payment-container">
						<div class="user-container">
							<input type="hidden" value="${sessionScope.user.getId()}" id="userId" />
							<div class="user-line">
								<div class="input-name">First Name</div>
								<span class="info" id="first-name"><c:out value="${userInfo.getFirstName()}" /></span>
							</div>
							<div class="user-line">
								<div class="input-name">Last Name</div>
								<span class="info" id="last-name"><c:out value="${userInfo.getLastName()}" /></span>
							</div>
							<div class="user-line">
								<div class="input-name">Phone</div>
								<span class="info" id="phone"><c:out value="${userInfo.getPhone()}" /></span>
							</div>
							<div class="user-line">
								<div class="input-name">Address</div>
								<span class="info" id="address"><c:out value="${userInfo.getaddress()}" /></span>
							</div>
						</div>
						<div class="payment-btn-container">
							<div class="text">Choose Your Payment Method</div>
							<div class="button-container">
								<button onclick="vnpay()" class="vnpay-btn btn-checkout">VNPAY</button>
								<div id="paypal-button-container" class="paypal-button-container"></div>
							</div>
							<button onclick="cancelPayment()" id="cancel" class="cancel-btn btn-checkout">Cancel</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script>
		// hide payment
		$("#payment-overlay").toggle();

		total = $("#total-amount").text()

		if(parseInt(total, 10) === 0) {
			$('#checkout-btn').prop('disabled', true);
		} else {
		  	// only show if the total amount greater than 0
			$('#checkout-btn').prop('disabled', false);
		}

		// toggle payment
		 $(document).ready(() => {
			showPayment = function() {
				 $("#payment-overlay").toggle();
			}

			cancelPayment = function() {
				 $("#payment-overlay").toggle();
			}

			vnpay = function() {
				let total = $("#total-amount").text().trim()
				let submitUrl = "vnpayajax";
				$.ajax({
				type: "GET",
				url: submitUrl,
				data: {
					amount: total,
					userId: $("#userId").val(),
				},
				dataType: 'JSON',
				success: function (x) {
					if (x.code === '00') {
						location.href=x.data;
						return false;
					} else {
						alert(x.Message);
					}
				}
				});
			}
		});
	</script>
</html>
