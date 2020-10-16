package com.example.idea;

public class Main {

    public static void main(String[] args) {
		Management management = new Management("gbc",100,20);
		management.addStudent(1,"fatih",23,1234,true,1000,0,true,0);
		management.addStudent(1,"simon",25,4567,true,1000,0,true,0);
		management.addStudent(2,"alex",28,6789,true,1000,0,true,0);
		management.addTeacher("maziar","javascript",12);
		management.addTeacher("mak","html",11);
		management.addTeacher("andrew","c#",10);
		management.addTeacher("anjana","java",13);
		management.addTeacher("abid","database",14);
		management.gradeStudent(1234,12,50,50,3);
		management.gradeStudent(1234,11,60,70,3);
		management.gradeStudent(1234,10,60,70,3);
		management.gradeStudent(1234,13,60,70,3);
		management.gradeStudent(1234,14,60,70,3);
		management.calculateStudentGpa(1234);
		System.out.println(management.getStudentById(1234).getInfo());

    }
}
