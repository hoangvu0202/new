
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    	<div class="footer">
		<div class="footer-middle">
			<div class="container">
				<div class="footer-middle-in">
						<h6>About us</h6>
				</div>
				<div class="footer-middle-in">
                        <h6>Information</h6>
					<ul>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					</ul>
				</div>
				<div class="footer-middle-in">
					<h6>Customer Service</h6>
					<ul>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					</ul>
					</div>
				<div class="footer-middle-in">
					<h6>My Account</h6>
					<ul>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
				</div>
			</div>
			<p class="footer-class">Copyright © 2019 by  <a href="#" target="_blank">VUNH</a> </p>
			<script type="text/javascript">
						$(document).ready(function() {
							/*
							var defaults = {
					  			containerID: 'toTop', // fading element id
								containerHoverID: 'toTopHover', // fading element hover id
								scrollSpeed: 1200,
								easingType: 'linear' 
					 		};
							*/
							
							$().UItoTop({ easingType: 'easeOutQuart' });
							
						});
					</script>
				<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>

		</div>
    </body>
</html>
