package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void whenCreateItem() {
        Input input = new MockInput(new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        List<UserAction> actions = List.of(new Create(output), new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        Output output = new ConsoleOutput();
        String replacedName = "New item name";
        Input input = new MockInput(new String[] {"0", String.valueOf(item.getId()), replacedName, "1"});
        List<UserAction> actions = List.of(new Replace(output), new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Output output = new ConsoleOutput();
        Input input = new MockInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        List<UserAction> actions = List.of(new Delete(output), new Exit(output));
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
        List<UserAction> actions = List.of(new FindAll(output), new Exit(output));
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
        List<UserAction> actions = List.of(new FindByName(output), new Exit(output));
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
        List<UserAction> actions = List.of(new FindById(output), new Exit(output));
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

    @Test
    void whenInvalidExit() {
        Output output = new StubOutput();
        Input input = new MockInput(new String[] {"9", "0"});
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "Неверный ввод, вы можете выбрать: 0 .. 0" + ln
                        + "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(new String[] {"one", "1"});
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(new String[] {"5"});
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu");
        assertThat(selected).isEqualTo(5);
    }

    @Test
    void whenMultipleValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(new String[] {"5", "4", "11"});
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu");
        assertThat(selected).isEqualTo(5);
        int selected1 = input.askInt("Enter menu");
        assertThat(selected1).isEqualTo(4);
        int selected2 = input.askInt("Enter menu");
        assertThat(selected2).isEqualTo(11);
    }

    @Test
    void whenValidMinusInput() {
        Output output = new StubOutput();
        Input in = new MockInput(new String[] {"-5", "4", "11"});
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu");
        assertThat(selected).isEqualTo(-5);
    }
}