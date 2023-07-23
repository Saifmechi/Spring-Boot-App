package com.EMB.app_EMB.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.EMB.app_EMB.Entity.Moderateur;
import com.EMB.app_EMB.Exception.ControllerExceptions.ViolationException;
import com.EMB.app_EMB.Exception.ServiceExceptions.RessourceNotFoundException;
import com.EMB.app_EMB.Services.Implementation.ModerateurImpl;

@RestController
@RequestMapping("/moderateurs")
public class ModerateurController {
    @Autowired
    private ModerateurImpl moderateurService;

    @GetMapping
    public ResponseEntity<List<Moderateur>> getAllModerateurs() {
        List<Moderateur> moderateurs = moderateurService.getAllModerateurs();
        return ResponseEntity.ok(moderateurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moderateur> getModerateurById(@PathVariable Long id) {
        try {
            Moderateur moderateur = moderateurService.getModerateurById(id);
            return ResponseEntity.ok(moderateur);
        } catch (RessourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Moderateur> saveModerateur(@RequestBody Moderateur moderateur) {
        Moderateur savedModerateur = moderateurService.saveModerateur(moderateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedModerateur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Moderateur> updateModerateur(@PathVariable Long id, @RequestBody Moderateur moderateur) {
        try {
            Moderateur updatedModerateur = moderateurService.updateModerateur(id, moderateur);
            return ResponseEntity.ok(updatedModerateur);
        } catch (RessourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModerateurById(@PathVariable Long id) {
        try {
            moderateurService.deleteModerateurById(id);
            return ResponseEntity.noContent().build();
        } catch (RessourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}