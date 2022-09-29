
<%@include file="header.jsp" %>


	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="text-center mb-5 text-dark">${requestScope.message}</div>
				<div class="text-center mb-5 text-danger">${requestScope.error}</div>
				<div class="card my-5">

					<form action='<spring:url value="/userLogin"/>' method="post" class="card-body cardbody-color p-lg-5">

						<div class="text-center">
							<img
								src='<spring:url value="/images/login-logo.png"/>'
								class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
								width="200px" alt="profile">
						</div>

						<div class="mb-3">
							<input  style="text-decoration: none;" type="text" name="email" class="form-control" id="Username"
								 placeholder="User Name">
						</div>
						<div class="mb-3">
							<input type="password" name="password" class="form-control" id="password"
								placeholder="password">
						</div>
						<div class="text-center">
							<button type="submit" class="btn btn-color px-5 mb-5 w-100">Login</button>
						 <a href='<spring:url value="/forgetPassword"/>' class="text-dark fw-bold" style="flot:left;"> 	Forget Password</a>
						</div>

						
						
						<div id="emailHelp" class="form-text text-center mb-5 text-dark">
							Not Registered? <a href='<spring:url value="/registration"/>' class="text-dark fw-bold"> Create an Account</a>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<!-- partial -->
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta2/js/bootstrap.min.js'></script>
 <%@include file="footer.jsp" %>