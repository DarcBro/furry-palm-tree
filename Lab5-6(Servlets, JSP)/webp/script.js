function deleteRow() {
    var display_IDToDelete = prompt("Введите ID дисплея, которую нужно удалить.");
    // строка с параметрами для отправки
    var parameters = "display_ID=" + display_IDToDelete;

    var request = new XMLHttpRequest();
    request.open("POST", "http://localhost:8081/webp/DeleteProgram");
    request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    request.send(parameters);
    window.location.reload(false);
}