package com.hm.v2distributedapp.controller;

import com.hm.v2distributedapp.entity.form.UserForm;
import com.hm.v2distributedapp.service.MockService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/23 8:21
 */
@RestController
@RequestMapping("/mock")
@Slf4j
public class MockController {

    @Autowired
    MockService mockService;
    /**
     * 重复提交
     */
    @PostMapping(value = "/repeatSubmit")
    public void repeatSubmit (@RequestBody UserForm form) {
        mockService.addForm(form);
    }
}
