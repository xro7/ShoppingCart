<%@ page import="java.util.*" %>

<html>
    
    <center><h1>Welcome to my Shopping Cart page</h1></center>
    
    <br>
    
    <center><img src="shoppingcart.png"/></center>
    
    <br>
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
                <td> <jsp:useBean id="cafe" class="Cart.Item" scope="request"/>
                        <jsp:getProperty name="cafe" property="price"/></td>
                <td><input type="text" name="cafeq" title="Enter the quantity" value="<jsp:getProperty name="cafe" property="quantity"/>"/></td>
                <td>$ <jsp:getProperty name="cafe" property="totalprice"/> </td>
            </tr>
             <tr>
                <td>Sugar</td>
                <td><jsp:useBean id="sugar" class="Cart.Item" scope="request"/>
                           <jsp:getProperty name="sugar" property="price"/></td>
                <td><input type="text" name="sugarq" title="Enter the quantity" value="<jsp:getProperty name="sugar" property="quantity"/>"/></td>
                <td>$ <jsp:getProperty name="sugar" property="totalprice"/> </td>
            </tr>
            <tr>
                <td>Water</td>
                <td><jsp:useBean id="water" class="Cart.Item" scope="request"/>
                    <jsp:getProperty name="water" property="price"/></td>
                <td><input type="text" name="waterq" title="Enter the quantity" value="<jsp:getProperty name="water" property="quantity"/>"/></td>
                <td>$ <jsp:getProperty name="water" property="totalprice"/></td>
            </tr>
            <tr>
                <td>Total</td>
                <td> </td>
                <td> </td>
                <td>$ ${totalprice.price}</td>
            </tr>
          
        </table></center>
            <br>
            <center><input type="submit" value="Checkout"/></center>
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