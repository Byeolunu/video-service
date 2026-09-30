package com.systemdesign.videoservice.dao.Repositories;

import com.systemdesign.videoservice.dao.Entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatorRepository extends JpaRepository<Creator, Long> {
}
