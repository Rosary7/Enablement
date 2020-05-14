package com.sb.rest.springdatajpa.embeddable_composite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateContractorRepository extends JpaRepository<CreateContractor, Long> {

}
