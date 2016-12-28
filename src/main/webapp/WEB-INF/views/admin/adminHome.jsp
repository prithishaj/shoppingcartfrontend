<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Admin page</h2>

<form:form action="category" method="post" commandName="user">  
<table>
        <tr>
            <td><form:label path="id">
            <spring:message text="ID"/>
            </form:label></td>

            <td><form:input path="id" pattern=".{4,15}" required="true"
            title="id should be 4 to 15 characters"/></td>
         </tr>

      <tr>
<td><form:label path="name">
<spring:message text="Name"/>
</form:label></td>

<td><form:input path="name" required="true" 
title="Name field should not be empty" /></td>
     </tr>

<tr>
<td><form:label path="address">
<spring:message text="Address"/>
</form:label></td>

<td><form:input type="tel" path="address" pattern="^\d{10}$" required="true"
title="Please enter the valid address"/></td>
</tr>


<tr>
<td><input type="submit" value="<spring:message text="Admin"/>"/></td>
<td><input type="reset" value="<spring:message text="Reset"/>"/></td>
</tr>
</table>

</form:form>

</body>
</html>