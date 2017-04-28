/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Modelo.Persona;
import Modelo.Registro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

/**
 *
 * @author Labing
 */
public class Registros {

    PreparedStatement preparedStmt;
    Connection connection;
    String query;

    public Registros() {
        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("MySQL JDBC Driver Registered!");
        this.connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
        //Insertion 
        // create a sql date object so we can use it in our INSERT statement
        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

    }

    public boolean agregar(Registro a) {
        boolean r = false;
        try {
            // the mysql insert statement
            query = " insert into Registros (id,NumHabitacion,fechaInicio,fechaSalida,Responsable)"
                    + " values (?, ?,?,?,?)";
            // create the mysql insert preparedstatement
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, a.getId());
            preparedStmt.setInt(2, a.getNumHabitacion());
            preparedStmt.setDate(3, a.getFechaInicio());
            preparedStmt.setDate(4, a.getFechaSalida());
            preparedStmt.setInt(4, a.getResponsable().getCedula());
            // execute the preparedstatement
            preparedStmt.execute();
            System.out.println("You made it, the insertion is ok!");
            r = true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make insertion!");
            e.printStackTrace();
        }
        return r;
    }

    public Registro buscar(int id) {
        Registro a = null;
        // if you only need a few columns, specify them by name instead of using "*"
        this.query = "select * from persona where Cedula = " + id;
        try {
            // create the java statement
            Statement st = this.connection.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(this.query);
            // iterate through the java resultset
            while (rs.next()) {
                int id2 = rs.getInt("id");
                int habitacion = rs.getInt("NumHabitacion");
                Date fini = rs.getDate("fechaInicio");
                Date fsal = rs.getDate("fechaSalida");
                int res = rs.getInt("Responsable");
                Persona  p = new Personas().buscar(res);
                a = new Registro(id2, habitacion, fini, fsal, p);
            }
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }
        return a;
    }

    public boolean eliminar(int id) {
        boolean r = false;
        try {
            this.query = "delete from persona where Cedula = " + id;
            this.preparedStmt = this.connection.prepareStatement(this.query);
            this.preparedStmt.execute();
            System.out.println(" se borro corectamente \n\n ");
            r = true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }

        return r;
    }

    public void disconect() throws SQLException {
        this.connection.close();
    }

    public PreparedStatement getPreparedStmt() {
        return preparedStmt;
    }

    public Connection getConnection() {
        return connection;
    }

}
