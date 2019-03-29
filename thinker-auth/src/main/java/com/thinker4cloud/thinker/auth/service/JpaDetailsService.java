package com.thinker4cloud.thinker.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.thinker4cloud.thinker.auth.entity.SysUser;
import com.thinker4cloud.thinker.auth.repository.SysUserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class JpaDetailsService implements UserDetailsService {

    private final SysUserRepository sysUserRepository;

    @Autowired
    public JpaDetailsService(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<SysUser> sysUser = sysUserRepository.findSysUserByUsername(username);

        return sysUser.map(it -> {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            return new User(it.getUsername(), it.getPassword(), grantedAuthorities);
        }).orElseThrow(() -> new UsernameNotFoundException("用户" + username + "不存在!"));
    }
}
