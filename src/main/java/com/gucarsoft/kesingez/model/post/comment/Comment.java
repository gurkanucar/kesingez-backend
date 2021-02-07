package com.gucarsoft.kesingez.model.post.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gucarsoft.kesingez.model.BaseEntity;
import com.gucarsoft.kesingez.model.post.Post;
import com.gucarsoft.kesingez.model.user.User;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "comment")

public class Comment extends BaseEntity {

    @Column(name = "details")
    private String comment;

    @OneToOne
    private User user;

    private Long reportCount;

    @Column(name = "showStatus")
    private boolean show;

    @OneToOne
    Post post;

}
