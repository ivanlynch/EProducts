<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@include file="Dependencies.jsp" %>
        <title>JSP Page</title>
    </head>
    <body class="error-body">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="error-template">
                        <h1>Oops!</h1>
                        <h2>403 Access Denied</h2>
                        <div class="error-details">${msg}</div>
                        <div class="error-actions">
                            <a href="/EProducts/home" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
                                Ir a Home </a><a href="" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-envelope"></span> Contactar soporte </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
