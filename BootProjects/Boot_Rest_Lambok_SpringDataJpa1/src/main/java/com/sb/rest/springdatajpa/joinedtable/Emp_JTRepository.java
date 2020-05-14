package com.sb.rest.springdatajpa.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Emp_JTRepository extends JpaRepository<Emp_JT, Long> {

}

