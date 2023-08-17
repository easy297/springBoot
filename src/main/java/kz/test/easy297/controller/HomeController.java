package kz.test.easy297.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value="/")
    public String indexPage() {
        return "index";
    }

    @GetMapping(value = "/about")
    public String aboutPage() {
        return "about";
    }
}
