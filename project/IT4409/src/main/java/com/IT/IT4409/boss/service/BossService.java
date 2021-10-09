package com.IT.IT4409.boss.service;

import com.IT.IT4409.entity.JobPost;
import com.IT.IT4409.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface BossService {
    public void saveJobPost(JobPost jobPost);
    public List<JobPost> findJobByAuthor(User author);
    public JobPost findById(Long id);
    public void deleteJobPost(long id);
    public List<JobPost> findJobByTitle(String keyword);
    public Page<JobPost> findAll(Specification<JobPost> spec, Pageable pageable);

}
