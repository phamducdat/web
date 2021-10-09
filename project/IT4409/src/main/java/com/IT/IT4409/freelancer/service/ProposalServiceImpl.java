package com.IT.IT4409.freelancer.service;

import com.IT.IT4409.entity.Proposal;
import com.IT.IT4409.repo.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalServiceImpl implements ProposalService {

    @Autowired
    private ProposalRepository proposalRepository;

    @Override
    public List<Proposal> indexByFreelancerId(Integer freelancerId) {
        return proposalRepository.indexByFreelancerId(freelancerId);
    }

    @Override
    public Integer store(Double budget, String description, Integer freelancerId, long jobPostId, String timeRequirement) {
        return proposalRepository.insertProposal(budget, description, freelancerId, jobPostId, false, timeRequirement);
    }

    @Override
    public void save(Proposal proposal) {
        proposalRepository.save(proposal);
    }

    @Override
    public List<Proposal> listProposal(Long id) {
        return (List<Proposal>) proposalRepository.findProposalByJobPostId(id);
    }

    @Override
    public Proposal findProposal(Long id) {
        return proposalRepository.findProposalById(id);
    }

    @Override
    public void saveProposal(Proposal proposal) {
        proposalRepository.save(proposal);
    }
}
