package com.example.backend.service;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.backend.entity.Video;
import com.example.backend.repository.VideoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.io.IOException;


@Service

public class VideoService {

    private final Cloudinary cloudinary;
    private final VideoRepository videoRepository;

    public VideoService(Cloudinary cloudinary, VideoRepository videoRepository) {
        this.cloudinary = cloudinary;
        this.videoRepository = videoRepository;
    }

    @SuppressWarnings("unchecked")
    public Video uploadVideo(MultipartFile file,
                             String title,
                             String description,
                             String uploadedBy) throws IOException {

        Map<String, Object> uploadResult =
                (Map<String, Object>) cloudinary.uploader().upload(
                        file.getBytes(),
                        ObjectUtils.asMap(
                                "resource_type", "video",
                                "folder", "my_app/videos"
                        )
                );

        String videoUrl = String.valueOf(uploadResult.get("secure_url"));
        String publicId = String.valueOf(uploadResult.get("public_id"));

        Video video = Video.builder()
                .title(title)
                .description(description)
                .videoUrl(videoUrl)
                .publicId(publicId)
                .uploadedBy(uploadedBy)
                .thumbnailUrl(videoUrl + ".jpg")
                .views(0L)
                .build();

        return videoRepository.save(video);
    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
}