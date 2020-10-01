package com.example.idea;

import java.util.LinkedHashMap;

public class Teacher {
    private String name, profession;

    public Teacher(String name, String profession){
        this.name = name;
        this.profession = profession;
    }

    public String getName(){
        return name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void gradeStudent(Student student, Teacher teacher, int midterm, int finalterm, int credit){
            int pointsResult = (midterm + finalterm) / 2;
            student.courses.put(teacher.getProfession(),pointsResult);
    }

    public void passOrNoPass(Student student, Teacher teacher){
        int grade = student.courses.get(teacher.getProfession());
        if(grade >= 50){
            student.setAdvanceToNextYear(true);
            System.out.println("You can advance to next year on " + teacher.getProfession());
        }else {
            student.setAdvanceToNextYear(false);
            System.out.println("You can not advance to next year on " + teacher.getProfession());

        }
    }
    public String getInfo(Teacher teacher){
        String s = "";
        if(teacher.getProfession() != "unemployed") {
            s = "Teacher: " + teacher.getName() + " is " + teacher.getProfession() + " teacher";
            return s;
        }
        s = "Teacher " + teacher.getName() + " is no longer working in our school";
        return s;
     }
}
