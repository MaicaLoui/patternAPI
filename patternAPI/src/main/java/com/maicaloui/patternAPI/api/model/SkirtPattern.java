package com.maicaloui.patternAPI.api.model;

public class SkirtPattern {

    private Long id;

    private double oneToFour;
    private double threeToSix;
    private double oneToSeven;
    private double threeToNine;
    private double oneToThree;
    private double oneToTwo;
    private double fourToFive;

    private double sevenToTen;
    private double sevenToTwelve;
    private double thirdteenToFourteen;
    private double frontDart;
    private double frontDartLength;
    private double backDart;
    private double amountOfBackDart;

    public double getFrontDartLength() {
        return frontDartLength;
    }

    public void setFrontDartLength(double frontDartLength) {
        this.frontDartLength = frontDartLength;
    }

    public double getAmountOfBackDart() {
        return amountOfBackDart;
    }

    public void setAmountOfBackDart(double amountOfBackDart) {
        this.amountOfBackDart = amountOfBackDart;
    }

    public double getBackDart() {
        return backDart;
    }

    public void setBackDart(double backDart) {
        this.backDart = backDart;
    }

    public double getFrontDart() {
        return frontDart;
    }

    public void setFrontDart(double frontDart) {
        this.frontDart = frontDart;
    }

    public double getThirdteenToFourteen() {
        return thirdteenToFourteen;
    }

    public void setThirdteenToFourteen(double thirdteenToFourteen) {
        this.thirdteenToFourteen = thirdteenToFourteen;
    }

    public double getSevenToTwelve() {
        return sevenToTwelve;
    }

    public void setSevenToTwelve(double sevenToTwelve) {
        this.sevenToTwelve = sevenToTwelve;
    }

    public double getSevenToTen() {
        return sevenToTen;
    }

    public void setSevenToTen(double sevenToTen) {
        this.sevenToTen = sevenToTen;
    }

    public double getFourToFive() {
        return fourToFive;
    }

    public void setFourToFive(double fourToFive) {
        this.fourToFive = fourToFive;
    }

    public double getOneToTwo() {
        return oneToTwo;
    }

    public void setOneToTwo(double oneToTwo) {
        this.oneToTwo = oneToTwo;
    }

    public double getOneToThree() {
        return oneToThree;
    }

    public void setOneToThree(double oneToThree) {
        this.oneToThree = oneToThree;
    }

    public double getThreeToNine() {
        return threeToNine;
    }

    public void setThreeToNine(double threeToNine) {
        this.threeToNine = threeToNine;
    }

    public double getOneToSeven() {
        return oneToSeven;
    }

    public void setOneToSeven(double oneToSeven) {
        this.oneToSeven = oneToSeven;
    }

    public double getThreeToSix() {
        return threeToSix;
    }

    public void setThreeToSix(double threeToSix) {
        this.threeToSix = threeToSix;
    }

    public SkirtPattern() {
    }

    public SkirtPattern(Long id, double oneToFour) {
        this.id = id;
        this.oneToFour = oneToFour;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getoneToFour() {
        return oneToFour;
    }

    public void setoneToFour(double oneToFour) {
        this.oneToFour = oneToFour;
    }

    // @Override
    // public String toString() {
    // return "Skirt [hip=" + hip + ", hip_height=" + hip_height + ", id=" + id + ",
    // skirt_length=" + skirt_length
    // + ", waist=" + waist + "]";
    // }
}
