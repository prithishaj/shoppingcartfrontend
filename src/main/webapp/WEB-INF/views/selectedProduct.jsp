<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:set var = "imageFolder" value = "D:\\ShoppingCart\\Images" />

<table>

<tr>

    <td>
        <img alt = "${selectedProduct.name}" src = "${imageFolder}${selectedProduct.id}.jpg">
    </td>
    
    <td><a class = "col-xs-offset-5 btn btn-tg btn-success" href = "cart_checkout">Checkout</a>
    </td>
    <td></td>
</tr>

<tr>
     <td>Price : ${selectedProduct.price}</td>
</tr>

<tr>
    <td><a class = "icon-shopping-cart" href = "myCart/add/${selectedProduct.id}">Add To Cart</a></td>     
</table>

</body>
</html>