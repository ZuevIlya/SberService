package sberServlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MainServlet extends HttpServlet {
    // constructor() -> init() -> service() -> destroy()

    // Вызывается один раз и выполняется конфигурация servlet
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); // Инициализация config в родительском servlet
    }

    // Обработка всех входящих запросов (вызывается при каждом запросе)
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    // Работа get методов
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    }

    // Работа post методов
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestData = req.getReader().lines().collect(Collectors.joining()); // Чтение данных через поток
        Gson gson = new Gson(); // Создание GSON объекта
        GsonForm gsonForm = gson.fromJson(requestData, GsonForm.class); // Создание GSON формы для работы с текстом
        if (!Objects.equals(gsonForm.getText(), "")) { // Проверка на пустой текст
            gsonForm.setCorrect(gsonForm.getText()); // Проверка текста на скобки
            gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create(); // Создание GSON без текста
            resp.setContentType("application/json"); // Создание ответ в формате application/json
            resp.setCharacterEncoding("UTF-8"); // Установка метода кодирования UTF-8
            String json = gson.toJson(gsonForm); // Преобразование GSON в JSON
            resp.getWriter().write(json); // Отправка JSON
        } else {;
            resp.getWriter().write("null text");
        }
    }

    // Вызывается один раз перед штатным завершением работы servlet
    @Override
    public void destroy() {
    }

}
