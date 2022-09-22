<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>Login Info</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>

<body>
	
	<div class="container">
	<table class="table table-striped">
		<caption>Login Info</caption>
		<thead>
			<tr>
				<th>Login ID</th>
				<th>Password</th>
				
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${Login}" var="l">
			<tr>
				<td>${l.id}</td>
				<td>${l.password}</td>
				
				
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<br>
		<a type="button" class="btn" href="/adminDashboard">Return to Dashboard </a>
	<br>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>

</html>