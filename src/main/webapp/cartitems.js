function Item(myName, myPrice, myDscrptn) {
    this.name = myName;
    this.count = 1;
    this.price = myPrice;
    this.dscrptn = myDscrptn;
}

function Cart() {
    this.dscntPrcnt = 0;
    this.dscntVle = 0;
    this.total = 0;
    this.dscntTtl = 0;
    this.minNmbrDscntItms = 0;
    this.nmbrItms = 0;
    this.items = new Array();

    this.addItem = function addItem(myItem) {
        this.items[this.nmbrItms] = myItem;
        this.nmbrItms++;
    }
}
var shppngCart = new Cart();
function addToCart(myItem, myPrice) {
    var anItem = new Item(myItem, myPrice);
    shppngCart.addItem(anItem);
}
function viewCart1() {
    var jsonCart = encodeURIComponent(JSON.stringify(shppngCart));
    window.location = "carttotal1.jsp?jsonclnt=" + jsonCart;
}
function viewCart2() {
    var jsonCart = encodeURIComponent(JSON.stringify(shppngCart));
    window.location = "carttotal2.jsp?jsonclnt=" + jsonCart;
}
function displayCart(myResponseText) {
    var myCart = JSON.parse(myResponseText);
    var length = myCart.items.length;
    var innerHtml = "";

    document.getElementById("nmbrItms").innerHTML = myCart.nmbrItms;
    document.getElementById("subtotal").innerHTML = myCart.total.toFixed(2);
    document.getElementById("discountvalue").innerHTML = myCart.dscntVle.toFixed(2);
    document.getElementById("discounttotal").innerHTML = myCart.dscntTtl.toFixed(2);

    for (var k = 0; k < length; k++) {
        innerHtml += '<p><a href="#">' + myCart.items[k].name + '</a> <span class="price">' + myCart.items[k].price.toFixed(2) + '</span></p>';
    }
    document.getElementById("cartdisplay").innerHTML = innerHtml;
}
