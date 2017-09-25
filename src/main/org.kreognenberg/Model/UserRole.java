package Model;

public class UserRole {
    private int id;
    private User username;
    private String role;

    public User getUsername() {
        return username;
    }

    public void setUsername(User user) {
        this.username = user;
    }

    public UserRole(int id, User user, String role) {
        this.id = id;
        this.username = user;
        this.role = role;
    }

    public UserRole(User user, String role) {
        setUsername(user);
        setRole(role);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
