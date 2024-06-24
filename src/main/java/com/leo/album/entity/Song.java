package com.leo.album.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class Song {
    private Long id;
    private String name;
    private int duration;
    private Long albumId;

    public Song() {}
}