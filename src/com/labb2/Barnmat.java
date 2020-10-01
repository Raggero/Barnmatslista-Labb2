package com.labb2;

public class Barnmat {

    private String namn;
    private String marke;
    private String omdome;
    private boolean favorit;


    public Barnmat(String namn, String marke, String omdome, boolean favorit) {
        this.namn = namn;
        this.marke = marke;
        this.omdome = omdome;
        this.favorit = favorit;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getOmdome() {
        return omdome;
    }

    public void setOmdome(String omdome) {
        this.omdome = omdome;
    }

    public boolean getFavorit() {
        return favorit;
    }

    public void setFavorit(boolean favorit) {
        this.favorit = favorit;
    }
}
