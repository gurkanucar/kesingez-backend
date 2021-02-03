package com.gucarsoft.kesingez.model.user.post;

import com.gucarsoft.kesingez.model.BaseEntity;
import com.gucarsoft.kesingez.model.user.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {
    @OneToOne
    private User user;

    private int reportCount;

    private boolean show;

}
