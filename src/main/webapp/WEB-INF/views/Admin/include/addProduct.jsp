
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Product</a></li>
			<li class="breadcrumb-item">Add Product</li>
			<li class="breadcrumb-item active">Add Gift</li>
			<li class="breadcrumb-item"><a class="btn btn-primary right"
				href='<spring:url value="/Admin/Dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Add Product</h2>
		</div>

		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		<div class="container mt-3">
			<div class="container" style="margin-top: 50px;">
				<form method="post" action='<spring:url value="/Admin/add_product"></spring:url>' enctype="multipart/form-data">
					<fieldset>
						<div class="row">
							<div class="col-lg-4">
								<label class="col control-label text-center" for="category">Product
									Category</label>
								<div class="input-group">
									<input type="text" class="form-control" name="category" />
								</div>
							</div>

							<div class="col-lg-4">
								<label class="col control-label text-center" for="stock">Available
									Stock</label>
								<div class="input-group">
									<input id="stock" name="stock" class="form-control text-center"
										type="number" />
								</div>
							</div>

							<div class="col-lg-4">
								<label class="col control-label text-center" for="brand">
									Brand</label>
								<div class="input-group">
									<input type="text" class="form-control text-center" id="brand"
										name="brand" />
								</div>
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-md-4">
								<label class="col control-label text-center" for="name">
									Name </label>
								<div class="input-group">
									<input id="name" name="name" placeholder=""
										class="form-control text-center" type="text" />
								</div>
							</div>


							<div class="col-lg-4">
								<label class="col control-label text-center" for="title">
									Title </label>
								<div class="input-group">
									<input id="title" name="title" placeholder=""
										class="form-control text-center" type="text" />
								</div>
							</div>

							<div class="col-md-4">
								<label class="col control-label text-center" for="price">
									Price </label>
								<div class="input-group">
									<input id="price" name="price" placeholder=""
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
										name="description" rows="5"></textarea>
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
										class="form-control text-center" type="date" />
								</div>
							</div>


							<div class="col-lg-4">
								<label class="col control-label text-center" for="warrenty">
									Warrenty</label>
								<div class="input-group">
									<input id="warrenty" name="warrenty" placeholder=""
										class="form-control text-center" type="number" />
								</div>
							</div>

							<div class="col-lg-4">
								<label class="col control-label text-center" for="man_info">
									Manufacture Name </label>
								<div class="input-group">
									<input id="man_info" name="mname" placeholder=""
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

								<input id="dimension" name="dimension" placeholder="dimension"
									class="form-control" type="text" />
							</div>



							<div class="col-lg-3">
								<label class="col control-label text-center" for="color">Color</label>
								<div class="input-group">
									<input id="color" name="color" class="form-control"
										type="color" />
								</div>
							</div>

							<div class="col-lg-2">
								<label class="col control-label text-center" for="weight">Weight</label>

								<input id="weight" name="weight" placeholder=""
									class="form-control" type="number" />
							</div>


							<div class="col-lg-4">
								<label class="col control-label text-center" for="image">Product
									Image</label> <input type="file" id="myFile" name="image">
							</div>
						</div>
						<hr>
						<hr>
						<div class="form-group row">
							<div class="col-md-8 text-center">
								<input type="submit" id="save" value="Save" name="save"
									class="btn btn-large btn-success">

								<button class="btn btn-large btn-danger" type="reset">Cancel</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>


		</div>
	</div>
</div>
