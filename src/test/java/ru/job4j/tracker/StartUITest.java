package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void whenCreateItem() {
        Input input = new MockInput(new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        UserAction[] actions = {new CreateAction(output), new ExitAction(output)};
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
        UserAction[] actions = {new ReplaceAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Output output = new ConsoleOutput();
        Input input = new MockInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {new DeleteAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }
}