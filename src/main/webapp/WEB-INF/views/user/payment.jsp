<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Method</title>
</head>
<body>

<form:form class = "form-horizontal" commandName = "paymentMethod">

Net Banking: <input type = "radio" name = "paymentMethod" value = "Net Banking">
Cash On Delivery: <input type = "radio" name = "paymentMethod" value = "Cash On Delivery">

<div class = "col=md-offset-3">
<input type = "submit" name = "_eventId_submitPaymentMethod" 
       class = "btn btn-md-btn-success" value = "Save">

<input type = "submit" name = "_eventId_cancelPaymentMethod" 
       class = "btn btn-md-btn-danger" value = "Cancel">
</div>
</form:form>
</body>
</html>