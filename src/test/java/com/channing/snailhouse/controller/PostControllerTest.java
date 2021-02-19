package com.channing.snailhouse.controller;

import com.channing.snailhouse.service.PostService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class PostControllerTest {

    @Autowired
    PostService postService;

    @Test
    void testGetPostList() {
        Page page = new Page();
        page.setPageNum(0);
        page.setPageSize(1);
        PageInfo pageInfo = postService.queryPostList(page);
        PageInfo assertPageInfo = new PageInfo();
        assertPageInfo.setPageSize(1);
        assertPageInfo.setPageNum(0);
    }
}
