package com.assessment.xdesign.munro.library.utils;

import com.assessment.xdesign.munro.library.model.Munro;

import java.math.BigDecimal;

public class Builder {

    public static Munro munro(Integer RUNNING_NO, String munroName, BigDecimal heightInMeter,
                              String year1891, String year1921, String year1933, String year1953,
                              String year1969, String year1974, String year1981, String year1984,
                              String year1990, String year1997, String yearPost1997){

        Munro munro = new Munro();
        munro.setRUNNING_NO(RUNNING_NO);
        munro.setMunroName(munroName);
        munro.setHeightInMeter(heightInMeter);
        munro.setYear1891(year1891);
        munro.setYear1921(year1921);
        munro.setYear1933(year1933);
        munro.setYear1953(year1953);
        munro.setYear1969(year1969);
        munro.setYear1974(year1974);
        munro.setYear1981(year1981);
        munro.setYear1984(year1984);
        munro.setYear1990(year1990);
        munro.setYear1997(year1997);
        munro.setYearPost1997(yearPost1997);
        return munro;
    }
}
