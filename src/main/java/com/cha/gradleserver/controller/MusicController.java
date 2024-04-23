package com.cha.gradleserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cha.gradleserver.service.MusicService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MusicController {

    private final MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("/test")
    public String addToPlaylist() {

        return "hello world";
    }

    @PostMapping("/api/addToPlaylist")
    public ResponseEntity<String> addToPlaylist(@RequestBody String selectedSong) {
        boolean success = musicService.addToPlaylist(selectedSong);
        if (success) {
            return ResponseEntity.ok("Song added to playlist successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add song to playlist");
        }
    }
}
