package com.belajar;

    public class Employee extends Manusia {
        float salary = 4000f;
        String name = "Ridho";
        int age = 17;
        
        public void showInfo(){
            System.out.println("Name: " + super.name);
            System.out.println("Age: " + super.age);
            System.out.println("Salary: $" + salary);
 }
       
    }

