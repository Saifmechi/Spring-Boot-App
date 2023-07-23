package com.EMB.app_EMB.Services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EMB.app_EMB.Entity.Moderateur;
import com.EMB.app_EMB.Exception.ServiceExceptions.RessourceNotFoundException;
import com.EMB.app_EMB.Repository.ModerateurRepository;
import com.EMB.app_EMB.Services.Interfaces.ModerateurInterface;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ModerateurImpl implements ModerateurInterface {

    @Autowired
    private ModerateurRepository moderateurRepository;

    @Override
    public Moderateur saveModerateur(Moderateur moderateur) {
        return moderateurRepository.save(moderateur);
    }

    @Override
    public Moderateur updateModerateur(Long id, Moderateur moderateur) {
        Moderateur existingModerateur = moderateurRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Moderateur not found with id " + id));

        existingModerateur.setNom(moderateur.getNom());
        existingModerateur.setPrenom(moderateur.getPrenom());
        existingModerateur.setEmail(moderateur.getEmail());
        existingModerateur.setPassword(moderateur.getPassword());
        
        return moderateurRepository.save(existingModerateur);
    }

    @Override
    public void deleteModerateurById(Long id) {
        if (!moderateurRepository.existsById(id)) {
            throw new RessourceNotFoundException("Moderateur not found with id " + id);
        }
        moderateurRepository.deleteById(id);
    }

    @Override
    public Moderateur getModerateurById(Long id) {
        return moderateurRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Moderateur not found with id " + id));
    }

    @Override
    public List<Moderateur> getAllModerateurs() {
        return moderateurRepository.findAll();
    }
}
