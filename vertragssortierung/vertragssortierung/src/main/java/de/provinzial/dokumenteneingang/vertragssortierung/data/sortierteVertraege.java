package de.provinzial.dokumenteneingang.vertragssortierung.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class sortiertevertraege {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sortierID;
    private Long vertragsnummer;
    private Long versicherungsnehmerID;
    private String Nachname;
    private String Vorname;


    public Long getSortierID() {
        return sortierID;
    }
    public void setSortierID(Long sortierID) {
        this.sortierID = sortierID;
    }
    public Long getVertragsNummer() {
        return vertragsnummer;
    }
    public void setVertragsNummer(Long vertragsNummer) {
        this.vertragsnummer = vertragsNummer;
    }
    public Long getVersicherungsnehmerID() {
        return versicherungsnehmerID;
    }
    public void setVersicherungsnehmerID(Long versicherungsnehmerID) {
        this.versicherungsnehmerID = versicherungsnehmerID;
    }
    public String getNachname() {
        return Nachname;
    }
    public void setNachname(String nachname) {
        Nachname = nachname;
    }
    public String getVorname() {
        return Vorname;
    }
    public void setVorname(String vorname) {
        Vorname = vorname;
    }
    
    @Override
    public String toString() {
        return "sortierteVertraege{" +
                "sortierID=" + sortierID +
                ", vertragsNummer=" + vertragsnummer +
                ", versicherungsnehmerID=" + versicherungsnehmerID +
                ", Nachname='" + Nachname + '\'' +
                ", Vorname='" + Vorname + '\'' +
                '}';
    }
}
