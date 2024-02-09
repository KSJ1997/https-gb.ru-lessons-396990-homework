package Homework1;

public class Main {
    public static void main(String[] args) {
        // Создаем объект Student и инициализируем его данными
        Student student = new Student("Иван Петров", 20, 0.0);

        // Сериализуем объект в файл
        SerializationUtil.serializeObject(student, "student.ser");

        // Десериализуем объект из файла
        Student deserializedStudent = (Student) SerializationUtil.deserializeObject("student.ser");

        // Выводим детали объекта после десериализации
        if (deserializedStudent != null) {
            deserializedStudent.printDetails();
        }
    }
}
