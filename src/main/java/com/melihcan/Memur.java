package com.melihcan;

public class Memur extends Personel {

    private final int JUNIOR_SAATLIK_UCRET = 400;
    private final int MID_SAATLIK_UCRET = 500;
    private final int SENIOR_SAATLIK_UCRET = 600;
    private final int maxCalismaSaati = 180;


    private final double mesaiKatsayi = 1.5;

    public double getMesaiKatsayi() {
        return mesaiKatsayi;
    }

    private EDerece derece;

    public int getMaxCalismaSaati() {
        return maxCalismaSaati;
    }

    public EDerece getDerece() {
        return derece;
    }

    public void setDerece(EDerece derece) {
        this.derece = derece;
    }

    public Memur() {

    }

    public Memur(String name, String surname, Erole role, int calismaSaati) {
        super(name, surname, role, calismaSaati);
        this.derece = EDerece.values()[(int) (Math.random() * 3)];

        setMaas(maasHesapla());
    }

    @Override
    public double maasHesapla() {
        if (getCalismaSaati() < maxCalismaSaati) {
            if (derece.equals(EDerece.JUNIOR)) {
                return getCalismaSaati() * JUNIOR_SAATLIK_UCRET;
            } else if (derece.equals(EDerece.MID)) {
                return getCalismaSaati() * MID_SAATLIK_UCRET;
            }
            return getCalismaSaati() * SENIOR_SAATLIK_UCRET;
        } else {
            if (derece.equals(EDerece.JUNIOR)) {
                return ((getCalismaSaati() - maxCalismaSaati) * (mesaiKatsayi) * JUNIOR_SAATLIK_UCRET);
            } else if (derece.equals(EDerece.MID)) {
                return ((getCalismaSaati() - maxCalismaSaati) * (mesaiKatsayi) * MID_SAATLIK_UCRET);
            }
            return ((getCalismaSaati() - maxCalismaSaati) * (mesaiKatsayi) * SENIOR_SAATLIK_UCRET);
        }


    }
}