package ik.ikman.oop;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello janith.....");

        Student student= new Student();
        student.id=12;
        student.name="janith";
        student.address="colombo";

        System.out.println(student.id);
        System.out.println(student.name);
        System.out.println(student.address);

        student.study();
        student.takeExam();
    }
}