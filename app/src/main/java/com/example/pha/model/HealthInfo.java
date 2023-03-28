package com.example.pha.model;

public class HealthInfo {
    int age, height_in, height_ft, weight;
    String bp, sgr, vac;
    String blood;

    //constructor
    public HealthInfo(int age, int height_in, int height_ft, int weight, String bp, String sgr, String vac, String blood) {
        this.age = age;
        this.height_in = height_in;
        this.height_ft = height_ft;
        this.weight = weight;
        this.bp = bp;
        this.sgr = sgr;
        this.vac = vac;
        this.blood = blood;
    }


    //getter
    public int getAge() {
        return age;
    }

    public int getHeight_in() {
        return height_in;
    }

    public int getHeight_ft() {
        return height_ft;
    }

    public int getWeight() {
        return weight;
    }

    public String getBp() {
        return bp;
    }

    public String getSgr() {
        return sgr;
    }

    public String getVac() {
        return vac;
    }

    public String getBlood() {
        return blood;
    }


    //setter
    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight_in(int height_in) {
        this.height_in = height_in;
    }

    public void setHeight_ft(int height_ft) {
        this.height_ft = height_ft;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public void setSgr(String sgr) {
        this.sgr = sgr;
    }

    public void setVac(String vac) {
        this.vac = vac;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }
}
