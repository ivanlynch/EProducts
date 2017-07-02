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
        
        <c:choose>
            <c:when test="${empty cart}">
                <div class="container">
                    <div class="modal-content">
                        <div class="modal-header">
                            <div class="alert alert-success totalBox">
                                <div id="totalPrice">Su carrito está vacío</div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="container">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h3><span class="glyphicon glyphicon-shopping-cart"></span> Carrito</h3>
                        </div>
                        <hr/>
                        <table class="table table-hover">
                            <tbody class="modal-content">
                                <c:forEach items="${cart}" var="item">
                                    <tr>
                                        <td><c:out value="${item.product.id}"></c:out></td>
                                        <td><c:out value="${item.product.productName}"></c:out></td>
                                        <td><c:out value="${item.product.productDescription}"></c:out></td>
                                        <fmt:setLocale value="es-AR" scope="session"/>
                                        <td><fmt:formatNumber value="${item.product.productPrice}" type="currency" currencySymbol="$"/></td>
                                        <td>
                                            <input type="number" class="cantidad" placeholder="Ingrese la cantidad" min="0" value="1" onkeydown="return false" >
                                            <input class="precioUnitario" type="hidden" value="${item.product.productPrice}">
                                        </td>
                                        <td class="totalQty"></td>
                                        <td>
                                            <a href="<c:url value="/cart/delete/${item.product.id}"/>"><span class="glyphicon glyphicon-trash"></span></a>
                                        </td>
                                    </tr>
                                </c:forEach>    
                            </tbody>
                        </table>
                        <div class="alert alert-success totalBox">
                            <div style="display: inline-block">Total:</div>
                            <div id="totalPrice" style="display: inline-block"></div>
                        </div>
                        <hr>
                        <div class="modal-footer">
                            <a class="btn btn-success" href="#" style="display: inline-block">Checkout</a>
                        </div> 
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
        

    </body>


</html>
