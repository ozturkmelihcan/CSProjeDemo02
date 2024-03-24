package com.melihcan;



import java.io.IOException;

public class Program {

    public static void main(String[] args) throws IOException {
        DosyaOku fileR = new DosyaOku();
        fileR.jsonFileOku();
        MaasBordro maasBordro = new MaasBordro(fileR.getPersonelList());
        maasBordro.bordroyuYaz();


    }
}