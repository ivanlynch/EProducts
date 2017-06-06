<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Products</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/public/css/materialize.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/public/css/icons.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/public/css/material-icons.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/public/css/newcss.css"/>">
        <!-- Importamos JQuery y la libreria de MaterializeCss -->
        <script src="<c:url value="/public/js/jquery-2.1.1.min.js"/>"></script>
        <script src="<c:url value="/public/js/materialize.min.js"/>"></script>
        <script src="<c:url value="/public/js/customFunctions.js"/>"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>

    <body>



        <!-- Definimos la barra de navegacion -->
        <nav>
            <div class="nav-wrapper cyan">
                <a href="#" class="brand-logo left" style="padding-left: 200px;"><i class="material-icons">shopping_cart</i>E-Products</a>
                <ul class="right hide-on-med-and-down">
                    <li><a onclick="document.getElementById('modal1').style.display = 'block'">Iniciar sesion</a></li>
                    <li><a>¿Ayuda?</a></li>
                    <li><a href="#!">Contacto</a></li>
                </ul> 
            </div>
        </nav>


        <!-- The Modal -->
        <div id="modal1" class="modal2">
            <span onclick="document.getElementById('modal1').style.display = 'none'" class="close" title="Close Modal">&times;</span>

            <!-- Modal Content -->
            <form:form id="login-form" method="POST" commandName="users" class="modal-content2 animate">
                <div class="imgcontainer">
                    <img src="<c:url value="/public/images/rsz_default-user.png"/>" alt="Avatar2" class="avatar">
                </div>
                <div class="container">
                    <form action="/index.htm" method="POST">
                        <p>
                            <label id="Correo"><b>Correo</b></label>
                            <input name="correo" id="correo" class="form-control"/>
                        </p>
                        <p>
                            <label ><b>Password</b></label>
                            <input type="password" name="password" id="password" class="form-control"/>
                        </p>
                        <button type="submit" class="cyan">Enviar</button>
                    </form>
                    <button type="button" onclick="document.getElementById('modal1').style.display = 'none'" class="red">Cancel</button>
                    <span class="psw">Olvidaste tu <a href="#">Contraseña?</a></span>
                </div>
            </form:form>
        </div>

        <div class="container">
            <h1>Productos</h1>
            <hr/>
            <div class="row">

            </div>            
        </div>
        
    </body>
    

</html>
