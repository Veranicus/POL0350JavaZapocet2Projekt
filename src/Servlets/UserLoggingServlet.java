package Servlets;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserLoggingServlet", urlPatterns = {"/UserLoggingServlet"})
public class UserLoggingServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserLoggingServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserLoggingServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");


//            Získavanie parametrom z requestu, teda z fieldov po ich vyplnení na úvodnej stránke index.html
            String loggingName = request.getParameter("loggingName");
            String password = request.getParameter("password");
//           Kontrola správnych logginov, teda prihlasovacieho mena a hesla po ich zadaní na úvodnej stránke index.html
            if ("123".equals(password) && loggingName.equals("John") || "456".equals(password) && loggingName.equals("Dominic")
                    || "789".equals(password) && loggingName.equals("Patrick") || "985".equals(password) && loggingName.equals("Daniel")
                    || "464".equals(password) && loggingName.equals("Taylor")) {

//                Vytváranie objektu s prihlasovacím menom usera
                model.User userLoggingCredential = new User(loggingName);
                System.out.println(loggingName);

//              Pridanie daného objektu k requestu
                request.setAttribute("userLoggingCredential", userLoggingCredential);

//                Presun usera na novú stránku a odoslanie nami získaných údajov, teda objektu v requeste
//                 V prípade zadanie dobrého logging mena a hesla
                request.getRequestDispatcher("successfulLogging.jsp").forward(request, response);

            } else {
//                V prípade zadania zlého logginu, presmerovanie na stránku oznamujúcu chybný pokus o prihlásenie
                request.getRequestDispatcher("unsuccessfulLogging.jsp").forward(request, response);
            }
        }
    }
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
        processRequest(request, response);
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
