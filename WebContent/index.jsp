<%-- 
    Document   : index
    Created on : Aug 25, 2017, 12:54:32 PM
    Author     : UNQ
--%>

<%@page import="com.vu.entity.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.vu.services.*"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <c:set value="${pageContext.request.contextPath}" var="root"></c:set>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Index</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Bonfire Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
        Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
        <link href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
<!--//fonts-->
<script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function($) {
            $(".scroll").click(function(event){		
            event.preventDefault();
            $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
            });
            </script>
        <!--slider-script-->
		<script src="js/responsiveslides.min.js"></script>
			<script>
				$(function () {
				  $("#slider1").responsiveSlides({
					auto: true,
					speed: 500,
					namespace: "callbacks",
					pager: true
				  });
				});
			</script>
<!--//slider-script-->
<script>$(document).ready(function(c) {
	$('.alert-close').on('click', function(c){
		$('.message').fadeOut('slow', function(c){
	  		$('.message').remove();
		});
	});	  
});
</script>
<script>$(document).ready(function(c) {
	$('.alert-close1').on('click', function(c){
		$('.message1').fadeOut('slow', function(c){
	  		$('.message1').remove();
		});
	});	  
});
</script>
        <c:set value="${pageContext.request.contextPath}" var="root"></c:set>
    </head>
    <body>
            <% Cart cart1= (Cart)session.getAttribute("cart");
                if(cart1==null){
                	cart1= new Cart();
                	session.setAttribute("cart", cart1);
                }
            %>
        <jsp:include page="include/header.jsp"></jsp:include>
        <div class="container">

		<div class="content">
                    <div class="content-bottom">
			<h3 class="future">NEW</h3>
			<div class="content-bottom-in">
			<% 
				ProductServiceImp proImp1 = new  ProductServiceImp();
           		ArrayList<Product> list = (ArrayList<Product>)proImp1.getListProduct(2);
				
			%>
               <ul id="flexiselDemo2">		
               <%

               if(list != null){
               	for(Product p : list){
               %>	
				<li>
                      <div class="col-md men">
                        <a href="#" class="compare-in "><img src="<%=p.getPicture() %>" alt="" />
                        <div class="compare in-compare"></div>
                        </a>
						<div class="top-content bag">
                        <h5><a href="#"><%=p.getProductName() %></a></h5>
                        <div class="white">
                        <a href="${root}/CartController?command=plus&productid=<%=p.getProductId()%>" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD CART</a>
                        <p class="dollar"><span class="in-dollar">$</span><span><%=p.getPrice() %></span><span>0</span></p>
                        <div class="clearfix"></div>
                        </div>
						</div>							
                     </div>
                </li>
					<%
               			}
               }
					%>
                </ul>
		<script type="text/javascript">
		$(window).load(function() {
			$("#flexiselDemo2").flexisel({
				visibleItems: 4,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,    		
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		    
		});
	</script>
					</div>
				</div>
                    
                <%  ProductServiceImp proImp= new ProductServiceImp();
                    int papers=1, first=0, last=0 ;
                    if(request.getParameter("papers")==null){
                        papers=1;
                    }else{
                        papers= Integer.parseInt(request.getParameter("papers"));
                        if(papers<=0){
                            papers=1;
                            response.sendRedirect("index.jsp?papers=1");
                        }
                    }
                    int total= proImp.countProduct();
                    if(total<8){
                        first= papers-1;
                        last= total;
                    }else{
                        first= (papers-1) * 7;
                        last= 8;
                    }
                    List<Product> getListP= proImp.getListByPaper(first, last);
                %>
			<div class="content-top">
				<h3 class="future">All Product</h3>
				<div class="content-top-in">
                  <% for(Product pro: getListP ){ %>
					<div class="col-md-3 md-col">
                     <div class="col-md">
                     <a href="#"><img  src="<%=pro.getPicture() %>" /></a>	
                        <div class="top-content">
                        <h5><a href="#"><%=pro.getProductName()%></a></h5>
                            <div class="white">
                             <a href="${root}/CartController?command=plus&productid=<%=pro.getProductId()%>" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">ADD CART</a>
                             <p class="dollar"><span class="in-dollar">Price</span><span><%=pro.getPrice()%></span></p>
                             <div class="clearfix"></div>
                            </div>
                                                   
                         </div>							
                        </div>
                     <br><br>
					</div>
                   <%}%>
					<div class="clearfix"></div>
					</div>
				</div>
				<!---->
			<div class="content-middle">
					<h3 class="future"></h3>
					<div class="content-middle-in">
					<ul id="flexiselDemo1">			
						<li><img src="images/a1.png" height="100px" width="100px"/></li>
			 			<li><img src="images/a2.png" height="100px" width="100px"/></li>
						<li><img src="images/a3.png"  height="100px" width="100px"/></li>
						<li><img src="images/a4.png" height="100px" width="100px"/></li>
						<li><img src="images/a5.png" height="100px" width="100px"/></li>
					</ul>
            	<script type="text/javascript">
		$(window).load(function() {
			$("#flexiselDemo1").flexisel({
				visibleItems: 4,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,    		
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		    
		});
	</script>
	<script type="text/javascript" src="js/jquery.flexisel.js"></script>

					</div>
				</div>

			</div>
				<ul class="start" style="vertical-align: middle">
                     <li ><a href="index.jsp?papers=<%=papers-1%>"><i></i></a></li>
                             <% for(int i=1; i<= total/7+1; i++){%>    
                     <li class="arrow"><a href="index.jsp?papers=<%=i%>"><%=i%></a></li>
                                <%}%>
					<li ><a href="index.jsp?papers=<%=papers+1%>"><i class="next"></i></a></li>
				</ul>
		</div>
	<!---->
        <jsp:include page="include/footer.jsp"></jsp:include>
    </body>
</html>
