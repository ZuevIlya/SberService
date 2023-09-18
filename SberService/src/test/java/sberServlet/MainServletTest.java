package sberServlet;

import static org.junit.Assert.*;

public class MainServletTest {

    @org.junit.Test
    public void isCorrectFunction_true() {
        GsonForm gsonForm = new GsonForm();
        String string = "Вчера я отправился в поход в лес (это мое любимое место для отдыха) вместе с друзьями. " +
                "Мы выбрали маршрут, который проходил через горные потоки и поля (для разнообразия). " +
                "В начале пути погода была отличной, солнце светило ярко, и птицы радостно пели. " +
                "Однако, когда мы подошли ближе к вершине горы, небо стало покрываться облаками, " +
                "(как будто природа готовила нам небольшой сюрприз). Несмотря на это, виды были захватывающими, " +
                "особенно когда мы достигли высшей точки и увидели прекрасный вид на долину " +
                "(я почувствовал, что все усилия стоили того).";
        gsonForm.setText(string);
        gsonForm.setCorrect(gsonForm.getText());
        boolean result = true;
        assertEquals(gsonForm.isCorrect(), result);
    }

    @org.junit.Test
    public void isCorrectFunction_false() {
        GsonForm gsonForm = new GsonForm();
        String string = "([{Вчера я отправился в поход в лес (это мое любимое место для отдыха) вместе с друзьями. " +
                "Мы выбрали маршрут, который проходил через горные потоки и поля (для разнообразия). " +
                "В начале пути погода была отличной, солнце светило ярко, и птицы радостно пели. " +
                "Однако, когда мы подошли ближе к вершине горы, небо стало покрываться облаками, " +
                "(как будто природа готовила нам небольшой сюрприз). Несмотря на это, виды были захватывающими, " +
                "особенно когда мы достигли высшей точки и увидели прекрасный вид на долину " +
                "(я почувствовал, что все усилия стоили того).";
        gsonForm.setText(string);
        gsonForm.setCorrect(gsonForm.getText());
        boolean result = false;
        assertEquals(gsonForm.isCorrect(), result);
    }

    @org.junit.Test
    public void isCorrectFunction_without_text() {
        GsonForm gsonForm = new GsonForm();
        String string = "()[]{}";
        gsonForm.setText(string);
        gsonForm.setCorrect(gsonForm.getText());
        boolean result = false;
        assertEquals(gsonForm.isCorrect(), result);
    }
}