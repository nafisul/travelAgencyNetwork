package com.bs23.travelagencynetwork.dto;

import java.util.Date;

public class StatusDTO {
    private Long postId;
    private String post;
    private String location;
    private int postPrivacy;
    private Date postedAt;
    private String userName;

    public StatusDTO(){}

    public StatusDTO(Long postId, String post, String location, int postPrivacy, Date postedAt) {
        this.postId = postId;
        this.post = post;
        this.location = location;
        this.postPrivacy = postPrivacy;
        this.postedAt = postedAt;
    }

    public StatusDTO(Long postId, String post, String location, int postPrivacy) {
        this.postId = postId;
        this.post = post;
        this.location = location;
        this.postPrivacy = postPrivacy;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPostPrivacy() {
        return postPrivacy;
    }

    public void setPostPrivacy(int postPrivacy) {
        this.postPrivacy = postPrivacy;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
