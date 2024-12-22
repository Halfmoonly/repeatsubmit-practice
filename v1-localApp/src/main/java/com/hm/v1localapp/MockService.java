package com.hm.v1localapp;

import com.hm.v1localapp.annotation.SemaphoreDoc;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Halfmoonly
 * @project: repeatsubmit-practice
 * @Date: 2024/12/22 12:36
 */
@Service
public class MockService {
    @SemaphoreDoc(key = "test", limit = 2, blockingTime = 5)
    public String doSomething(String param) {
        // 模拟业务逻辑
        return "Executed with parameter: " + param;
    }
}
