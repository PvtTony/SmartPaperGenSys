package me.songt.smartpaper.service.impl;

import me.songt.smartpaper.po.User;
import me.songt.smartpaper.po.UserRole;
import me.songt.smartpaper.repository.UserRepository;
import me.songt.smartpaper.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 2017/3/27.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService
{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userRepository.findByuserName(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user == null)
        {
            throw new UsernameNotFoundException("Username not found.");
        }
        authorities.add(new SimpleGrantedAuthority(userRoleRepository.findByroleId(user.getUserRoleId()).getRoleName()));
        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getUserPassword(), authorities);
    }
}
