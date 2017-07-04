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
                    <li><a id="logOut" href="${contextPath}/home"><span class="glyphicon glyphicon-arrow-left"></span>  Volver</a></li>
                </ul>
            </div>
        </nav>
        
        
        <div class="container">
            <div class="modal-content">
                <div class="modal-header">
                    <h3>Administracion de cuenta</h3>
                </div>
                
            </div>
        </div>

    </body>


</html>
