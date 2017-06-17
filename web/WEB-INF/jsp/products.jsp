<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
                <a id="username">Administración de Productos</a>
                <ul class="nav navbar-nav navbar-right">
                    <li><a id="logOut" href="/EProducts/admin"><span class="glyphicon glyphicon-arrow-left"></span>  Volver</a></li>
                </ul>
            </div>
        </nav>
        
        
        <ul class="cd-items cd-container">
            
            <table class="customtable">
                    <thead class="modal-header">
                        <tr>
                            <th>#ID</th>
                            <th>Nombre</th>
                            <th>Descripción</th>
                            <th>Precio</th>
                            <th>Stock</th>
                            <th><a class="btn btn-add" href="products/add">Agregar</a></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody class="modal-content">
                        <c:forEach items="${products}" var="product">
                            <tr>
                                <td><c:out value="${product.id}"></c:out></td>
                                <td><c:out value="${product.productName}"></c:out></td>
                                <td><c:out value="${product.productDescription}"></c:out></td>
                                <fmt:setLocale value="es_AR" scope="session"/>
                                <td><fmt:formatNumber value="${product.productPrice}" type="currency" currencySymbol="$"/></td>
                                <td><c:out value="${product.productStock}"></c:out></td>
                                <td><img src="data:image/jpeg;base64,${product.productImage}"/></td>
                                <td>
                                    <a href="<c:url value="products/edit?id=${product.id}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                    <a href="<c:url value="products/delete?id=${product.id}"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
            </table>
                
        </ul>

    </body>


</html>
