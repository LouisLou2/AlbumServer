package com.leo.album.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Album {
    private long id;
    private String name;
    private String artist;
    private String imageUrl;
    private String artistNameUrl;
    private LocalDateTime releaseDate;
    private String genre;
    private String description;
    private List<String>songs;
    
    public Album(){
        songs=new ArrayList<>();
    }
}
