package com.example.app.model;

public class Video {

    private Long id;

    private String title;

    private String description;

    private String videoUrl;

    private String thumbnailUrl;

    private String uploadedBy;

    private String createdAt;

    // EMPTY CONSTRUCTOR
    public Video() {
    }

    // FULL CONSTRUCTOR
    public Video(Long id,
                 String title,
                 String description,
                 String videoUrl,
                 String thumbnailUrl,
                 String uploadedBy,
                 String createdAt) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.videoUrl = videoUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.uploadedBy = uploadedBy;
        this.createdAt = createdAt;
    }

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}