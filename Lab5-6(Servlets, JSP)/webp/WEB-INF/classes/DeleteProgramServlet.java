import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/DeleteProgram")
public class DeleteProgramServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        int display_ID = Integer.parseInt(request.getParameter("display_ID"));

        try {
            String url = "jdbc:mysql://localhost:3306/disp?useSSL=false&useJDBCComplaintTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String username = "root";
            String password = "5555";

            try (Connection connection = DriverManager.getConnection(url, username, password)){
                Statement statement = connection.createStatement();
                statement.executeUpdate("DELETE FROM displays WHERE display_ID = " + display_ID);
            }

        }

        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}