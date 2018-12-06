<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

   <h1 class="my-4">List Of Items</h1>
          
          <div class="list-group">
          <c:forEach items ="${categories}" var ="category">
           <a href="${contextRoot}/show/all/${category.id}/products" class="list-group-item" id="a_${category.name}">${category.name}</a> <i class='fas fa-laptop' style='font-size:24px;color:red'></i>
            
          </c:forEach>  
          
          </div>
          
</body>
</html>