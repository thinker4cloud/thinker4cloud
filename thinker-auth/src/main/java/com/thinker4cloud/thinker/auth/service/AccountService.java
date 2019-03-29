package com.thinker4cloud.thinker.auth.service;

import com.thinker4cloud.thinker.auth.exception.UsernameExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.thinker4cloud.thinker.auth.entity.SysUser;
import com.thinker4cloud.thinker.auth.repository.SysUserRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * Created by dev@panjunye.com on 2019/03/29.
 */

@Service
public class AccountService {

    private final SysUserRepository sysUserRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountService(SysUserRepository sysUserRepository, PasswordEncoder passwordEncoder) {
        this.sysUserRepository = sysUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public SysUser createUserByUsername(@NotNull String username, @NotNull String password) {
        Optional<SysUser> sysUserOptional = sysUserRepository.findSysUserByUsername(username);
        if (sysUserOptional.isPresent()) {
            throw new UsernameExistException(username);
        }
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser.setPassword(passwordEncoder.encode(password));

        return sysUserRepository.save(sysUser);
    }
}
