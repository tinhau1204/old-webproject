<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./Components/reset.css">
    <link rel="stylesheet" href="./Components/global.css">
    <link rel="stylesheet" href="./Components/manager/productManager.css">
    <link rel="stylesheet" href="./Components/Header/nav-pc.css">
    <link rel="stylesheet" href="./Components/Header/left-nav.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="./Components/js/searchProductByName.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script type="text/javascript" src="./Components/js/openAddproduct.js"></script>
    <title>Document</title>
</head>
<body>
    <%@ include file = "./header.jsp"%>
    
    <!-- body -->
  <div class="body-container">
      <div class="wrapper">
          <div class="main-box">
            <div class="box-header">
                <h2 class="box-title">Product Management</h2>
                <div class="add-container">
                    <button class="addItems-btn" onclick="openAddForm()">Add More</button>
            </div>
            </div>
            <div class="box-body">
                <div class="box-body-title-container">
                    <div class="box-body-title id-container"> Id</div>
                    <div class="box-body-title item-container"> Items</div>
                    <div class="box-body-title name-container"> Name</div>
                    <div class="box-body-title quality-container"> Quanlity</div>
                    <div class="box-body-title price-container"> Price</div>
                    <div class="box-body-title action-container"> Action</div>
                </div>
                <c:forEach var = "p" items = "${listTrees}" >
                <div class="Product">
                    <h2 class="id-container "><c:out value = "${p.getTreeid()}"/></h2>

                    <a href="#" class="items-img-container item-container box" >
                        <img src="${p.getTreeImg()}" alt="" class="item-img">
                    </a>

                    <div class="items-description name-container box">
                        <div class="items-name "><c:out value = "${p.treeName}"/></div>
                    </div>

                    <div class="items-description quality-container box">
                        <div class="items-name"><c:out value = "${p.getAmount()}"/></div>
                    </div>

                    <div class="price-container price-container box">
                        <div class="price-items"><c:out value = "${p.price}"/>$</div>
                    </div>

                    <div class="action-container">
                    <a href="productManagement?pid=${p.getTreeid()}&action=goToUpDate" class="update-container btn-items box">
                        <img src="./icon_web/edit-solid.svg" class="update" width="35" height="35">
                    </a>
                    <a href="deleteItem?pid=${p.getTreeid()}" class="delete-container btn-items box" >
                        <img src="./icon_web/trash-alt-solid.svg" width="35" height="35" alt="">
                    </a>
                    </div>
                </div>
            </c:forEach>
                
                </div>

            </div>
          </div>

          <div class="addproduct" id = "openaddproduct" >
            
                <div class="box-addproduct">
                    <div class="box-title-add">
                        <h1 class="box-add-title"> ADD PRODUCT</h1>
                    </div>
                    <form action="productManagement" class="box-add-body">
                        <div class="box-line">
                            <div class="name">Name:</div>
                            <div class="input-group">
                                <input type="text" class="input-style"  name="nameAdd" required>
                            </div>
                        </div>

                        <div class="box-line">
                            <div class="name">Image:</div>
                            <div class="input-group">
                                <input type="text" class="input-style" name="imageAdd" required>
                            </div>
                        </div>

                        <div class="box-line">
                            <div class="name">Quality:</div>
                            <div class="input-group">
                                <input type="text" class="input-style" name="qualityAdd" required>
                            </div>
                        </div>

                        <div class="box-line">
                            <div class="name">Price:</div>
                            <div class="input-group">
                                <input type="text" class="input-style" name="PriceAdd" required>
                            </div>
                        </div>
                        <div class="box-line">
                            <div class="name">Kind:</div>
                            <div class="input-group">
                                <input type="text" class="input-style" name="KindAdd" required>
                            </div>
                        </div>
                        <div class="box-line">
                            <div class="name">Brand:</div>
                            <div class="input-group">
                                <input type="text" class="input-style" name="BrandAdd" required>
                            </div>
                        </div>

                        <div class="box-line">
                            <div class="name">Description:</div>
                            <div class="input-group">
                                <input type="text" class="input-style" name="DescriptionAdd" required>
                            </div>
                        </div>
                        <div  class="add-btn-container">
                            <input type="hidden" name="action" value="addItems">
                            <button class="add-btn btn-box-add">ADD</button>
                            <button class="back-btn btn-box-add" onclick="closeAddProduct()">BACK</button>
                        </div>
                    </form>
            </div>
            
            </div>
        </div>
      </div>
  </div>
</body>
</html>