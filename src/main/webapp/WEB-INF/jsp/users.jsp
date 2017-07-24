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
                        <li><a id="logOut" href="${contextPath}/home"><span class="glyphicon glyphicon-arrow-left"></span>  Volver</a></li>   
                    </ul>
                </div>
            </div>
        </nav>
        
        
        <div class="container">
            <div class="modal-content">
                <div class="modal-header">
                    <h3>Administracion de Usuarios</h3>
                </div>
                <table class="table table-hover">
                    <thead class="modal-header">
                        <tr>                            
                            <th>Nombre</th>
                            <th>Correo</th>
                            <th>Telefono</th>                           
                            <th><a class="btn btn-add" href="users/add">Agregar</a></th>                            
                        </tr>
                    </thead>
                    <tbody class="modal-content">
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td><c:out value="${user.nombre}"></c:out></td>
                                <td><c:out value="${user.correo}"></c:out></td>
                                <td><c:out value="${user.telefono}"></c:out></td>
                                    <td>
                                        <a href="<c:url value="users/edit?id=${user.id}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                    <a href="<c:url value="users/delete?id=${user.id}"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </body>


</html>
