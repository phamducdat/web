package com.IT.IT4409.freelancer.service;

import com.IT.IT4409.entity.Proposal;

import java.util.List;

public interface ProposalService {

    public List<Proposal> indexByFreelancerId(Integer freelancerId);

    public Integer store(Double budget, String description, Integer freelancerId, long jobPostId, String timeRequirement);

    public void save(Proposal proposal);

    public List<Proposal> listProposal(Long id);
    
    public Proposal findProposal(Long id);

    public void saveProposal(Proposal proposal);
}
