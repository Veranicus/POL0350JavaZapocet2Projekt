package Servlets;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserDataControlServlet", urlPatterns = {"/UserDataControlServlet"})
public class UserDataControlServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserDataControlServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserDataControlServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

//          Ziskavanie parametrov
            String loggingName = request.getParameter("loggingName");
            String userName = request.getParameter("userName");
            String yearOfBirth = request.getParameter("yearOfBirth");
            String userPlace = request.getParameter("userPlace");


//            Zapisovanie do out/artifacts/web_war_exploded/WEB-INF/WrittenInfo.txt
 
            File outputFile = new File(getServletContext().getRealPath("/") + "WrittenInfo.txt"); //súbor v zložke projektu
            FileWriter userInformation= new FileWriter(outputFile, true);
            userInformation.write(loggingName + " - " + userName  + " - " + yearOfBirth + " - " + userPlace + " | \r\n"); //zapis informaci o userovy
            userInformation.close(); // zatvorenie streamu

            model.User userLoggingCredential = new User(loggingName);
            request.setAttribute("userLoggingCredential", userLoggingCredential);// vytvorenie requestu
            request.getRequestDispatcher("successfulLogging.jsp").forward(request,response); // na stránku pre prihlásenie


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