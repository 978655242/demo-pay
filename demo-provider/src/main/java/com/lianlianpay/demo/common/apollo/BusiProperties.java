package com.lianlianpay.demo.common.apollo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @ClassName: BusiProperties
 * @Description: apollo配置
 * @Author: lihp
 * @Date: 2021/6/17 9:52
 **/
@Data
@Component
@ConfigurationProperties(prefix = "busidemo")
@RefreshScope
public class BusiProperties {

    /**
     * 查询url
     */
    private String queryUrl = "https://www.baidu.com/query";


}
