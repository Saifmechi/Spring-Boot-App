package com.EMB.app_EMB.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EMB.app_EMB.Entity.Formulaire;
import com.EMB.app_EMB.Exception.ControllerExceptions.ViolationException;
import com.EMB.app_EMB.Exception.ServiceExceptions.RessourceNotFoundException;
import com.EMB.app_EMB.Services.Implementation.FormulaireImpl;

@RestController
@RequestMapping("/formulaires")
public class FormulaireController {
    @Autowired
    private FormulaireImpl formulaireService;

    @GetMapping
    public ResponseEntity<List<Formulaire>> getAllFormulaires() {
        List<Formulaire> formulaires = formulaireService.getAllFormulaires();
        return ResponseEntity.ok(formulaires);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formulaire> getFormulaireById(@PathVariable Long id) {
        try {
            Formulaire formulaire = formulaireService.getFormulaireById(id);
            return ResponseEntity.ok(formulaire);
        } catch (RessourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Formulaire> saveFormulaire(@RequestBody Formulaire formulaire) {
        Formulaire savedFormulaire = formulaireService.saveFormulaire(formulaire);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFormulaire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Formulaire> updateFormulaire(@PathVariable Long id, @RequestBody Formulaire formulaire) {
        try {
            Formulaire updatedFormulaire = formulaireService.updateFormulaire(id, formulaire);
            return ResponseEntity.ok(updatedFormulaire);
        } catch (RessourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormulaireById(@PathVariable Long id) {
        try {
            formulaireService.deleteFormulaireById(id);
            return ResponseEntity.noContent().build();
        } catch (RessourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}