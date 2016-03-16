<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>

<body>
<div id="postForm">
	<h2>Writing new Post</h2>
	<form:form id="blogpostform" name="blogpostform" method="POST" commandName="blogPost" action="/postBlog">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
				<tr>
				<td>Heading :</td>
				<td><form:input path="heading"  /></td>
				<td><form:errors path="heading" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Post :</td>
				<td><form:textarea path="content" rows="5" cols="30" /></td>
				<td><form:errors path="content" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td colspan="3"><input type="submit" name="Post" /></td>
			</tr>
		</table>
	</form:form>
</div>
<div>
<form id="filterform">
<table>
			<tr>
				<td>filtername</td>
				<td><input type="text" name="filtername" /></td>				
			</tr>			
			<tr>
				<td colspan="3"><button type="button" onclick="saveFilter()">SaveFilter</button></td>
			</tr>
		</table>
</form>
</div>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
 <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.8/jquery.validate.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
   
});
function saveFilter()
{
    var datastring = $("#blogpostform").serialize();
    var filterName = $("#filterform").find('input[name="filtername"]').val();  
    console.log(datastring);
     console.log(filterName);
   
        $.ajax({
            type: "POST",
            url: "saveFilter",
            data:datastring,
            success: function(data) {
                 alert('Data send');
            }
        });
         return false;
}
</script>
</body>
</html>