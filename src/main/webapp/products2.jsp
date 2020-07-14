<!DOCTYPE html>
<html>
    <head>        
        <link rel="stylesheet" href="products.css">
        <script src="cartitems.js"></script>        
    </head>
    <body>

        <h2 style="text-align:center">Tacos (Demo 2)</h2>
        <div class="container">
            <div class="card">
                <h1>Veggie</h1>
                <p class="price">$2.50</p>
                <p>Description about the taco.</p>
                <p><button onclick="addToCart('Veggie Taco',2.50);">Add to Cart</button></p>
            </div>
            <div class="card">
                <h1>Chicken</h1>
                <p class="price">$3.00</p>
                <p>Description about the taco.</p>
                <p><button onclick="addToCart('Chicken Taco',3.00);">Add to Cart</button></p>
            </div>
            <div class="card">
                <h1>Beef</h1>
                <p class="price">$3.00</p>
                <p>Description about the taco.</p>
                <p><button onclick="addToCart('Beef Taco',3.00);">Add to Cart</button></p>
            </div>
            <div class="card">
                <h1>Chorizo</h1>
                <p class="price">$3.50</p>
                <p>Description about the taco.</p>
                <p><button onclick="addToCart('Chorizo Taco',3.50);">Add to Cart</button></p>
            </div>    
        </div>
        <p><button onclick="viewCart2();">View Cart</button></p>
    </body>
</html>