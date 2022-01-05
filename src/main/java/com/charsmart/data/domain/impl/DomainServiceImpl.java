package com.charsmart.data.domain.impl;

import com.charsmart.data.common.Result;
import com.charsmart.data.config.RemoteConfig;
import com.charsmart.data.config.RemoteServiceConfig;
import com.charsmart.data.domain.DomainService;
import com.charsmart.data.entity.SysUser;
import com.charsmart.data.mapper.SysUserMapper;
import com.charsmart.data.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Author: Wonder
 * @Date: Created on 2021/12/17 上午11:31
 */
@Service
public class DomainServiceImpl implements DomainService {
    private SysUserService userService;
    private final RemoteConfig remoteConfig;

    private final SysUserMapper userMapper;

    public DomainServiceImpl(SysUserService userService, RemoteConfig remoteConfig, SysUserMapper userMapper) {
        this.userService = userService;
        this.remoteConfig = remoteConfig;
        this.userMapper = userMapper;
    }

    @Override
    public Result userInfo(String userName) {
        Optional<SysUser> sysUser = userService.query().eq(SysUser.USER_NAME, userName).oneOpt();
        RemoteServiceConfig service = remoteConfig.getService();
        Stream<String> StringStream = Stream.of("hello", "biu");
        if (sysUser.isPresent()) {
            return Result.success(sysUser);
        }
        return Result.success();
    }

    @Override
    @Transactional
    public Result saveUser(String userName, String phoneNum) {
        SysUser sysUser = new SysUser().setUserName(userName).setTelephone(phoneNum).setUserId("1")
                .setCreateBy("1").setCreateDate(LocalDateTime.now());
        userService.save(sysUser);
        SysUser sysUser2 = new SysUser().setUserName(userName).setTelephone(phoneNum);
        userService.save(sysUser2);
        return Result.success();
    }
}
