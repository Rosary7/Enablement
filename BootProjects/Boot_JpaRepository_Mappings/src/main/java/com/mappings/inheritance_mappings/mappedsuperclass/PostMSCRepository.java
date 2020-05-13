package com.mappings.inheritancemappings.mappedsuperclass;

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMSCRepository extends JpaRepository<PostMSC, Long> {

}

