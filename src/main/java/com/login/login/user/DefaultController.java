package com.login.login.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class DefaultController {
    private final UserService userService;

    @GetMapping("/'")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @GetMapping("/join")
    public String joinForm(Model model){
        model.addAttribute("form", new DBUserRequestAddDto());
        return "join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute DBUserRequestAddDto requestAddDto){
        Long savedId = userService.save(requestAddDto);

        return "redirect:/";
    }
}
