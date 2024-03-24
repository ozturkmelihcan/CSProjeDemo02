package com.melihcan;

public abstract class Personel {

    private String name;
    private String surname;

    private Erole role;

    private double calismaSaati;

    private double maas;



    public double getMaas() {
        return maas;
    }

    public String getName() {
        return name;
    }

    public void setMaas(double maas) {
        this.maas = maas;
    }

    public double getCalismaSaati() {
        return calismaSaati;
    }

    public void setCalismaSaati(double calismaSaati) {
        this.calismaSaati = calismaSaati;
    }

    public Personel(String name) {
        this.name = name;
    }

    public Personel(String name, String surname, Erole role,int calismaSaati) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.calismaSaati = calismaSaati;

    }

    public Personel() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Erole getRole() {
        return role;
    }

    public void setRole(Erole role) {
        this.role = role;
    }

    public abstract double maasHesapla();

    @Override
    public String toString() {
        return "Personel{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", role=" + role +
                ", calismaSaati=" + calismaSaati +
                ", maas=" + maas +
                '}';
    }
}
