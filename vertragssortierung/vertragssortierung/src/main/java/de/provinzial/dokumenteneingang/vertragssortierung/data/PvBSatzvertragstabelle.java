package de.provinzial.dokumenteneingang.vertragssortierung.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PvBSatzvertragstabelle {

        @Id
        private Long vertragsnummer;
        private String anwendung;
        private String verwaltungsunternehmen;
        private String versicherungszweig;
        private String guelabdat;
    
        private Long versicherungsnehmerID;
        private String produktgeber;
    
        private String anwendungmig;
        private String anwendungnachf;
    
        /**
         * AWD_CD
         */
        public String getAnwendung() {
            return this.anwendung;
        }
    
        /**
         * VVT_NR
         */
        public Long getVertragsNummer() {
            return this.vertragsnummer;
        }
    
        /**
         * VSZW_KZ
         */
        public String getVersicherungsZweig() {
            return this.versicherungszweig;
        }
    
        /**
         * Gültigkeit des jüngsten Satzes zu gelesener Vertragsnummmer/Herkunft
         * Insbesondere bei migrierten Verträgen das Migrationsdatum
         */
        public String getGuelAbDat() {
            return this.guelabdat;
        }
    
        /**
         * Bei migrierten Verträgen (unter Beibehaltung der Vertragsnummmer) das Quellsystem (AWD_CD), aus dem migriert wurde
         */
        public String getAnwendungMig() {
            return this.anwendungmig;
        }
    
        /**
         * Bei migrierten Verträgen (unter Beibehaltung der Vertragsnummmer) das Zielsystem (AWD_CD), in das migriert wurde
         */
        public String getAnwendungNachf() {
            return this.anwendungnachf;
        }

        public Long getVersicherungsnehmerID() {
            return versicherungsnehmerID;
        }
    
        public void setAnwendung(String anwendung) {
            this.anwendung = anwendung;
        }
    
        public void setVertragsNummer(Long vertragsNummer) {
            this.vertragsnummer = vertragsNummer;
        }
    
        public void setVersicherungsZweig(String versicherungsZweig) {
            this.versicherungszweig = versicherungsZweig;
        }
    
        public void setGuelAbDat(String guelAbDat) {
            this.guelabdat = guelAbDat;
        }
    
        public void setAnwendungMig(String anwendungMig) {
            this.anwendungmig = anwendungMig;
        }
    
        public void setAnwendungNachf(String awendungNachf) {
            this.anwendungnachf = awendungNachf;
        }
    
        public String getVerwaltungsunternehmen() {
            return this.verwaltungsunternehmen;
        }
    
        public String getProduktgeber() {
            return this.produktgeber;
        }
    
        public void setProduktgeber(String produktgeber) {
            this.produktgeber = produktgeber;
        }
    
        public void setVerwaltungsunternehmen(String verwaltungsunternehmen) {
            this.verwaltungsunternehmen = verwaltungsunternehmen;
        }
    
        


        public void setVersicherungsnehmerID(Long versicherungsnehmerID) {
            this.versicherungsnehmerID = versicherungsnehmerID;
        }
        @Override
        public String toString() {
            return "PvBSatzVertragsTabelle [anwendung=" + this.anwendung + ", vertragsNummer=" + this.vertragsnummer
                    + ", verwaltungsunternehmen=" + this.verwaltungsunternehmen + ", versicherungsZweig=" + this.versicherungszweig
                    + ", guelAbDat=" + this.guelabdat + ", versicherungsnehmerID="+ this.versicherungsnehmerID + "]";
        }

    
    }
    

