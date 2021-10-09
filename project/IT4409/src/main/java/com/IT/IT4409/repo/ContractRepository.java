package com.IT.IT4409.repo;

import com.IT.IT4409.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("contractRepository")
public interface ContractRepository extends JpaRepository<Contract, Long> {

    @Query("SELECT contract FROM Contract contract WHERE contract.freelancerId = ?1")
    List<Contract> getAllByFreelancerId(long freelancerId);

//    List<Contract> getActiveByFreelancerId(long freelancerId);
}
