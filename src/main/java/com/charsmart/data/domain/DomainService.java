package com.charsmart.data.domain;

import com.charsmart.data.common.Result;

/**
 * @Author: Wonder
 * @Date: Created on 2021/12/17 上午11:30
 */
public interface DomainService {
    Result userInfo(String userName);

    Result saveUser(String userName, String phoneNum);
}
