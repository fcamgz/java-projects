package com.example.idea;

public class Main {

    public static void main(String[] args) {
	    Student fatih = new Student(1,"fatih",22,1234);
	    Teacher maziar = new Teacher("Maziar", "JavaScript");
	    Management management = new Management("gbc");
	    management.addStudent(fatih);
		System.out.println(fatih.getInfo());
		System.out.println(fatih.studentClasses);

	    maziar.gradeStudent(fatih,maziar,80,90,2);
	    maziar.passOrNoPass(fatih,maziar);
	    maziar.getInfo();
    }
}
