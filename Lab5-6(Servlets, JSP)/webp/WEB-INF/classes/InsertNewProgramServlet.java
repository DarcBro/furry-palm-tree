import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/InsertNewProgram")
public class InsertNewProgramServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        String Display_name = request.getParameter("display_name");
        String Resolution = request.getParameter("resolution");
        String Diagonal = request.getParameter("diagonal");
        String Update_frequency = request.getParameter("update_frequency");
        String Price = request.getParameter("price");

        try {
            String url = "jdbc:mysql://localhost:3306/disp?useSSL=false&useJDBCComplaintTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String username = "root";
            String password = "5555";

            try (Connection connection = DriverManager.getConnection(url, username, password)){
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT MAX(display_ID) FROM displays");
                resultSet.next();
                int nextDisplayID = resultSet.getInt(1) + 1;

                statement.executeUpdate("INSERT INTO displays (display_name, resolution, diagonal, update_frequency, price) VALUES ('"+Display_name+"', '"+Resolution+"', '"+Diagonal+"', "+Update_frequency+", "+Price+")");

                writer.println("<!DOCTYPE html>"+
                        "<html lang=\"ru\">"+

                        "<head>"+
                        "<meta charset=\"UTF-8\">"+
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"+
                        "<title>Ответ от сервера</title>"+
                        "</head>"+
                        "<body>"+
                        "<p class=\"lead\">"+
                        "Запись добавлена!"+
                        "</p>"+
                        "<a href=\"Main\">"+
                        "<button type = \"button\">Вернуться к списку</button>"+
                        "</a>"+
                        "</body>"+
                        "</html>");
            }
        }
        catch(Exception e){
            writer.println("<p>Database connection failed...123</p>");
            writer.println("<p>"+e.getMessage()+"</p>");
            writer.println("<a href=\"Main\"><button>Вернуться к списку</button></a>");
            e.printStackTrace();
        }
        finally {
            writer.close();
        }
    }
}