/**
 *
 * @author ΧΡΟ
 */
package Cart;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.*;

public class CartServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.setContentType("text/html");            
            
       
            int cafeQuantity=0,sugarQuantity=0,waterQuantity=0;
            String cafeq = request.getParameter("cafeq");
            String sugarq = request.getParameter("sugarq");
            String waterq = request.getParameter("waterq");
            try {
                cafeQuantity = Integer.parseInt(cafeq);
            }
            catch(NumberFormatException e) {
                    cafeQuantity = 0;
                    cafeq = "";
            }
            try {
                sugarQuantity = Integer.parseInt(sugarq);
            }
            catch(NumberFormatException e) {
                    sugarQuantity = 0;
                    sugarq = "";
            }
            try {
                waterQuantity = Integer.parseInt(waterq);
            }
            catch(NumberFormatException e) {
                    waterQuantity = 0;
                    waterq = "";
            }
            Item cafe = new Item();
            Item sugar = new Item();
            Item water = new Item(); 
            cafe.setName("cafe");
            cafe.setQuantity(cafeQuantity);
            sugar.setName("sugar");
            sugar.setQuantity(sugarQuantity);
            water.setName("water");
            water.setQuantity(waterQuantity);
           
            
           
    
            String cafep = getServletContext().getInitParameter("cafePrice");
            String sugarp = getServletContext().getInitParameter("sugarPrice");
            String waterp = getServletContext().getInitParameter("waterPrice");
            double cafePrice = Double.parseDouble(cafep);
            double sugarPrice =  Double.parseDouble(sugarp);
            double waterPrice =Double.parseDouble(waterp); 
            
            cafe.setPrice(cafePrice);
            sugar.setPrice(sugarPrice);
            water.setPrice(waterPrice);
            
            double totalCafePrice = roundTwoDecimals(cafePrice*cafeQuantity);
            double totalSugarPrice = roundTwoDecimals(sugarPrice*sugarQuantity);
            double totalWaterPrice = roundTwoDecimals(waterPrice*waterQuantity);
            double total = totalCafePrice+totalSugarPrice+totalWaterPrice;
            
            cafe.setTotalprice(totalCafePrice);
            sugar.setTotalprice(totalSugarPrice);
            water.setTotalprice(totalWaterPrice);
            
            request.setAttribute("cafe",cafe);
            request.setAttribute("sugar",sugar);
            request.setAttribute("water",water);
            request.setAttribute("total",total);
            
      
            Cookie cafeCookie = new Cookie("cafe",cafe.getQuantity()+"");
            cafeCookie.setMaxAge(30 * 60);
            Cookie sugarCookie = new Cookie("sugar",sugar.getQuantity()+"");
            sugarCookie.setMaxAge(30 * 60);
            Cookie waterCookie = new Cookie("water",water.getQuantity()+"");
            waterCookie.setMaxAge(30 * 60);
           
            response.addCookie(cafeCookie);
            response.addCookie(sugarCookie);
            response.addCookie(waterCookie);
            
            
            
            
                     
           
            RequestDispatcher view = request.getRequestDispatcher("form.jsp");
            view.forward(request, response);
           
        }
        catch (ServletException e) {}
        catch (IOException e) {}
            
           

    }
    
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.setContentType("text/html");
            
            Cookie[] cookies = request.getCookies();
            
            String cafeq = "",sugarq="",waterq="";
            
            Item cafe = new Item();
            Item sugar = new Item();
            Item water = new Item(); 
            cafe.setName("cafe");
            cafe.setQuantity(0);
            sugar.setName("sugar");
            sugar.setQuantity(0);
            water.setName("water");
            water.setQuantity(0);
            
            String cafep = getServletContext().getInitParameter("cafePrice");
            String sugarp = getServletContext().getInitParameter("sugarPrice");
            String waterp = getServletContext().getInitParameter("waterPrice");
            double cafePrice= Double.parseDouble(cafep);
            double sugarPrice =Double.parseDouble(sugarp);
            double waterPrice = Double.parseDouble(waterp); 
            
            cafe.setPrice(cafePrice);
            sugar.setPrice(sugarPrice);
            water.setPrice(waterPrice);
            
            cafe.setTotalprice(0.00);
            sugar.setTotalprice(0.00);
            water.setTotalprice(0.00);
            
            
            if(cookies != null) {
                
                for(int i = 0; i < cookies.length; i++) {
                    Cookie cookie = cookies[i];
                    if(cookie.getName().equals("cafe")) {
                        cafeq = cookie.getValue();
                        int cq = Integer.parseInt(cafeq);
                        cafe.setQuantity(cq);
                        cafe.setTotalprice(roundTwoDecimals(cafe.getQuantity()*cafe.getPrice()));
                    }
                    else if(cookie.getName().equals("sugar")){
                        sugarq=cookie.getValue();
                        int sq = Integer.parseInt(sugarq);
                        sugar.setQuantity(sq);
                        sugar.setTotalprice(roundTwoDecimals(sugar.getQuantity()*sugar.getPrice()));
                    }
                    else if(cookie.getName().equals("water")){
                        waterq=cookie.getValue();
                        int wq = Integer.parseInt(waterq);
                        water.setQuantity(wq);
                        water.setTotalprice(roundTwoDecimals(water.getQuantity()*water.getPrice()));
                    }
               }     
                        
                    
            }
                
     
                     
            
            request.setAttribute("cafe",cafe);
            request.setAttribute("sugar",sugar);
            request.setAttribute("water",water);
           
                
            RequestDispatcher view = request.getRequestDispatcher("form.jsp");
            view.forward(request, response);
           
        }
        catch (ServletException e) {}
        catch (IOException e) {}
            
           

    }
    
      
   
    
    
    private static double roundTwoDecimals(double d) {         
         BigDecimal bd = new BigDecimal(d).setScale(2, RoundingMode.HALF_EVEN);
         d = bd.doubleValue();
         return(d);
    }
    
             
}


