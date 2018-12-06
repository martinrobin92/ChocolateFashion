<div class="container">

<div class="row">
<!-- To Display SideBar -->
<div class="col-md-3">

<%@include file="./shared/sidebar.jsp" %>

</div>

<!-- To Display The Actual Products -->
<div class="col-md-9">
<!-- Adding BreadCrumb Component -->
<div class="row">

<div class="col-lg-9">


<c:if test="${userClickAllProducts == true }">
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
<li class="breadcrumb-item active">All Products</li>

</ol>
</nav>
</c:if>

<c:if test="${userClickCategoryProducts == true }">

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

</div>

</div>


</div>