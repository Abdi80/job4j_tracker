package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User user1 : users) {
            if (user1.getUsername().equals(login)) {
                user = user1;
                break;
            }
        }
        if (user != null) {
            return user;
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() && user.getUsername().length() > 2) {
            return true;
        } else {
            throw new UserInvalidException("User invalid");
        }
    }

    public static void main(String[] args) {
        User[] users = {new User("Petr Arsentev", true),
                        new User("Xi", true),
                        new User("Bob", true),
                        new User("Karl", false)};
        String serchName = "Petr Arsentev";
        try {
            User user = findUser(users, serchName);
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ei) {
            ei.printStackTrace();
        } catch (UserNotFoundException ef) {
            ef.printStackTrace();
        }

    }
}
