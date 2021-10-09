package com.IT.IT4409.repo;

import com.IT.IT4409.entity.JobPost;
import com.IT.IT4409.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Long>, JpaSpecificationExecutor<JobPost> {
    JobPost findByTitle(String title);
    JobPost findAllByAuthor(User author);
    List<JobPost> findByAuthorOrderByIdDesc(User author);
    JobPost findById(long id);
    void deleteById(long id);

    @Query("SELECT j From JobPost j WHERE j.title LIKE %:title%")
    List<JobPost> findByTitleLike(@Param("title") String title);

}
