<%-- 
    Document   : personas
    Created on : 28/04/2017, 10:27:04 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <form method= "POST" action="Pisos1">
             <h1>Nuevo piso</h1>
            <table>
                <tr>
                    <td>Numero del piso:</td> 
                    <td><input type="number" name="NumPiso" size="2" placeholder="Ingrese el numero del piso"/> </td>
                </tr>
                <tr>
                    <td>Numero de habitaciones:</td>  
                    <td><input type="number" name="NumHabitaciones" size="2" placeholder="Ingrese el numero de habitaciones"/> </td>
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
