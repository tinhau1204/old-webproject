<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./Components/reset.css">
    <link rel="stylesheet" href="./Components/global.css">
    <link rel="stylesheet" href="./Components/manager/upDateProduct.css">
    <title>Document</title>
</head>
<body>
    <div class="addproduct" id = "openaddproduct" >
            
        <div class="box-addproduct">
            <div class="box-title-add">
                <h1 class="box-add-title"> UPDATE PRODUCT</h1>
            </div>
            <form action="productManagement" class="box-add-body">
                <div class="box-line">
                    <div class="name">Name:</div>
                    <div class="input-group">
                        <input type="text" class="input-style" value = "${tree.getTreeName()}"  name="nameAdd" required readonly>
                    </div>
                </div>

                <div class="box-line">
                    <div class="name">Image:</div>
                    <div class="input-group">
                        <input type="text" class="input-style" value = "${tree.getTreeImg()}" name="imageAdd" required>
                    </div>
                </div>

                <div class="box-line">
                    <div class="name">Quality:</div>
                    <div class="input-group">
                        <input type="text" class="input-style" value = "${tree.getAmount()}" name="qualityAdd" required>
                    </div>
                </div>

                <div class="box-line">
                    <div class="name">Price:</div>
                    <div class="input-group">
                        <input type="text" class="input-style" value = "${tree.getPrice()}" name="PriceAdd" required>
                    </div>
                </div>
                <div class="box-line">
                    <div class="name">Kind:</div>
                    <div class="input-group">
                        <input type="text" class="input-style" value = "${tree.getTreeKind()}" name="KindAdd" required>
                    </div>
                </div>
                <div class="box-line">
                    <div class="name">Brand:</div>
                    <div class="input-group">
                        <input type="text" class="input-style" value = "${tree.getPrice()}" name="BrandAdd" required>
                    </div>
                </div>

                <div class="box-line">
                    <div class="name">Description:</div>
                    <div class="input-group">
                        <input type="text" class="input-style" value = "${tree.getTreeDescription()}" name="DescriptionAdd" required>
                    </div>
                </div>
                <div  class="add-btn-container">
                    <input type="hidden" name="action" value="updateItems">
                    <input type="hidden" name="itemId" value="${tree.getTreeid()}">
                    <button class="add-btn btn-box-add">UPDATE</button>
                    <form action="productManagement">
                    <input type="hidden" name="action" value="goToManageProduct">
                        <button class="back-btn btn-box-add">BACK</button>
                    </form>
                </div>
            </form>
    </div>
    
    </div>
</div>
</body>
</html>