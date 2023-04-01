package com.example.pha.model;

public class HealthInfo {
    int  height_in, height_ft, weight;
    String dob,blood,bp, sgr, vac, gender;

    public int getHeight_in() {
        return height_in;
    }

    public void setHeight_in(int height_in) {
        this.height_in = height_in;
    }

    public int getHeight_ft() {
        return height_ft;
    }

    public void setHeight_ft(int height_ft) {
        this.height_ft = height_ft;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getSgr() {
        return sgr;
    }

    public void setSgr(String sgr) {
        this.sgr = sgr;
    }

    public String getVac() {
        return vac;
    }

    public void setVac(String vac) {
        this.vac = vac;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
