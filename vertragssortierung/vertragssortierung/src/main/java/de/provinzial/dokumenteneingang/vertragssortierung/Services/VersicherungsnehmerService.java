package de.provinzial.dokumenteneingang.vertragssortierung.Services;

import org.springframework.stereotype.Service;

import de.provinzial.dokumenteneingang.vertragssortierung.data.sortierteVertraege;

@Service
public class VersicherungsnehmerService {
    // Methode zum Zusammenführen zweier Teilarrays von arr[].
    // Das erste Teilarray ist arr[l..m]
    // Das zweite Teilarray ist arr[m+1..r]
    private void merge(sortierteVertraege  arr[], int l, int m, int r) {
        // Größen der beiden Teilarrays finden
        int n1 = m - l + 1;
        int n2 = r - m;

        // Temporäre Arrays erstellen
        sortierteVertraege L[] = new sortierteVertraege[n1];
        sortierteVertraege R[] = new sortierteVertraege[n2];

        // Daten in temporäre Arrays kopieren
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Initialindizes der ersten und zweiten Teilarrays
        int i = 0, j = 0;

        // Initialindex des zusammengesetzten Teilarrays
        int k = l;
        while (i < n1 && j < n2) {
            // Vergleich unter Verwendung der compareTo Methode von Strings,
            // um alphabetische Ordnung zu gewährleisten
            if (L[i].getNachname().compareTo(R[j].getNachname()) < 0 ||
            (L[i].getNachname().equals(R[j].getNachname()) && 
             L[i].getVorname().compareTo(R[j].getVorname()) <= 0)) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
        }

        // Kopiere restliche Elemente von L[], falls vorhanden
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Kopiere restliche Elemente von R[], falls vorhanden
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
        // Hauptfunktion, die den MergeSort-Algorithmus implementiert.
    // Hier wird MergeSort auf ein Array von Strings angewendet, um sie alphabetisch zu sortieren.
    public void sort(sortierteVertraege arr[], int l, int r) {
        if (l < r) {
            // Finde die Mitte des Arrays
            int m = l + (r - l) / 2;

            // Sortiere die erste und zweite Hälfte
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Führe die sortierten Hälften zusammen
            merge(arr, l, m, r);
        }
    }

    // Hilfsmethode zum Drucken des Arrays von Strings
    static void printArray(String arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    }
    

