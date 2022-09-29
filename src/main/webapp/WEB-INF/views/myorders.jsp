<%@include file="header.jsp" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%
		if ((session.getAttribute("userDetails") == null) || (session.getAttribute("userDetails") == "")) {
	%>
	<c:redirect url="../"></c:redirect>
	<%
		} else {
	%>
<div class="alert alert-primary text-center" role="alert">
			<h2>My Past Order List</h2>
		</div>

<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Sr No</th>
							<th scope="col">Product Image</th>
							<th scope="col">Product Name</th>
							<th scope="col">Amount</th>
							<th scope="col">Status</th>
						</tr>
					</thead>
					<%int sr=0; %>
					<tbody>
						<c:forEach var="prod" items="${sessionScope.orderList}">
							<tr>
								<td scope="row"> ${sr=sr+1} </td>
								<td><img src="data:image/jpeg;base64,${prod.prod.imgUtility}" height=100px width=100px/></td>
								<td>${prod.prod.name}</td>
								<td>${prod.prod.price}</td>
								<td>${prod.status}</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
</body>
</html>
<%}%>

 <%@include file="footer.jsp" %>