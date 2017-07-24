<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>E-Products</title>
        <%@include file="Dependencies.jsp" %>
    </head>

    <body style="padding-top: 0px">

        <!-- Definimos la barra de navegacion -->
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a href="#" class="navbar-brand"><span class="glyphicon glyphicon-shopping-cart"></span> EProducts</a>
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only"> Toogle Navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <c:choose>
                            <c:when test="${empty authenticatedUser.username}">
                            <li><a href="${contextPath}/">Inicio</a></li>
                            <li><a href="#">¿Ayúda?</a></li>    
                            <li><a href="#">Contacto</a></li>
                            <li><a id="myBtn" data-backdrop="static" data-toggle='modal' data-target='#loginModal'><span class="glyphicon glyphicon-log-in"></span> Iniciar sesion</a></li>
                            </c:when>
                            <c:otherwise>
                            <li><a href="${contextPath}/home">Home</a></li>
                            <li><a href="#">¿Ayúda?</a></li>    
                            <li><a href="#">Contacto</a></li>
                            <li><a href="${contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </nav>
    
    
        <!-- Modal -->
        <div class="modal fade" id="loginModal">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header" style="padding:35px 50px;">
                        <button type="button" data-dismiss="modal" class="close pull-right">&times;</button>
                        <h3 class="modal-title"><span class="glyphicon glyphicon-lock"></span> Iniciar sesion</h4>
                    </div>
                    <div class="modal-body" style="padding:40px 50px;">                       
                        <form id="login-form" action="${contextPath}/j_spring_security_check" method="POST" name="loginForm">
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
                            <div class="form-group">
                                <button type="submit" id="loginBtn" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Iniciar sesion </button>
                            </div>
                            
                        </form>
                        <hr/>
                        <div id="errorMsg">${error}</div>   
                    </div>
                    <div class="modal-footer">
                        <p>¿No tenes cuenta? <a href="${contextPath}/singup">Registrate</a></p>
                        <p>¿Olvidates tu <a href="#">contraseña?</a></p>
                    </div>
                </div>
            </div>
        </div>            

	<div class="container products">
                <c:forEach items="${model.products}" var="product">
                    <div class="products-item">
                            <div class="product-image">
                                <img src="data:image/jpeg;base64,${product.productImage}" alt="">
                            </div>
                            <div class="caption">
                                <h4><a href=  "#">${product.productName}</a></h4>
                                <h4>$ ${product.productPrice}</h4>
                                <p>${product.productDescription}</p>
                            </div>
                            <div class="ratings">
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    (15 reviews)
                                </p>
                            </div>
                            <div class="btn-ground text-center">
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#${product.id}"><i class="fa fa-search"></i> Quick View</button>
                            </div>
                    </div>
                </c:forEach>
        </div>
        <c:forEach items="${model.products}" var="product">
            <div class="modal fade product_view" id="${product.id}">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <a href="#" data-dismiss="modal" class="class pull-right"><span class="glyphicon glyphicon-remove"></span></a>
                            <h3 class="modal-title">${product.productName}</h3>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-md-6 product_img">
                                    <img src="data:image/jpeg;base64,${product.productImage}" alt="" class="img-responsive">
                                </div>
                                <div class="col-md-6 product_content">
                                    <h4>Numero de control: <span>${product.id}</span></h4>
                                    <div class="rating">
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                        (10 reviews)
                                    </div>
                                    <p>${product.productDescription}</p>
                                    <h3 class="cost"><span class="glyphicon glyphicon-usd"></span> ${product.productPrice} <small class="pre-cost"><span class="glyphicon glyphicon-usd"></span> ${product.productPrice}</small></h3>
                                    <div class="row">
                                        <div class="col-md-4 col-sm-12">
                                            <input type="number" id="qty" class="form-control qty" min="0" max="${product.productStock}" value="1" onkeydown="return false">
                                            <div>Stock: ${product.productStock}</div>
                                        </div>
                                        <!-- end col -->
                                    </div>
                                    <div class="space-ten"></div>
                                    <div class="btn-ground">
                                        <input id="productId" type="hidden" value="${product.id}" />
                                        <a  id="addToCart" type="button" class="btn btn-primary" href="${contextPath}/cart/add/${product.id}/1"><i class="glyphicon glyphicon-shopping-cart"></i> Add To Cart</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        
        
    </body>
    

</html>