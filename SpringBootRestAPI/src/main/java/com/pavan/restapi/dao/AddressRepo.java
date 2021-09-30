package com.pavan.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pavan.restapi.model.Address;

@RepositoryRestResource
public interface AddressRepo extends JpaRepository<Address, Long>{

}
