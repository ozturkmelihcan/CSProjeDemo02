package com.melihcan;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;



public class MaasBordro {

    private List<Personel>personelList;
    public MaasBordro(List<Personel>personelList) {
        this.personelList = personelList;
    }



    private final int bonus = 3000;
    public void bordroyuYaz() {

        LocalDate localDate = LocalDate.now();
        StringBuilder jsonBuilder = new StringBuilder();
        String mesaj = "150 saatten az çalışmıştır.";

        jsonBuilder.append("{\n");
        jsonBuilder.append("  \"bordro\": \"" + localDate.getMonth() + " " + localDate.getYear() + "\",\n");
        jsonBuilder.append("  \"personel\": [\n");


        for (int i = 0; i < personelList.size(); i++) {
            Personel personel = personelList.get(i);
            jsonBuilder.append("    {\n");
            jsonBuilder.append("      \"isim\": \"" + personel.getName() + "\",\n");
            jsonBuilder.append("      \"soyisim\": \"" + personel.getSurname() + "\",\n");
            jsonBuilder.append("      \"odemeDetaylari\": {\n");
            jsonBuilder.append("        \"anaOdeme\": " + personel.getMaas() + ",\n");
            if (personel.getCalismaSaati()<150){
                jsonBuilder.append("        \"mesaj : \": " +'"' + mesaj+ '"'+",\n");
            }
            jsonBuilder.append("        \"bonus\": " +  bonus +",\n");
            jsonBuilder.append("        \"toplamOdeme\": " + (personel.getMaas() + bonus) + "\n");
            jsonBuilder.append("      }\n");

            if (i < personelList.size() - 1) {
                jsonBuilder.append("    },\n");
            } else {
                jsonBuilder.append("    }\n");
            }
        }


        jsonBuilder.append("  ]\n");
        jsonBuilder.append("}\n");
        try {
            FileWriter file = new FileWriter("maasBordro.json");
            file.write(jsonBuilder.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }}

