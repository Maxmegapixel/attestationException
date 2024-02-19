package view;

import java.util.Scanner;

public class View {
    private final Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public String getUserInput() {
        System.out.println("Введите данные в следующем порядке через пробел: Фамилия Имя Отчество дата_рождения(в формате dd.MM.yyyy) номер_телефона пол(f/m)");
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
