package ru.job4j.bank;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу с пользователями и счетами
 * @author NURLAN
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных о пользователях и имеющихся у них счетах в коллекции Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и если его нет в коллекции users,
     * добавляет его
     * @param user пользователь добавляемый в коллекцию
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход паспорт пользователя
     * и удаляет этого пользователя из коллекции users
     * @param passport ключ по которому производится удаление
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод принимает на вход паспорт и банковский счет
     * доавляет счет в коллекцию счетов
     * @param passport ключ для поиска пользователя
     * @param account счет который необходимо добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает паспорт пользователя и возвращает пользователя
     * @param passport ключ для поиска пользователя
     * @return возвращает пользователя или null если пользователь не найден
     */
    public User findByPassport(String passport) {
        User user = null;
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                user = key;
                break;
            }
        }
        return user;
    }

    /**
     * Метод принимает паспорт и реквизит и возвращает счет
     * @param passport ключ для поиска пользователя
     * @param requisite реквизит для поиска банковского счета
     * @return возвращает счет или null если счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод описывающий перевод денег
     * принимает на вход паспорт и реквизиты счета отправителя
     * а также паспорт и реквизиты счета получателя и сумму перевода
     * @param sourcePassport паспорт отправителя
     * @param sourceRequisite реквизиты счета отправителя
     * @param destinationPassport паспорт получателя
     * @param destinationRequisite реквизиты счета получателя
     * @param amount сумма перевода
     * @return возвращает true если перевод осуществлен, иначе false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && destinationAccount != null
                && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance()  - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
