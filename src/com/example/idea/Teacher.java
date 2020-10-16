package com.example.idea;

import java.util.LinkedHashMap;

public class Teacher {
    private String name, profession;
    private int id;

    public Teacher(String name, String profession, int id){
        this.name = name;
        this.profession = profession;
        this.id = id;
    }

    public int getTeacherId(){
        return id;
    }
    public void setTeacherId(int id){
        this.id = id;
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



    public String getInfo(){
        String s = "";
        if(profession != "former") {
            s = "Teacher: " + name + " is " + profession + " teacher";
            return s;
        }
        s = "Teacher " + name + " is no longer working in our school";
        return s;
     }
}
