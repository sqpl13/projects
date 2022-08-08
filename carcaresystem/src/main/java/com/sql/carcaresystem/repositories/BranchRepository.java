package com.sql.carcaresystem.repositories;

import java.util.List;

import com.sql.carcaresystem.models.Branch;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BranchRepository extends CrudRepository<Branch, Integer> {
    
    @Query (value = "SELECT * FROM branch ORDER by branchName", nativeQuery = true)
    List<Branch> sortBranchByName();

    @Query (value = "SELECT * FROM branch ORDER by branchName='Main' desc, branchName asc", nativeQuery = true)
    List<Branch> sortBranchByNameMainFirst();
}
