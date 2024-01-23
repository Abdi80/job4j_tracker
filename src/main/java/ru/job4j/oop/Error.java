package ru.job4j.oop;

public class Error {

    private boolean active;

    private int status;

    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("active - " + active);
        System.out.println("status - " + status);
        System.out.println("message - " + message);
    }

    public static void main(String[] args) {
        Error firstError = new Error();
        firstError.printInfo();
        Error secondError = new Error(true, 2, "stupid error");
        secondError.printInfo();
        Error thirdError = new Error(true, 3, "interesting error");
        thirdError.printInfo();
    }
}
