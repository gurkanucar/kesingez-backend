package com.gucarsoft.kesingez.model;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
@Where(clause = "deleted = false")
public class Image extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 3557442030704173228L;

    private String name;
    private String url;

    
}
