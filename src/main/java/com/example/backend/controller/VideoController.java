package com.example.backend.controller;


import com.example.backend.entity.Video;
import com.example.backend.service.VideoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
@CrossOrigin("*")
public class VideoController {


    
    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Video uploadVideo(
            @RequestParam("file") MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("uploadedBy") String uploadedBy
    ) throws Exception {
        return videoService.uploadVideo(file, title, description, uploadedBy);
    }

    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }
    
}

