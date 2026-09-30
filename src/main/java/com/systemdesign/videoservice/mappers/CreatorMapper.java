package com.systemdesign.videoservice.mappers;

import com.systemdesign.videoservice.dto.CreatorRequest;
import com.systemdesign.videoservice.dao.Entities.Creator;
import org.springframework.stereotype.Component;

@Component
public class CreatorMapper {

    public Creator fromRequest(CreatorRequest request) {
        return Creator.builder()
                .name(request.getName())
                .email(request.getEmail())
                .build();
    }
}