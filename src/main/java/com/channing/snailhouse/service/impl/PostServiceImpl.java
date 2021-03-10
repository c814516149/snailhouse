package com.channing.snailhouse.service.impl;

import com.channing.snailhouse.bean.dto.PostDto;
import com.channing.snailhouse.model.PostMapper;
import com.channing.snailhouse.service.PostService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostMapper postMapper;

    @Autowired
    public void setPostMapper(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public PageInfo<PostDto> queryPostList(Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<PostDto> postDtos = postMapper.queryPostList();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setList(postDtos);
        pageInfo.setPageNum(page.getPageNum());
        pageInfo.setPageSize(page.getPageSize());
        return pageInfo;
    }
}
