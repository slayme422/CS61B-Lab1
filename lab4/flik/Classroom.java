package flik;

import java.util.Iterator;

//不变: 要添加一个新的地方永远都是size位置
public class Classroom implements Iterable<Classroom.Student> {
    Student[] classroom;
    int size;

    public Classroom() {
        classroom = new Student[50];
        size = 0;
    }

    public Iterator<Classroom.Student> iterator() {
        return new ClassroomIterator();
    }

    public int size() {
        return size;
    }

    public void addStudent(Student s) {
        if (size == classroom.length) {
            return;
        }
        classroom[size] = s;
        size = size + 1;
    }

    class Student {
        String name;
        int age;

        public Student(String n, int a) {
            this.name = n;
            this.age = a;
        }
    }

    private class ClassroomIterator implements Iterator<Student> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < classroom.length;
        }

        @Override
        public Student next() {
            Student returnStuff = classroom[current];
            current = current + 1;
            return returnStuff;
        }
    }


    public static void main(String[] args) {
        Classroom c = new Classroom();

        Classroom.Student kensho = c.new Student("Kensho", 19);
        for (int i = 0; i < 50; i++) {
            c.addStudent(kensho);
        }
        System.out.println(c.size);

        for (Student student : c) {
            System.out.println(student.name);
        }
    }
}

