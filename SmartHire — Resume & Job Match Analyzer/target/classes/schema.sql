-- Run once in MySQL Workbench or the mysql CLI
CREATE DATABASE IF NOT EXISTS smarthire_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE smarthire_db;

-- Optional: Hibernate (ddl-auto=update) creates this table for you automatically.
CREATE TABLE IF NOT EXISTS analyses (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  job_title VARCHAR(120) NOT NULL,
  resume_filename VARCHAR(255),
  matching_skills VARCHAR(1000),
  missing_skills VARCHAR(1000),
  extra_skills VARCHAR(1000),
  match_percentage DOUBLE NOT NULL,
  created_at DATETIME NOT NULL
);
-- Privacy: the resume file and job description text are NOT stored.
