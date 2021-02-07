package com.gucarsoft.kesingez.service;

import com.gucarsoft.kesingez.model.address.AddressDTO;
import com.gucarsoft.kesingez.model.address.Region;
import com.gucarsoft.kesingez.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService {

    @Autowired
    AddressRepository repository;

    public ResponseEntity getAddress() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity getAddressByID(Long id) {
        return new ResponseEntity<>(repository.findById(id),HttpStatus.OK);
    }

    public ResponseEntity getByPlate(int plate) {
        return new ResponseEntity<>(repository.findAllByPlate(plate),HttpStatus.OK);
    }

    public ResponseEntity getByRegion(Region region) {
        return new ResponseEntity<>(repository.findAllByRegion(region.toString()),HttpStatus.OK);
    }


    public ResponseEntity createAddress(AddressDTO entity) {
        return new ResponseEntity<>(repository.save(entity), HttpStatus.OK);
    }

    public ResponseEntity updateAddress(AddressDTO entity) {
        AddressDTO addressDto = repository.findById(entity.getId()).get();
        addressDto.setCountryName(entity.getCountryName());
        addressDto.setCityName(entity.getCityName());
        addressDto.setDistrictName(entity.getDistrictName());
        addressDto.setPlate(entity.getPlate());
        addressDto.setRegion(entity.getRegion());
        return new ResponseEntity<>(repository.save(entity), HttpStatus.OK);
    }

    public ResponseEntity deleteAddress(Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
