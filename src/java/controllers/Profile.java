/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import helpers.Helper;
import helpers.Message;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.UsersModel;

/**
 *
 * @author davi
 */
@WebServlet(name = "Profile", urlPatterns = {"/profile"})
public class Profile extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (Helper.isEmpty(action)) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/home"));
        }

        if (action.equals("login")) {
            this.loginAction(request, response);
        }
        if(action.equals("home")){
            this.homeAction(request, response);
        }
    }

    protected void loginAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            models.beans.User user = UsersModel.authenticate(username, password);
            if (user == null) {
                request.setAttribute("message", new Message("Login ou senha inválidos", "error"));
                getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
                return;
            }

            request.getSession().setAttribute("user", user);
            request.setAttribute("action", "leriado");
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/profile?action=home"));

        } catch (Exception e) {
            request.setAttribute("message", new Message(e.getMessage(), "error"));
            getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
        }
    }
    
    protected void homeAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/home"));
            return;
        }
        
        getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
