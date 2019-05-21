<%-- 
    Document   : product
    Author     : VUNH
--%>

<%@page import="com.vu.entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>product</title>
 <link href="../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Bonfire Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
<!--//fonts-->
<script type="text/javascript" src="../js/move-top.js"></script>
<script type="text/javascript" src="../js/easing.js"></script>
				<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
				</script>
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
    </head>
    <body>
        <jsp:include page="../include/header.jsp"/>              
		<div class="container">
			<div class="products">
					<h2 class=" products-in">PRODUCTS BY CATEGORY</h2>
                                        <div class=" top-products"> 
                                            <% Cart cart1= (Cart)session.getAttribute("cart");
                                                if(cart1==null){
                                                    cart1= new Cart();
                                                    session.setAttribute("cart", cart1);
                                                }
                                            %>
                                           
                       <c:forEach var="pro" items="${getlist}">
                                            <div class="col-md-3 md-col">
						<div class="col-md">
                        <a href="#" class="compare-in"><img  src="../${pro.getPicture()}" alt="" />
						</a>	
						<div class="top-content">
						<h5><a href="#">${pro.getProductName()}</a></h5>
                                   <div class="white">
                                    <a href="${root}/EZOnline/CartController?command=plus&productid=${pro.getProductId()}" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD CART</a>
                                     <p class="dollar"><span class="in-dollar">Price</span><span>${pro.getPrice()}</span></p>
                                      <div class="clearfix"></div>
                                    </div>
						</div>							
						</div>
                                                    <br>
                                                    <br>
                                            </div>
                        </c:forEach>   
                                            
					<div class="clearfix"></div>
					</div>

			</div>
		</div>
                		<ul class="start">
					<li ><a href="#"><i></i></a></li>
					<li><span>1</span></li>	
					<li ><a href="#"><i  class="next"> </i></a></li>
				</ul>
		<!---->   
                <jsp:include page="../include/footer.jsp"></jsp:include>
    </body>
</html>
