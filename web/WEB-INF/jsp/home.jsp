<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
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
                            <c:when test="${authenticatedUser.isAdmin}">
                                <li><a href="/EProducts/admin">Administracion</a></li>
                                <li><a href="/EProducts/index">Inicio</a></li>
                                <li><a href="#">¿Ayúda?</a></li>
                                <li><a href="#">Contacto</a></li>
                                <li><a href="/EProducts/logout"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="/EProducts/index">Inicio</a></li>
                                <li><a href="#">¿Ayúda?</a></li>
                                <li><a href="#">Contacto</a></li>
                                <li><a href="/EProducts/logout"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
                            </c:otherwise>
                        </c:choose>                        
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="panel panel-success">
                <div class="panel-heading">
                    Usuario conectado: ${authenticatedUser.username}
                </div>
            </div>
            <div class="container admin-panel">
                <div class="admin-panel-item">
                    <div class="modal-content">
                        <div class="modal-header tile">                       
                            <h4><span class="glyphicon glyphicon-shopping-cart"></span> Carrito </h4>
                        </div>
                        <div class="modal-body tile" style="padding:40px 50px;">
                            <p>
                                Productos agregados al carrito
                            </p>
                        </div>
                        <div class="modal-footer tile">
                            <a class="btn btn-success btn-block" href="/EProducts/cart">Ir</a>
                        </div>
                    </div>
                </div>
                <div class="admin-panel-item">
                    <div class="modal-content">
                        <div class="modal-header tile" style="padding:35px 50px;">                       
                            <h4><span class="glyphicon glyphicon-user"></span> Cuenta </h4>
                        </div>
                        <div class="modal-body tile" style="padding:40px 50px;">
                            <p>
                                Configuracion de la cuenta
                            </p>
                        </div>
                        <div class="modal-footer tile">
                            <a class="btn btn-success btn-block" href="/EProducts/account">Ir</a>
                        </div>
                    </div>
                </div>
                <div class="admin-panel-item">
                    <div class="modal-content">
                        <div class="modal-header tile" style="padding:35px 50px;">                       
                            <h4><span class="glyphicon glyphicon-user"></span> Deseos </h4>
                        </div>
                        <div class="modal-body tile" style="padding:40px 50px;">
                            <p>
                                Lista de deseos
                            </p>
                        </div>
                        <div class="modal-footer tile">
                            <a class="btn btn-success btn-block" href="/EProducts/users">Ir</a>
                        </div>
                    </div>
                </div>
                <div class="admin-panel-item">
                    <div class="modal-content">
                        <div class="modal-header tile" style="padding:35px 50px;">                       
                            <h4><span class="glyphicon glyphicon-user"></span> Compras </h4>
                        </div>
                        <div class="modal-body tile" style="padding:40px 50px;">
                            <p>
                                Historial de las compras realizadas exitosamente
                            </p>
                        </div>
                        <div class="modal-footer tile">
                            <a class="btn btn-success btn-block" href="/EProducts/users">Ir</a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        
    </body>
    

</html>
