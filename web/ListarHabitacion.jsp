<%-- 
    Document   : ListarHabitacion
    Created on : 28/04/2017, 10:57:01 AM
    Author     : LENOVO
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form>
            <h1>Listado Habitaciones</h1>
            <table border="0">
                <tr>
                    <td> ID</td> 
                    <td> Nombre</td> 
                    <td> Sección</td> 
                    <td> cantidad de Equi.Reparados</td> 
                    <td> Correo</td> 
                    <td> Rol</td> 
                </tr>
                <%
                    Habitaciones c = new Habitaciones();
                    String query = "SELECT * FROM Habitacion";
                    Connection connection = c.getConnection();
                    try {
                        // create the java statement
                        Statement st = connection.createStatement();
                        // execute the query, and get a java resultset
                        ResultSet rs = st.executeQuery(query);
                        // iterate through the java resultset
                        while (rs.next()) {
                            int id = rs.getInt("NumHabitacion");
                            int sec = rs.getInt("CapMaxOcupacion");
                            int cant = rs.getInt("Precio");
                            int NumPiso = rs.getInt("NumPiso");
                            // print the results
                            out.println("<tr>");
                            out.println("<td> " + id + "</td>");
                            
                            out.println("<td> " + sec + "</td>");
                            out.println("<td> " + cant + "</td>");
                            out.println("<td> " + NumPiso + "</td>");
                            out.println("</tr>");
                        }
                        st.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        System.out.println("Failed to make update!");
                        e.printStackTrace();
                    }
                %>
            </table>
            <input type="button" id="button" onClick="window.location.href = 'index.jsp'" name="regresar" value="Regresar"> 
        </form>
    </body>
</html>
