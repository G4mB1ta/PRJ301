/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 *
 * @author kminh
 */
public class Process2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Process2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Process2 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String fn = request.getParameter("firstname");
            String ln = request.getParameter("lastname");
            String rn = request.getParameter("rollnumber");
            String fln = ln + " " + fn;
            String gender = request.getParameter("gender");
            String userTitle = GetTitleFromGender(gender);
            String specialization = request.getParameter("specialization");
            String birthday = request.getParameter("birthday");
            String e1 = request.getParameter("english1");
            String e2 = request.getParameter("english2");
            String e3 = request.getParameter("english3");
            String e4 = request.getParameter("english4");
            String e[] = { e1, e2, e3, e4};
            boolean isNotEmpty = IsNotEmpty(fn, ln, rn);

            if (!isNotEmpty) {
                out.print("Please input infor");
            } else if (!isValidRN(rn)) {
                out.print("Roll number is not valid");
            } else {
                out.print("<h4>Welcome %s %s</h4>".formatted(userTitle, fn));
                out.print("<h4>Your information: </h4>");
                out.print("<h4>Roll number: %s</h4>".formatted(rn));
                out.print("<h4>Full name: %s</h4>".formatted(fln));
                out.print("<h4>Birthday: %s</h4>".formatted(birthday));
                out.print("<h4>Gender: %s</h4>".formatted(gender));
                out.print("<h4>Specialization:%s</h4>".formatted(specialization));
                out.print("<h4>English must completed: ");
                for (int i = 0; i < e.length; i++) {
                    String course = "English " + (i + 1);
                    if (e[i] == null || e[i].trim().isEmpty()) {
                        out.print("%s; ".formatted(course));
                    }
                }
                out.print("</h4>");
            }

        }
    }

    boolean IsNotEmpty(String fn, String ln, String rn) {
        return !fn.isEmpty() && !ln.isEmpty() && !rn.isEmpty();
    }

    boolean isValidRN(String rn) {
        String regex = "^(HS|HE|HA)\\d{6}$";
        return rn.matches(regex);
    }
    
    private String GetTitleFromGender(String gender) {
        switch (gender) {
            case "Male":
                return "Mr.";
            case "Female":
                return "Ms.";
            default:
                return "";
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
