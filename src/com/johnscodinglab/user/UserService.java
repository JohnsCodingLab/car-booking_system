package com.johnscodinglab.user;

public class UserService {
    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public void addUser(User user) {
        userDAO.saveUser(user);
    }

    public User[] getUsers() {
        return userDAO.getUsers();
    }
}
