<%-- 
    Document   : BusarPiso.jsp
    Created on : 28/04/2017, 10:35:22 AM
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
        <form method= "POST" action="Pisos1">
            <h1>Buscar Piso</h1>
            <table>
                <tr>
                    <td>digite el numero del piso:</td>
                    <td><input type="number" name="NumPiso" max-leng="2" size="2" placeholder="Ingrese el N°del piso"></td>
                </tr>
                <tr>
                    <td><input type="submit" id="submit" name="buscar" value="Buscar"/></td>
                    <td><input type="button" id="button" onClick="window.location.href = 'index.jsp'" name="regresar" value="Regresar"></td>
                </tr>
            </table>
            <input type="hidden" name="tipo" value="1"/>  
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
