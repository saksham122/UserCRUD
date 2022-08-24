<html>
<head>
<%@include file="./base.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">Welcome to User CRUD App</h1>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Name</th>
							<th scope="col">Gender</th>
							<th scope="col">Age</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${users }" var="u">
						<tr>
							<th scope="row">${u.id }</th>
							<td>${u.name }</td>
							<td>${u.gender }</td>
							<td>${u.age}</td>
							<td>
							<a href="delete/${u.id }"><i class="fa-solid fa-trash-can"></i></a>
							<a href="update/${u.id }"><i class="fa-solid fa-pen"></i></a>
							
							</td>
						</tr>
						</c:forEach>
						
					</tbody>
				</table>
				
				<div class="container text-center">
				<a href ="add-user" class="btn btn-outline-success">Add User</a>
				<a href ="search-user" class="btn btn-outline-success">Search User</a>
				
				
				</div>
			</div>


		</div>
	</div>
</body>
</html>
