package com.IT.IT4409.freelancer.service;

import com.IT.IT4409.entity.JobPost;
import com.IT.IT4409.repo.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    JobPostRepository jobPostRepository;

    @Override
    public JobPost findById(long id) {
        return jobPostRepository.findById(id);
    }
}
