package com.systemdesign.videoservice.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoRequest {
    private String name;
    private String url;
    private String description;
    private LocalDate datePublication;
    private CreatorRequest creator;
}