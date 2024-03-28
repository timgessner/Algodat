package de.provinzial.dokumenteneingang.vertragssortierung.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.provinzial.dokumenteneingang.vertragssortierung.data.PvBSatzvertragstabelle;

@Repository
public interface VertragsRepository extends JpaRepository<PvBSatzvertragstabelle, Long>{

    
} 