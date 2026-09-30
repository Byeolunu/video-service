package com.systemdesign.videoservice.mappers;

import com.systemdesign.videoservice.dto.VideoRequest;
import com.systemdesign.videoservice.dao.Entities.Video;
import org.springframework.stereotype.Component;

@Component
public class VideoMapper {



    public Video fromRequest(VideoRequest request) {
        return Video.builder()
                .name(request.getName())
                .url(request.getUrl())
                .description(request.getDescription())
                .datePublication(request.getDatePublication())
                .build();
    }
}