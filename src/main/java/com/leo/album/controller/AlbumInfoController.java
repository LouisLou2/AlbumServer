package com.leo.album.controller;

import com.leo.album.MusicInfoService;
import com.leo.album.entity.Album;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlbumInfoController {
    @Resource
    private MusicInfoService musicInfoService;
    
    @GetMapping("/album_info")
    public Album getAlbumInfo(@RequestParam("id") long id){
        return musicInfoService.getAlbum(id);
    }
}
