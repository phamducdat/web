package com.IT.IT4409.freelancer.service;

import com.IT.IT4409.entity.Contract;

import java.util.List;

public interface ContractService {
    public List<Contract> getFreelancerContracts(long freelancerId);
    public void createContract(Contract contract);
}
