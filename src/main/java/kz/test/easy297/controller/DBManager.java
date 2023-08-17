package kz.test.easy297.controller;

import kz.test.easy297.db.Music;

import java.util.ArrayList;

public class DBManager {
    private static final ArrayList<Music> musics = new ArrayList<>();

    static {
        musics.add(new Music(1L, "Music1", "Singer1", 188));
        musics.add(new Music(2L, "Music2", "Singer2", 189));
        musics.add(new Music(3L, "Music3", "Singer3", 168));
        musics.add(new Music(4L, "Music4", "Singer4", 192));
        musics.add(new Music(5L, "Music5", "Singer5", 230));
    }

    public static ArrayList<Music> getMusics() {
        return musics;
    }
}
