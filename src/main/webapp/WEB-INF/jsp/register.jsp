<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>LoginW</title>
</head>
<body>

<h2>Blogger Information</h2>
<form:form method="POST" action="/register">
   <table>
    <tr>
        <td><form:label path="username">User Name</form:label></td>
        <td><form:input path="username" /></td>
    </tr>
    <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:input path="password" /></td>
    </tr>
       <tr>
           <td><form:label path="role">Role</form:label></td>
           <td><form:input path="role" /></td>
       </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>