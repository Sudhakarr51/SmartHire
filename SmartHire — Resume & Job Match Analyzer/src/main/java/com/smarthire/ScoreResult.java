package com.smarthire.dto;

import java.util.List;

/** A Java record: an immutable data holder with getters generated automatically. */
public record ScoreResult(List<String> matching, List<String> missing, List<String> extra, double percentage) { }
