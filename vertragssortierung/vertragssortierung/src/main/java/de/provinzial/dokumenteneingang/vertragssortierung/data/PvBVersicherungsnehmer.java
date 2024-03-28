package de.provinzial.dokumenteneingang.vertragssortierung.data;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PvBVersicherungsnehmer {
    
    @Id
    private Long versicherungsnehmerID;

    private String Vorname;

    private String Nachname;

    private String Strasse;

    private String Hausnummer;

    private int PLZ;

    private String Ort;

    private String geburtsdatum;


    public Long getversicherungsnehmerID() {
        return versicherungsnehmerID;
    }

    public void setversicherungsnehmerID(Long versicherungsnehmerID) {
        this.versicherungsnehmerID = versicherungsnehmerID;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }


    public String getStrasse() {
        return Strasse;
    }

    public void setStrasse(String strasse) {
        Strasse = strasse;
    }

    public String getHausnummer() {
        return Hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        Hausnummer = hausnummer;
    }

    public int getPLZ() {
        return PLZ;
    }

    public void setPLZ(int pLZ) {
        PLZ = pLZ;
    }

    public String getOrt() {
        return Ort;
    }

    public void setOrt(String ort) {
        Ort = ort;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    @Override
    public String toString() {
        return "PvBVersicherungsnehmer{" +
                "versicherungsnehmerID=" + versicherungsnehmerID +
                ", Vorname='" + Vorname + '\'' +
                ", Nachname='" + Nachname + '\'' +
                ", Strasse='" + Strasse + '\'' +
                ", Hausnummer='" + Hausnummer + '\'' +
                ", PLZ=" + PLZ +
                ", Ort='" + Ort + '\'' +
                ", geburtsdatum='" + geburtsdatum + '\'' +
                '}';
    }
}
