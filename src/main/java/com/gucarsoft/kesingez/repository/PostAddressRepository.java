package com.gucarsoft.kesingez.repository;

import com.gucarsoft.kesingez.model.address.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostAddressRepository extends BaseRepository<Address, Long> {

}
