<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>Bills of  ${name}</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>

<body>
<table summary=""><br>
 <caption>YOUR BILL DETAILS</caption>
   <tr>
   				<th>Bill Id</th>
				<th>Bill arrived date</th>
				<th>Bill paid date</th>
				<th>Cost</th>
				<th>Mode of Payment</th>
				<th>Reference Id</th>
				
  </tr>
  <tbody>
			<c:forEach items="${Bills}" var="bill">
			<tr>
				<td>${bill.id}</td>
				<td>${bill.ar_date}</td>
				<td>${bill.pa_date}</td>
				<td>${bill.cost}</td>
				<td>${bill.mode}</td>
				<td>${bill.ref_id}</td>
			</tr>
			</c:forEach>
		</tbody>
</table>
<br>
    <div class="centered">
      <a class="btn" type="button" href="/welcome">Return to Dashboard </a>
    </div> 
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