<%-- 
    Document   : ListarPersona
    Created on : 28/04/2017, 11:00:56 AM
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
 <form>
            <h1>Listado Empleados</h1>
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
                    Empleados c = new Empleados();
                    String query = "SELECT * FROM Empleado";
                    Connection connection = c.getConnection();
                    try {
                        // create the java statement
                        Statement st = connection.createStatement();
                        // execute the query, and get a java resultset
                        ResultSet rs = st.executeQuery(query);
                        // iterate through the java resultset
                        while (rs.next()) {
                            int id = rs.getInt("idEmpleado");
                            String nom = rs.getString("nombre");
                            int sec = rs.getInt("seccion");
                            int cant = rs.getInt("CantEquiReparados");
                            String nomu = rs.getString("email");
                            String rol = rs.getString("rol");
                            // print the results
                            out.println("<tr>");
                            out.println("<td> " + id + "</td>");
                            out.println("<td> " + nom + "</td>");
                            out.println("<td> " + sec + "</td>");
                            out.println("<td> " + cant + "</td>");
                            out.println("<td> " + nomu + "</td>");
                            out.println("<td> " + rol + "</td>");
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
