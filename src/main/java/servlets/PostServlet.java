package servlets;

import beans.PostBean;
import beans.UserBean;
import org.example.model.Accounts;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name="post",
        urlPatterns = "/post"
)
public class PostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();

        String tittle = req.getParameter("tittle");
        String pContent = req.getParameter("pContent");
        String comment = req.getParameter("comment");

        PostBean postBean = new PostBean();
        postBean.setTitle(tittle);
        postBean.setpContent(pContent);
        postBean.setUserName((String)req.getSession().getAttribute("name"));
        postBean.setComment(comment);

        if(req.getSession() != null){
            for(UserBean user: Accounts.getAccounts().getUsers()){
                if(user.getFirstName().equalsIgnoreCase((String)req.getSession().getAttribute("name"))){
                    user.getPosts().add(postBean);
                    out.println(user.getFirstName() + "'s post");
                    for(PostBean postBean1: user.getPosts()){
                        out.println(postBean1.getTitle() + " \n" +
                                postBean1.getpContent()+ " \n" +
                                postBean1.getComment());
                    }
                }
            }

        }

    }
}
