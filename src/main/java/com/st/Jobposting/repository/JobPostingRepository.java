
package com.st.Jobposting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.Jobposting.model.JobPosting;

import java.util.List;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    List<JobPosting> findByTitleContainingIgnoreCaseOrLocationContainingIgnoreCaseOrRequiredSkillsContainingIgnoreCase(
        String title, String location, String requiredSkills);
}
