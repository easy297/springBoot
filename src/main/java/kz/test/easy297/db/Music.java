package kz.test.easy297.db;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    private Long id;
    private String name;
    private String author;
    private int duration;
}
