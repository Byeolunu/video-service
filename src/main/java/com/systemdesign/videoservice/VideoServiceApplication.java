package com.systemdesign.videoservice;

import com.systemdesign.videoservice.dao.Entities.Creator;
import com.systemdesign.videoservice.dao.Entities.Video;
import com.systemdesign.videoservice.dao.Repositories.CreatorRepository;
import com.systemdesign.videoservice.dao.Repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VideoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CreatorRepository creatorRepository,
                            VideoRepository videoRepository) {

        return args -> {

            List<Creator> creators = List.of(
                    Creator.builder()
                            .name("John Doe")
                            .email("john@gmail.com")
                            .build(),

                    Creator.builder()
                            .name("Jane Smith")
                            .email("jane@gmail.com")
                            .build()
            );

            creatorRepository.saveAll(creators);

            List<Video> videos = List.of(
                    Video.builder()
                            .name("Spring Boot Tutorial")
                            .url("https://youtube.com/video1")
                            .description("Spring Boot introduction")
                            .datePublication(LocalDate.now())
                            .creator(creators.get(0))
                            .build(),

                    Video.builder()
                            .name("GraphQL Tutorial")
                            .url("https://youtube.com/video2")
                            .description("Introduction to GraphQL")
                            .datePublication(LocalDate.now())
                            .creator(creators.get(1))
                            .build()
            );

            videoRepository.saveAll(videos);
        };
    }
}