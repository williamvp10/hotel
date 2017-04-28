/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.Personas;
import Modelo.Persona;
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
public class Personas1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Personas c;

    public Personas1() throws FileNotFoundException {
        c = new Personas();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            int id = Integer.parseInt(request.getParameter("Cedula"));
            int tipo = Integer.parseInt(request.getParameter("tipo"));
            if (tipo == 1) {
                Persona e1 = c.buscar(id);
                if (e1 == null) {
                    request.setAttribute("Mensaje", "No se encontro ");
                } else {
                    request.setAttribute("Mensaje", "Nombre: " + e1.getNombre());
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("BuscarPersona.jsp");
                dispacher.forward(request, response);
            } else if (tipo == 2) {
                boolean p = this.c.eliminar(id);
                if (p) {
                    request.setAttribute("Mensaje", "Se a eliminado correctamente ");
                } else {
                    request.setAttribute("Mensaje", "no se encontro ");
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("EliminarPersona.jsp");
                dispacher.forward(request, response);
            } else if (tipo == 3) {
                if (request.getParameter("Nombre").length() != 0) {
                    String nombre = request.getParameter("Nombre").trim();
                    String apellido = request.getParameter("Apellido").trim();
                    int telefono = Integer.parseInt(request.getParameter("Telefono"));
                    int NumHabitacion = Integer.parseInt(request.getParameter("NumHabitacion"));

                    Persona p = new Persona(nombre, apellido, id, telefono, NumHabitacion);
                    boolean n = this.c.agregar(p);
                    if (n) {
                        request.setAttribute("Mensaje", "Se agrego correctamente ");
                    } else {
                        request.setAttribute("Mensaje", "id repetido intente nuevamente ");
                    }
                } else {
                    request.setAttribute("Mensaje", "casillas incompletas intente nuevamente ");
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("NuevaPersona.jsp");
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
            Logger.getLogger(Personas1.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Personas1.class.getName()).log(Level.SEVERE, null, ex);
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
