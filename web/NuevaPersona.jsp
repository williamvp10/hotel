<%-- 
    Document   : NuevaPersona
    Created on : 28/04/2017, 10:40:32 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form method= "POST" action="Personas1">
            <h1>Nueva Persona</h1>
            <table>
                
                <tr>
                    <td>Nombre: </td>  
                    <td><input type="text" name="Nombre" size="20" placeholder="Ingrese el nombre"/>  </td>
                <tr>
                    <tr>
                    <td>apellido: </td>    
                    <td><input type="text" name="Apellido" size="20" placeholder="Ingrese el apellido"/> </td>
                </tr>
                    <tr>
                    <td>Cedula:</td>     
                    <td><input type="number" name="Cedula" size="10" placeholder="Ingrese la cedula"/> </td>
                </tr>
                    <td>telefono: </td>    
                    <td><input type="number" name="Telefono" size="15" placeholder="Ingrese el telefono"/> </td>
                </tr>
                <tr>
                    <td> numero de habitacion: </td>    
                    <td> <input type="number" name="NumHabitacion" size="3" placeholder="Ingrese el N° de la habitacion"/></td>
                </tr>
                <tr>
                    <td><input type="submit" id="submit" name="Crear" value="Crear"></td>
                    <td><input type="button" id="button" onClick="window.location.href = 'index.html'" name="regresar" value="Regresar"> </td>
                </tr>
                <input type="hidden" name="tipo" value="3">
            </table>

            <%
                if (request.getAttribute("Mensaje") != null) {%>
            <h1><%=(String) request.getAttribute("Mensaje")%></h1> 
            <% request.removeAttribute("Mensaje");
            %>
            <%
                }
            %>
        </form>
    </body>
</html>
