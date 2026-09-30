package com.systemdesign.videoservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatorRequest {
    private String name;
    private String email;
}