<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="row">

		<div class="col-xs-12">

			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				<li class="breadcrumb-item"><a
					href="${contextRoot}/show/all/products">Products</a></li>
				<li class="breadcrumb-item active">${product.name }</li>

			</ol>

		</div>




	</div>

	<div class="row">

		<div class="col-xs-12 col-sm-4">
			<div class="thumbnail">
				<img src="${images}/${product.code}.jpg" class="img img-responsive" />
			</div>
		</div>
		<div class="col-xs-12 col-sm-4"></div>

		<div class="col-xs-12 col-sm-4">

			<br />

			<h1>${product.name}</h1>
			<hr />

			<p>
				<b>${product.description}</b>
			</p>
			<hr />

			<h3>
				Price <strong> &#8377; ${product.unitPrice} /- </strong>
			</h3>
			<hr />

			
			
			<c:choose>
				<c:when test="${product.quantity < 1}">
					<h4>
						Quantity Available :<strong><span style="color: red">Out
								Of Stock</span> </strong>
					</h4>
				<del><a href="javascript:void(0)"class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart">AddToCart</span></a></del>
				</c:when>
				<c:otherwise>
				
				<h4>
				Quantity Available :<strong> ${product.quantity}</strong>
			</h4>
			<a href="${contextRoot}/cart/add/${product.id}/product"class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart">AddToCart</span></a>
				</c:otherwise>
			</c:choose>
			 
			<a	href="${contextRoot}/show/all/products" class="btn btn-primary"><span class="glyphicon glyphicon-chevron-left">Back</span></a>
		</div>
	</div>



</div>