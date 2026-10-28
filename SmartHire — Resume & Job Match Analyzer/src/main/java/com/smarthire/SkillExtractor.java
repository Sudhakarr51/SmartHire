package com.smarthire.util;

import org.springframework.stereotype.Component;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Finds known skills in text using whole-word matching.
 * To add a skill, add one line to SKILLS: canonical name -> aliases.
 */
@Component
public class SkillExtractor {

    private static final Map<String, List<String>> SKILLS = new LinkedHashMap<>();
    static {
        SKILLS.put("Java", List.of("java"));
        SKILLS.put("Spring Boot", List.of("spring boot", "springboot"));
        SKILLS.put("SQL", List.of("sql"));
        SKILLS.put("MySQL", List.of("mysql"));
        SKILLS.put("HTML", List.of("html", "html5"));
        SKILLS.put("CSS", List.of("css", "css3"));
        SKILLS.put("JavaScript", List.of("javascript", "js"));
        SKILLS.put("Git", List.of("git", "github"));
        SKILLS.put("REST APIs", List.of("rest api", "rest apis", "restful", "rest"));
        SKILLS.put("Problem Solving", List.of("problem solving", "problem-solving"));
        SKILLS.put("Python", List.of("python"));
        SKILLS.put("Hibernate", List.of("hibernate", "jpa"));
        SKILLS.put("Maven", List.of("maven"));
        SKILLS.put("JUnit", List.of("junit"));
        SKILLS.put("Docker", List.of("docker"));
        SKILLS.put("Data Structures", List.of("data structures", "dsa"));
    }

    /** Returns canonical skill names found in the text, in catalog order. */
    public Set<String> extract(String text) {
        Set<String> found = new LinkedHashSet<>();
        if (text == null || text.isBlank()) return found;
        String lower = text.toLowerCase(Locale.ROOT);
        for (Map.Entry<String, List<String>> entry : SKILLS.entrySet()) {
            for (String alias : entry.getValue()) {
                // The two lookaround parts make sure "java" does not match inside "javascript"
                Pattern p = Pattern.compile("(?<![a-z0-9])" + Pattern.quote(alias) + "(?![a-z0-9])");
                if (p.matcher(lower).find()) { found.add(entry.getKey()); break; }
            }
        }
        return found;
    }
}
