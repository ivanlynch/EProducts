<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Products</title>
        <%@include file="Dependencies.jsp" %>
    </head>

    <body>

        <!-- Definimos la barra de navegacion -->
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a href="#" class="navbar-brand"><span class="glyphicon glyphicon-shopping-cart"></span> EProducts</a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">Inicio</a></li>
                    <li><a href="#">¿Ayúda?</a></li>
                    <li><a href="#">Contacto</a></li>
                    <li><a id="myBtn" data-backdrop="static" data-toggle='modal' data-target='#loginModal'><span class="glyphicon glyphicon-log-in"></span> Iniciar sesion</a></li>
                </ul>
            </div>
        </nav>
    
    
        <!-- Modal -->
        <div class="modal fade" id="loginModal">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header" style="padding:35px 50px;">
                        <button type="button" data-dismiss="modal" class="close">&times;</button>
                        <h4><span class="glyphicon glyphicon-lock"></span> Iniciar sesion</h4>
                    </div>
                    <div class="modal-body" style="padding:40px 50px;">
                        <form:form id="register-form" name="submitForm" method='POST'>
                            <div class="form-group">
                                <label for="usrname" ><span class="glyphicon glyphicon-user"></span> Correo</label>
                                <input type="text" class="form-control" name="correo" id="correo">
                            </div>
                            <div class="form-group">
                                <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Contraseña</label>
                                <input type="password" class="form-control" name="password">
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox" value="" checked>Remember me</label>
                            </div>
                            <button type="submit" id="loginBtn" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Iniciar sesion</button>
                            
                        </form:form>
                        <hr/>
                        <div id="errorMsg">${error}</div>   
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
                        <p>¿No tenes cuenta? <a href="#">Registrate</a></p>
                        <p>Olvidates tu <a href="#">contraseña?</a></p>
                    </div>
                </div>

            </div>
        </div> 



        <header>
		<h1>Nuestros Productos</h1>
	</header>
	
	<ul class="cd-items cd-container">
		<li class="cd-item">
			<img src="<c:url value="/resources/public/images/item-1.jpg"/>" alt="Item Preview">
			<a href="#0" class="cd-trigger">Quick View</a>
		</li> <!-- cd-item -->
        </ul>
	<div class="cd-quick-view">
		<div class="cd-slider-wrapper">
			<ul class="cd-slider">
				<li class="selected"><img src="<c:url value="/resources/public/images/item-1.jpg"/>" alt="Product 1"></li>
				<li><img src="<c:url value="/resources/public/images/item-2.jpg"/>" alt="Product 2"></li>
				<li><img src="<c:url value="/resources/public/images/item-3.jpg"/>" alt="Product 3"></li>
			</ul> <!-- cd-slider -->

			<ul class="cd-slider-navigation">
				<li><a class="cd-next" href="#0">Prev</a></li>
				<li><a class="cd-prev" href="#0">Next</a></li>
			</ul> <!-- cd-slider-navigation -->
		</div> <!-- cd-slider-wrapper -->

		<div class="cd-item-info">
			<h2>Produt Title</h2>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Officia, omnis illo iste ratione. Numquam eveniet quo, ullam itaque expedita impedit. Eveniet, asperiores amet iste repellendus similique reiciendis, maxime laborum praesentium.</p>

			<ul class="cd-item-action">
				<li><button class="add-to-cart">Add to cart</button></li>					
				<li><a href="#0">Learn more</a></li>	
			</ul> <!-- cd-item-action -->
		</div> <!-- cd-item-info -->
		<a href="#0" class="cd-close">Close</a>
	</div> <!-- cd-quick-view -->
        
    </body>
    

</html>