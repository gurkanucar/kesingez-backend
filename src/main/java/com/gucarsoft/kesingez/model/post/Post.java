package com.gucarsoft.kesingez.model.post;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gucarsoft.kesingez.model.BaseEntity;
import com.gucarsoft.kesingez.model.Image;
import com.gucarsoft.kesingez.model.address.Address;
import com.gucarsoft.kesingez.model.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Post extends BaseEntity {

    @ManyToOne
    private User user;

    private String detail;

    @OneToMany
    private List<Futures> futuresList;

    @OneToMany
    private List<Category> categoryList;

    @OneToMany
    private List<Image> imageList;

    private Long reportCount;

    @OneToOne
    private Address address;

    @Column(name = "showStatus")
    private boolean show;

    @Column(name = "likeCount")
    private Long likeCount;

}
