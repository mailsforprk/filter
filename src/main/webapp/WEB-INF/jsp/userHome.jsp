<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>

<%if(true){%><div>Welcome: ${message}!</div><%} %> 
	<a href="postBlog">New Post</a><br>
	
	<c:if test="${not empty postList}">

		<ul>
			<c:forEach var="post" items="${postList}">
				<li>${post.heading}</li>
					${post.content}
			</c:forEach>
		</ul>

	</c:if>
	
</body>
</html>




