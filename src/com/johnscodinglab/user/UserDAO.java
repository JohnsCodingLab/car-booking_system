package com.johnscodinglab.user;

public class UserDAO {
    private static final User[] users;
    private int slots = 0;
    private static final int CAPACITY = 10;

    static {
        users = new User[CAPACITY];
    }

    public void saveUser(User user) {
        if (slots > CAPACITY) {
            System.out.println("Not enough space to add user");
        }
        users[slots++] = user;
    }

    public User[] getUsers() {
        if (slots == 0) {
            return new User[0];
        }
        return users;
    }
}
