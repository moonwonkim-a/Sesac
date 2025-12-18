package com.ohgiraffers.section02;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        List<OnlineCourse> course = Arrays.asList(
                new OnlineCourse("Java의 정석", "Programming", 120, false),
                new OnlineCourse("Spring 완전 정복", "Programming", 300, false),
                new OnlineCourse("JPA 끝장내기", "Programming", 240, false),
                new OnlineCourse("포토샵 마스터", "Design", 90, true),
                new OnlineCourse("일러스트레이터 시작하기", "Design", 110, true),
                new OnlineCourse("SQL 첫걸음", "Database", 80, true),
                new OnlineCourse("데이터베이스 모델링", "Database", 150, false)
        );

        /* Programming 카테고리 중 수강 시간 200분 초과인 강의 제목 출력하기 */

        // for, if 사용
        for(OnlineCourse c : course) {
            if("Programming".equals(c.getCategory()) && c.getDuration() > 200 ) {
                System.out.println(c.getTitle());
            }
        }

        course.stream()
                .filter(c -> "Programming".equals(c.getCategory()))
                .filter(c -> c.getDuration() > 200)
                .map(OnlineCourse::getTitle)
                .forEach(System.out::println);

        /* 중간 연산 */

        // sorted
        course.stream()
                .filter(OnlineCourse::isFree)
                // Comparator 람다식으로 구현!! 오름차순 정렬
                .sorted((c1, c2) -> c1.getDuration() - c2.getDuration())
                .forEach(System.out::println);

        // distinct : 중복 제거하기
        course.stream()
                .map(OnlineCourse::getCategory)
                .distinct()
                .forEach(System.out::println);

        /* 최종 연산 */

        // collect
        List<OnlineCourse> designCourses = course.stream()
                .filter(c -> "Design".equals(c.getCategory()))
                .collect(Collectors.toList());
        System.out.println(designCourses);

        // 간단한 통계 구현
        // count() : 스트림에 남아있는 요소 개수 확인
        // sum() :  남은 요소의 합계
        // average() : 남은 요소의 평균
        int totalDurationOfFreeCourses = course.stream()
                .filter(OnlineCourse::isFree)
                .mapToInt(OnlineCourse::getDuration)    // mapToInt : IntStream으로 변환(sum() 수행 가능)
                .sum();
        System.out.println(totalDurationOfFreeCourses + "분");

        /* groupingBy */
        // 모든 강의를 카테고리별로 분류해서 정리하기
        // collect에게 groupingBy를 할건데 기준은 '카테고리야' 라고 알려주면
        // 스트림이 알아서 Map<카테고리, 해당 강의 리스트> 형태로 분류해줌
        Map<String, List<OnlineCourse>> courseByCategory = course.stream()
                .collect(Collectors.groupingBy(OnlineCourse::getCategory));

        // Map 출력
        courseByCategory.forEach((category, courseList) -> {
            System.out.println("[" + category + "]");
            courseList.forEach(c -> System.out.println(" - " + c.getTitle()));
        });
    }
}