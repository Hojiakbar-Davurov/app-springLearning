package com.example.appspringlearning;

import java.time.LocalDate;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
//        System.out.println(isChangeEducationGroup(LocalDate.parse("2017-10-09"), 6, 6));
        System.out.println(ZoneId.of("Asia/Tashkent"));

    }

    public static Boolean isChangeEducationGroup(LocalDate birthDate, Integer previousGradeId, Integer newGradeId) {
        boolean isAvailable = false;
        int age = LocalDate.now().getYear() - birthDate.getYear();

        switch (previousGradeId) {
            case 1:
                isAvailable = newGradeId == 1 || newGradeId == 6;
                break;
            case 2:
                isAvailable = newGradeId == 2 || newGradeId == 6;
                break;
            case 3:
                isAvailable = newGradeId == 3 || newGradeId == 6;
                break;
            case 4:
                isAvailable = newGradeId == 4 || newGradeId == 6;
                break;
            case 5:
                isAvailable = newGradeId == 5 || newGradeId == 6;
                break;
            case 6: {
                if (newGradeId == 1 && age == 2) {
                    isAvailable = true;
                } else if (newGradeId == 2 && age == 3) {
                    isAvailable = true;
                } else if (newGradeId == 3 && age == 4) {
                    isAvailable = true;
                } else if (newGradeId == 4 && age == 5) {
                    isAvailable = true;
                } else if (newGradeId == 5 && age == 6) {
                    isAvailable = true;
                } else if (newGradeId == 6) {
                    isAvailable = true;
                }
                break;
            }
            case 7:
                isAvailable = newGradeId == 7;
                break;
            case 8:
                isAvailable = newGradeId == 8;
                break;
            case 9:
                isAvailable = newGradeId == 9;
                break;
            case 10:
                isAvailable = newGradeId == 10;
                break;
        }

        return isAvailable;
    }
}
