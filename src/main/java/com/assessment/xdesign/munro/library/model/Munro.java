package com.assessment.xdesign.munro.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Author: Atul Kumar
 * Entity class to hold Munro data
 * */
@Entity
@Table(name="TBL_MUNRO")
public class Munro {
    @Id
    Integer RUNNING_NO;
    @Column (name="MUNRONAME")
    String munroName;
    @Column (name="HEIGHTINMETER")
    BigDecimal heightInMeter;
    @Column (name="YEAR1891")
    String year1891;
    @Column (name="YEAR1921")
    String year1921;
    @Column (name="YEAR1933")
    String year1933;
    @Column (name="YEAR1953")
    String year1953;
    @Column (name="YEAR1969")
    String year1969;
    @Column (name="YEAR1974")
    String year1974;
    @Column (name="YEAR1981")
    String year1981;
    @Column (name="YEAR1984")
    String year1984;
    @Column (name="YEAR1990")
    String year1990;
    @Column (name="YEAR1997")
    String year1997;
    @Column (name="YEARPOST1997")
    String yearPost1997;

    public Integer getRUNNING_NO() {
        return RUNNING_NO;
    }

    public void setRUNNING_NO(Integer RUNNING_NO) {
        this.RUNNING_NO = RUNNING_NO;
    }

    public String getMunroName() {
        return munroName;
    }

    public void setMunroName(String munroName) {
        this.munroName = munroName;
    }

    public BigDecimal getHeightInMeter() {
        return heightInMeter;
    }

    public void setHeightInMeter(BigDecimal heightInMeter) {
        this.heightInMeter = heightInMeter;
    }

    public String getYear1891() {
        return year1891;
    }

    public void setYear1891(String year1891) {
        this.year1891 = year1891;
    }

    public String getYear1921() {
        return year1921;
    }

    public void setYear1921(String year1921) {
        this.year1921 = year1921;
    }

    public String getYear1933() {
        return year1933;
    }

    public void setYear1933(String year1933) {
        this.year1933 = year1933;
    }

    public String getYear1953() {
        return year1953;
    }

    public void setYear1953(String year1953) {
        this.year1953 = year1953;
    }

    public String getYear1969() {
        return year1969;
    }

    public void setYear1969(String year1969) {
        this.year1969 = year1969;
    }

    public String getYear1974() {
        return year1974;
    }

    public void setYear1974(String year1974) {
        this.year1974 = year1974;
    }

    public String getYear1981() {
        return year1981;
    }

    public void setYear1981(String year1981) {
        this.year1981 = year1981;
    }

    public String getYear1984() {
        return year1984;
    }

    public void setYear1984(String year1984) {
        this.year1984 = year1984;
    }

    public String getYear1990() {
        return year1990;
    }

    public void setYear1990(String year1990) {
        this.year1990 = year1990;
    }

    public String getYear1997() {
        return year1997;
    }

    public void setYear1997(String year1997) {
        this.year1997 = year1997;
    }

    public String getYearPost1997() {
        return yearPost1997;
    }

    public void setYearPost1997(String yearPost1997) {
        this.yearPost1997 = yearPost1997;
    }

}
