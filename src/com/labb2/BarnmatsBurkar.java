package com.labb2;

public class BarnmatsBurkar extends Barnmat {

    private String kolhydratKalla;
    private String proteinKalla;

    public BarnmatsBurkar(String namn, String marke,  String omdome, String kolhydratKalla, String proteinKalla) {
        super(namn, marke, omdome, false);
        this.kolhydratKalla = kolhydratKalla;
        this.proteinKalla = proteinKalla;
    }

    public String getKolhydratKalla() {
        return kolhydratKalla;
    }

    public String getProteinKalla() {
        return proteinKalla;
    }

    public void setKolhydratKalla(String kolhydratKalla) {
        this.kolhydratKalla = kolhydratKalla;
    }

    public void setProteinKalla(String proteinKalla) {
        this.proteinKalla = proteinKalla;
    }
}
