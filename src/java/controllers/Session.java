package controllers;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import helpers.*;

import models.UsersModel;

/**
 *
 * @author davi
 */
@WebServlet(name = "Session", urlPatterns = {"/session"})
public class Session extends HttpServlet {

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
        System.out.println(action);

        if (Helper.isEmpty(action)) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
            return;
        }

        if (action.equals("login")) {
            loginAction(request, response);
            return;
        }

        if (action.equals("logout")) {
            logoutAction(request, response);
            return;
        }

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
    }

    protected void loginAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/profile"));

        } catch (Exception e) {
            request.setAttribute("message", new Message(e.getMessage(), "error"));
            getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
        }
    }

    protected void logoutAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.getSession().removeAttribute("user");
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
        } catch (Exception e) {
            request.setAttribute("message", new Message(e.getMessage(), "error"));
            getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
        }
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
