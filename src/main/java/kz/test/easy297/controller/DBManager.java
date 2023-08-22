package kz.test.easy297.controller;

import kz.test.easy297.db.Music;

import java.util.ArrayList;

public class DBManager {
    private static final ArrayList<Music> musics = new ArrayList<>();

    private static Long id = 1L;
    public static ArrayList<Music> getMusics() {
        return musics;
    }

    public static void addMusic(Music music) {
        music.setId(id);
        id++;
        musics.add(music);
    }

    public static Music getMusic(int id) {
        return musics.stream().filter(music -> music.getId() == id).findFirst().orElse(null);
    }
}
