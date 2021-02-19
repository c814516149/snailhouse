package com.channing.snailhouse.service;

import com.channing.snailhouse.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactory {

    @Autowired
    private PostServiceImpl postService;

    public PostService getPostService() {
        return  postService;
    }
}
