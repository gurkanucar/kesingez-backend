package com.gucarsoft.kesingez.model.user.post;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gucarsoft.kesingez.model.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@JsonIgnoreProperties(value = {"createdBy", "created", "modifiedBy", "modified"},
        allowSetters = true)
@Data
@Entity
public class AddressDTO extends BaseEntity {

    private String countryName;
    private String cityName;
    private String districtName;
    private int plate;

}
