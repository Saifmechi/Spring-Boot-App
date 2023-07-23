package com.EMB.app_EMB.Services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.EMB.app_EMB.Exception.ServiceExceptions.RessourceNotFoundException;
import com.EMB.app_EMB.Entity.Formulaire;
import com.EMB.app_EMB.Repository.FormulaireRepository;
import com.EMB.app_EMB.Services.Interfaces.FormulaireInterface;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FormulaireImpl implements FormulaireInterface {

    @Autowired
    private FormulaireRepository formulaireRepository;

    @Override
    public Formulaire saveFormulaire(Formulaire formulaire){
        return formulaireRepository.save(formulaire);
    }

    @Override
    public Formulaire updateFormulaire(Long id, Formulaire formulaire){
        Formulaire existingFormulaire = formulaireRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Formulaire not found with id " + id));
        existingFormulaire.setTitre(formulaire.getTitre());
        existingFormulaire.setSujet(formulaire.getSujet());
        existingFormulaire.setVisiteur(formulaire.getVisiteur());
        
        // Update other properties
        return formulaireRepository.save(existingFormulaire);
    }

    @Override
    public void deleteFormulaireById(Long id) {
        if (!formulaireRepository.existsById(id)) {
            throw new RessourceNotFoundException("Formulaire not found with id " + id);
        }
        formulaireRepository.deleteById(id);
    }

    @Override
    public Formulaire getFormulaireById(Long id) {
        return formulaireRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Formulaire not found with id " + id));
    }

    @Override
    public List<Formulaire> getAllFormulaires() {
        return formulaireRepository.findAll();
    }
}
