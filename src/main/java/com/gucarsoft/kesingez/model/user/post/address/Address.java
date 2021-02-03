package com.gucarsoft.kesingez.model.user.post.address;

import com.gucarsoft.kesingez.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@Entity
@Where(clause = "deleted = false")
public class Address extends BaseEntity {

    @OneToOne
    private AddressDTO addressDto;
    private String detail;

    private double latitude;
    private double longitude;

    private String street;


}
