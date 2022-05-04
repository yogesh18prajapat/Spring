<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Product</title>
    <style>
        table{
            border: 1px solid black;
            border-radius: 5px;
            padding: 30px;
            box-shadow: 0 1px 2px 0 rgb(0 0 0 / 20%);

        }
        input[type=text]{
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            box-sizing: border-box;
            border: none;
            border-bottom: 2px solid lightgrey;
        }
        .content{
            text-align: center;
        }
        .container{
            width: 100%;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-content: center;
            align-items: center;
        }
        input[type=submit]{
            width: 80%;
            height: 30px;
            background-color: #fb641b;
            border: 1px solid black;
            border-radius: 3px;
            text-transform: uppercase;
            cursor: pointer;
            box-shadow: 0 1px 2px 0 rgb(0 0 0 / 20%);
        }
        tr td th{
            padding: 100px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="content">
            <form action="add_product" method="post" id="form">
                <table>
                    <tr>
                        <th>Product Name</th>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <th>Product Description</th>
                        <td><textarea name="description" id="form" cols="30" rows="10"></textarea></td>
                    </tr>
                    <tr>
                        <th>Product Price</th>
                        <td><input type="text" name="price"></td>
                    </tr>
                    <tr>
                        <th>Quantity</th>
                        <td><input type="text" name="quantity"></td>
                    </tr>
                    <tr>
                        <th>Product Image</th>
                        <td><input type="text" name="img"></td>
                    </tr>
                 
                    <tr>
                        <th>Section</th>
                        <td>
                            <input type="radio" name="section" value="male"> Male 
                            <input type="radio" name="section" value="female"> Female 
                            <input type="radio" name="section" value="kids"> Kids
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Add Product"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>