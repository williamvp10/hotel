<%-- 
    Document   : ListarPiso
    Created on : 28/04/2017, 10:54:09 AM
    Author     : LENOVO
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
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
            <h1>Listado Aeronaves</h1>
            <table border="0">
            <tr>
                <td> ID</td> 
                <td> Nombre</td> 
            </tr>
            <%
                Pisos c = new Pisos();
                String query = "SELECT * FROM Piso";
                 Connection connection=c.getConnection();
                try {
                    // create the java statement
                    Statement st = connection.createStatement();
                    // execute the query, and get a java resultset
                    ResultSet rs = st.executeQuery(query);
                    // iterate through the java resultset
                    while (rs.next()) {
                        int id = rs.getInt("NumPiso");
                        String num = rs.getString("NumHabitaciones");
                        // print the results
                        out.println("<tr>");
                        out.println("<td> " + id + "</td>");
                        out.println("<td> " + num + "</td>");
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
            <input type="button" id="button" onClick="window.location.href = 'index.html'" name="regresar" value="Regresar"> 
        </form>
    </body>
</html>
