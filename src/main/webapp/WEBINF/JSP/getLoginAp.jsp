<html>

<head>
<title>GetApartment</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body>
	<font color="red">${message}</font>
	<div class="container">
		
		<form method="post">
		<fieldset class="form-group">
			<label>Apartment Id</label>
			<input name="a_id" type="text" class="form-control" required="required"/>
		</fieldset>
		
		
		<br>
		<button type="submit" class="btn btn-success">View</button>
		</form>
		
	</div>
	<br>
		<a type="button" class="btn" href="/adminDashboard">Return to Dashboard </a>
	<br>	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>

</html>