package com.company;

import com.company.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private List<String> allArabic;

    public InputValidator() {
        allArabic = new ArrayList<>();
        String[] arabic = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        allArabic.addAll(Arrays.asList(arabic));
    }

    private String validateNum(String num) {
        boolean isArabic = false;
        boolean isRomanian = false;
        for (int i = 0; i < allArabic.size(); i++) {
            if (num.equalsIgnoreCase(allArabic.get(i))) {
                isRomanian = true;
                break;
            }
        }
        for (int i = 1; i <= 10; i++) {
            try {
                Integer tmp = Integer.parseInt(num);
                if (i == tmp) {
                    isArabic = true;
                    break;
                }
            } catch (Exception e) {
                continue;
            }
        }
        return !isArabic && !isRomanian ? "INVALID" : isArabic ? "ARABIC" : "ROMANIAN";
    }
    public String validateTwoNums(String one, String two) {
        String firstRes = validateNum(one);
        String secondRes = validateNum(two);
        if (firstRes.equalsIgnoreCase("INVALID") || secondRes.equalsIgnoreCase("INVALID")) {
            throw new InvalidInputException();
        } else if (!firstRes.equalsIgnoreCase(secondRes)) {
            throw new InvalidInputException();
        }
        return firstRes;
    }
}
