package com.example.board.controller;


import com.example.board.service.UserService;
import com.example.board.vo.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.board.dto.UserDto;

import java.util.List;

@Controller
@AllArgsConstructor
public class JoinController {
    private final UserService userService;

    @GetMapping("/user/join")
    public String joinMain() {
        return "user/join";
    }

    @PostMapping("/user/join")
    public String createUser(UserDto memberDto) {
        userService.createMember(memberDto.toEntity());
        return "redirect:/";
    }

    @GetMapping("/user/list")
    public String userList(Model model) {
        List<User> users = userService.getUserList();
        model.addAttribute("users", users);
        return "user/list";
    }
}
