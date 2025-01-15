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

/**
 *
 * @author kminh
 */
public class Process3 extends HttpServlet {

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
            out.println("<title>Servlet Process3</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Process3 at " + request.getContextPath() + "</h1>");
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
            String birthday = request.getParameter("birthday");
            String gender = request.getParameter("gender");
            String specialization = request.getParameter("specialization");

            String e1 = request.getParameter("english1");
            String e2 = request.getParameter("english2");
            String e3 = request.getParameter("english3");
            String e4 = request.getParameter("english4");
            String[] englishCourses = {e1, e2, e3, e4};

// Xác định các môn English chưa hoàn thành
            StringBuilder incompleteCourses = new StringBuilder();
            for (int i = 0; i < englishCourses.length; i++) {
                if (englishCourses[i] == null || englishCourses[i].trim().isEmpty()) {
                    incompleteCourses.append("English ").append(i + 1).append("; ");
                }
            }

            out.print("<!DOCTYPE html>");
            out.print("<html lang='en'>");
            out.print("<head>");
            out.print("<meta charset='UTF-8'>");
            out.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.print("<title>Student Information</title>");
            out.print("<link rel='stylesheet' href='review3.css'>");
            out.print("</head>");
            out.print("<body>");

            out.print("<div>");
            out.print("<h3>Submit new student</h3>");
            out.print("<table class='table-solid-border'>");
            out.print("<tr class='bold tr-text-align-center'>");
            out.print("<th>Rollnum</th>");
            out.print("<th>Lastname</th>");
            out.print("<th>Firstname</th>");
            out.print("<th>Birthday</th>");
            out.print("<th>Gender</th>");
            out.print("<th>Specialization</th>");
            out.print("<th>English must be completed</th>");
            out.print("</tr>");

            out.print("<tr>");
            out.print("<td>%s</td>".formatted(rn));
            out.print("<td>%s</td>".formatted(ln));
            out.print("<td>%s</td>".formatted(fn));
            out.print("<td>%s</td>".formatted(birthday));
            out.print("<td>%s</td>".formatted(gender));
            out.print("<td>%s</td>".formatted(specialization));
            out.print("<td>%s</td>".formatted(incompleteCourses.toString().isEmpty() ? "None" : incompleteCourses.toString()));
            out.print("</tr>");
            out.print("</table>");
            out.print("</div>");

            out.print("</body>");
            out.print("</html>");

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
