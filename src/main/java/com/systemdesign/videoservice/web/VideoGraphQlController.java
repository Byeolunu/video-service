package com.systemdesign.videoservice.web;

import com.systemdesign.videoservice.dao.Entities.Creator;
import com.systemdesign.videoservice.dao.Entities.Video;
import com.systemdesign.videoservice.dao.Repositories.CreatorRepository;
import com.systemdesign.videoservice.dao.Repositories.VideoRepository;
import com.systemdesign.videoservice.dto.CreatorRequest;
import com.systemdesign.videoservice.dto.VideoRequest;
import com.systemdesign.videoservice.mappers.CreatorMapper;
import com.systemdesign.videoservice.mappers.VideoMapper;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Controller
public class VideoGraphQlController {
    private final CreatorRepository creatorRepository;
    private final VideoRepository videoRepository;
    private final CreatorMapper creatorMapper;
    private final VideoMapper videoMapper;

    public VideoGraphQlController(
            CreatorRepository creatorRepository,
            VideoRepository videoRepository,
            CreatorMapper creatorMapper,
            VideoMapper videoMapper) {

        this.creatorRepository = creatorRepository;
        this.videoRepository = videoRepository;
        this.creatorMapper = creatorMapper;
        this.videoMapper = videoMapper;
    }


    @QueryMapping
    public List<Video> videoList(){
        return videoRepository.findAll();
    }

    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return creatorRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Creator %s not found",id)));
    }

    @MutationMapping
    public Creator saveCreator(@Argument CreatorRequest creator) {
        Creator c = creatorMapper.fromRequest(creator);
        return creatorRepository.save(c);
    }

    @MutationMapping
    public Video saveVideo(@Argument VideoRequest video) {
        Video v = videoMapper.fromRequest(video);
        return videoRepository.save(v);
    }

    @SubscriptionMapping
    public Flux<Video> notifyVideoChange() {
        return Flux.fromStream(
                Stream.generate(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Random random = new Random();
                    CreatorRequest creatorRequest = CreatorRequest.builder().name("x" +
                                    new Random().nextInt())
                            .email("x@gmail.com").build();
                    Creator creator = creatorRepository.save(creatorMapper.fromRequest(creatorRequest));
                    Video video = videoRepository.findById(1L)
                            .orElseThrow(() -> new RuntimeException("Video 1 not found"));

                    video.setCreator(creator);
                    videoRepository.save(video);
                    return video;
                }));
    }
}