<%-- 
    Document   : NuevaHabitacion
    Created on : 28/04/2017, 10:45:39 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <form method= "POST" action="Habitaciones1">
             <h1>Nueva Habitacion</h1>
            <table>
                <tr>
                    <td>Numero de Habitacion:</td> 
                    <td><input type="number" name="NumHabitacion" size="3" placeholder="Ingrese el numero de habitacion"/> </td>
                </tr>
                <tr>
                    <td>Capacidad Maxima:</td> 
                    <td><input type="number" name="CapMaxOcupacion" size="2" placeholder="Ingrese la capacidad maxima"/> </td>
                </tr>
                <tr>
                    <td>Precio:</td> 
                    <td><input type="number" name="precio" size="4,2" placeholder="Ingrese el precio"/> </td>
                </tr>
                <tr>
                    <td>Numero de Piso:</td> 
                    <td><input type="number" name="NumPiso" size="2" placeholder="Ingrese el numero del piso"/> </td>
                </tr>
                <tr>
                    <td><input type="submit" id="submit" name="Crear" value="Crear"></td>
                    <td><input type="button" id="button" onClick="window.location.href='index.html'" name="regresar" value="Regresar"> </td>
                </tr>
                <input type="hidden" name="tipo" value="3">
            </table>
            <%
                if (request.getAttribute("Mensaje") != null) {%>
            <h1><%=(String) request.getAttribute("Mensaje")%></h1> 
            <% request.removeAttribute("Mensaje");%>
            <%
                }
            %>
        </form>
</html>
