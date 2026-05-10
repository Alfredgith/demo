package com.example.backend.controller;


import com.example.backend.entity.Video;
import com.example.backend.repository.VideoRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/videos")
@CrossOrigin("*")
public class VideoController {

    private final VideoRepository repository;

    public VideoController(VideoRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/save")
    public Video saveVideo(@RequestBody Video video) {
        return repository.save(video);
    }

    @GetMapping("/feed")
    public List<Video> getFeed() {
        return repository.findAllByOrderByCreatedAtDesc();
    }
}