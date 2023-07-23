package com.EMB.app_EMB.Services.Interfaces;

import java.util.List;

import com.EMB.app_EMB.Entity.Formulaire;

public interface FormulaireInterface {

    Formulaire saveFormulaire(Formulaire formulaire);
    Formulaire updateFormulaire(Long id, Formulaire formulaire);
    void deleteFormulaireById(Long id);
    Formulaire getFormulaireById(Long id);
    List<Formulaire> getAllFormulaires();
}
