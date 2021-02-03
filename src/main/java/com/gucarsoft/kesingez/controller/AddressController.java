package com.gucarsoft.kesingez.controller;

import com.gucarsoft.kesingez.model.user.post.address.AddressDTO;
import com.gucarsoft.kesingez.model.user.post.address.REGION;
import com.gucarsoft.kesingez.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController extends BaseController{

    @Autowired
    AddressService addressService;

    @GetMapping
    public ResponseEntity get() {
        return addressService.getAddress();
    }

    @GetMapping("/{id}")
    public ResponseEntity getByID(@PathVariable Long id) {
        return addressService.getAddressByID(id);
    }

    @GetMapping("/plate/{plate}")
    public ResponseEntity getByPlate(@PathVariable int plate) {
        return addressService.getByPlate(plate);
    }

    @GetMapping("/region/{region}")
    public ResponseEntity getByPlate(@PathVariable REGION region) {
        return addressService.getByRegion(region);
    }



    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity create(@RequestBody AddressDTO entity) {
        return addressService.createAddress(entity);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public ResponseEntity update(@RequestBody AddressDTO entity) {
        return addressService.updateAddress(entity);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return addressService.deleteAddress(id);
    }


}
