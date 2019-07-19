package com.bs23.travelagencynetwork.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "status_id")
    private int id;

    @Column(name = "user_status")
    private String post;

    @Column(name = "status_privacy")
    private int postPrivacy;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "posted_at")
    private Date postedAt = new Date();

    public Status(){}

    public Status(String post, int postPrivacy, User user, Location location, Date postedAt) {
        this.post = post;
        this.postPrivacy = postPrivacy;
        this.user = user;
        this.location = location;
        this.postedAt = postedAt;
    }

    public Status(String post, int postPrivacy, User user) {
        this.post = post;
        this.postPrivacy = postPrivacy;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getPostPrivacy() {
        return postPrivacy;
    }

    public void setPostPrivacy(int postPrivacy) {
        this.postPrivacy = postPrivacy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }
}
