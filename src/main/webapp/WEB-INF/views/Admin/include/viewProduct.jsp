
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Layout</a></li>
			<li class="breadcrumb-item active">Advertisement</li>
			<li class="breadcrumb-item">
			<a class="btn btn-primary right" href='<spring:url value="/Admin/Dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Availabe Product  List</h2>
		</div>

<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Sr No</th>
							<th scope="col">Product Image</th>
							<th scope="col">Product Name</th>
							<th scope="col">Availabe Stock</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="prod" items="${sessionScope.productList}">
							<tr>
								<td scope="row">${prod.id}</td>
								<td><img src="data:image/jpeg;base64,${prod.imgUtility}" height=100px width=100px/></td>
								<td>${prod.name}</td>
								<td>${prod.stock}</td>
								<td><a 
									href='<spring:url value="/Admin/UpdateProduct?pid=${prod.id}"/>'><button
											type="button" class="btn btn-primary">
											<i class="far fa-eye"></i>
										</button></a> <a 
									href='<spring:url value="/Admin/delete_product?pid=${prod.id}"/>'><button
											type="button" class="btn btn-danger">
											<i class="far fa-trash-alt"></i>
										</button></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>