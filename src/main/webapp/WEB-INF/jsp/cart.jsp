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
                    <li><a id="logOut" href="${contextPath}/home"><span class="glyphicon glyphicon-arrow-left"></span>  Volver</a></li>
                </ul>
            </div>
        </nav>
        
        <div class="container">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h3><span class="glyphicon glyphicon-check"></span> Detalle de la compra </h3>
                            </div>
                            <table class="table table-hover">
                                <thead>
                                    <th>#ID</th>
                                    <th>Nombre de producto</th>
                                    <th>Descripcion</th>
                                    <th>Cantidad</th>
                                    <th>Precio</th>
                                </thead>
                                <tbody class="modal-content">
                                    <c:set var="count" scope="session" value="0"/>
                                    <c:forEach items="${cart}" var="item">
                                        <c:set var="totalPriceUnit" scope="session" value="${item.product.productPrice * item.quantity}"/>
                                        <c:set var="count" scope="session" value="${count + totalPriceUnit}" />
                                        <tr class="tableRow">
                                            <td id="productId"><c:out value="${item.product.id}"></c:out></td>
                                            <td id="productName"><c:out value="${item.product.productName}"></c:out></td>
                                            <td id="productDescription"><c:out value="${item.product.productDescription}"></c:out></td>
                                            <td id="quantity"><c:out value="${item.quantity}"></c:out></td>
                                            <td id="productPrice"><c:out value="${totalPriceUnit}"></c:out></td>
                                            <td><a href="<c:url value="/cart/delete/${item.product.id}"/>"><span class="glyphicon glyphicon-trash"></span></a></td>
                                        </tr>
                                    </c:forEach>    
                                </tbody>
                            </table>
                            <div class="alert alert-success totalBox">
                                <div style="display: inline-block">Total:</div>
                                <div id="totalPrice" style="display: inline-block">${count}</div>
                            </div>

                            <div class="modal-footer">
                                <a id="checkout" class="btn btn-success checkout"><span class="glyphicon glyphicon-trash">Comprar</a>
                            </div> 
                            
                        </div>
        </div>
        
        

    </body>


</html>
