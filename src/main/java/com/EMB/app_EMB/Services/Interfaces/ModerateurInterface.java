package com.EMB.app_EMB.Services.Interfaces;

import java.util.List;

import com.EMB.app_EMB.Entity.Moderateur;

public interface ModerateurInterface {

	   Moderateur saveModerateur(Moderateur moderateur);
	   Moderateur updateModerateur(Long id, Moderateur moderateur);
	   void deleteModerateurById(Long id);
	   Moderateur getModerateurById(Long id);
	   List<Moderateur> getAllModerateurs();
}
