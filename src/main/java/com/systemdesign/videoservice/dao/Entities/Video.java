package com.systemdesign.videoservice.dao.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String url;
    private String description;
    private LocalDate datePublication;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Creator creator;
}