package com.mappings.inheritance_mappings.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee_TPCRepository extends JpaRepository<Employee_TPC, Long> {

}
