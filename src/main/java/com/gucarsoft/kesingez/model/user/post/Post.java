package com.gucarsoft.kesingez.model.user.post;

import com.gucarsoft.kesingez.model.BaseEntity;
import com.gucarsoft.kesingez.model.Image;
import com.gucarsoft.kesingez.model.user.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Post extends BaseEntity {

    @ManyToOne
    private User user;

    @OneToMany
    private List<Comment> commentList;

    private String detail;

    @OneToMany
    private List<Futures> futuresList;

    @OneToMany
    private List<Category> categoryList;

    @OneToMany
    private List<Image> imageList;

}
