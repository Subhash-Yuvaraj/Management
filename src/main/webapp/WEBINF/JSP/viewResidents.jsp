<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>Visitors</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>

<body>
	<table summary=""><img class = "img" src="https://g5-assets-cld-res.cloudinary.com/image/upload/x_0,y_0,h_3432,w_6240,c_crop/q_auto,f_auto,c_fill,g_center,h_1098,w_1998/v1629135189/g5/g5-c-5m5d9vuh1-harbor-group-international-single-domain-client/g5-cl-1lqe6nzgbr-harbor-group-international-single-domain-client-sugar-land-tx/uploads/resident_resources-hero_xqcy4w.jpg"  width="300" height="200" ><br>
 <caption>LIST OF RESIDENTS</caption>
   <tr>
   				<th>Apartment ID</th>
				<th>Resident ID</th>
				<th>Name</th>
				<th>Gender</th>
				<th>Age</th>
				<th>Blood Group</th>
				<th>Contact</th>
     
  </tr>
  <tbody>
			<c:forEach items="${Residents}" var="Resident">
			<tr>
				<td>${Resident.ap_id}</td>
				<td>${Resident.r_id}</td>
				<td>${Resident.name}</td>
				<td>${Resident.gender}</td>
				<td>${Resident.age}</td>
				<td>${Resident.blood_group}</td>
				<td><a type="button" class="btn btn-success" href="/view?r_id=${Resident.r_id}">View Contact</a></td>
			</tr>
			</c:forEach>
		</tbody>
</table>
<br>
    <div class="centered">
      <a class="btn" type="button" href="/adminDashboard">Return to Dashboard </a>
    </div> 
    <br>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>
<style>
body{
  text-align:center;
  background:linear-gradient(to right, #330066, #ff99cc);
}

caption {
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

tr:nth-of-type(even) { background-color:#FFF5CC; } 
tr:nth-of-type(odd){
background-color:#ffffff;
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