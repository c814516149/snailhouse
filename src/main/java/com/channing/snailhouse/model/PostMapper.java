package com.channing.snailhouse.model;

import com.channing.snailhouse.bean.dto.PostDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PostMapper {
    List<PostDto> queryPostList();
}
