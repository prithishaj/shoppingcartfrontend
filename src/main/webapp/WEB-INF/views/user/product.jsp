<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
</head>
<body>

<h1>Add a Product</h1>

<c:url var = "addAction" value = "/manage_product_add?${_csrf.parameterName}-${_csrf.token}"></c:url>
<form:form action ="${addAction}" commandName = "product" 
           enctype = "multipart/form-data" method = "post">
<table>
<tr>
   <td><form:label path="id">
   <spring:message text = "ID" />
   </form:label></td>
   
   <c:choose>
   <c:when test = "${!empty product.id}">
   <td><form:input path = "id" value = "" disabled = "true" readonly="true" />
   </td>
   </c:when>
   
   <c:otherwise>
   <td><form:input path = "id" pattern = ".{5.20}" required = "true"
                title = "id should contains 5 to 20 characters" /></td>
</c:otherwise>
<tr>
<form:input path = "id" hidden = "true" />
<td><form:label path = "name">
     <spring:message text = "Name" />
     </form:label>
     </td>
     </tr>
     </c:choose>
     </tr>
     </form:form>
</table>

</body>
</html>