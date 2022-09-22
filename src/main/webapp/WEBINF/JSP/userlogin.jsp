<html>
<title>User Login</title>
<body>
	<font color="red">${message}</font>
	<h2>Residents Login</h2>
   <div class = "login">
	<font color="red">${message}</font> 
	<form id = "login" method="POST">
	<label><b>User id</b></label><br>
	<input type = "text" name ="name" id = "name" placeholder = "User_id">
	<br><br>
	<label><b>Password</b></label>
	<input type = "Password" name = "password" id = "pass" placeholder = "Password">
	<br><br>
	<input class = "button" type = "submit"value="Log in"/>
	</form>
	</div>
	</form>
</body>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
	
	body  
{  
    margin: 0;  
    padding: 0;   
    background-size:cover;
     background-image:url("https://images.pexels.com/photos/323705/pexels-photo-323705.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
    background-repeat:no-repeat;
    font-family: "Poppins",sans-serif;  
}  
.login{  
        width: 382px;  
        overflow: hidden;  
        margin: auto; ;  
        margin: 200 0 0 900px;  
        padding: 100px;  
        background: #add8e6;  
        border-radius: 15px ; 
        box-shadow:8px 8px; 
          
}  
h2{  
    text-align: center;  
    color: #000000;  
    padding-top: 50px;  
}  
label{  
    color: #000000;  
    font-size: 17px;  
}  
#name{  
    width: 300px;  
    height: 30px;  
    border: none;  
    border-radius: 3px;  
    padding-left: 8px;  
}  
#pass{  
    width: 300px;  
    height: 30px;  
    border: none;  
    border-radius: 3px;  
    padding-left: 8px;  
      
}  
.button{  
    width: 300px;  
    height: 30px;  
    border: none;  
    border-radius: 17px;  
    padding-left: 7px;  
    color: black;  
    text-align:center;
}



	
</style>
</html>