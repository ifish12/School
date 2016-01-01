package com.cs616;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "user")
/**
 * Created by 1345356 on 2015-11-24.
 */
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="userid")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="imageurl")
    private String imageUrl;


    @Column(name="usertype")
    private UserType userType;


    @OneToMany(mappedBy = "assignedTo", targetEntity = Defect.class)
    private List<Defect> assigned;

    @OneToMany(mappedBy = "createdBy", targetEntity = Defect.class)
    private List<Defect> created;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imgUrl) {
        this.imageUrl = imgUrl;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<Defect> getAssigned() {
        return assigned;
    }

    public void setAssigned(List<Defect> assigned) {
        this.assigned = assigned;
    }

    public List<Defect> getCreated() {
        return created;
    }

    public void setCreated(List<Defect> created) {
        this.created = created;
    }
}
