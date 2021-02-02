<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'viewageemp1result.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>


    <table class="table table-bordered table-striped table-control table-hover table-condensed ">
<thead class="head1">
<tr ><th colspan="12">emp1loyees List based on age</th></tr>

</thead>
 <tbody>
  <tr><th>Id</th><th>Name</th><th>qualification</th><th>gender</th><th>doj</th>
  <th>Pancard</th><th>dob</th><th>salary</th></tr>

    <c:forEach items="${ageemployeesList}" var="emp1">
	 <tr><td>${emp1.id}</td><td>${emp1.name}<td>${emp1.qualification}</td><td>${emp1.gender}</td><td>${emp1.doj}</td>
	  <td>${emp1.pancard}</td><td>${emp1.dob}</td><td>${emp1.salary}</td>

	  </tr>
	  </c:forEach>
		</tbody>
	</table>
  </body>
</html>
