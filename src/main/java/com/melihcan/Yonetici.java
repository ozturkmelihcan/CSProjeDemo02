package com.melihcan;

public class Yonetici extends Personel{


    private final double SAATLIK_UCRET = 500;

    private static double BONUS = 1.5 ;

    public double getSAATLIK_UCRET() {
        return SAATLIK_UCRET;
    }

    public Yonetici(String name, String surname, Erole role, int calismaSaati) {
        super(name, surname, role, calismaSaati);
        maasHesapla();
    }

    @Override
    public double maasHesapla() {
           setMaas((getCalismaSaati()*SAATLIK_UCRET)+(getCalismaSaati()*BONUS));
        return 0;
    }



}
