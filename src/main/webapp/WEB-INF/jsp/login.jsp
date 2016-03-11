<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <title>LoginW</title>
</head>
<body>

<h2>Blogger Information</h2>
<form name="f" action="<c:url value='login'/>"
      method="POST">
    <table>
        <tr>
            <td>Username:</td>
            <td><input type='text' name='username' /></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password'></td>
        </tr>
        <tr>
            <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit">&nbsp;<input name="reset" type="reset"></td>
        </tr>
    </table>
</form>
</body>
</html>


