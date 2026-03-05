/**
 * Copyright (c) 2013-2017 All Rights Reserved.
 */
package com.tups;

import com.tups.mpay.common.utils.TraceUtil;
import com.lianpay.framework.core.test.DefaultSpringJUnitRunner;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.UUID;

/**
 * 测试配置
 * 
 * @author wuliang
 * @version $Id: TestSupport.java, v 0.1 2018年11月5日 上午11:12:16 wuliang Exp $
 */
@RunWith(DefaultSpringJUnitRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Commit
@WebAppConfiguration
public class TestSupport {

    static {
        TraceUtil.setCorrelationID(UUID.randomUUID().toString());
    }

}
