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
                <a id="username">Panel de Administración</a>
                <ul class="nav navbar-nav navbar-right">
                    <li><a id="logOut" href="/EProducts/logout"><span class="glyphicon glyphicon-log-out"></span>Log out</a></li>
                </ul>
            </div>
        </nav>

        <ul class="cd-items cd-container">
		<li class="cd-item custompanel">
                    <div class="modal-content">
                        <div class="modal-header" style="padding:35px 50px;">                       
                            <h4><span class="glyphicon glyphicon-cog"></span> Productos </h4>
                        </div>
                        <div class="modal-body" style="padding:40px 50px;">
                            <p>
                                Administracion de productos
                            </p>
                        </div>
                        <div class="modal-footer">
                            <a class="btn btn-success btn-block" href="/EProducts/products">Ir</a>
                        </div>
                    </div>
		</li>
                <li class="cd-item custompanel">
                    <div class="modal-content">
                        <div class="modal-header" style="padding:35px 50px;">                       
                            <h4><span class="glyphicon glyphicon-user"></span> Usuarios </h4>
                        </div>
                        <div class="modal-body" style="padding:40px 50px;">
                            <p>
                                Administracion de usuarios
                            </p>
                        </div>
                        <div class="modal-footer">
                            <a class="btn btn-success btn-block" href="/EProducts/users">Ir</a>
                        </div>
                    </div>
		</li>
        </ul>

    </body>


</html>
