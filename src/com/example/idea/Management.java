package com.example.idea;

import java.lang.reflect.Array;

public class Management {
    private String name;
    private int numOfStudents, numOfTeachers;
    private Student[] studentList;
    private Teacher[] teacherList;

    public Management(String name){
        this.name = name;
        numOfStudents = 0;
        numOfTeachers = 0;
        studentList = new Student[numOfStudents];
        teacherList = new Teacher[numOfTeachers];
    }


    public boolean studentPayment(Student student, double balance){
        if (balance > 0) {
            student.setBalance(student.getBalance() + balance);
            return true;
        }
        return false;
    }

    public void addStudent(int studentGrade, String name, int age, int studentID){
            Student student = new Student(studentGrade,name, age, studentID);
            student.setPaid(true);
            student.setBalance(1000);
            student.setCredit(0);
            student.setCurrentlyEnrolled(true);
            studentList[numOfStudents] = student;
            numOfStudents++;
        System.out.println("Student: " + student.getName() + " is successfully added to system");
    }

    public void removeStudent(Student student){
        student.setGpa(0);
        student.setCredit(0);
        student.setAdvanceToNextYear(false);
        student.setCurrentlyEnrolled(false);
        student.setPaid(false);
        numOfStudents--;
        System.out.println("Student " + student + " is removed");
    }

    public void addTeacher(String name, String profession){
        Teacher teacher = new Teacher(name,profession);
        teacherList[numOfTeachers] = teacher;
        numOfTeachers++;
    }

    public void removeTeacher(Teacher teacher){
        teacher.setProfession("unemployed");
        numOfTeachers--;
    }

    public void advanceStudentForNextYear(Student student){
        if(student.getGpa() > 2 && student.getBalance() > 1000){
            student.setStudentGrade(student.getStudentGrade() + 1);
            student.setAdvanceToNextYear(true);
            student.setBalance(student.getBalance() - 1000);
        }
        else if(student.getGpa() > 2 && student.getBalance() < 1000){
            System.out.println("Sorry you student " + student + " with GPA: " +student.getGpa() + " can not advance to next year");
            student.setAdvanceToNextYear(false);
        }
        else if (student.getGpa() < 2 && student.getBalance() > 1000){
            System.out.println("Sorry you student " + student + " has enough balance " +student.getBalance() + " but gpa is too low GPA: "+ student.getGpa());
            student.setAdvanceToNextYear(false);
        }
        else {
            System.out.println("Student " + student.getName() + " doesn't have enough gpa nor enough balance");
            student.setAdvanceToNextYear(false);
        }
    }

    public void setStudentGpa(Student student){
        double result = student.courses.get(student) / student.getCredit();
        student.setGpa(result);
    }

    public void showHonourStudent(Student student){
        if(student.getGpa() >= 3.5){
            System.out.println("You recognized as a honour student your gpa is " + student.getGpa());
        }
        else if(student.getGpa() >= 3){
            System.out.println("You recognized as a successful student your gpa is " + student.getGpa());
        }
        else {
            System.out.println("You are not in the honour list your gpa is needs to be 3 or higher GPA: " + student.getGpa());
        }
    }
    public int showNumberOfStudents(){
        return numOfStudents;
    }
    public int showNumberOfTeachers(){
        return numOfTeachers;
    }
}
