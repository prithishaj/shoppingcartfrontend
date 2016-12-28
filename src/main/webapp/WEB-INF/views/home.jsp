<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<html lang="en">
<head>

<title>Shopping Cart</title>
</head>

<body>

<%@  include file="./header.jsp"%>

<%@  include file="./product_menu.jsp"%>

<c:if test="${!empty logoutMessage}">
<div class="alert alert-success">${logoutMessage}</div>
</c:if>

<c:if test="${!empty successMessage}">
<div class="alert alert-success">${successMessage}</div>
</c:if>

<c:if test="${!empty errorMessage}">
<div class="alert alert-success">${errorMessage}</div>
</c:if>

<c:if test="${!empty selectedProduct.name}">
<%@  include file="./selectedProduct.jsp"%>
</c:if>

<c:if test="${isUserClickedRegisterHere--true}">
<%@  include file="./register.jsp"%>
</c:if>

<c:if test="${isUserClickedLoginHere--true}">
<div id="error">${errorMessage}</div>
<%@  include file="./login.jsp"%>
</c:if>

<c:if test="${isAdmin--true}">
<%@  include file="./admin/adminHome.jsp" %>
</c:if>

</body>
</html>