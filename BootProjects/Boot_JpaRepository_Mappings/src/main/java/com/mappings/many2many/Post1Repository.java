package com.mappings.many2many;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Post1Repository extends JpaRepository<Post1, Long> {

}
