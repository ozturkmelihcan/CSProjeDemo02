package com.melihcan;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class DosyaOku {

    private List<Personel> personelList;
    private List<Yonetici> yoneticiList;
    private List<Memur> memurList;

    public List<Yonetici> getYoneticiList() {
        return yoneticiList;
    }

    public void setYoneticiList(List<Yonetici> yoneticiList) {
        this.yoneticiList = yoneticiList;
    }

    public List<Memur> getMemurList() {
        return memurList;
    }

    public void setMemurList(List<Memur> memurList) {
        this.memurList = memurList;

    }

    public DosyaOku() {
        this.personelList = new ArrayList<>();
        this.memurList = new ArrayList<>();
        this.yoneticiList = new ArrayList<>();
    }

    public List<Personel> getPersonelList() {
        return personelList;
    }

    public void setPersonelList(List<Personel> personelList) {
        this.personelList = personelList;
    }


    public List<Personel> jsonFileOku() throws IOException {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/java/com/melihcan/data.json")) {

            Object obj = parser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;

            for (Object o : jsonArray) {
                JSONObject jsonObject = (JSONObject) o;
                if (( jsonObject.get("role")).equals("MEMUR")) {
                    Long longDeger = (Long) jsonObject.get("saat");
                    Memur memur = new Memur((String) jsonObject.get("name"),(String) jsonObject.get("surname"),
                            Erole.valueOf((String) jsonObject.get("role")), longDeger.intValue()  );
                    personelList.add(memur);
                    memurList.add(memur);
                } else {
                    Long longDeger = (Long) jsonObject.get("saat");
                    Yonetici yonetici = new Yonetici((String) jsonObject.get("name"),(String) jsonObject.get("surname")
                    ,Erole.valueOf((String) jsonObject.get("role")),longDeger.intValue());
                    personelList.add(yonetici);
                    yoneticiList.add(yonetici);

                }

            }
            ;
            System.out.println(personelList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return personelList;

    }


}
