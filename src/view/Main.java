package view;

import controller.StudentController;
import model.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Nhap vao thong tin của student");
        Scanner scanner = new Scanner(System.in);
        System.out.println("ID");
        int id = scanner.nextInt();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("name");
        String name = scanner1.nextLine();
        System.out.println("age");
        int age = scanner1.nextInt();
        System.out.println("email");
        String email = scanner1.nextLine();

        Student student = new Student(id, name, age, email);
        StudentController.add(student);
    }
}