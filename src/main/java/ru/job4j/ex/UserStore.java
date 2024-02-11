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
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean valid = true;
        if (!user.isValid() || user.getUsername().length() < 3) {
            valid = false;
            throw new UserInvalidException("User invalid");
        }
        return valid;
    }

    public static void main(String[] args) {
        User[] users = {new User("Petr Arsentev", true),
                        new User("Xi", true),
                        new User("Bob", true),
                        new User("Karl", false)};
        String serchName = "Bob";
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
