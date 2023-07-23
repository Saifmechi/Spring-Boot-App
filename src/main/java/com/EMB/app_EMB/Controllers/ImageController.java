package com.EMB.app_EMB.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.EMB.app_EMB.Entity.Image;
import com.EMB.app_EMB.Services.Interfaces.ImageInterface;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageInterface imageService;

    // Get all images
    @GetMapping("/")
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    // Get image by id
    @GetMapping("/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable Long id) {
        Image image = imageService.getImageById(id);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }

    // Add image
    @PostMapping("/")
    public ResponseEntity<Image> addImage(@RequestBody Image image) {
        Image savedImage = imageService.saveImage(image);
        return new ResponseEntity<>(savedImage, HttpStatus.CREATED);
    }

    // Update image
    @PutMapping("/{id}")
    public ResponseEntity<Image> updateImage(@PathVariable Long id, @RequestBody Image image) {
        Image updatedImage = imageService.updateImage(id, image);
        return new ResponseEntity<>(updatedImage, HttpStatus.OK);
    }

    // Delete image by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImageById(@PathVariable Long id) {
        imageService.deleteImageById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
