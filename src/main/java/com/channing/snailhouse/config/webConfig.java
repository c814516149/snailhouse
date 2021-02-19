package com.channing.snailhouse.config;

import com.channing.snailhouse.service.PostService;
import com.channing.snailhouse.service.ServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Service;

@Configuration
public class webConfig {

    @Autowired
    private ServiceFactory serviceFactory;

    @Bean
    public PostService postService() {
        return serviceFactory.getPostService();
    }
}
