<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>Unpaid bills</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>

<body>
	<table summary=""><img class = "img" src="https://images.pexels.com/photos/7824630/pexels-photo-7824630.jpeg?auto=compress&cs=tinysrgb&w=1600"  width="300" height="200" ><br>
 <caption>Here are the list of Unpaid Bills</caption>
   <tr>
     <th>Bill ID</th>
	 <th>Arrived Date</th>
     <th>Cost</th>
     <th>Apartment ID</th>
  </tr>
  <tbody>
			<c:forEach items="${Bills}" var="bill">
			<tr>
				<td>${bill.id}</td>
				<td>${bill.ar_date}</td>
				<td>${bill.cost}</td>
				<td>${bill.ap_id}</td>
			</tr>
			</c:forEach>
		</tbody>
</table>
<br>
    <div class="centered">
      <a class="btn" type="button" href="/adminDashboard">Return to Dashboard </a>
    </div> 
		
	<br>
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

tr:first-of-type { background-color:#009900; 
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