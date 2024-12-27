package controller;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private static List<Student> students = new ArrayList<>();

    public static List<Student> getStudents(){
        try {
            List<Student> students = readFile();
        return students;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void add(Student student){
        students.add(student);

        try {
            writeFile(students);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void writeFile(List<Student> students) throws IOException {
        File file = new File("students.txt");
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(students);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            fileOutputStream.close();
            objectOutputStream.close();
        }
    }

    public static List<Student> readFile() throws IOException {
        File file = new File("students.txt");

        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        List<Student> studentss = new ArrayList<>();

        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
            try {
                studentss = (List<Student>) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            fileInputStream.close();
            objectInputStream.close();
        }


        return studentss;
    }

}
