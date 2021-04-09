package servlets;

import beans.UserBean;
import  org.example.model.Accounts;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name="registration",
        urlPatterns = "/registration"
)

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String pswd = req.getParameter("pswd");
        UserBean account = new UserBean();
        account.setFirstName(firstname);
        account.setLastName(lastname);
        account.setEmail(email);
        account.setPswd(pswd);

        Accounts accounts = Accounts.getAccounts();
        accounts.getUsers().add(account);

        Cookie cookie = new Cookie("name", firstname);
        resp.addCookie(cookie);

        out.println("First name: " + account.getFirstName() + "<br>");
        out.println("Last name: " +account.getLastName()+ "<br>");
        out.println("Email: " +account.getEmail()+ "<br>");
        out.println("Password: " +account.getPswd()+ "<br>");
        out.close();
    }
}
