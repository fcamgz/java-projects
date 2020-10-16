package com.example.idea;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Management {
    private String name;
    final int NUMBEROFCLASSES = 5;
    public int numOfStudents, numOfTeachers;
    private Student[] studentList;
    private Teacher[] teacherList;



    public Management(String name, int studentCapacity, int teacherCapacity){
        this.name = name;
        numOfStudents = 0;
        numOfTeachers = 0;
        studentList = new Student[studentCapacity];
        teacherList = new Teacher[teacherCapacity];
    }


    public boolean studentPayment(Student student, double balance){
        if (balance > 0) {
            student.setBalance(student.getBalance() + balance);
            return true;
        }
        return false;
    }

    public void addStudent(int studentGrade, String name, int age, int studentID, boolean paidTuition, double balance, int credit, boolean currentlyEnrolled,double gpa){
            Student student = new Student(studentGrade, name, age, studentID, paidTuition, balance, credit, currentlyEnrolled,gpa);
            student.setNumberOfClasses(NUMBEROFCLASSES);
            student.studentClasses = new String[student.getNumberOfClasses()];
            studentList[numOfStudents] = student;
            numOfStudents++;
            System.out.println("Student: " + student.getName() + " is successfully added to system");
    }

    public Student getStudentById(int id){
        for(Student i : studentList){
            if(i.getStudentID() == id){
                return i;
            }
        }
        return null;
    }

    public Teacher getTeacherById(int id){
        for(Teacher i : teacherList){
            if(i.getTeacherId() == id){
                return i;
            }
        }
        return null;
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


    public void addTeacher(String name, String profession, int id){
        Teacher teacher = new Teacher(name,profession,id);
        teacherList[numOfTeachers] = teacher;
        System.out.println("Teacher: " + teacher.getName() + " with id: " + teacher.getTeacherId() + " profession of " + teacher.getProfession() + " is successfully added to system");
        numOfTeachers++;
    }

    public void removeTeacher(int id){
        getTeacherById(id).setProfession("former");
        numOfTeachers--;
    }

    public void advanceStudentForNextYear(int id){
        if(getStudentById(id).getGpa() > 2 && getStudentById(id).getBalance() >= 1000){
            getStudentById(id).setStudentGrade(getStudentById(id).getStudentGrade() + 1);
            getStudentById(id).setAdvanceToNextYear(true);
            getStudentById(id).setBalance(getStudentById(id).getBalance() - 1000);
        }
        else if(getStudentById(id).getGpa() > 2 && getStudentById(id).getBalance() < 1000){
            System.out.println("Sorry you student " + getStudentById(id).getName() + " with GPA: " +getStudentById(id).getGpa() + " can not advance to next year");
            getStudentById(id).setAdvanceToNextYear(false);
        }
        else if (getStudentById(id).getGpa() < 2 && getStudentById(id).getBalance() >= 1000){
            System.out.println("Sorry you student " + getStudentById(id).getName() + " has enough balance " +getStudentById(id).getBalance() + " but gpa is too low GPA: "+ getStudentById(id).getGpa());
            getStudentById(id).setAdvanceToNextYear(false);
        }
        else {
            System.out.println("Student " + getStudentById(id).getName() + " doesn't have enough gpa nor enough balance");
            getStudentById(id).setAdvanceToNextYear(false);
        }
    }


    public void gradeStudent(int studentId, int teacherId, int midterm, int finalterm, int credit){
        int pointsResult = ((midterm + finalterm) / 2) / credit;
        getStudentById(studentId).studentCoursesList.put(getTeacherById(teacherId).getProfession(),pointsResult);
    }


    public void calculateStudentGpa(int studentId){
        double result = 0;
        for(Integer  i : getStudentById(studentId).studentCoursesList.values()){
            result += i;
        }
        getStudentById(studentId).setGpa(result);
    }

    public void passOrNoPass(int studentId, int teacherId){
        int grade = getStudentById(studentId).studentCoursesList.get(getTeacherById(teacherId).getProfession());
        if(grade >= 50){
            getStudentById(studentId).setAdvanceToNextYear(true);
            System.out.println("You can advance to next year on " + getTeacherById(teacherId).getProfession());
        }else {
            getStudentById(studentId).setAdvanceToNextYear(false);
            System.out.println("You can not advance to next year on " + getTeacherById(teacherId).getProfession());

        }
    }

    public void showHonourStudent(int id){
        if(getStudentById(id).getGpa() >= 3.5){
            System.out.println("You recognized as a honour student your gpa is " + getStudentById(id).getGpa());
        }
        else if(getStudentById(id).getGpa() >= 3){
            System.out.println("You recognized as a successful student your gpa is " + getStudentById(id).getGpa());
        }
        else {
            System.out.println("You are not in the honour list your gpa is needs to be 3 or higher GPA: " + getStudentById(id).getGpa());
        }
    }
    public int showNumberOfStudents(){
        return numOfStudents;
    }
    public int showNumberOfTeachers(){
        return numOfTeachers;
    }
}
