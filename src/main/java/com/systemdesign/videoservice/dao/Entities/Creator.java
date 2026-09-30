package com.systemdesign.videoservice.dao.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Creator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;
    public String email;

    @OneToMany(mappedBy = "creator")
    private List<Video> videos;
}
