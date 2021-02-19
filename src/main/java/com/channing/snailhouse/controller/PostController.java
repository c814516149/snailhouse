package com.channing.snailhouse.controller;

import com.channing.snailhouse.bean.Result;
import com.channing.snailhouse.bean.dto.PostDto;
import com.channing.snailhouse.service.PostService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="${version}")
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping(value = "/getPostList", method = RequestMethod.POST)
    public Result<PageInfo<PostDto>> getPostList( @RequestParam int pageNo,
                                             @RequestParam int pageSize ) {
        Page page = new Page();
        page.setPageNum(pageNo);
        page.setPageSize(pageSize);
        PageInfo<PostDto> pageInfo = postService.queryPostList(page);
        return new Result<>(pageInfo);
    }

}
