<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    <!-- Mapping The Static Resources Css Js  -->
    <spring:url var="css" value="/assets/css"/>
    
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${title}</title>
    
    <script>
    
    window.menu = '${title}';
    
    window.contextRoot = '${contextRoot}';
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

 <!-- Bootswatch CSS -->
<link href="${css}/bootstrap-theme.css" rel="stylesheet">


<link href="${css}/jquery.dataTables.css" rel="stylesheet">

<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">

<!-- DataTable CSS -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">
 
    <!-- Custom styles for this template -->
    <link href="${css}/myapp.css" rel="stylesheet">

  </head>

  <body>
<div class="wrapper">
   <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <div class="collapse navbar-collapse" id="navbarResponsive">
              <a class="nav-link" id="home" href="${contextRoot}/home">Home
                <span class="sr-only">(current)</span>
              </a>
           </div>
      </div>
    </nav>
   
 <div class="content">
 <div class="container">
 
 <div class="row">
 
 <div class ="col-xs-12">
 
 <div class="jumbotron">
 
 <h1>${errortitle}</h1>
 <hr/>
 
 <blockquote>
 
 ${errordescription}
 </blockquote>
 
 
 
 </div>
 
 
 
 
 
 </div>
 
 
 
 
 
 </div>
 
 
 
 
 
 
 </div>
 </div>
 </div>
 
 
     <script src="${js}/jquery.js"></script>
    
    <script src="${js}/bootstrap.bundle.min.js"></script>

<!-- JQuer DataTables -->
<script type="text/javascript" src="${js}/jquery.dataTables.js"></script>

<script type="text/javascript" src="${js}/dataTables.bootstrap4.js"></script>


<script src="${js}/myapp.js"></script>

  </body>

</html>
