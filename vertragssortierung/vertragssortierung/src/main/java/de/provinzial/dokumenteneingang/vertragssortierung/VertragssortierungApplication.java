package de.provinzial.dokumenteneingang.vertragssortierung;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.provinzial.dokumenteneingang.vertragssortierung.Services.RepositoryService;
import de.provinzial.dokumenteneingang.vertragssortierung.Services.VersicherungsnehmerService;
import de.provinzial.dokumenteneingang.vertragssortierung.data.PvBSatzvertragstabelle;
import de.provinzial.dokumenteneingang.vertragssortierung.data.sortiertevertraege;
import de.provinzial.dokumenteneingang.vertragssortierung.data.PvBVersicherungsnehmer;

@SpringBootApplication
public class VertragssortierungApplication implements CommandLineRunner{

	private final RepositoryService repositoryService;
	private final VersicherungsnehmerService sortierungService;

    @Autowired
    public VertragssortierungApplication(RepositoryService repositoryService, VersicherungsnehmerService sortierungService) {
        this.repositoryService = repositoryService;
		this.sortierungService = sortierungService;
    }
	public static void main(String[] args) {
		SpringApplication.run(VertragssortierungApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
            
		sortieren();
    }

	private void sortieren() {
		List<PvBVersicherungsnehmer> versicherungsnehmer = repositoryService.getAllVersicherungsnehmer();
		List<PvBSatzvertragstabelle> vertraege = repositoryService.getAllVertraege();
		
		Map<Long, PvBVersicherungsnehmer> versicherungsnehmerMap = new HashMap<>();
		// Fülle die Map für schnellen Zugriff
		for (PvBVersicherungsnehmer vn : versicherungsnehmer) {
			versicherungsnehmerMap.put(vn.getversicherungsnehmerID(), vn);
		}

		List<sortiertevertraege> sortierteVertraege = verbinden(vertraege, versicherungsnehmerMap);


		sortiertevertraege[] sortierteVertraegeArray = new sortiertevertraege[versicherungsnehmer.size()];
		sortierteVertraegeArray = sortierteVertraege.toArray(sortierteVertraegeArray);


		sortierungService.sort(sortierteVertraegeArray, 0, versicherungsnehmer.size() - 1);

		printArray(sortierteVertraegeArray);
		repositoryService.pushSortierteVertraege(sortierteVertraegeArray);
	}

	public List<sortiertevertraege> verbinden(List<PvBSatzvertragstabelle> vertraegeListe, Map<Long, PvBVersicherungsnehmer> versicherungsnehmer) {
        // Verbinde Verträge mit Versicherungsnehmer-Informationen
        List<sortiertevertraege> verbundeneListe = vertraegeListe.stream().map(vertrag -> {
            PvBVersicherungsnehmer vn = versicherungsnehmer.get(vertrag.getVersicherungsnehmerID());
            sortiertevertraege sv = new sortiertevertraege();
            sv.setVertragsNummer(vertrag.getVertragsNummer());
            sv.setVersicherungsnehmerID(vertrag.getVersicherungsnehmerID());
            sv.setNachname(vn.getNachname());
            sv.setVorname(vn.getVorname());
            // Setze hier weitere notwendige Felder
            return sv;
        }).collect(Collectors.toList());

		return verbundeneListe;
	}

	    // Hilfsmethode zum Drucken des Arrays von Strings
		static void printArray(sortiertevertraege arr[]) {
			int n = arr.length;
			for (int i = 0; i < n; ++i)
				System.out.print("{" + arr[i].toString() + "} + ");
			System.out.println();
		}
}
