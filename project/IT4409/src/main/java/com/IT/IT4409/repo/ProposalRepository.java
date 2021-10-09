package com.IT.IT4409.repo;

import com.IT.IT4409.entity.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository()
public interface ProposalRepository extends JpaRepository<Proposal, Long> {

    /**
     * Query list of proposals for freelancer
     *
     * @param freelancerId
     * @return List<Proposal>
     */
    @Query("SELECT p FROM Proposal p WHERE p.freelancer.id = ?1")
    public List<Proposal> indexByFreelancerId(Integer freelancerId);

    /**
     * Insert new proposal
     *
     * @param budget
     * @param description
     * @param freelancerId
     * @param jobPostId
     * @param timeRequirement
     * @return Integer
     */
    @Modifying
    @Query(value = "insert into proposals (budget, description, freelancer_id, job_post_id, status, time_requirement) values (:budget, :description, :freelancer_id, :job_post_id, :status, :time_requirement)", nativeQuery = true)
    @Transactional
    public Integer insertProposal(@Param("budget") Double budget, @Param("description") String description, @Param("freelancer_id") Integer freelancerId, @Param("job_post_id") long jobPostId, @Param("status") boolean status, @Param("time_requirement") String timeRequirement);

    public List<Proposal> findProposalByJobPostId(long id);

    public Proposal findProposalById(long id);
}
