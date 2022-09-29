
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Orders</a></li>
			<li class="breadcrumb-item active">Orders</li>
			<li class="breadcrumb-item">
			<a class="btn btn-primary right" href='<spring:url value="/Admin/Dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Availabe Order  List</h2>
		</div>

<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Sr No</th>
							<th scope="col">Product Image</th>
							<th scope="col">Product Name</th>
							<th scope="col">Customer Name</th>
							<th scope="col">Customer Address</th>
							<th scope="col">Status</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="prod" items="${sessionScope.orderList}">
							<tr>
								<td scope="row">${prod.id}</td>
								<td><img src="data:image/jpeg;base64,${prod.prod.imgUtility}" height=100px width=100px/></td>
								<td>${prod.prod.name}</td>
								<td>${prod.customer.name}</td>
								<td>${prod.customer.address},${prod.customer.locality}</td>
								<td>${prod.status}</td>
								<td><a 
									href='<spring:url value="/Admin/toggle_order?oid=${prod.id}"/>'><button
											type="button" class="btn btn-primary">
											<i class="far fa-eye"></i>
										</button></a> </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>