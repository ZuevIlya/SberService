# SberService
SberService for Sber Tournament 31.08.2023-14.09.2023
## Документация API: https://documenter.getpostman.com/view/20945270/2s9YC7Trw2
Сервис написан на Java (сборка Maven)
Протокол передачи сообщений - HTTP
Основная цель проекта - сервис, принимающий post запросы с текстом и отправляющий ответ с корректностью текста
Текст корректный, если соблюдаются текущие правила:
- В тексте присутствуют буквы
- Если в тексте присутствуют скобки, то они должны правильно попарно открываться и закрываться
На сервис отправяется запрос с телом JSON, который хранит поле текст. Далее запускается функция проверки и текста и сервис отправляет POST запрос в ответ, в котором указана корректность данного текста.

Класс MainServlet.java - это сервлет для принятия и отправки запросов
Класс GsonForm.java - это парсер GSON формата. Так же он хранит метод для проверки текста на корректность
Класс MainServletTest.java - класс для тестирования функции проверки текста на корректность

Все зависимости, требующиеся для запуска проекта, хранятся в файле pom.xml:
- javax.servlet - позволяется запустить свой servlet
 ```
<dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>4.0.1</version>
    </dependency>
```

- javax.json и org.glassfish - позволяет работать с форматом JSON
```
<dependency>
      <groupId>javax.json</groupId>
      <artifactId>javax.json-api</artifactId>
      <version>1.1.2</version>
    </dependency>
    <dependency>
      <groupId>org.glassfish</groupId>
      <artifactId>javax.json</artifactId>
      <version>1.1.2</version>
    </dependency>
```

- com.google.code.gson - позволяет работать с форматом GSON
```
<dependency>
      <groupId>com.google.code.gson</groupId>
      <artifactId>gson</artifactId>
      <version>2.10.1</version>
    </dependency>
```

- junit - тестирование проекта
```
<dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>RELEASE</version>
      <scope>test</scope>
    </dependency>
```

Для запуска проекта нажимаем Maven -> Plugins -> jetty -> jetty:run
