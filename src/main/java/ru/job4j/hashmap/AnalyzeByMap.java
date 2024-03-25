package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0;
        int quantity = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                quantity++;
            }
        }
        return quantity != 0 ? score / quantity : 0;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        double score;
        int quantity;
        double averageScore;
        for (Pupil pupil : pupils) {
            score = 0;
            quantity = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                quantity++;
            }
            averageScore = quantity != 0 ? score / quantity : 0;
            list.add(new Label(pupil.name(), averageScore));
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> list = new ArrayList<>();
        int quantity = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), (oldValue, newValue)
                        -> oldValue + subject.score());
            }
            quantity++;
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            double score = quantity != 0 ? (double) entry.getValue() / quantity : 0;
            list.add(new Label(entry.getKey(), score));
        }
        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        double score;
        for (Pupil pupil : pupils) {
            score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            list.add(new Label(pupil.name(), score));
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), (oldValue, newValue)
                        -> oldValue + subject.score());
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Label(entry.getKey(), entry.getValue()));
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }
}
