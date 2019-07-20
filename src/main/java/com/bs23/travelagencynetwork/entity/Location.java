package com.bs23.travelagencynetwork.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location_id")
    private Long id;

    @Column(name = "location_name")
    private String location;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private Set<Status> statuses;

    public Location(){}

    public Location(String location, Set<Status> statuses) {
        this.location = location;
        this.statuses = statuses;
    }

    public Location(String location) {
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(Set<Status> statuses) {
        this.statuses = statuses;
    }
}

