package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PassportOfficeTest {

    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenAddFalse() {
        PassportOffice office = new PassportOffice();
        office.add(new Citizen("2f44a", "Petr Arsentev"));
        office.add(new Citizen("5d88a", "Pol Verho"));
        Citizen citizen = new Citizen("5d88a", "Pol Verho");
        assertThat(office.add(citizen)).isFalse();
    }
}