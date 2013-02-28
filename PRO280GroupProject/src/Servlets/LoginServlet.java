package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet meant to set up the log in page, and authenticate users
 * User: jflores
 * Date: 2/27/13
 * Time: 5:58 PM -- Created
 */
@WebServlet("Login.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //I am uncertain as to what needs to happen here
        //      https://my.neumont.edu/nuid/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
