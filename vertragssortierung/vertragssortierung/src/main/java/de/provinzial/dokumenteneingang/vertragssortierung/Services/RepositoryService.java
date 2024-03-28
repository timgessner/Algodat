package de.provinzial.dokumenteneingang.vertragssortierung.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.provinzial.dokumenteneingang.vertragssortierung.Repository.SortierteVertraegeRepository;
import de.provinzial.dokumenteneingang.vertragssortierung.Repository.VersicherungsnehmerRepository;
import de.provinzial.dokumenteneingang.vertragssortierung.Repository.VertragsRepository;
import de.provinzial.dokumenteneingang.vertragssortierung.data.PvBSatzvertragstabelle;
import de.provinzial.dokumenteneingang.vertragssortierung.data.PvBVersicherungsnehmer;
import de.provinzial.dokumenteneingang.vertragssortierung.data.sortierteVertraege;

@Service
public class RepositoryService {
    private final VertragsRepository vertragsRepository;
    private final VersicherungsnehmerRepository versicherungsnehmerRepository;
    private final SortierteVertraegeRepository sortierteVertraegeRepository;

    @Autowired
    public RepositoryService(VertragsRepository vertragsRepository, VersicherungsnehmerRepository versicherungsnehmerRepository, SortierteVertraegeRepository sortierteVertraegeRepository) {
        this.vertragsRepository = vertragsRepository;
        this.versicherungsnehmerRepository = versicherungsnehmerRepository;
        this.sortierteVertraegeRepository = sortierteVertraegeRepository;
    }

    public List<PvBSatzvertragstabelle> getAllVertraege() {

        List<PvBSatzvertragstabelle> vertrage = vertragsRepository.findAll();

        return vertrage;
    }

    public List<PvBVersicherungsnehmer> getAllVersicherungsnehmer() {

        List<PvBVersicherungsnehmer> versicherungsnehmer = versicherungsnehmerRepository.findAll();

        return versicherungsnehmer;
    }

    public void pushSortierteVertraege(List<sortierteVertraege> sortierteVertraeges) {

        sortierteVertraegeRepository.deleteAll();
        sortierteVertraegeRepository.saveAll(sortierteVertraeges);
    }


}
