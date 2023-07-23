package com.EMB.app_EMB.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired ;
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
import com.EMB.app_EMB.Entity.Projet;
import com.EMB.app_EMB.Exception.ControllerExceptions.ViolationException;
import com.EMB.app_EMB.Exception.ServiceExceptions.RessourceNotFoundException;
import com.EMB.app_EMB.Services.Implementation.ProjetImpl;

@RestController
@RequestMapping("/projets")
public class ProjetController {
    @Autowired
    private ProjetImpl projetService;

    @GetMapping
    public ResponseEntity<List<Projet>> getAllProjets() {
        List<Projet> projets = projetService.getAllProjets();
        return ResponseEntity.ok(projets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projet> getProjetById(@PathVariable Long id) {
        try {
            Projet projet = projetService.getProjetById(id);
            return ResponseEntity.ok(projet);
        } catch (RessourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Projet> saveProjet(@RequestBody Projet projet) {
        Projet savedProjet = projetService.saveProjet(projet);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProjet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projet> updateProjet(@PathVariable Long id, @RequestBody Projet projet) {
        try {
            Projet updatedProjet = projetService.updateProjet(id, projet);
            return ResponseEntity.ok(updatedProjet);
        } catch (RessourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjetById(@PathVariable Long id) {
        try {
            projetService.deleteProjetById(id);
            return ResponseEntity.noContent().build();
        } catch (RessourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

 
}

