package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    public void whenCompareNameInc() {
        Comparator<Job> cmpNameInc = new JobIncreaseByName();
        int result = cmpNameInc.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1));
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenCompareNameDec() {
        Comparator<Job> cmpNameDec = new JobDescByName();
        int result = cmpNameDec.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1));
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparePriorityInc() {
        Comparator<Job> cmpPriorityInc = new JobIncreaseByPriority();
        int result = cmpPriorityInc.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1));
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparePriorityDec() {
        Comparator<Job> cmpPriorityDec = new JobDescByPriority();
        int result = cmpPriorityDec.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1));
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int result = cmpNamePriority.compare(
                new Job("Fix bug", 5),
                new Job("Fix bug", 1));
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorByPriorityAndName() {
        Comparator<Job> cmpPriorityName = new JobIncreaseByPriority().thenComparing(new JobIncreaseByName());
        int result = cmpPriorityName.compare(
                new Job("Impl task", 5),
                new Job("Fix bug", 5));
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByPriorityAndNameDif() {
        Comparator<Job> cmpPriorityName = new JobIncreaseByPriority().thenComparing(new JobDescByName());
        int result = cmpPriorityName.compare(
                new Job("Impl task", 5),
                new Job("Fix bug", 5));
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorByPriorityAndNameEq() {
        Comparator<Job> cmpPriorityName = new JobIncreaseByPriority().thenComparing(new JobDescByName());
        int result = cmpPriorityName.compare(
                new Job("Fix bug", 5),
                new Job("Fix bug", 5));
        assertThat(result).isEqualTo(0);
    }
}