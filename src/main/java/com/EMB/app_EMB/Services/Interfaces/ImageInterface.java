package com.EMB.app_EMB.Services.Interfaces;

import java.util.List;


import com.EMB.app_EMB.Entity.Image;

public interface ImageInterface {

    List<Image> getAllImages();

    Image getImageById(Long id);

    Image saveImage(Image image);
    Image updateImage(Long id,Image image) ;

    void deleteImageById(Long id) ;
}
