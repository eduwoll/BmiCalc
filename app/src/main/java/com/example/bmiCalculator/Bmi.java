package com.example.bmiCalculator;


public class Bmi {
    String name;
    Float weight, bmi;
    Integer height,category;

    public Bmi(String name, Float weight, Integer height){
        this.name = name;
        this.weight = weight;
        this.height = height;
        bmiCalc();
    }

    public String getName() {
        return name;
    }

    public Float getWeight() {
        return weight;
    }

    public Integer getHeight() {
        return height;
    }

    public Float getBmi() {
        return bmi;
    }

    public Integer getCategory() {
        return category;
    }

    private void bmiCalc(){
        Float hMeters = (float) this.height / 100;

        bmi = weight / (hMeters * hMeters);

        if(bmi < 18.5)
            category = 1;
        else if (bmi < 25)
            category = 2;
        else if (bmi < 30)
            category = 3;
        else if (bmi < 35)
            category = 4;
        else if (bmi < 40)
            category = 5;
        else
            category = 6;
    }
}
