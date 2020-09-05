package com.jm.sign.controller;


import com.jm.sign.config.JwtProvider;
import com.jm.sign.dto.JoinDto;
import com.jm.sign.dto.LoginDto;
import com.jm.sign.service.UserService;
import com.jm.sign.vo.DefaultRes;
import com.jm.sign.vo.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user/*")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private JwtProvider jwtProvider;

    @PostMapping("/join")
    @ResponseBody
    public ResponseEntity join(@RequestBody JoinDto joinDto) {
        try {
            return new ResponseEntity<>(userService.join(joinDto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new DefaultRes(500, "INTERNAL SERVER ERR"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity login(@RequestBody LoginDto loginDto) {
        try {
            DefaultRes res = userService.login(loginDto);
            if (res.getStatus() == 200) {
                User user = (User)res.getData();
                String token = jwtProvider.createToken(user.getUid().toString(), user.getRoles());
                res.setData(token);
            }
            return new ResponseEntity(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new DefaultRes(500, "Internal ServerERR"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
