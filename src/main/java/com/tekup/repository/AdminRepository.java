package com.tekup.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tekup.models.Admin;


@Repository

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    
}
