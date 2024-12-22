package com.hm.v2distributedapp.service.impl;

import com.hm.v2distributedapp.annotation.DistributedLock;
import com.hm.v2distributedapp.constant.CacheConstant;
import com.hm.v2distributedapp.entity.form.UserForm;
import com.hm.v2distributedapp.service.MockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: lyflexi
 * @project: springboot-practice
 * @Date: 2024/11/20 11:10
 */
@Service
@Slf4j
public class MockServiceImpl implements MockService {
    @Override
    @DistributedLock(method = CacheConstant.ADD_FORM, uniqueKey = "#form.name")
    public void addForm(UserForm form) {
        log.info("current form:{}",form);
    }
}
