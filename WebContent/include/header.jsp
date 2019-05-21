<%-- 
    Document   : header
    Author     : VUNH
--%>

<%@page import="com.vu.entity.Cart"%>
<%@page import="com.vu.entity.Catogory"%>
<%@page import="java.util.Map"%>
<%@page import="com.vu.entity.Item"%>
<%@page import="com.vu.services.*"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>header</title>
        <c:set value="${pageContext.request.contextPath}" var="root"></c:set>
    </head>
    <body>
	<% 
       Cart cart1= (Cart)session.getAttribute("cart");
	%>
    	<div class="header">
	<div class="header-top">
            <div class="container">	
		<div class="header-top-in">	
                    <div class="logo" >
                        <a href="<c:url value="/index.jsp"></c:url>"></a>
                    </div>
			<div class="header-in">
			<ul class="icon1 sub-icon1">
                            <li > <a href="${root}/view/cart.jsp" > CART </a> </li>	
                            <li><div class="cart">
                            <a href="${root}/view/cart.jsp" class="cart-in"> </a>
                         <span><%=cart1.count()%></span>
                            </div>
                            </li>
                        </ul>
                        </div>
		<div class="clearfix"> </div>
                <div class="search" style="left: 75%; width: 250px">
                    <form>
                        <input  type="text" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" >
			<input type="submit" value="">
                    </form>
                    </div>
			</div>
			</div>
		</div>
        <% CategoryServiceImp cateimp= new CategoryServiceImp();
            List<Catogory> getList= cateimp.getListCat();
        %>
		<div class="header-bottom">
		<div class="container">
			<div class="h_menu4">
				<a class="toggleMenu" href="#">Menu</a>
				<ul class="nav">
                <li class="active"><a href="<c:url value="/index.jsp"></c:url>"><i> </i>Home</a></li>
					<li ><a href="#" >MENU</a>
						<ul class="drop">
                <% for(Catogory cate: getList){ %>
                   <li><a href="${root}/ViewProductController?command=viewbycate&cateid=<%=cate.getCategoryId()%>"><%=cate.getCategoryName()%></a></li>
                 <%}%>
						</ul>
						</li> 						
						<li><a href="${root }/view/home.jsp" >  Hello</a></li>            
						<li><a href="${root }/view/home.jsp" >  Answer </a></li>
						<li><a href="${root }/view/home.jsp" >contact </a></li>
				</ul>
                 <script type="text/javascript" src="${root}/js/nav.js"></script>
			</div>
		</div>
		</div>
	</div>
    </body>
</html>
