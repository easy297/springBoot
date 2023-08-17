package kz.test.easy297.controller;

import kz.test.easy297.db.Music;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value="/")
    public String indexPage(Model model) {
        ArrayList<Music> musicArray = DBManager.getMusics();
        model.addAttribute("musics", musicArray);
        return "index";
    }

    @GetMapping(value = "/about")
    public String aboutPage() {
        return "about";
    }
}
