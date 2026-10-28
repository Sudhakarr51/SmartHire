package com.smarthire.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/** One saved analysis. Skills are stored as comma-separated text for simplicity. */
@Entity
@Table(name = "analyses")
public class Analysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String jobTitle;

    @Column(length = 255)
    private String resumeFilename;

    @Column(length = 1000)
    private String matchingSkills;

    @Column(length = 1000)
    private String missingSkills;

    @Column(length = 1000)
    private String extraSkills;

    @Column(nullable = false)
    private double matchPercentage;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() { this.createdAt = LocalDateTime.now(); }

    public Long getId() { return id; }
    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
    public String getResumeFilename() { return resumeFilename; }
    public void setResumeFilename(String resumeFilename) { this.resumeFilename = resumeFilename; }
    public String getMatchingSkills() { return matchingSkills; }
    public void setMatchingSkills(String matchingSkills) { this.matchingSkills = matchingSkills; }
    public String getMissingSkills() { return missingSkills; }
    public void setMissingSkills(String missingSkills) { this.missingSkills = missingSkills; }
    public String getExtraSkills() { return extraSkills; }
    public void setExtraSkills(String extraSkills) { this.extraSkills = extraSkills; }
    public double getMatchPercentage() { return matchPercentage; }
    public void setMatchPercentage(double matchPercentage) { this.matchPercentage = matchPercentage; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
