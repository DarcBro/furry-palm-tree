<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="JavaClasses.*" %>
<%@ page import ="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>DisplaysHTML</title>
    <script src="script.js"></script>
</head>

<body>
    <section>
        <div>
            <div>
                <div>
                    <form action="InsertNewProgram" method="POST">
                        <fieldset>
                            <hr>
                            <p>Название дисплея</p>
                            <input type="text" id="display_name" name ="display_name">
                            <p>Разрешение</p>
                            <input type="text" id="resolution" name = "resolution">
                            <p>Диагональ</p>
                            <input type="number" id="diagonal" name = "diagonal">
                            <p>Частота обновления</p>
                            <input type="number" id="update_frequency" name = "update_frequency">
                            <p>Стоимость</p>
                            <input type="number" id="price" name = "price">
                           <hr>
                            <button type="submit" id="create">Добавить запись</button>
                        </fieldset>
                    </form>
                    <button type="button" id="delete" onclick="deleteRow()" >Удалить запись</button>
                </div>
            </div>
        </div>
    </section>
    <br>
    <div></div>
    <br>
    <section>
        <div>
            <div>
                <div>

                    <br>
                    <table id="displays">
                        <thead>
                            <tr>
                            <th>ID дисплея</th>
                            <th>Название дисплея</th>
                            <th>Разрешение</th>
                            <th>Диагональ</th>
                            <th>Частота обновления</th>
                            <th>Стоимость</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                            <% if (request.getAttribute("displays") != null) {

                                ArrayList<ProgramBean> list = (ArrayList<ProgramBean>) request.getAttribute("displays");
                            
                                for (ProgramBean element : list) {
                                    out.println("<tr>");
                                    out.println("<td>" + element.getDisplay_ID() + "</td>");
                                    out.println("<td>" + element.getDisplay_name() + "</td>");
                                    out.println("<td>" + element.getResolution() + "</td>");
                                    out.println("<td>" + element.getDiagonal() + "</td>");
                                    out.println("<td>" + element.getUpdate_frequency() + "</td>");
                                    out.println("<td>" + element.getPrice() + "</td>");
                                    out.println("</tr>");
                                }
                              }
                            %>

                            <%-- <c:forEach var="display" items="${displays}">
                                <tr>
                                    <th>${display.get(0).getDisplay_ID()}</th>
                                    <td>${display.Display_name}</td>
                                    <td>${display.Resolution}</td>
                                    <td>${display.Diagonal}</td>
                                    <td>${display.Update_frequency}</td>
                                    <td>${display.Price}</td>
                                </tr>
                            </c:forEach> --%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
</body>
</html>