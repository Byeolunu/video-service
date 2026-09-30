package com.systemdesign.videoservice.dao.Repositories;

import com.systemdesign.videoservice.dao.Entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
