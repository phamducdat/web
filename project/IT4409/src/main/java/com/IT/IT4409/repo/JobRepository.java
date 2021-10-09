package com.IT.IT4409.repo;

import com.IT.IT4409.entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jobRepository")
public interface JobRepository extends JpaRepository<JobPost, Integer> {

    @Override
    Optional<JobPost> findById(Integer id);

    @Override
    List<JobPost> findAll();

    // Find user who post job

    // Count number of proposals

    // Get list of skills need for job

}
