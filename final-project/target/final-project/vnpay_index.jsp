<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Create new order</title>
        <!-- Bootstrap core CSS -->
        <link href="./Components/vnpay/bootstrap.min.css" rel="stylesheet"/>
        <!-- Custom styles for this template -->
        <link href="./Components/vnpay/jumbotron-narrow.css" rel="stylesheet">      
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>

    <body>

        <div class="container">
            <div class="header clearfix">

                <h3 class="text-muted">VNPAY DEMO</h3>
            </div>
            <h3>Create new order</h3>
            <div class="table-responsive">
                <form action="vnpayajax" id="frmCreateOrder" method="post">        
                    <div class="form-group">
                        <label for="language">Type</label>
                        <select name="ordertype" id="ordertype" class="form-control">
                            <option value="billpayment">Pay the bill</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="amount">Amount</label>
                        <input class="form-control" data-val="true" data-val-number="The field Amount must be a number." data-val-required="The Amount field is required." id="amount" max="100000000" min="1" name="amount" type="number" value="10000" />
                    </div>
                    <div class="form-group">
                        <label for="OrderDescription">Content billing</label>
                        <textarea class="form-control" cols="20" id="vnp_OrderInfo" name="vnp_OrderInfo" rows="2">Pay the bill</textarea>
                    </div>
                    <div class="form-group">
                        <label for="bankcode">Bank</label>
                        <select name="bankcode" id="bankcode" class="form-control">
                            <option value="NCB">NCB Bank</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <h3>Billing information</h3>
                    </div>
                    <div class="form-group">
                        <label >Fullname (*)</label>
                        <input class="form-control" id="txt_billing_fullname"
                               name="txt_billing_fullname" type="text" value="DO NGOC ANH VIEN"/>      
                    </div>
                    <div class="form-group">
                        <label >Phone number (*)</label>
                        <input class="form-control" id="txt_billing_mobile"
                               name="txt_billing_mobile" type="text" value="0934998386"/>   
                    </div>
                    <div class="form-group">
                        <label >Address (*)</label>
                        <input class="form-control" id="txt_billing_addr1"
                               name="txt_billing_addr1" type="text" value="Vo Van Ngan - Thu Duc"/>   
                    </div>
                    <button type="submit" class="btn btn-default">Pay now</button>
                </form>
            </div>
            <p>
                &nbsp;
            </p>
            <footer class="footer">
                <p>&copy; VNPAY 2021</p>
            </footer>
        </div>  
        <link href="https://pay.vnpay.vn/lib/vnpay/vnpay.css" rel="stylesheet" />
        <script src="https://pay.vnpay.vn/lib/vnpay/vnpay.min.js"></script>
        <script type="text/javascript">
            $("#frmCreateOrder").submit(function () {
                var postData = $("#frmCreateOrder").serialize();
                var submitUrl = $("#frmCreateOrder").attr("action");
                $.ajax({
                    type: "POST",
                    url: submitUrl,
                    data: postData,
                    dataType: 'JSON',
                    success: function (x) {
                        if (x.code === '00') {
                            if (window.vnpay) {
                                vnpay.open({width: 768, height: 600, url: x.data});
                            } else {
                                location.href = x.data;
                            }
                            return false;
                        } else {
                            alert(x.Message);
                        }
                    }
                });
                return false;
            });
        </script>       
    </body>
</html>
