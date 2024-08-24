package com.st.Jobposting.service;

import com.st.Jobposting.model.JobPosting;
import com.st.Jobposting.repository.JobPostingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPostingService {

    @Autowired
    private JobPostingRepository jobPostingRepository;

    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.findAll();
    }

    public Optional<JobPosting> getJobPostingById(Long id) {
        return jobPostingRepository.findById(id);
    }

    public JobPosting createJobPosting(JobPosting jobPosting) {
        return jobPostingRepository.save(jobPosting);
    }

    public JobPosting updateJobPosting(Long id, JobPosting jobPosting) {
        jobPosting.setId(id);
        return jobPostingRepository.save(jobPosting);
    }

    public void deleteJobPosting(Long id) {
        jobPostingRepository.deleteById(id);
    }

    public List<JobPosting> searchJobPostings(String title, String location, String requiredSkills) {
        return jobPostingRepository.findByTitleContainingIgnoreCaseOrLocationContainingIgnoreCaseOrRequiredSkillsContainingIgnoreCase(
            title, location, requiredSkills);
    }
}
