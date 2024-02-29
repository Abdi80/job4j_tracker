package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NotifyAccountTest {

    @Test
    void whenAddTwoDifferentAccounts() {
        List<Account> accounts = Arrays.asList(
                new Account("785", "Nick", "D1538"),
                new Account("589", "Fil", "D4535"));
        HashSet<Account> expected = new HashSet<>();
        expected.add(new Account("785", "Nick", "D1538"));
        expected.add(new Account("589", "Fil", "D4535"));
        assertThat(NotifyAccount.sent(accounts)).containsAll(expected);
    }

    @Test
    public void whenAddTwoDuplicateAccounts() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("123", "Ivan Ivanov", "000000001")
        );
        HashSet<Account> expected = new HashSet<>();
        expected.add(new Account("123", "Petr Arsentev", "eDer3432f"));
        assertThat(NotifyAccount.sent(accounts)).containsAll(expected);
    }

    @Test
    public void whenAddSomeDuplicateAccounts() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "eDer3432f"),
                new Account("123", "Ivan Ivanov", "000000001"),
                new Account("142", "Petr Petrov", "000000002"),
                new Account("123", "Mark Markov", "000000003")
        );
        HashSet<Account> expected = new HashSet<>();
        expected.add(new Account("123", "Petr Arsentev", "eDer3432f"));
        expected.add(new Account("142", "Petr Arsentev", "eDer3432f"));
        assertThat(NotifyAccount.sent(accounts)).containsAll(expected);
    }
}