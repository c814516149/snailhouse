package com.channing.snailhouse.bean.dto;

import java.util.Date;

public class PostDto {
    private Integer postId;
    private Integer postAuthorId;
    private Date postDate;
    private Date postDateGMT;
    private String postContent;
    private String postTitle;
    private String postExcerpt;
    private Integer postStatus; //文章状态 1.公开，2.私密
    private Integer commentStatus; //评论状态 1.开放，2.关闭
    private String postPassword;
    private String postName;
    private Integer pingStatus; //是否允许转载 1.允许，2.不允许
    private Date postModified;
    private Date postModifiedGMT;
    private Integer postParent;
    private Integer menuOrder;
    private Integer postType; //文章类型 1.原创，2.转载
    private String postMimeType;
    private Integer commentCount;
    private Integer visitCount;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getPostAuthorId() {
        return postAuthorId;
    }

    public void setPostAuthorId(Integer postAuthorId) {
        this.postAuthorId = postAuthorId;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Date getPostDateGMT() {
        return postDateGMT;
    }

    public void setPostDateGMT(Date postDateGMT) {
        this.postDateGMT = postDateGMT;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostExcerpt() {
        return postExcerpt;
    }

    public void setPostExcerpt(String postExcerpt) {
        this.postExcerpt = postExcerpt;
    }

    public Integer getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(Integer postStatus) {
        this.postStatus = postStatus;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getPostPassword() {
        return postPassword;
    }

    public void setPostPassword(String postPassword) {
        this.postPassword = postPassword;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Integer getPingStatus() {
        return pingStatus;
    }

    public void setPingStatus(Integer pingStatus) {
        this.pingStatus = pingStatus;
    }

    public Date getPostModified() {
        return postModified;
    }

    public void setPostModified(Date postModified) {
        this.postModified = postModified;
    }

    public Date getPostModifiedGMT() {
        return postModifiedGMT;
    }

    public void setPostModifiedGMT(Date postModifiedGMT) {
        this.postModifiedGMT = postModifiedGMT;
    }

    public Integer getPostParent() {
        return postParent;
    }

    public void setPostParent(Integer postParent) {
        this.postParent = postParent;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public Integer getPostType() {
        return postType;
    }

    public void setPostType(Integer postType) {
        this.postType = postType;
    }

    public String getPostMimeType() {
        return postMimeType;
    }

    public void setPostMimeType(String postMimeType) {
        this.postMimeType = postMimeType;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }
}
