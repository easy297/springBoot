package kz.test.easy297.model;

import jakarta.persistence.*;
import lombok.Data;
@Data

@Entity
@Table(name = "t_musics")
public class MusicModel {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    @Column(name = "id") // column name
    private Long id;

    @Column(name = "music_name")
    private String name;

    @Column(name = "duration")
    private int duration;

    @Column(name = "author")
    private String author;
}
