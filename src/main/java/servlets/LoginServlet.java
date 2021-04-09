package servlets;
import beans.UserBean;
import org.example.model.Accounts;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name="login",
        urlPatterns = "/login"
)

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();

        String email = req.getParameter("email");
        String pswd = req.getParameter("pswd");


        if(!Accounts.getAccounts().getUsers().isEmpty()){
            for(UserBean userBean: Accounts.getAccounts().getUsers()){
                if (userBean.getEmail().equals(email)  && userBean.getPswd().equals(pswd)){
                    String name = userBean.getFirstName();
                    out.print("You are successfully logged in!");
                    out.print("<br>Welcome, " + name);
                    Cookie ck = new Cookie("name",name);
                    resp.addCookie(ck);

                    HttpSession session=req.getSession();
                    session.setAttribute("name",name);
                }else{
                    out.print("Error, email or password incorrect!");
                    req.getRequestDispatcher("login.jsp").include(req, resp);
                }
            }
        }else{
            out.println("You are not registered yet!");
            out.println("<a href=\"registration.jsp\"> Register</a>");
        }
        out.close();
    }

}

