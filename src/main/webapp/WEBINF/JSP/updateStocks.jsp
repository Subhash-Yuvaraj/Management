<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>Update Stocks</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>

<body>
<div style="display:flex">

<div style="flex:1"><table summary=""><br>
 <caption></caption>
   <tr style="height:30px">
   				<th>Item Id</th>
				<th>Item</th>
				<th>Price</th>
				<th>In Stock</th>
				
  </tr>
  <tbody>
			<c:forEach items="${Goods}" var="good">
			<tr style="height:10px">

				<td>${good.id}</td>
				<td>${good.name}</td>
				<td>${good.price}</td>
				<td>${good.quantity}</td>
			</tr>
			</c:forEach>
		</tbody>
	
</table>
</div>
<div style="flex:1">

<br>
<br>
<br>
Enter new Stock Quantity
<br>
<br>
<br>
<form class="form" method = "post">
			<input name="car" type="text" class="form-control" >
			<br>
			<br>
			<input name="beet" type="text" class="form-control" >
			<br>
			<br>
			<input name="milk" type="text" class="form-control" >
			<br>
			<br>
			<input name="tomato" type="text" class="form-control" >
			    <button type="submit" class="btn btn-success">Update</button>
			
		<br>
		</form>
</div>

</div>
<br>
		<br>
		
		<a class="btn btn-success" href="/adminDashboard">Return to Dashboard</a>
		<br>
    
    <br>	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
</body>

<style>

body{
background:linear-gradient(#e66465, #9198e5);
 text-align:center;
}

caption {
text-align:center;
color: #ffffff;
}

table { 
  border: 2px solid #787878;
        width: 800px;
  border-spacing: 0; 
        margin: auto; }

th {background-color: #ffffff;}

td, th { padding: 25px; 
         font-family: Arial, sans-serif;  } 

caption { font-family: Verdana, sans-serif;
           font-size: 2.0em;
           font-weight: bold; 
		   padding-bottom: 5px;}

tr:nth-of-type(even) { background-color:#ffffff; } 
tr:nth-of-type(odd){
background-color:#FFF5CC;
}
tr:first-of-type { 
                   color: #0D0D0D; }

.centered{
  display:flex;
  justify-content:center;
  align-items:center;
}


a{
  font-size:larger;
  font-weight:600;
  text-decoration:none;
  margin: 1rem auto;
}
.btn{

border-radius:20px;
font-size:15px;
background-color:#ffffff;
color:#000000;
}


</style>

</html>