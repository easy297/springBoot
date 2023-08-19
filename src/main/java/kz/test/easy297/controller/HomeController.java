package kz.test.easy297.controller;

import kz.test.easy297.db.Music;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value="/")
    public String indexPage(Model model) {
        ArrayList<Music> musicArray = DBManager.getMusics();
        model.addAttribute("musics", musicArray);
        return "index";
    }

    @PostMapping(value = "/add-music")
    public String addMusic(Music music) {
        DBManager.addMusic(music);
        return "redirect:/"; // response.sendRedirect("/")
    }
//    @PostMapping(value = "/add-music-v2")
//    public String addMusicV2(
//        @RequestParam(name = "music-name") String name,
//        @RequestParam(name = "music-author") String author,
//        @RequestParam(name = "music-duration") int duration
//    ){
//        Music music = new Music();
//        music.setName(name);
//        music.setAuthor(author);
//        music.setDuration(duration);
//        DBManager.addMusic(music);
//        return "redirect:/"; // response.sendRedirect("/")
//    }

    @GetMapping(value = "/music-details")
    public String getMusic(@RequestParam(name = "musicId") int id,
                           Model model){
        Music music = DBManager.getMusic(id);
        model.addAttribute("song", music);
        return "details";
    }

    @GetMapping(value = "/add-music")
    public String addMusicPage(Model model) {
        return "addMusic";
    }

    @GetMapping(value = "/details/{musicId}")
    public String musicDetails(@PathVariable(name = "musicId") int id,
                               Model model) {
        Music music = DBManager.getMusic(id);
        model.addAttribute("song", music);
        return "details";
    }

}
