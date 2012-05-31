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
@WebServlet(name = "Signup", urlPatterns = {"/signup"})
public class Signup extends HttpServlet {

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

        if (action.equals("form")) {
            formAction(request, response);
            return;
        }

        if (action.equals("signup")) {
            signupAction(request, response);
            return;
        }

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
    }

    protected void formAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //- VALIDADES PARAMETERS
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (Helper.isEmpty(name) || Helper.isEmpty(email) || Helper.isEmpty(password)) {
            request.setAttribute("message", new Message("Favor preencher todos os dados", "error"));
            getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
            return;
        }

        //- CHECK IF EMAIL EXISTES
        try {
            if ( UsersModel.findByEmail(email) != null) {
                request.setAttribute("message", new Message("Seu email já existe em nosso banco de dados", "info"));
                getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
                return;
            }
        } catch (Exception e) {
            request.setAttribute("message", new Message(e.getMessage(), "error"));
            getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
            return;
        }

        //- CREATE THE OBJECT FOR THE SIGNUP FORM
        models.beans.User user = new models.beans.User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        //- FOWARD THE REQUEST TO THE SIGNUP FORM
        request.setAttribute("userSignup", user);
        getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);

    }

    protected void signupAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //- VALIDATES THE REQUEST PARAMETERS
        String name = request.getParameter("name").trim();
        String email = request.getParameter("email").trim();
        String sex = request.getParameter("sex").trim();
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        if (Helper.isEmpty(email) || Helper.isEmpty(username) || Helper.isEmpty(password)) {
            request.setAttribute("message", new Message("Favor preencher todos os dados", "error"));
            getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
            return;
        }

        //- CREATE THE OBJECT FOR THE SIGNUP FORM
        models.beans.User userSignup = new models.beans.User();
        userSignup.setName(name);
        userSignup.setEmail(email);
        userSignup.setUsername(username);
        userSignup.setPassword(password);
        userSignup.setSex(sex);
        request.setAttribute("userSignup", userSignup);

        try {
            if (UsersModel.findByEmail(email) != null) {
                request.setAttribute("message", new Message("Seu <strong>email</strong> já existe em nosso banco de dados", "info"));
                getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);
                return;
            }

            if (UsersModel.findByUsername(username) != null) {
                request.setAttribute("message", new Message("Seu <strong>usuário</strong> já existe em nosso banco de dados", "info"));
                getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);
                return;
            }

            UsersModel.save(userSignup);
            request.getSession().setAttribute("user", userSignup);
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/profile"));

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
