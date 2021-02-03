package com.gucarsoft.kesingez.model.user.post;


import com.gucarsoft.kesingez.model.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Category extends BaseEntity {

    private String name;

}
