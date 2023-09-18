package sberServlet;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Stack;

public class GsonForm {
    @SerializedName("text")
    private String text;

    @SerializedName("isCorrect")
    @Expose
    private boolean isCorrect;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(String string) {
        isCorrect = isCorrectFunction(string);
    }

    // Функция проверки текста на корректность
    public static boolean isCorrectFunction(String string) {
        Stack<Character> stack = new Stack<>();
        boolean text = false; // Наличие букв
        for (char c: string.toCharArray()) {
            if (Character.isLetter(c)) {
                text = true; // Если встретили букву - это текст
            }
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c); // Открывающиеся скобки добавляем в стек
                    break;
                case ')':
                    if ((!stack.empty()) && (stack.lastElement() == '(')) { // Если стек не пустой и закрывающаяся скобка совпадает с верхней скобкой в стеке - то они уничтожаются
                        stack.pop();
                        break;
                    } else return false;
                case ']':
                    if ((!stack.empty()) && (stack.lastElement() == '[')) {
                        stack.pop();
                        break;
                    } else return false;
                case '}':
                    if ((!stack.empty()) && (stack.lastElement() == '{')) {
                        stack.pop();
                        break;
                    } else return false;
            }
        }
        return stack.empty() && text; // Если стек остался пустой и в тексте присутствуют буквы - то текст правильный
    }
}
