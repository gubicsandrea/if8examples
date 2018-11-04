package com.training360.image;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
public class ImageController {

    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @RequestMapping(value = "/image/{id}", method = RequestMethod.POST)
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file, @PathVariable("id") Long id){
        Image image = new Image();
        if(id != null) {
            image.setId(id);
        }
        String fileName = file.getOriginalFilename();
        if(fileName.length() > 50) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        image.setFileName(fileName);
        MediaType mediaType = MediaType.parseMediaType(file.getContentType());
        if(!mediaType.equals(MediaType.IMAGE_GIF) && !mediaType.equals(MediaType.IMAGE_JPEG) && !mediaType.equals(MediaType.IMAGE_PNG)) {
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).build();
        }
        image.setMediaType(mediaType);
        try {
            image.setFileBytes(file.getBytes());
            imageService.saveImage(image);
            return ResponseEntity.ok("File is successfully uploaded.");
        } catch (IOException ioex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/image", method = RequestMethod.POST)
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file){
        Image image = new Image();
        String fileName = file.getOriginalFilename();
        if(fileName.length() > 50) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        image.setFileName(fileName);
        MediaType mediaType = MediaType.parseMediaType(file.getContentType());
        if(!mediaType.equals(MediaType.IMAGE_GIF) && !mediaType.equals(MediaType.IMAGE_JPEG) && !mediaType.equals(MediaType.IMAGE_PNG)) {
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).build();
        }
        image.setMediaType(mediaType);
        try {
            image.setFileBytes(file.getBytes());
            imageService.saveImage(image);
            return ResponseEntity.ok("File is successfully uploaded.");
        } catch (IOException ioex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") long id){
        Image image = imageService.getImage(id);
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=" + image.getFileName())
                .contentType(image.getMediaType())
                .body(image.getFileBytes());
    }
}
