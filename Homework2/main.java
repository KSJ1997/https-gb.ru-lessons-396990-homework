package Homework2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.*;

public class Student {
    private String name;
    private int age;
    private double GPA;

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + GPA);
    }

    public static void main(String[] args) {
        // Создаем объект класса Student и инициализируем его данными
        Student student = new Student("John Doe", 20, 3.5);

        // Сериализация объекта в XML файл
        serializeToXML(student, "student.xml");

        // Десериализация объекта из XML файла
        Student deserializedStudentFromXML = deserializeFromXML("student.xml");

        // Выводим все поля объекта после десериализации из XML
        if (deserializedStudentFromXML != null) {
            deserializedStudentFromXML.printDetails();
        }

        // Сериализация объекта в JSON файл
        serializeToJSON(student, "student.json");

        // Десериализация объекта из JSON файла
        Student deserializedStudentFromJSON = deserializeFromJSON("student.json");

        // Выводим все поля объекта после десериализации из JSON
        if (deserializedStudentFromJSON != null) {
            deserializedStudentFromJSON.printDetails();
        }
    }

    // Метод для сериализации объекта в XML файл
    private static void serializeToXML(Student student, String fileName) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(fileName), student);
            System.out.println("Serialization to XML completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для десериализации объекта из XML файла
    private static Student deserializeFromXML(String fileName) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.readValue(new File(fileName), Student.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Метод для сериализации объекта в JSON файл
    private static void serializeToJSON(Student student, String fileName) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(fileName), student);
            System.out.println("Serialization to JSON completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для десериализации объекта из JSON файла
    private static Student deserializeFromJSON(String fileName) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(fileName), Student.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
