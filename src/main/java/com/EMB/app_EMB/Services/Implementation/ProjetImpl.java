package com.EMB.app_EMB.Services.Implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.EMB.app_EMB.Exception.ServiceExceptions.RessourceNotFoundException;
import com.EMB.app_EMB.Entity.Projet;
import com.EMB.app_EMB.Repository.ProjetRepository;
import com.EMB.app_EMB.Services.Interfaces.ProjetInterface;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProjetImpl implements ProjetInterface {
	
	@Autowired
    private ProjetRepository projetRepository;

    @Override
    public Projet saveProjet(Projet projet){
        return projetRepository.save(projet);
    }

    @Override
    public Projet updateProjet(Long id, Projet projet){
        Projet existingProjet = projetRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Projet not found with id " + id));
        
        existingProjet.setNomProjet(projet.getNomProjet());
        existingProjet.setDescription(projet.getDescription());
        existingProjet.setAdresse(projet.getAdresse());
        existingProjet.setStatus(projet.isStatus());
        existingProjet.setCategorie(projet.getCategorie());
        existingProjet.setClient_projet(projet.getClient_projet());
        existingProjet.setImages(projet.getImages());
        existingProjet.setDateFin(projet.getDateFin());
        existingProjet.setDateDebut();
        
        
        // Update other properties
        return projetRepository.save(existingProjet);
    }

    @Override
    public void deleteProjetById(Long id) {
        if (!projetRepository.existsById(id)) {
            throw new RessourceNotFoundException("Projet not found with id " + id);
        }
        projetRepository.deleteById(id);
    }

    @Override
    public Projet getProjetById(Long id) {
        return projetRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Projet not found with id " + id));
    }

    @Override
    public List<Projet> getAllProjets() {
        return projetRepository.findAll();
    }
}

