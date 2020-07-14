<%-- 
    Document   : carttotal
    Created on : Jul 10, 2020, 2:06:43 PM
    Author     : cgthomasjr
--%>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="cartitem.css">

<script src="cartitems.js"></script>
<script>
var xmlhttp = new XMLHttpRequest();
xmlhttp.onreadystatechange = function() {
  if (this.readyState == 4 && this.status == 200) {
    displayCart(this.responseText);             
  }
};
xmlhttp.open("GET", "cartprocess.jsp"+window.location.search, true);
xmlhttp.send();    
</script>    
</head>
<body>
  <h2>Cart Total</h2>
  <div class="row">
  <div class="col-25">
      <div class="container">
      <h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b id="nmbrItms">-1</b></span></h4>
      <div id="cartdisplay">
      <p><a href="#"></a> <span class="price"></span></p>
      </div>
      <hr>
      <p>Sub Total <span class="price" style="color:black"><b id="subtotal">$30</b></span></p>
      <p>Discount <span class="price" style="color:black"><b id="discountvalue">$30</b></span></p>      
      <p>Total <span class="price" style="color:black"><b id="discounttotal">$30</b></span></p>      
      </div>
  </div>
</div>
</body>
</html>