<div class="container">

	<div class="row">
		<!-- To Display SideBar -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!-- To Display The Actual Products -->
		<div class="col-md-9">
			<!-- Adding BreadCrumb Component -->
			<div class="row">

				<div class="col-lg-9">


					<c:if test="${userClickAllProducts == true }">
						<script>
							window.categoryId = '';
						</script>
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
								<li class="breadcrumb-item active">All Products</li>

							</ol>
						</nav>
					</c:if>

					<c:if test="${userClickCategoryProducts == true }">

						<script>
							window.categoryId = '${category1.id}';
						</script>

						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
								<li class="breadcrumb-item active">Category</li>
								<li class="breadcrumb-item active">${category1.name}</li>
							</ol>
						</nav>
					</c:if>



				</div>



			</div>

			

				<div class="col-xs-12">

					<table id="listofprod" class="table table-striped table-dark ">

						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Quantity</th>
								<th>Price</th>
								<th></th>
							</tr>
						</thead>
						
						

					</table>


				</div>

			</div>

		</div>

	</div>


