<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Products</title>
        <%@include file="../Dependencies.jsp" %>
    </head>

    <body>

        <!-- Definimos la barra de navegacion -->
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a href="#" class="navbar-brand"><span class="glyphicon glyphicon-shopping-cart"></span> EProducts</a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a id="logOut" href="${contextPath}/users"><span class="glyphicon glyphicon-arrow-left"></span>  Volver</a></li>
                </ul>
            </div>
        </nav>


        <!-- Modal -->
        <div class="modal fade" id="loginModal">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header" style="padding:35px 50px;">
                        <button type="button" data-dismiss="modal" class="close">&times;</button>
                        <h4><span class="glyphicon glyphicon-lock"></span> Iniciar sesion</h4>
                    </div>
                    <div class="modal-body" style="padding:40px 50px;">
                        <form:form id="login-form" name="loginForm" method='POST'>
                            <div class="form-group">
                                <label for="usrname" ><span class="glyphicon glyphicon-user"></span> Correo</label>
                                <input type="text" class="form-control" name="correo" id="correo">
                            </div>
                            <div class="form-group">
                                <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Contraseña</label>
                                <input type="password" class="form-control" name="password">
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox" value="" checked>Remember me</label>
                            </div>
                            <div class="form-group">
                                <button type="submit" id="loginBtn" class="btn btn-custom btn-block"><span class="glyphicon glyphicon-off"></span> Iniciar sesion </button>
                            </div>

                        </form:form>
                        <hr/>
                        <div id="errorMsg">${error}</div>   
                    </div>
                    <div class="modal-footer">
                        <p>¿No tenes cuenta? <a href="${contextPath}/singup">Registrate</a></p>
                        <p>Olvidates tu <a href="#">contraseña?</a></p>
                    </div>
                </div>

            </div>
        </div> 
        <div class="container">
            <div class="modal-content">
                    <div class="modal-header" style="padding:35px 50px;">
                        <h4><span class="glyphicon glyphicon-plus-sign"></span> Agregar Usuario</h4>
                    </div>
                    <div class="modal-body" style="padding:40px 50px;">
                        <form:form id="register-form" commandName="users" method='POST'>
                            <div class="form-group">
                                <form:label path="username" ><span class="glyphicon glyphicon-user"></span> Nombre</form:label>
                                <form:input type="text" class="form-control" path="username"/>
                                <form:errors path="username"/>
                            </div>
                            <div class="form-group">
                                <form:label path="correo" ><span class="glyphicon glyphicon-envelope"></span> Correo</form:label>
                                <form:input type="text" class="form-control" name="correo" path="correo" />
                                <form:errors path="correo"/>
                            </div>
                            <div class="form-group">
                                <form:label path="telefono" ><span class="glyphicon glyphicon-phone"></span> Telefono</form:label>
                                <form:input type="text" class="form-control" name="telefono" path="telefono" />
                            </div>
                            <div class="form-group">
                                <form:label path="password"><span class="glyphicon glyphicon-lock"></span> Contraseña</form:label>
                                <form:input type="password" class="form-control" name="password" path="password"/>
                            </div>
                            <div class="form-group">
                                <form:label path="password2"><span class="glyphicon glyphicon-lock"></span> Repetir Contraseña</form:label>
                                <form:input type="password" class="form-control" name="repassword" path="password2"/>
                            </div>
                            <div class="form-group">
                                <form:label path="isAdmin"><span class="glyphicon glyphicon-lock"></span> ¿Es Administrador? </form:label>
                                <form:checkbox class="form-control" value="1" path="isAdmin"/>
                            </div>
                            <div class="form-group">
                                <button type="submit" id="loginBtn" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Enviar </button>
                            </div>
                            <hr/>
                            <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                        </form:form>
                    </div>
                </div>
                            
        </div>







    </body>


</html>