package com.maicaloui.patternAPI.api;

import com.maicaloui.patternAPI.api.model.SkirtPattern;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class GetSkirtPattern {
    public static SkirtPattern skirtPatternResult(double hip, double waist, double hipHeight,
            double skirtLength) {

        SkirtPattern skirtPattern = new SkirtPattern();

        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.HALF_UP);

        double halfOfWaist = Double.parseDouble(df.format(waist * 0.5));
        double halfOfHip = Double.parseDouble(df.format(hip * 0.5));
        double quarterOfHip = Double.parseDouble(df.format(hip * 0.25));

        // A - B - C
        double A = Double.parseDouble(df.format(halfOfHip - halfOfWaist));
        Double B = Double.parseDouble(df.format(A / 2));
        Double C = Double.parseDouble(df.format(B / 2));

        // Value of 4-A = AA
        Double diff;
        Double newHalfOfHip;
        Double newQuarterOfHip;

        // If A is less than 8 ... make it 8
        if (A < 8) {
            // diff = 8.0 - A;
            // Double ndiff = diff*2;
            diff = hip - waist;
            // New Hip
            Double newHip = hip + diff;
            // Double NH= H + ndiff;

            // New Half / Quarter of Hip after updating H
            newHalfOfHip = Double.parseDouble(df.format(newHip * 0.5));
            newQuarterOfHip = Double.parseDouble(df.format(newHip * 0.25));

            Double newA = newHalfOfHip - halfOfWaist;
            B = newA / 2;
            C = B / 2;

            // HOH 1-4/ 3-6
            skirtPattern.setoneToFour(newHalfOfHip);
            skirtPattern.setThreeToSix(newHalfOfHip);

            // QOH 1-7 / 3-9
            skirtPattern.setOneToSeven(newQuarterOfHip);
            skirtPattern.setThreeToNine(newQuarterOfHip);

            // If A is MORE than 8 do...
        } else {
            // HOH 1-4/ 3-6
            skirtPattern.setoneToFour(halfOfHip);
            skirtPattern.setThreeToSix(halfOfHip);

            // QOH 1-7 / 3-9
            skirtPattern.setOneToSeven(quarterOfHip);
            skirtPattern.setThreeToNine(quarterOfHip);
        }

        // SL 1-3
        skirtPattern.setOneToThree(skirtLength);
        // HH 1-2
        skirtPattern.setOneToTwo(hipHeight);
        // HH 4-5
        skirtPattern.setFourToFive(hipHeight);

        Double frontDart = 0.0;
        if (B > 9) {
            // decB -> The decimal behind the 9
            String decB;
            BigDecimal bigDecimal = new BigDecimal(String.valueOf(B));
            int intValue = bigDecimal.intValue();
            decB = bigDecimal.subtract(new BigDecimal(intValue)).toPlainString();

            Double NB = B + Double.parseDouble(decB);
            Double NC = Double.parseDouble(df.format(NB / 2));

            Double zeiPatras = Double.parseDouble(df.format(NC - 0.5));
            Double zeiDilanti = Double.parseDouble(df.format(NC + 0.5));

            // backWaist
            skirtPattern.setSevenToTen(zeiPatras);
            // coordinates.put("sevenToTen", zeiPatras);

            // frontWaist
            skirtPattern.setSevenToTwelve(zeiDilanti);
            skirtPattern.setThirdteenToFourteen(8.0);

            // This is because B>=9
            skirtPattern.setFrontDart(3.0);
            frontDart = 3.0;
            // nachiDilanti.setText("E saya aki lo tin un nachi figura dilanti di 3 cm ");

        } else {

            if (B < 3) {
                skirtPattern.setFrontDart(0.0);
                frontDart = 0.0;
                // nachiDilanti.setText("E saya aki lo no mester di nachi dilanti");
            } else if (B >= 3.1 && B <= 3.9) {
                skirtPattern.setThirdteenToFourteen(8.0);
                skirtPattern.setFrontDart(1.5);
                frontDart = 1.5;
                skirtPattern.setFrontDartLength(8);
                // nachiDilanti.setText("E saya aki lo tin un nachi figura dilanti di 1.5 cm ");
            } else if (B >= 4 && B <= 8) {

                skirtPattern.setThirdteenToFourteen(8.0);
                skirtPattern.setFrontDart(2.0);
                frontDart = 2.0;
                skirtPattern.setFrontDartLength(8);
                // nachiDilanti.setText("E saya aki lo tin un nachi figura dilanti di 2 cm ");
            } else if (B >= 8.1 && B <= 8.9) {
                double decimalPart = B - Math.floor(B);
                double frontDartWidth = 2.0 + decimalPart;
                skirtPattern.setThirdteenToFourteen(8.0);
                skirtPattern.setFrontDart(frontDartWidth);
                frontDart = frontDartWidth;

                skirtPattern.setFrontDartLength(8);
                // nachiDilanti.setText("E saya aki lo tin un nachi figura dilanti di : " +2 +
                // doubleAsString.substring(indexOfDecimal) +" cm");
            } else if (B >= 9) {

                skirtPattern.setThirdteenToFourteen(8.0);
                skirtPattern.setFrontDart(3.0);
                frontDart = 3.0;
                skirtPattern.setFrontDartLength(8);
                // nachiDilanti.setText("E saya aki lo tin un nachi figura dilanti di 3 cm ");
            }

        }

        double backDart = B - frontDart;
        // double backDart = Double.parseDouble(df.format(B-nachiBPatras()));
        if (backDart < 3) {
            double zei710Result = Double.parseDouble(df.format(C - 0.5));
            double zei110 = Double.parseDouble(df.format(quarterOfHip - zei710Result));
            double nachiP2 = Double.parseDouble(df.format(zei110 / 2));
            // BigDecimal bd = new BigDecimal(nachiP2);

            // E saya aki lo tin 1 nachi di figura patras (15), profundidad di 15 = 13 cm
            skirtPattern.setBackDart(nachiP2);
            skirtPattern.setAmountOfBackDart(1);

        } else if (backDart > 3) {

            double zei710Result = Double.parseDouble(df.format(C - 0.5));
            double zei110 = Double.parseDouble(df.format(quarterOfHip - zei710Result));
            double nachiP2 = Double.parseDouble(df.format(zei110 / 3));
            // BigDecimal bd = new BigDecimal(nachiP2);

            // E saya aki lo tin 2 nachi di figura patras (15 & 16), profundidad di 15 = 12
            // cm i di 16 = 14 cm

            skirtPattern.setBackDart(nachiP2);
            skirtPattern.setAmountOfBackDart(2);

        }

        Double zeiPatras = Double.parseDouble(df.format(C - 0.5));
        skirtPattern.setSevenToTen(zeiPatras);
        Double zeiDilanti = Double.parseDouble(df.format(C + 0.5));
        skirtPattern.setSevenToTwelve(zeiDilanti);
        return skirtPattern;
    }

    public static SkirtPattern skirtPatternWaistResult(double hip, double waist, double hipHeight,
            double skirtLength) {
        SkirtPattern skirtPattern = new SkirtPattern();
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.HALF_UP);

        // Half of Waist(HOW)
        Double HOW = Double.parseDouble(df.format(waist * 0.5));

        // Half / Quarter of Hip (HOH/QOH)
        Double HOH = Double.parseDouble(df.format(hip * 0.5));
        Double QOH = Double.parseDouble(df.format(hip * 0.25));

        // A - B - C
        Double A = Double.parseDouble(df.format(HOH - HOW));
        Double B = Double.parseDouble(df.format(A / 2));
        Double C = Double.parseDouble(df.format(B / 2));

        // Value of 4-A = AA
        Double diff;
        Double NHOH;
        Double rdiff;

        if (A < 8) {
            // diff = 8.0 - A;
            // Double ndiff = diff*2;
            diff = hip - waist;
            rdiff = 8 - diff;

            // New Hip
            Double NH = hip + rdiff;
            // Double NH= H + ndiff;

            // New Half / Quarter of Hip after updating H
            NHOH = Double.parseDouble(df.format(NH * 0.5));
            // NQOH=Double.parseDouble(df.format(NH*0.25));

            Double newA = NHOH - HOW;
            B = newA / 2;
            C = B / 2;
            // coordinates.put("fourToFive", newA);
            // tv14_36.setText( NHOH + " cm"); //HOH 1-4/ 3-6
            // tv17.setText( NQOH + " cm"); //QOH 1-7 / 3-9

            // If A is MORE than 8 do...
        } else {

            // tv14_36.setText( HOH + " cm"); //HOH 1-4/ 3-6
            // tv17.setText( QOH + " cm"); //QOH 1-7 / 3-9
            // coordinates.put("fourToFive", A);
        }

        if (B > 9) {
            // decB -> The decimal behind the 9
            String decB;
            BigDecimal bigDecimal = new BigDecimal(String.valueOf(B));
            int intValue = bigDecimal.intValue();
            decB = bigDecimal.subtract(new BigDecimal(intValue)).toPlainString();

            Double NB = B + Double.parseDouble(decB);
            Double NC = Double.parseDouble(df.format(NB / 2));

            Double zeiPatras = Double.parseDouble(df.format(NC - 0.5));
            Double zeiDilanti = Double.parseDouble(df.format(NC + 0.5));

            // backWaist
            skirtPattern.setSevenToTen(zeiPatras);
            // coordinates.put("sevenToTen", zeiPatras);

            // frontWaist
            skirtPattern.setSevenToTwelve(zeiDilanti);
            skirtPattern.setThirdteenToFourteen(8.0);

            // This is because B>=9
            skirtPattern.setFrontDart(3.0);

            // nachiDilanti.setText("E saya aki lo tin un nachi figura dilanti di 3 cm ");

        } else {

            if (B < 3) {
                skirtPattern.setFrontDart(0.0);
                // nachiDilanti.setText("E saya aki lo no mester di nachi dilanti");
            } else if (B >= 3.1 && B <= 3.9) {
                skirtPattern.setThirdteenToFourteen(8.0);
                skirtPattern.setFrontDart(1.5);
                // nachiDilanti.setText("E saya aki lo tin un nachi figura dilanti di 1.5 cm ");
            } else if (B >= 4 && B <= 8) {

                skirtPattern.setThirdteenToFourteen(8.0);
                skirtPattern.setFrontDart(2.0);
                // nachiDilanti.setText("E saya aki lo tin un nachi figura dilanti di 2 cm ");
            } else if (B >= 8.1 && B <= 8.9) {
                double decB = B;
                String doubleAsString = String.valueOf(decB);
                int indexOfDecimal = doubleAsString.indexOf(".");

                skirtPattern.setThirdteenToFourteen(8.0);
                skirtPattern.setFrontDart(2.0 + indexOfDecimal);
                // nachiDilanti.setText("E saya aki lo tin un nachi figura dilanti di : " +2 +
                // doubleAsString.substring(indexOfDecimal) +" cm");
            } else if (B >= 9) {

                skirtPattern.setThirdteenToFourteen(8.0);
                skirtPattern.setFrontDart(3.0);
                // nachiDilanti.setText("E saya aki lo tin un nachi figura dilanti di 3 cm ");
            }
        }

        Double zeiPatras = Double.parseDouble(df.format(C - 0.5));
        skirtPattern.setSevenToTen(zeiPatras);
        Double zeiDilanti = Double.parseDouble(df.format(C + 0.5));
        skirtPattern.setSevenToTwelve(zeiDilanti);

        return skirtPattern;
    }

}
