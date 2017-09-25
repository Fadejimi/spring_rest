package Model;

import util.ModelUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private String beerKind;
    private String gender;
    private List<String> complicatedInterests;
    private String confirmPassword;
    private String interests;
    private Set<UserRole> userRole = new HashSet<UserRole>(0);

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRoles) {
        this.userRole = userRoles;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public User(String username, String email, String password, String beerKind, String gender, String interests) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.beerKind = beerKind;
        this.gender = gender;
        this.interests = interests;
    }

    public User() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBeerKind() {
        return beerKind;
    }

    public void setBeerKind(String beerKind) {
        this.beerKind = beerKind;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getComplicatedInterests() {
        return ModelUtil.computeInterests(this.interests);
    }

    public void setComplicatedInterests(List<String> interests) {
        this.complicatedInterests = interests;
        this.interests = ModelUtil.delimitInterests(interests);
    }



    public String getInterests() {
        return this.interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
        this.complicatedInterests = ModelUtil.computeInterests(interests);
    }


    public boolean isNew() {
        if (this.id == null) {
            return true;
        }
        return false;
    }
}
