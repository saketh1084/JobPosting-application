package com.st.Jobposting.controller;

import com.st.Jobposting.model.JobPosting;
import com.st.Jobposting.service.JobPostingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/job-postings")
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;

    @GetMapping
    public List<JobPosting> getAllJobPostings() {
        return jobPostingService.getAllJobPostings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPosting> getJobPostingById(@PathVariable Long id) {
        Optional<JobPosting> jobPosting = jobPostingService.getJobPostingById(id);
        return jobPosting.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<JobPosting> createJobPosting(@RequestBody JobPosting jobPosting) {
        JobPosting createdJobPosting = jobPostingService.createJobPosting(jobPosting);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJobPosting);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPosting> updateJobPosting(@PathVariable Long id, @RequestBody JobPosting jobPosting) {
        JobPosting updatedJobPosting = jobPostingService.updateJobPosting(id, jobPosting);
        return ResponseEntity.ok(updatedJobPosting);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobPosting(@PathVariable Long id) {
        jobPostingService.deleteJobPosting(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<JobPosting> searchJobPostings(
        @RequestParam(required = false) String title,
        @RequestParam(required = false) String location,
        @RequestParam(required = false) String requiredSkills) {
        return jobPostingService.searchJobPostings(title, location, requiredSkills);
    }
}
