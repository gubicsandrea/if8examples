package com.training360.image;

import org.springframework.http.MediaType;

public class Image {

    private long id;
    private byte[] fileBytes;
    private MediaType mediaType;
    private String fileName;

    public Image() {
    }

    public Image(long id, byte[] fileBytes, MediaType mediaType, String fileName) {
        this.id = id;
        this.fileBytes = fileBytes;
        this.mediaType = mediaType;
        this.fileName = fileName;
    }

    public long getId() {
        return id;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
