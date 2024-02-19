package controller;

import model.InvalidGenderException;
import model.Person;
import view.View;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void processUserInput(String input) {
        String[] parts = input.split(" ");
        if (parts.length != 6) {
            view.displayMessage("Ошибка: неверное количество данных. Пожалуйста, введите данные в правильном формате.");
            return;
        }

        try {
            String lastName = parts[0];
            String firstName = parts[1];
            String middleName = parts[2];
            String birthDate = parts[3];
            long phoneNumber = Long.parseLong(parts[4]);
            char gender = parts[5].charAt(0);

            Person person = new Person(lastName, firstName, middleName, birthDate, phoneNumber, gender);

            String filename = lastName + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write(person.toString());
            writer.newLine();
            writer.close();

            view.displayMessage("Данные успешно записаны в файл " + filename);
        } catch (NumberFormatException e) {
            view.displayMessage("Ошибка: номер телефона должен быть целым числом.");
        } catch (ParseException e) {
            view.displayMessage("Ошибка: неверный формат даты рождения. Используйте формат dd.MM.yyyy.");
        } catch (InvalidGenderException e) {
            view.displayMessage(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        View view = new View();
        Controller controller = new Controller(view);

        String userInput = view.getUserInput();
        controller.processUserInput(userInput);
    }
}
