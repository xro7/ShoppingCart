<%@ page import="java.util.*" %>

<html>
    
    <center><h1>Welcome to my Shopping Cart page</h1></center>
    
    <br>
    
    <center><img src="shoppingcart.png"/></center>
    
    <br>
    
    <% Cart.Item cafe = (Cart.Item)request.getAttribute("cafe");%>
    <% Cart.Item sugar = (Cart.Item)request.getAttribute("sugar");%>
    <% Cart.Item water = (Cart.Item)request.getAttribute("water");%>
    
  
    
    
    <body>
        
        <form method="POST" action="Cart.do">
                  
        <center><table border="1">
            <tr>
                <td>Item</td>
                <td>Price</td>
                <td>Quantity</td>
                <td>Total</td>
            </tr>
            <tr>
                <td>Cafe</td>
                <td><% out.print("$ " + cafe.getPrice()); %></td>
                <td><input type="text" name="cafeq" title="Type the quantity." value="<%=cafe.getQuantity()%>"/></td>
                <td><% out.print("$ " + cafe.getTotalprice()); %></td>
            </tr>
            <tr>
                <td>Sugar</td>
                <td><% out.print("$ " + sugar.getPrice()); %></td>
                <td><input type="text" name="sugarq" title="Type the quantity." value="<%=sugar.getQuantity()%>"/></td>
                <td><% out.print("$ " + sugar.getTotalprice()); %></td>
            </tr>
            <tr>
                <td>Water</td>
                <td><% out.print("$ " + water.getPrice()); %></td>
                <td><input type="text" name="waterq" title="Type the quantity." value="<%=water.getQuantity()%>"/></td>
                <td><% out.print("$ " + water.getTotalprice()); %></td>
            </tr>
            <tr>
                <td>Total</td>
                <td> </td>
                <td> </td>
                <td><% out.print("$");%> <%= water.getTotalprice()+sugar.getTotalprice()+cafe.getTotalprice() %></td>
            </tr>
        </table></center>
            <br>
            <center><input type="submit" value="Checkout" title="Checkout."/></center>
        </form>
            
        </form>

	<form method= "POST" action = "redirect.do">
		<button  id = "button2" type="SUBMIT"  onmouseout="details2('?')" onmouseover="details2('Show me the Report!')">?</button>
	
	
	<a href="http://xro7.net46.net/www/converter.rar"><button id="button" onmouseout="details('!')" onmouseover="details('Download the Code!')">!</button></a>
        <p><i>by <a href="http://xro7.wordpress.com/">xro7</a></i></p>
	</form>
            
    
<script type="text/javascript">    
    
function details(text){

	button.innerHTML=text

}

function details2(text){

	button2.innerHTML=text

}

</script>

 </body>  
    
</html>