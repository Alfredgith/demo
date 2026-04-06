package com.example.backend.entity;
import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "videos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String videoUrl;

    private String thumbnailUrl;

    private String publicId;

    private String uploadedBy;
    
    @Builder.Default
    private Long views = 0L;
}
