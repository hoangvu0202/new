<%-- 
    Document   : CART
    Author     : VUNH
--%>

<%@page import="java.util.Map"%>
<%@page import="com.vu.entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
            <!-- cart -->
        <script src="../js/simpleCart.min.js"> </script>
        <!-- cart -->
        <link rel="stylesheet" href="../css/flexslider.css" type="text/css" media="screen" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>checkout</title>
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
        <link href="../bootracp/style.css" rel="stylesheet" type="text/css" media="all" />
        <!-- cart -->
        <script src="../bootracp/simpleCart.min.js"> </script>
        <!-- cart -->
        <link rel="stylesheet" href="../aaa/flexslider.css" type="text/css" media="screen" />
    <c:set value="${pageContext.request.contextPath}" var="root"></c:set>    
    </head>
    <body>
        <% Cart cart1= (Cart)session.getAttribute("cart"); %>
        <jsp:include page="../include/header.jsp"></jsp:include>
        <div class="container">

            <div class="col-lg-5">
                <!-- checkout -->
                <div class="cart-items">
                <div class="container">
                    <div class="dreamcrub">
                <ul class="previous">
                	<li><a href="${root}/index.jsp">Back to Previous Page</a></li>
                </ul>
                <div class="clearfix"></div>
                    </div>
                    <h2>Quanlity (<%=cart1.count()%>)</h2>

        <% for (Map.Entry<Integer, Item> gio : cart1.getCart().entrySet()) { %>
      
		<div class="cart-gd">
			  <div class="cart-header3">
                  <div class="close3"> <a href="">Remove</a></div>
				  <div class="cart-sec simpleCart_shelfItem">
						<div class="cart-item cyc">
                       <img src="" class="img-responsive" alt="">
						</div>
					   <div class="cart-item-info">
						<h3><a href="#"> <%=gio.getValue().getProduct().getProductName()%> </a><span><%=gio.getValue().getProduct().getNote()%></span></h3>
						<ul class="qty">
							<li><p>order value:<%=gio.getValue().getProduct().getPrice()%></p></li>
                            <li><p>
                                 <input type="button" value="-" name="command" class="btn btn-default"/>
                                 <input  class="text-center" disabled="true" value="<%=gio.getValue().getQuantity()%>">
                                 <input type="button" value="+" name="command" class="btn btn-default"/>
                            </p></li>
						</ul>
							 <div class="delivery">
							 <p></p>
							 <span></span>
							 <div class="clearfix"></div>
				        </div>	
					   </div>
					   <div class="clearfix"></div>						
				  </div>
			  </div>
                    </div>
           <%} %>
        

                  
		<div class="news-letter">
			<div class="container">
				<div class="join">

					<h6><label>Discount Code</label></h6>
					<div >
						<form id="cart22" action="../CartController" method="post">
                       <input id="idcode" name="idcode" class="text-center" value="" />
                       <input class="btn btn-light" value="sale amount 10% " type="submit">
						</form>
					</div>
					<div class="clearfix"> </div>
				</div>

			</div>
			<div class="container">
				<div class="join">

					<h6>ToTal order value : </h6>
					<div class="sub-left-right">
						<form >
                       <input value="<%=cart1.total()%>" type="button" height="400px" width="400px">
					</form>
					   <a class="btn btn-success" href="../view/checkout.jsp">CHECK OUT</a>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
		</div> 
                    </div>
                </div>

                <!-- //checkout -->    
            </div>

        </div> 
        
     <!-- jquery validate-->
	<script src="../js/jquery.validate.js"></script>
	<script src="../js/additional-methods.min.js"></script>
	<!--jquery-->
	<link rel="stylesheet" href="https://jqueryvalidation.org/files/demo/site-demos.css" />
	
	<script type="text/javascript">
		$(document).ready(function() {
			$("#cart22").validate({
				rules : {
					idcode : {
						idcode : true,
						maxlength : 6,
					}
				},
				messages : {
					idcode : {
						idcode : "please input GOxxxx",
						maxlength : "please max munber 6 !"
					}

				}
			});
		});

		$.validator.methods.idcode = function(value, element) {
			return this.optional(element) || /[GO20]+[1]+[8]$/.test(value);
		}
	</script>

        <jsp:include page="../include/footer.jsp"></jsp:include>
    </body>
</html>
