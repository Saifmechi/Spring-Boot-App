package com.EMB.app_EMB.Services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EMB.app_EMB.Entity.Image;
import com.EMB.app_EMB.Exception.ServiceExceptions.RessourceNotFoundException;
import com.EMB.app_EMB.Repository.ImageRepository;
import com.EMB.app_EMB.Services.Interfaces.ImageInterface;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImageImpl implements ImageInterface {
	
	@Autowired
    private ImageRepository imageRepository;

    @Override
    public Image saveImage(Image image){
        return imageRepository.save(image);
    }

    @Override
    public Image updateImage(Long id, Image image){
        Image existingImage = imageRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Image not found with id " + id));
        existingImage.setData(image.getData());
        existingImage.setDescription(image.getDescription());
        existingImage.setBlog_image(image.getBlog_image());
        existingImage.setProjet(image.getProjet());
        
       
        return imageRepository.save(existingImage);
    }

    @Override
    public void deleteImageById(Long id) {
        if (!imageRepository.existsById(id)) {
            throw new RessourceNotFoundException("Image not found with id " + id);
        }
        imageRepository.deleteById(id);
    }

    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Image not found with id " + id));
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }
}