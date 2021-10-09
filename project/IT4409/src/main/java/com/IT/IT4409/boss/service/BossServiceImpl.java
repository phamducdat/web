package com.IT.IT4409.boss.service;

import com.IT.IT4409.entity.JobPost;
import com.IT.IT4409.entity.User;
import com.IT.IT4409.repo.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bossService")
public class BossServiceImpl implements BossService{
    @Autowired
    JobPostRepository jobPostRepository;

    @Override
    public void saveJobPost(JobPost jobPost) {
        jobPostRepository.save(jobPost);
    }

    @Override
    public List<JobPost> findJobByAuthor(User author) {
        return (List<JobPost>)jobPostRepository.findByAuthorOrderByIdDesc(author);
    }

    @Override
    public JobPost findById(Long id) {
        return jobPostRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteJobPost(long id) {
        jobPostRepository.deleteById(id);
    }

    @Override
    public List<JobPost> findJobByTitle(String keyword) {
        return this.jobPostRepository.findByTitleLike(keyword);
    }

    @Override
    public Page<JobPost> findAll(Specification<JobPost> spec, Pageable pageable) {
        return this.jobPostRepository.findAll(spec, pageable);
    }


}
