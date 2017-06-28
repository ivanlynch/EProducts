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
                <ul class="nav navbar-nav navbar-right">
                    <li><a id="logOut" href="/EProducts/home"><span class="glyphicon glyphicon-arrow-left"></span>  Volver</a></li>
                </ul>
            </div>
        </nav>
        
        
        <div class="container">
            <div class="modal-content">
                <div class="modal-header">
                    <h3>Carrito de compras</h3>
                </div>
                <table class="table table-hover">
                    <thead class="modal-header">
                        <tr>
                            <th>#ID</th>
                            <th>Nombre</th>
                            <th>Descripción</th>
                            <th>Precio</th>
                            <th>Stock</th>
                            <th></th>
                            <th><a class="btn" href="products/add">Agregar</a></th>
                        </tr>
                    </thead>
                    <tbody class="modal-content">
                        <c:forEach items="${cart}" var="item">
                            <tr>
                                <td><c:out value="${item.product.id}"></c:out></td>
                                <td><c:out value="${item.product.productName}"></c:out></td>
                                <td><c:out value="${item.product.productDescription}"></c:out></td>
                                <fmt:setLocale value="es_AR" scope="session"/>
                                <td><fmt:formatNumber value="${item.product.productPrice}" type="currency" currencySymbol="$"/></td>
                                <td><c:out value="${item.product.productStock}"></c:out></td>
                                <td><img src="data:image/jpeg;base64,${item.product.productImage}"/></td>
                                <td>
                                    <a href="<c:url value="products/edit?id=${item.product.id}"/>"><span class="glyphicon glyphicon-pencil"></span></a>
                                    <a href="<c:url value="products/delete?id=${item.product.id}"/>"><span class="glyphicon glyphicon-trash"></span></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </body>


</html>
