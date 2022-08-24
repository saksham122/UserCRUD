<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
<title>Insert title here</title>
</head>
<body>

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Fill The User Details</h1>
				<form action="handle-user" method="post">
					<div class="form-group">
						<label for="name"> User Name</label><input type="text"
							class="form-control" id="name" aria-describeby="emailHelp"
							name="name" placeholder="Enter the name of user">
					</div>
					<div class="form-group">

						<label for="gender">User Gender</label>
						<textarea class="form-control" name="gender" id="gender" rows="5"
							placeholder="Enter The Gender of the User"></textarea>
					</div>
					<div class="form-group">
						<label for="age">User Age</label><input type="text"
							placeholder="Enter the Age of The User" name="age"
							class="form-control" id="age">
					</div>
					<div class="container text center">
						<a href="${pageContext.request.contextPath }/"
							class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-primary">Add</button> 
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>