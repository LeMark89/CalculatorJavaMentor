package com.company;

import com.company.converter.LiteralConverter;

public class OperPair {
    String type;
    String firstRomanian;
    String secondRomanian;
    int firstArabic;
    int secondArabic;
    LiteralConverter converter;

    public OperPair(String type, int firstArabic, int secondArabic) {
        this.type = type;
        this.firstArabic = firstArabic;
        this.secondArabic = secondArabic;
        converter = new LiteralConverter();
    }

    public OperPair(String type, String firstRomanian, String secondRomanian, int firstArabic, int secondArabic) {
        this.type = type;
        this.firstRomanian = firstRomanian;
        this.secondRomanian = secondRomanian;
        this.firstArabic = firstArabic;
        this.secondArabic = secondArabic;
        converter = new LiteralConverter();
    }
    public String operate(String operationType) {
        String result = null;
        if (this.type.equalsIgnoreCase("ROMANIAN")) {
            this.firstArabic = converter.romanToDecimal(firstRomanian.toUpperCase());
            this.secondArabic = converter.romanToDecimal(secondRomanian.toUpperCase());
        }
        if (operationType.equalsIgnoreCase("+")) {
            result = plus();
        } else if (operationType.equalsIgnoreCase("-")) {
            result = minus();
        } else if (operationType.equalsIgnoreCase("/")) {
            result = divide();
        } else {
            result = multiply();
        }
        if (this.type.equalsIgnoreCase("ROMANIAN")) {
            int probTmp = Integer.parseInt(result);
            if (probTmp < 0) {
                int tmpRes = Math.abs(probTmp);
                result = "-" + converter.toRoman(tmpRes);
            } else if (probTmp == 0 ) {
                result = "0";
            } else {
                result = converter.toRoman(probTmp);
            }
        }
        return result;
    }
    private String plus() {
        return String.valueOf(firstArabic + secondArabic);
    }
    private String minus() {
        return String.valueOf(firstArabic - secondArabic);
    }
    private String divide() {
        return String.valueOf(firstArabic / secondArabic);
    }
    private String multiply() {
        return String.valueOf(firstArabic * secondArabic);
    }
}
