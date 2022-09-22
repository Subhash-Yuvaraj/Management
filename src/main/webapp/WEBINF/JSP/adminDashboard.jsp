<html>
  
  <head>
    <title>Admin Dashboard</title>
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.13.0/css/all.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>-->
  </head>
  
  
  <body>
    <!-- Start vertical navbar -->
    <header id="header">
       <div class="vertical-nav bg-white" id="sidebar">
          <div class="py-4 px-3 mb-2 mt-2 bg-light">
            <div class="align-items-center" id="half">    
               <a class="navbar-brand text-center" ><h1>Dashboard</h1></a>
            </div>
          </div>
          <p class="text-gray font-weight-bold text-uppercase px-3 small pb-3 mb-2 mt-3">Settings</p>
          <ul class="nav flex-column bg-white mb-0">
          
            <li class="nav-item">
              <a href="/addApartments" class="nav-link text-dark font-italic bg-light">
                <i class="fa fa-th-large mr-3 text-primary fa-fw"></i>Add Apartments
              </a>  
            </li>
    
            <li class="nav-item">
              <a href="/addResidents" class="nav-link text-dark font-italic bg-light">
                <i class="fas fa-compact-disc mr-3 text-primary fa-fw"></i>
                Add Residents
              </a>
            </li>
            
            
            <li class="nav-item">
              <a href="/addSubscriptions" class="nav-link text-dark font-italic bg-light">
                <i class="far fa-id-card mr-3 text-primary fa-fw"></i>
                Add Subscription
              </a>
            </li>
            
            <li class="nav-item">
              <a href="/paySubscriptions" class="nav-link text-dark font-italic bg-light">
                <i class="fas fa-blog mr-3 text-primary fa-fw"></i>
                Pay Subscription
              </a>
            </li>
            
            <li class="nav-item">
              <a href="/viewUnpaidBills" class="nav-link text-dark font-italic bg-light">
                <i class="far fa-images mr-3 text-primary fa-fw"></i>
                View Unpaid Subscriptions
              </a>
            </li>
            
            <li class="nav-item">
              <a href="/occupyParking" class="nav-link text-dark font-italic bg-light">
                <i class="fa fa-address-card mr-3 text-primary fa-fw"></i>
                Occupy Parking Lot
              </a>
            </li>
            <li class="nav-item">
              <a href="/addContact" class="nav-link text-dark font-italic bg-light">
                <i class="fa fa-address-card mr-3 text-primary fa-fw"></i>
                Add Contact
              </a>
            </li>
            <li class="nav-item">
              <a href="/buyNewApartment" class="nav-link text-dark font-italic bg-light">
                <i class="fa fa-address-card mr-3 text-primary fa-fw"></i>
                Buy New Apartment
              </a>
            </li>
            
            <li class="nav-item">
              <a href="/visitorCheckIn" class="nav-link text-dark font-italic bg-light">
                <i class="fa fa-address-card mr-3 text-primary fa-fw"></i>
                Check in Visitor
              </a>
            </li>
            
            <li class="nav-item">
              <a href="/deleteResident" class="nav-link text-dark font-italic bg-light">
                <i class="fa fa-address-card mr-3 text-primary fa-fw"></i>
                Delete Resident
              </a>
            </li>
            
            <li class="nav-item">
              <a href="/viewResidents" class="nav-link text-dark font-italic bg-light">
                <i class="fa fa-address-card mr-3 text-primary fa-fw"></i>
                View All Residents
              </a>
            </li>
            
            <li class="nav-item">
              <a href="/visitorCheckOut" class="nav-link text-dark font-italic bg-light">
                <i class="fa fa-address-card mr-3 text-primary fa-fw"></i>
                Checkout Visitor
              </a>
            </li>
            <li class="nav-item">
              <a href="/updateStocks" class="nav-link text-dark font-italic bg-light">
                <i class="fa fa-address-card mr-3 text-primary fa-fw"></i>
                Update Stocks
              </a>
	    </li>
            <li class="nav-item">
              <a href="/viewUnpaidGrocery" class="nav-link text-dark font-italic bg-light">
                <i class="fa fa-address-card mr-3 text-primary fa-fw"></i>
                Undelivered Grocery
              </a>
            </li>
            <li class="nav-item">
              <a href="/viewPaidGrocery" class="nav-link text-dark font-italic bg-light">
                <i class="fa fa-address-card mr-3 text-primary fa-fw"></i>
                Delivered Grocery
              </a>
            </li>
            <li class="nav-item">
              <a href="/adminLogin" class="nav-link text-dark font-italic bg-light">
                <i class="fa fa-address-card mr-3 text-primary fa-fw"></i>
                Log out
              </a>
            </li>
            
          </ul>
       </div>
    </header>

    <!-- Start Page content holder -->
    <div class="page-content p-5" id="content">
      
    <!-- Toggle button -->
        <button id="sidebarCollapse" type="button" class="btn btn-light bg-white rounded-pill px-4 mb-4"><i class="fa fa-bars mr-2"></i><small class="text-uppercase font-weight-bolder">Toggle</small></button>
      
    <!-- Content Header -->   
        <h2 class="display-4 font-weight-bold text-center text-white">Management Dashboard</h2>
        <div class="separator mt-4"></div>
      
    <!-- content -->
        <figure class="mb-4" id="img-div">
           <div id="image" >
             <img src="https://images.pexels.com/photos/3663530/pexels-photo-3663530.jpeg?auto=compress&cs=tinysrgb&w=1600" alt="...">
           </div><html>
  
         </figure>
  
        <div class="row text-white">
    <div class="col-lg-7 mx-auto">
      <p class="lead">Ocean Shores Apartments  is one of the luxurious residential project of Prestige Group which is located at Whitefield, Bangalore.It is one of the best apartments around Whitefield.</p>
        <u></u></a>
        
  </p>
    </div>
  </div>
      
    </div>
      
		
  </body>
  <style>
  //#half{
  border:1px solid black;
  text-align:center;
}
#half h1{
  font-family:'Dancing Script' , 'Helvetica', sans-serif;
  font-weight:800;
  font-size:30px;
  color:#b30086;
}
/*****************************/
.vertical-nav {
  min-width: 16rem;
  width: 16rem;
  height: 100vh;
  position: fixed;
  top: 0;
  left: 0;
  box-shadow: 3px 3px 10px rgba(0, 0, 0, 0.1);
  transition: all 0.4s;
}
.page-content {
  width: calc(100% - 17rem);
  margin-left: 17rem;
  transition: all 0.4s;
}
/*********************/
#img-div{
  width:98%;
  max-width: 100%;
  display: block;
  height:auto;
  margin:auto;
  //background:white;
}
#image img{
  width:872px;
  height:565px;
  /*this is the only way to make image responsive inside the flexbox*/
  margin:auto;
  display: block;
}
#image{
  /*responsive*/
  max-width: 99%;
  height: auto;
      /* */ 
  /*centerized*/
  display: block;
  margin-left: auto;
  margin-right: auto;
       /* */
}
.lead a:hover{
  text-decoration:none;
}

/* for toggle behavior */

#sidebar.active {
  margin-left: -17rem;
}

#content.active {
  width: 100%;
  margin: 0;
}
@media (max-width: 767px) {
  #sidebar {
    margin-left: -17rem;
  }
  #sidebar.active {
    margin-left: 0;
  }
  #content {
    width: 100%;
    margin: 0;
  }
  #content.active {
    margin-left: 17rem;
    /***padge****/
    width: calc(100% - 17rem);
  }
}


body {
  background:#330066;
  background: linear-gradient(to right, #330066, #ff99cc);
  background: -webkit-linear-gradient(to right, #330066, #ff99cc);
  min-height: 100vh;
  overflow-x: hidden;
}

.separator {
  margin: 3rem 0;
  border-bottom: 1px dashed #fff;
}

.text-uppercase {
  letter-spacing: 0.1em;
}

.text-gray {
  color: #aaa;
}
  </style>
  <script>
  /*https://bootstrapious.com/p/bootstrap-vertical-navbar*/
  // Sidebar toggle behavior function
 $(function() {
   // Sidebar toggle behavior
   $('#sidebarCollapse').on('click', function() {
     $('#sidebar, #content').toggleClass('active');
   });
 });
  </script>
  
</html>