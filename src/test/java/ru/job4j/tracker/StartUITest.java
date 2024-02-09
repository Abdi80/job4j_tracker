package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void whenCreateItem() {
        Input input = new MockInput(new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        UserAction[] actions = {new Create(output), new Exit(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        Output output = new ConsoleOutput();
        String replacedName = "New item name";
        Input input = new MockInput(new String[] {"0", String.valueOf(item.getId()), replacedName, "1"});
        UserAction[] actions = {new Replace(output), new Exit(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Output output = new ConsoleOutput();
        Input input = new MockInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {new Delete(output), new Exit(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenFindAllAction() {
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("First item"));
        Item two = tracker.add(new Item("Second item"));
        Output output = new StubOutput();
        Input input = new MockInput(new String[] {"0", "1"});
        UserAction[] actions = {new FindAll(output), new Exit(output)};
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод всех заявок ===" + ln
                        + one + ln
                        + two + ln
                        + "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByName() {
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("First item"));
        Item two = tracker.add(new Item("Second item"));
        Output output = new StubOutput();
        Input input = new MockInput(new String[] {"0", two.getName(), "1"});
        UserAction[] actions = {new FindByName(output), new Exit(output)};
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявок по имени ===" + ln
                        + two + ln
                        + "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindById() {
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("First item"));
        Item two = tracker.add(new Item("Second item"));
        Output output = new StubOutput();
        Input input = new MockInput(new String[] {"0", String.valueOf(one.getId()), "1"});
        UserAction[] actions = {new FindById(output), new Exit(output)};
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявки по id ===" + ln
                        + one + ln
                        + "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }
}