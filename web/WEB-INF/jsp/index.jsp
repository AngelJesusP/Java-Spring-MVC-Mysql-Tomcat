<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <link rel="stylesheet" href='<c:url value="/resources/Css/bootstrap.min.css" />' />
    </head>

    <body>
        <div class="d-flex">
            <div class="col-md-3">
                <div class="card mt-3 ml-3">
                    <div class="card-header text-center">
                        <label class="">CAMPOS PARA EL REGISTRO DEL USUARIO</label>
                    </div>
                    <div class="card-body">
                        <form method="POST">
                            <label for="codigoId">*Ingrese el id del usuario:</label>
                            <input type="number" id="codigoId" name="codigoId" class="form-control" placeholder="Ingrese el codigo del usuario">
                            <br>
                            <label for="nombre">*Ingrese el nombre del usuario:</label>
                            <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Ingrese el nombre del usuario">
                            <br>
                            <label for="apellido">*Ingrese el apellido del usuario:</label>
                            <input type="text" id="apellido" name="apellido" class="form-control" placeholder="Ingrese el apellido del usuario">  
                            <br>
                            <label for="sueldo">*Ingrese el sueldo del usuario:</label>
                            <input type="number" id="sueldo" name="sueldo" class="form-control" placeholder="Ingrese el sueldo del usuario">  
                            <br>
                            <button type="submit" class="btn btn-outline-info w-100" id="btnRegistrar">Registrar</button>
                            <button type="submit" class="btn btn-outline-success w-100 mt-3" id="btnActualizar">Actualizar</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-9">
                <table class="table table-hover mt-3 ml-3" id="tabla">
                    <thead class="bg-light">
                        <tr>
                            <th>CODIGO</th>
                            <th>NOMBRE</th>
                            <th>APELLIDO</th>
                            <th>SUELDO</th>
                            <th>FECHA CONT.</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <c:forEach var="dato" items="${persona}">
                        <tr onclick="enviarRegistroInputsEditar(this)" style="cursor: pointer">
                            <td>${dato.codigoId}</td>
                            <td>${dato.nombre}</td>
                            <td>${dato.apellido}</td>
                            <td>${dato.sueldo}</td>
                            <td>${dato.fechaIngreso}</td>
                            <td>
                                <a href="delete.htm?id=${dato.codigoId}" class="btn btn-danger">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <script src='<c:url value="/resources/Js/jquery-3.5.1.js" />' ></script>
        <script src='<c:url value="/resources/Js/app.js" />' ></script>
    </body>
</html>
