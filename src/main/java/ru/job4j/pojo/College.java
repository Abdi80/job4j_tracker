package ru.job4j.pojo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setStudent("Ivan Ivanov");
        student.setGroup("B-5");
        student.setDate(new GregorianCalendar(2023, Calendar.AUGUST, 10));
        System.out.println(student.getStudent() + " group - " + student.getGroup()
                                                + " admission date "
                                                + student.getDate().getTime());
    }
}
