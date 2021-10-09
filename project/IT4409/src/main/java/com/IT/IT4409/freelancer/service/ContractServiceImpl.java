package com.IT.IT4409.freelancer.service;

import com.IT.IT4409.entity.Contract;
import com.IT.IT4409.repo.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService{

    @Autowired
    private ContractRepository contractRepository;

    /**
     * Get all contracts of freelancer
     * @param freelancerId
     * @return
     */
    public List<Contract> getFreelancerContracts(long freelancerId){
        return contractRepository.getAllByFreelancerId(freelancerId);
    }

    @Override
    public void createContract(Contract contract) {
        contractRepository.save(contract);
    }
}
