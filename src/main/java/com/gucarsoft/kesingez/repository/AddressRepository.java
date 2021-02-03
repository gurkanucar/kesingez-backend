package com.gucarsoft.kesingez.repository;

import com.gucarsoft.kesingez.model.user.post.address.AddressDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends BaseRepository<AddressDTO, Long> {

    List<AddressDTO> findAllByRegion(String region);

    List<AddressDTO> findAllByPlate(int plate);

}
