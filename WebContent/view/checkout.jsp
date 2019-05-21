<%-- 
    Document   : CheckOut
    Author     : UNQ
--%>

<%@page import="com.vu.entity.Item"%>
<%@page import="java.util.Map"%>
<%@page import="com.vu.entity.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
    <!-- validate-->
    <script src="../js/jquery.validate.js" type="text/javascript"></script>
    <script src="../js/jquery.validate.min.js" type="text/javascript"></script>
    <script src="../js/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="../js/localization/messages_vi.js" type="text/javascript"></script>
    	<script type="text/javascript">
    		$(document).ready(function(){
			$("#contact").validate({
				errorElement: "span", // Định dạng cho thẻ HTML hiện thông báo lỗi
				rules: {
					cpassword: {
						equalTo: "#password" // So sánh trường cpassword với trường có id là password
					},
					min_field: { min: 5 }, //Giá trị tối thiểu
					max_field: { max : 10 }, //Giá trị tối đa
					range_field: { range: [4,10] }, //Giá trị trong khoảng từ 4 - 10
					rangelength_field: { rangelength: [4,10] } //Chiều dài chuỗi trong khoảng từ 4 - 10 ký tự
				}
			});
                        
		});
	</script>
                <c:set value="${pageContext.request.contextPath}" var="root"></c:set>
    </head>
    <body>
        <% Cart cart12 = (Cart)session.getAttribute("cart"); %>
    <jsp:include page="../include/header.jsp"></jsp:include>
        <div class="container">
         				<div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover"> <!--id="dataTables-example"-->
                                    <thead>
                                        <tr>
                                            <th>Product Name</th>
                                            <th>Price</th>
                                            <th>Quantity</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <% for (Map.Entry<Integer, Item> car : cart12.getCart().entrySet()) { %>
                                        <tr class="gradeA">
                                            <td><%=car.getValue().getProduct().getProductName() %></td>
                                            <td><%=car.getValue().getProduct().getPrice() %></td>
                                            <td ><%=car.getValue().getQuantity() %></td>
											
                                        </tr>
									 <%} %>
                                    </tbody>
                                </table>
                            </div>
				</div> 
            <div class="account">
		<h2 class="account-in">Check Out</h2>
                <div class="col-lg-5">
               <form action="${root}/CheckOutController" method="post">                 
                     <div class="form-group">
                       <label class="form-control" style="width: 450px">The total amount after subtract 10%(<a><%=cart12.getIdcode() %></a>) 
                       : <%=cart12.total() %>
                        </label>
                        </div>
                        <div class="form-group">
                            <label>address : </label>
                            <input class="form-control" name="address" style="width: 450px">
                        </div> 				
                        <div class="form-group">
                            <label>description : </label>
                            <input  class="form-control" style="width: 450px" name="description" >
                        </div>
                            <input type="hidden" name="command" value="checkout"/>
                            <input class="btn btn-primary" type="submit" value="Pay" onclick="check()"> 
                    </form>
                </div>
            </div>
        </div>
        <script type="text/javascript">
        	function check() {
				alert("order successful !");
			}
        	
        </script>
    <jsp:include page="../include/footer.jsp"></jsp:include>
    	<!-- Page-Level Plugin Scripts-->
	<script src="../js/plugins/dataTables/dataTables.bootstrap.js"></script>
	<script src="js/plugins/dataTables/dataTables.bootstrap.js"></script>
	<script>
		$(document).ready(function() {
			$('#dataTables-example').dataTable();
		});
	</script>
	
    </body>
</html>
