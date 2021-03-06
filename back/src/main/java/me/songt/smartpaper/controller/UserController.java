package me.songt.smartpaper.controller;

import me.songt.smartpaper.service.UserAuthService;
import me.songt.smartpaper.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tony on 2017/5/26.
 */
@RestController
public class UserController
{
    @Autowired
    private UserAuthService userAuthService;

    @PostMapping("/smartpaper/user/auth")
    public UserInfo auth(@RequestParam String username, @RequestParam String password)
    {
        return userAuthService.auth(username, password);
    }
}
