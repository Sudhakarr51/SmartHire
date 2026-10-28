package com.smarthire.util;

import com.smarthire.dto.ScoreResult;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * Transparent rule: score = (job skills found in resume / total job skills) x 100.
 * Extra resume skills are shown but do not change the score.
 */
@Component
public class ScoreCalculator {

    public ScoreResult calculate(Set<String> resumeSkills, Set<String> jobSkills) {
        List<String> matching = new ArrayList<>();
        List<String> missing = new ArrayList<>();
        for (String skill : jobSkills) {
            if (resumeSkills.contains(skill)) matching.add(skill); else missing.add(skill);
        }
        List<String> extra = new ArrayList<>();
        for (String skill : resumeSkills) {
            if (!jobSkills.contains(skill)) extra.add(skill);
        }
        double percentage = jobSkills.isEmpty() ? 0.0
                : Math.round(matching.size() * 1000.0 / jobSkills.size()) / 10.0;
        return new ScoreResult(matching, missing, extra, percentage);
    }
}
