package libraryManagementSystem;
// User class

import java.io.Serializable;

class User implements Serializable {
    private int userId;
    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() { return userId; }
    public String getName() { return name; }
}