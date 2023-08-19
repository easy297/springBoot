package kz.test.easy297.controller;

import kz.test.easy297.db.Music;

import java.util.ArrayList;

public class DBManager {
    private static final ArrayList<Music> musics = new ArrayList<>();
    private static Long id = 6L;

    static {
        musics.add(new Music(1L, "Runaway", "Kanye West", 548));
        musics.add(new Music(2L, "fukumean", "Gunna", 125));
        musics.add(new Music(3L, "MY EYES", "Travis Scott", 251));
        musics.add(new Music(4L, "Solo", "Future", 246));
        musics.add(new Music(5L, "Sprinter", "Dave, Central Cee", 229));
    }

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
