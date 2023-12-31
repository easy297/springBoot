package kz.test.easy297.controller;

import kz.test.easy297.db.Music;
import kz.test.easy297.dbconnect.MusicManager;
import kz.test.easy297.model.MusicModel;
import kz.test.easy297.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private MusicManager manager;

    @Autowired
    private MusicRepository musicRepository;
    @GetMapping(value="/")
    public String indexPage(Model model) {
//        List<MusicModel> musicModelList = musicRepository.findAll();
        List<MusicModel> musicModelList = musicRepository.findAllByDurationGreaterThan(0);
        model.addAttribute("musics", musicModelList);
        return "index";
    }

    @PostMapping(value = "/add-music")
    public String addMusic(MusicModel music) {
        musicRepository.save(music);
        return "redirect:/"; // response.sendRedirect("/")
    }
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
    public String musicDetails(@PathVariable(name = "musicId") Long id,
                               Model model) {
        MusicModel music = musicRepository.findById(id).orElse(null);
        model.addAttribute("song", music);
        return "details";
    }

    @PostMapping(value = "/save-music")
    public String saveMusic(MusicModel music){
        musicRepository.save(music);
        return "redirect:/";
    }

    @PostMapping(value = "/delete-music")
    public String deleteMusic(@RequestParam(name = "id") Long id){
        musicRepository.deleteById(id);
        return "redirect:/";
    }

}
