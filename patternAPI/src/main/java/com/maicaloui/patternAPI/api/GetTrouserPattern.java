package com.maicaloui.patternAPI.api;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.maicaloui.patternAPI.api.model.TrouserPattern;

public class GetTrouserPattern {
    public static TrouserPattern trouserPatternResult(double trouserLength, double inseamLength, double hip,
            double waist, double kneeCircumference, double heelAnkleCircumference, double waistWidth,
            double quadWidth, double calvesWidth, double crotchLength, String trouserType) {

        TrouserPattern trouserpattern = new TrouserPattern();

        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.HALF_UP);

        double hipHeight = Double.parseDouble(df.format((hip / 20) + 3));
        double kneeHeight = Double.parseDouble(df.format((inseamLength / 2) - (inseamLength / 10)));
        double WidthOfLegInfront = Double.parseDouble(df.format((hip / 4) - 1));
        double WidthOfLegBack = Double.parseDouble(df.format((hip / 4) + 1));
        double DiameterOfHip = Double.parseDouble(df.format((hip / 8) + 4));

        if ("stretch".equals(trouserType)) {
            double eigthToTen = Double.parseDouble(df.format(DiameterOfHip / 3));
            double fifteenToEighteen = Double.parseDouble(df.format((DiameterOfHip / 3) * 2));
            double middleOfFourToEleven = Double.parseDouble(df.format((WidthOfLegInfront + eigthToTen) / 2));
            double middleOfFourToNineteen = Double.parseDouble(df.format((WidthOfLegBack + fifteenToEighteen) / 2));

            trouserpattern.setTwoToSeven(WidthOfLegInfront);
            trouserpattern.setTwoToFourteen(WidthOfLegBack);
            trouserpattern.setEightToTen(eigthToTen);
            trouserpattern.setFifteenToEighteen(fifteenToEighteen);
            trouserpattern.setTwentyTwo(middleOfFourToEleven);
            trouserpattern.setTwentyFour(middleOfFourToNineteen);

        } else if ("plain".equals(trouserType)) {
            double WidthOfLegInfrontPlus = Double.parseDouble(df.format((WidthOfLegInfront + 0.5)));
            double WidthOfLegBackPlus = Double.parseDouble(df.format((WidthOfLegBack + 0.5)));
            double DiameterOfHipPlus = Double.parseDouble(df.format((DiameterOfHip + 2)));

            double eigthToTen = Double.parseDouble(df.format(DiameterOfHipPlus / 3));
            double fifteenToEighteen = Double.parseDouble(df.format((DiameterOfHipPlus / 3) * 2));
            double middleOfFourToEleven = Double.parseDouble(df.format((WidthOfLegInfrontPlus + eigthToTen) / 2));
            double middleOfFourToNineteen = Double.parseDouble(df.format((WidthOfLegBackPlus + fifteenToEighteen) / 2));

            trouserpattern.setTwoToSeven(WidthOfLegInfrontPlus);
            trouserpattern.setTwoToFourteen(WidthOfLegBackPlus);
            trouserpattern.setEightToTen(eigthToTen);
            trouserpattern.setFifteenToEighteen(fifteenToEighteen);
            trouserpattern.setTwentyTwo(middleOfFourToEleven);
            trouserpattern.setTwentyFour(middleOfFourToNineteen);

        } else if (trouserType == "normal") {

        } else {

        }

        trouserpattern.setOneToFive(trouserLength);
        trouserpattern.setFiveToThree(inseamLength);
        trouserpattern.setThreeToFour(kneeHeight);
        trouserpattern.setThreeToTwo(hipHeight);

        trouserpattern.setEightToNine(1);
        trouserpattern.setFifteenToSixteen(2);
        trouserpattern.setEighteenToSeventeen(1);

        return trouserpattern;
    }
}
