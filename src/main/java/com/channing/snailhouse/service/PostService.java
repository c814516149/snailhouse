package com.channing.snailhouse.service;

import com.channing.snailhouse.bean.dto.PostDto;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
   PageInfo<PostDto> queryPostList(Page page);
}
