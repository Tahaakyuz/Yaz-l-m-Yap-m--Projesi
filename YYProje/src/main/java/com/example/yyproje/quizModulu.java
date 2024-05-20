package com.example.yyproje;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class quizModulu {

    static class Question {
        int id;
        int correctStreak; // Üst üste doğru cevap sayısı
        LocalDate nextTestDate; // Bir sonraki test tarihi

        public Question(int id) {
            this.id = id;
            this.correctStreak = 0;
            this.nextTestDate = LocalDate.now();
        }
    }

    static Map<Integer, Question> questionMap = new HashMap<Integer, Question>();
    static List<Integer> knownQuestions = new ArrayList<Integer>();
    static Random random = new Random();

    public static void main(String[] args) {
        // İlk günün soruları
        LocalDate startDate = LocalDate.of(2024, 2, 8);
        List<Integer> firstDayQuestions = Arrays.asList(8, 12, 13, 33, 54, 55, 86, 87, 19, 10);
        List<Integer> correctFirstDay = Arrays.asList(8, 12, 86, 87, 19);

        initializeQuestions(firstDayQuestions);
        updateQuestions(correctFirstDay, startDate);

        // İkinci günün soruları
        LocalDate secondDate = startDate.plus(1, ChronoUnit.DAYS);
        List<Integer> secondDayAdditionalQuestions = Arrays.asList(2, 5, 6, 78, 45, 14, 56, 57, 80, 81);
        List<Integer> correctSecondDay = Arrays.asList(8, 12, 87, 45, 14, 56, 57, 80, 81);

        List<Integer> secondDayQuestions = generateNextDayQuestions(correctFirstDay, secondDayAdditionalQuestions);
        updateQuestions(correctSecondDay, secondDate);

        // Sonraki günler benzer şekilde devam eder
    }

    private static void initializeQuestions(List<Integer> questions) {
        for (int q : questions) {
            questionMap.put(q, new Question(q));
        }
    }

    private static void updateQuestions(List<Integer> correctAnswers, LocalDate testDate) {
        for (int id : correctAnswers) {
            Question question = questionMap.get(id);
            if (question != null) {
                question.correctStreak++;
                if (question.correctStreak == 6) {
                    knownQuestions.add(id);
                    questionMap.remove(id);
                } else {
                    question.nextTestDate = calculateNextTestDate(question.correctStreak, testDate);
                }
            }
        }
    }

    private static LocalDate calculateNextTestDate(int streak, LocalDate fromDate) {
        switch (streak) {
            case 1: return fromDate.plus(1, ChronoUnit.DAYS);
            case 2: return fromDate.plus(1, ChronoUnit.WEEKS);
            case 3: return fromDate.plus(1, ChronoUnit.MONTHS);
            case 4: return fromDate.plus(3, ChronoUnit.MONTHS);
            case 5: return fromDate.plus(6, ChronoUnit.MONTHS);
            case 6: return fromDate.plus(1, ChronoUnit.YEARS);
            default: return fromDate;
        }
    }

    private static List<Integer> generateNextDayQuestions(List<Integer> knownPreviousDay, List<Integer> additionalQuestions) {
        List<Integer> nextDayQuestions = new ArrayList<Integer>(knownPreviousDay);
        while (nextDayQuestions.size() < 10) {
            int randomQuestion = additionalQuestions.get(random.nextInt(additionalQuestions.size()));
            if (!nextDayQuestions.contains(randomQuestion)) {
                nextDayQuestions.add(randomQuestion);
            }
        }
        return nextDayQuestions;
    }
}
