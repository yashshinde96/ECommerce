
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Product</a></li>
			<li class="breadcrumb-item">View Product</li>
			<li class="breadcrumb-item active">Update Product</li>
			<li class="breadcrumb-item"><a class="btn btn-primary right"
				href='<spring:url value="/Admin/viewProduct"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Update Product</h2>
		</div>

		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		<div class="container mt-3">
			<div class="container" style="margin-top: 50px;">
				<form method="post"
					action='<spring:url value="/Admin/updateProduct"></spring:url>'
					enctype="multipart/form-data">
					<fieldset>
						<div class="row">
						<input type="text" value="${sessionScope.productDetails.id}" name="id" hidden>
							<div class="col-lg-4">
								<label class="col control-label text-center" for="category">Product
									Category</label>
								<div class="input-group">
									<input type="text"
										value="${sessionScope.productDetails.category}"
										class="form-control" name="category" />
								</div>
							</div>

							<div class="col-lg-4">
								<label class="col control-label text-center" for="stock">Available
									Stock</label>
								<div class="input-group">
									<input id="stock" value="${sessionScope.productDetails.stock}"
										name="stock" class="form-control text-center" type="number" />
								</div>
							</div>

							<div class="col-lg-4">
								<label class="col control-label text-center" for="brand">
									Brand</label>
								<div class="input-group">
									<input type="text" value="${sessionScope.productDetails.brand}"
										class="form-control text-center" id="brand" name="brand" />
								</div>
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-md-4">
								<label class="col control-label text-center" for="name">
									Name </label>
								<div class="input-group">
									<input id="name" value="${sessionScope.productDetails.name}"
										name="name" placeholder="" class="form-control text-center"
										type="text" />
								</div>
							</div>


							<div class="col-lg-4">
								<label class="col control-label text-center" for="title">
									Title </label>
								<div class="input-group">
									<input id="title" name="title" placeholder=""
										value="${sessionScope.productDetails.title}"
										class="form-control text-center" type="text" />
								</div>
							</div>

							<div class="col-md-4">
								<label class="col control-label text-center" for="price">
									Price </label>
								<div class="input-group">
									<input id="price" name="price" placeholder=""
										value="${sessionScope.productDetails.price}"
										class="form-control" type="number" />
								</div>
							</div>
						</div>
						<hr>

						<div class="row form-group">
							<div class="col-lg-8">
								<label class="col control-label text-center" for="description">Description</label>
								<div class="input-group">
									<textarea class="form-control" id="description.brief"
										name="description" rows="5"> ${sessionScope.productDetails.description}</textarea>
								</div>
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-md-12 panel">
								<h2>Manufacture Information</h2>
							</div>
						</div>
						<div class="row form-group">
							<div class="col-lg-4">
								<label class="col control-label text-center"
									for="manufacture_date"> Manufacture Date </label>
								<div class="input-group">
									<input id="manufacture_date" name="mdate"
										value="${sessionScope.productDetails.mdate}"
										class="form-control text-center" type="date" />
								</div>
							</div>


							<div class="col-lg-4">
								<label class="col control-label text-center" for="warrenty">
									Warrenty</label>
								<div class="input-group">
									<input id="warrenty" name="warrenty" placeholder=""
										value="${sessionScope.productDetails.warrenty}"
										class="form-control text-center" type="number" />
								</div>
							</div>

							<div class="col-lg-4">
								<label class="col control-label text-center" for="man_info">
									Manufacture Name </label>
								<div class="input-group">
									<input id="man_info" name="mname" placeholder=""
										value="${sessionScope.productDetails.mname}"
										class="form-control text-center" type="text" />
								</div>
							</div>
						</div>

						<hr>

						<hr>
						<div class="row">
							<div class="col-lg-12 panel ">
								<h2>Other Details</h2>
							</div>
						</div>


						<div class="row form-group">
							<div class="col-lg-3">
								<label class="col control-label text-center" for="dimension">Dimension</label>

								<input id="dimension" name="dimension"
									value="${sessionScope.productDetails.dimension}"
									placeholder="dimension" class="form-control" type="text" />
							</div>



							<div class="col-lg-3">
								<label class="col control-label text-center" for="color">Color</label>
								<div class="input-group">
									<input id="color" name="color" class="form-control"
										value="${sessionScope.productDetails.color}" type="color" />
								</div>
							</div>

							<div class="col-lg-2">
								<label class="col control-label text-center" for="weight">Weight</label>

								<input id="weight" name="weight" placeholder=""
									value="${sessionScope.productDetails.weight}"
									class="form-control" type="number" />
							</div>
							</div>

							<div class="row">
								<div class="col-lg-4">
									<div class="img-box">
										<img height="100px" width="100px"
											src="data:image/jpeg;base64,${sessionScope.productDetails.imgUtility}"
											alt="">
									</div>
								</div>
								<div class="col-lg-4">
									<label class="col control-label text-center" for="image">Product
										Image</label> <input type="file" value="${sessionScope.productDetails.image}" id="myFile" name="image">
								</div>
							</div>
						</div>
						<hr>
						<hr>
						<div class="form-group row">
							<div class="col-md-8 text-center">
								<input type="submit" id="save" value="update" name="save"
									class="btn btn-large btn-success">

								<a href='<spring:url value="/Admin/viewProduct"/>' class="btn btn-large btn-danger" type="reset">Cancel</a>
							</div>
						</div>
					</fieldset>
				</form>
			</div>


		</div>
	</div>
</div>
