<%@page import="java.net.URLEncoder"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="com.vnpay.Config"%>
<%@page import="com.cart.Cart"%>
<%@page import="com.cart.CartDAO"%>
<%@page import="com.user.User"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- 
	Document   : vnpay_return
	Created on : Sep 29, 2015, 7:23:56 PM
	Author     : xonv
	Description: Su dung de thong bao ket qua thanh toan toi khach hang. 
				 Khong thuc hien cap nhat vao db tai file nay
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<meta name="description" content="">
		<meta name="author" content="">
		<title>VNPAY RESPONSE</title>
		<!-- Bootstrap core CSS -->
		<link href="./Components/vnpay/bootstrap.min.css" rel="stylesheet"/>
		<!-- Custom styles for this template -->
		<link href="./Components/vnpay/jumbotron-narrow.css" rel="stylesheet"> 
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	</head>
	<body>
		<%
			//Begin process return from VNPAY
			Map fields = new HashMap();

			for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
                String fieldName = URLEncoder.encode((String) params.nextElement(), StandardCharsets.US_ASCII.toString());
                String fieldValue = URLEncoder.encode(request.getParameter(fieldName), StandardCharsets.US_ASCII.toString());
				if ((fieldValue != null) && (fieldValue.length() > 0)) {
					fields.put(fieldName, fieldValue);
				}
			}

			String vnp_SecureHash = request.getParameter("vnp_SecureHash");
			if (fields.containsKey("vnp_SecureHashType")) {
				fields.remove("vnp_SecureHashType");
			}
			if (fields.containsKey("vnp_SecureHash")) {
				fields.remove("vnp_SecureHash");
			}

			String signValue = Config.hashAllFields(fields);

		%>
		<!--Begin display -->
		<div class="container">
			<div class="header clearfix">
				<h3 class="text-muted">VNPAY RESPONSE</h3>
			</div>
			<div class="table-responsive">
				<div class="form-group">
					<label >Mã đơn hàng:</label>
					<label><%=request.getParameter("vnp_TxnRef")%></label>
				</div>    
				<div class="form-group">
					<label >Số tiền:</label>
					<label><%=request.getParameter("vnp_Amount")%></label>
				</div>  
				<div class="form-group">
					<label >Mã phản hồi (vnp_ResponseCode):</label>
					<label><%=request.getParameter("vnp_ResponseCode")%></label>
				</div> 
				<div class="form-group">
					<label >Mã GD Tại VNPAY:</label>
					<label><%=request.getParameter("vnp_TransactionNo")%></label>
				</div> 
				<div class="form-group">
					<label >Mã Ngân hàng:</label>
					<label><%=request.getParameter("vnp_BankCode")%></label>
				</div> 
				<div class="form-group">
					<label >Thời gian thanh toán:</label>
					<label><%=request.getParameter("vnp_PayDate")%></label>
				</div> 
				<div class="form-group">
					<label >Result:</label>
					<label>
						<%
							if (signValue.equals(vnp_SecureHash)) {
								if ("00".equals(request.getParameter("vnp_TransactionStatus"))) {
									int id = 0;
									try {
										id = Integer.parseInt(request.getParameter("vnp_OrderInfo"));
									} catch(NumberFormatException e) {
										System.out.println(e.getMessage());
									}
									Cart cart = CartDAO.selectCartByUid(id);
									CartDAO.updateCheckCart(cart);

									out.print("Success");
								} else {
									out.print("Failed");
								}
								
							} else {
								out.print("Invalid Signature");
							}
						%></label>
				</div> 
			</div>
			<p>
				&nbsp;
			</p>
			<footer class="footer">
				<p>&copy; VNPAY 2021</p>
			</footer>
		</div>  
	</body>
</html>

