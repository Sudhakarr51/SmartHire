package com.smarthire.repository;

import com.smarthire.entity.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/** Spring Data JPA writes the SQL for us (always parameterized, so safe from SQL injection). */
public interface AnalysisRepository extends JpaRepository<Analysis, Long> {
    List<Analysis> findTop5ByOrderByCreatedAtDesc();
}
