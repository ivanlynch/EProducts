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
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only"> Toogle Navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <a id="username">${users.nombre}</a>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">¿Ayúda?</a></li>
                        <li><a href="#">Contacto</a></li>
                        <li><a id="logOut" href="/EProducts/logout"><span class="glyphicon glyphicon-log-out"></span>Log out</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container bg-success">
            <h1>Productos</h1>
            <hr/>
            <div class="row">

            </div>            
        </div>
        
    </body>
    

</html>
