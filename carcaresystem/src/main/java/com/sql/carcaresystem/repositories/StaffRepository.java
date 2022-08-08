package com.sql.carcaresystem.repositories;

import java.util.List;

import com.sql.carcaresystem.models.Staff;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StaffRepository extends CrudRepository<Staff, Integer> {

    @Query (value= "SELECT s FROM Staff s where s.branchID = ?1")
    List<Staff> getStaffListByBranch(Integer id);
    
}
