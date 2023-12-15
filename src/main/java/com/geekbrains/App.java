package com.geekbrains;

import java.io.*;

public class App {
    public static void main(String[] args) {
        Student student = new Student("Иванов", 20, 3.5);

        // Сериализация объекта
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            out.writeObject(student);
            System.out.println("Объект сериализован и записан в файл student.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десериализация объекта
        Student deserializedStudent = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.ser"))) {
            deserializedStudent = (Student) in.readObject();
            System.out.println("Объект успешно десериализован из файла");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Вывод информации о десериализованном объекте
        if (deserializedStudent != null) {
            deserializedStudent.printInfo();
        } else {
            System.out.println("Не удалось десериализовать объект");
        }
    }
}
