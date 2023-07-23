package com.EMB.app_EMB.Services.Interfaces;

import java.util.List;

import com.EMB.app_EMB.Entity.Projet;

public interface ProjetInterface {

    Projet saveProjet(Projet projet);
    Projet updateProjet(Long id, Projet projet);
    void deleteProjetById(Long id);
    Projet getProjetById(Long id);
    List<Projet> getAllProjets();
}
