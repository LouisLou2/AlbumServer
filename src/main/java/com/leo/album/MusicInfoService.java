package com.leo.album;

import com.leo.album.entity.Album;
import com.leo.album.entity.Song;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MusicInfoService {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<Song> getSongsByAlbumId(long albumId) {
        String sql = "SELECT * FROM song WHERE album_id = ?";
        List<Map<String, Object>> res=jdbcTemplate.queryForList(sql,albumId);
        ArrayList<Song> songs = new ArrayList<>();
        for (Map<String, Object> row : res) {
            Song song = new Song();
            song.setId((Long) row.get("id"));
            song.setName((String) row.get("name"));
            song.setDuration((Integer) row.get("duration"));
            song.setAlbumId((Long) row.get("album_id"));
            songs.add(song);
        }
        return songs;
    }
    
    public Album getAlbum(long id) {
        String sql = "SELECT * FROM album WHERE id = ?";
        Map<String, Object> row = jdbcTemplate.queryForMap(sql, id);
        Album album = new Album();
        album.setId((Long) row.get("id"));
        album.setName((String) row.get("name"));
        album.setArtist((String) row.get("artist"));
        album.setImageUrl((String) row.get("imageUrl"));
        album.setArtistNameUrl((String) row.get("artistNameUrl"));
        album.setReleaseDate((LocalDateTime) row.get("releaseDate"));
        album.setGenre((String) row.get("genre"));
        album.setDescription((String) row.get("description"));
        List<Song> songList=getSongsByAlbumId(id);
        songList.forEach(song -> album.getSongs().add(song.getName()));
        return album;
    }
}
