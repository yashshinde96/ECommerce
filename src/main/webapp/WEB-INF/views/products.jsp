
<%@include file="header.jsp" %>

<section class="slider_section ">
			<div class="slider_bg_box">
				<c:forEach  var="banner" items="${sessionScope.bannerList}">
				<img src="data:image/jpeg;base64,${banner.imgUtility}" alt="">
				</c:forEach>
			</div>
			<div id="customCarousel1" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<div class="container ">
							<div class="row">
								<div class="col-md-7 col-lg-6 ">
									<div class="detail-box">
										<h1>
											<span> Sale 20% Off </span> <br> On Everything
										</h1>
										<p>Explicabo esse amet tempora quibusdam laudantium,
											laborum eaque magnam fugiat hic? Esse dicta aliquid error
											repudiandae earum suscipit fugiat molestias, veniam, vel
											architecto veritatis delectus repellat modi impedit sequi.</p>
										<div class="btn-box">
											<a href="" class="btn1"> Shop Now </a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="carousel-item ">
						<div class="container ">
							<div class="row">
								<div class="col-md-7 col-lg-6 ">
									<div class="detail-box">
										<h1>
											<span> Sale 20% Off </span> <br> On Everything
										</h1>
										<p>Explicabo esse amet tempora quibusdam laudantium,
											laborum eaque magnam fugiat hic? Esse dicta aliquid error
											repudiandae earum suscipit fugiat molestias, veniam, vel
											architecto veritatis delectus repellat modi impedit sequi.</p>
										<div class="btn-box">
											<a href="" class="btn1"> Shop Now </a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="carousel-item">
						<div class="container ">
							<div class="row">
								<div class="col-md-7 col-lg-6 ">
									<div class="detail-box">
										<h1>
											<span> Sale 20% Off </span> <br> On Everything
										</h1>
										<p>Explicabo esse amet tempora quibusdam laudantium,
											laborum eaque magnam fugiat hic? Esse dicta aliquid error
											repudiandae earum suscipit fugiat molestias, veniam, vel
											architecto veritatis delectus repellat modi impedit sequi.</p>
										<div class="btn-box">
											<a href="" class="btn1"> Shop Now </a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="container">
					<ol class="carousel-indicators">
						<li data-target="#customCarousel1" data-slide-to="0"
							class="active"></li>
						<li data-target="#customCarousel1" data-slide-to="1"></li>
						<li data-target="#customCarousel1" data-slide-to="2"></li>
					</ol>
				</div>
			</div>
		</section>
		<!-- end slider section -->
	</div>
	
	<section class="product_section layout_padding">
		<div class="container">
			<div class="heading_container heading_center">
				<h2>
					Our <span>products</span>
				</h2>
			</div>
			<div class="row">
				<c:forEach var="prod" items="${sessionScope.productList}">
					<div class="col-sm-6 col-md-4 col-lg-4">
						<div class="box">
							<div class="option_container">
								<div class="options">
									<a href='<spring:url value="/productd?pid=${prod.id}"></spring:url>' class="option1"> ${prod.name} </a> 
									<%
								if (session.getAttribute("userDetails") != null) {
							%>
								<a
									href='<spring:url value="/Customer/addToCard?pid=${prod.id}"/>'
									class="option2"> Add to Cart</a>

								<%}else{ %>
									<a href='<spring:url value="/login"/>' class="option2"> Add to Cart</a>
									<%} %>
								</div>
							</div>
							<div class="img-box">
								<img src="data:image/jpeg;base64,${prod.imgUtility}" alt="">
							</div>
							<div class="detail-box">
								<h5>${prod.name}</h5><br>
								<h6>${prod.price}</h6>
							</div>
						</div>
					</div>

				</c:forEach>
			</div>
			<div class="btn-box">
				<a href=""> View All products </a>
			</div>
		</div>
	</section>
	<!-- end product section -->
	
		 <%@include file="footer.jsp" %>