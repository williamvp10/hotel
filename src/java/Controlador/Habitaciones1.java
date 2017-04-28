/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.Habitaciones;
import Modelo.Habitacion;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Labing
 */
public class Habitaciones1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Habitaciones c;

    public Habitaciones1() throws FileNotFoundException {
        c = new Habitaciones();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            int id = Integer.parseInt(request.getParameter("NumHabitacion"));
            int tipo = Integer.parseInt(request.getParameter("tipo"));
            if (tipo == 1) {
                Habitacion e1 = c.buscar(id);
                if (e1 == null) {
                    request.setAttribute("Mensaje", "No se encontro ");
                } else {
                    request.setAttribute("Mensaje", "Numero de habitacion: " + e1.getNumHabitacion());
                    request.setAttribute("Mensaje", "Numero de piso " + e1.getNumHabitacion());
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("BuscarHabitacion.jsp");
                dispacher.forward(request, response);
            } else if (tipo == 2) {
                boolean p = this.c.eliminar(id);
                if (p) {
                    request.setAttribute("Mensaje", "Se a eliminado correctamente ");
                } else {
                    request.setAttribute("Mensaje", "no se encontro ");
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("EliminarHabitacion.jsp");
                dispacher.forward(request, response);
            } else if (tipo == 3) {
                if (Integer.parseInt(request.getParameter("NumHabitacion"))!=0) {
                    int CapMaxOcupacion = Integer.parseInt(request.getParameter("CapMaxOcupacion"));
                    int precio = Integer.parseInt(request.getParameter("precio"));
                    int NumPiso = Integer.parseInt(request.getParameter("NumPiso"));

                    Habitacion p = new Habitacion(id, CapMaxOcupacion, precio, NumPiso);
                    boolean n = this.c.agregar(p);
                    if (n) {
                        request.setAttribute("Mensaje", "Se agrego correctamente ");
                    } else {
                        request.setAttribute("Mensaje", "id repetido intente nuevamente ");
                    }
                } else {
                    request.setAttribute("Mensaje", "casillas incompletas intente nuevamente ");
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("NuevaHabitacion.jsp");
                dispacher.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Habitaciones1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Habitaciones1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

