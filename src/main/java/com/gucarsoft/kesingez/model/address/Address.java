package com.gucarsoft.kesingez.model.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gucarsoft.kesingez.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@Entity
@Where(clause = "deleted = false")
@JsonIgnoreProperties(value = {"createdBy", "created", "modifiedBy", "modified"},
        allowSetters = true)
public class Address extends BaseEntity {

    @OneToOne
    private AddressDTO addressDTO;
    private String detail;

    private double latitude;
    private double longitude;


}
