<%-- 
    Document   : NuevoRegistro
    Created on : 28/04/2017, 10:49:54 AM
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
        <form method= "POST" action="Registros1">
             <h1>Nueva Habitacion</h1>
            <table>
                <tr>
                    <td>id:</td> 
                    <td><input type="number" name="id" size="2" placeholder="Ingrese el id"/> </td>
                </tr>
                <tr>
                    <td>NumHabitacion:</td> 
                    <td><input type="number" name="NumHabitacion" size="3" placeholder="Ingrese el numero de la habitacion"/> </td>
                </tr>
                <tr>
                    <td>dia ingreso:</td>  
                    <td><input type="number" name="diai" size="3" placeholder="Ingrese dia de ingreso"/></td> 
                </tr>
                <tr>
                    <td>mes ingreso:</td>  
                    <td><input type="number" name="mesi" size="3" placeholder="Ingrese mes de ingreso"/></td> 
                </tr> 
                <tr>
                    <td>año ingreso:</td>  
                    <td><input type="number" name="añoi" size="3"placeholder="Ingrese año de ingreso"/></td> 
                </tr> 
                <tr>
                    <td>dia salida:</td>  
                    <td><input type="number" name="diaf" size="3" placeholder="Ingrese dia de salida"/></td> 
                </tr>
                <tr>
                    <td>mes salida:</td>   
                    <td><input type="number" name="mesf" size="3" placeholder="Ingrese mes de salida"/></td> 
                </tr>
                <tr>
                    <td>año salida:</td>   
                    <td><input type="number" name="añof" size="3" placeholder="Ingrese año de salida"/></td> 
                </tr> 
                <tr>
                    <td>Responsable:</td> 
                    <td><input type="number" name="Responsable" size="2" placeholder="Ingrese el numero del piso"/> </td>
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
    </body>
</html>
