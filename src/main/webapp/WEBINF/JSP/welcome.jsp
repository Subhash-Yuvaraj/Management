<html>

<head>

<title>User DashBoard</title>
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.13.0/css/all.css">

</head>

<body>
<div class="cards-list">
  
<div class="card 1">
  <div class="card_image"> <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQth9-31PUDErEZh3CjT9jw1uiygmjCYlhlWIGlOrxihYurT9NzV41rMfQeLb29X-fK8kM&usqp=CAU" /> </div>
  <div class="card_title title-white">
    <a href="/viewBills">View Bills</a>
  </div>
</div>

<div class="card 1">
  <div class="card_image"> <img src="https://thumbs.dreamstime.com/z/somebody-door-496543.jpg" /> </div>
  <div class="card_title title-white">
    <a href="/viewVisitors" class = "v">View Visitors</a>
  </div>
</div>
  
<div class="card 1">
  <div class="card_image"> <img src="https://www.localsamosa.com/wp-content/uploads/2020/03/1232.jpg" /> </div>
  <div class="card_title title-white">
    <a href="/orderGrocery" class = "v">Order Grocery</a>
  </div>
</div>

<div class="card 1">
  <div class="card_image"> <img src="https://previews.123rf.com/images/petrunina/petrunina1804/petrunina180400613/99730932-first-person-view-man-with-trolley-in-grocery-store-shopping-concept.jpg" /> </div>
  <div class="card_title title-white">
    <a href="/viewAllOrders" class = "v">View order log</a>
  </div>
</div>
  
</div>
<div class="centered">
      <a class="btn" type="button" href="/userlogin">Log Out </a>
</div>
</body>

<style>
body{
background:linear-gradient(#e66465, #9198e5);
text-align:center;
}
.cards-list {
  z-index: 0;
  width: 100%;
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
}

.card {
  margin: 30px auto;
  width: 300px;
  height: 300px;
  border-radius: 40px;
box-shadow: 5px 5px 30px 7px rgba(0,0,0,0.25), -5px -5px 30px 7px rgba(0,0,0,0.22);
  cursor: pointer;
  transition: 0.4s;
}

.card .card_image {
  width: inherit;
  height: inherit;
  border-radius: 40px;
}

.card .card_image img {
  width: inherit;
  height: inherit;
  border-radius: 40px;
  object-fit: cover;
}

.card .card_title {
  text-align: center;
  border-radius: 0px 0px 40px 40px;
  font-family: sans-serif;
  font-weight: bold;
  font-size: 30px;
  margin-top: -80px;
  height: 40px;
}

.card:hover {
  transform: scale(0.9, 0.9);
  box-shadow: 5px 5px 30px 15px rgba(0,0,0,0.25), 
    -5px -5px 30px 15px rgba(0,0,0,0.22);
}

.title-white {
  color: white;
}

.title-black {
  color: black;
}
a{
margin:1rem auto;
  color:black;
  text-decoration:none;
}
.v{
  color:white;
}
.btn{

border-radius:10px;
font-size:25px;
background-color:#ffffff;
color:#000000;
}
@media all and (max-width: 500px) {
  .card-list {
    /* On small screens, we are no longer using row direction but column */
    flex-direction: column;
  }
}



</style>



</html>