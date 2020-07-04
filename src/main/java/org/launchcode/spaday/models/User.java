package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    @NotBlank(message = "Username is required")
    @Size(min = 5, max = 15, message = "Username must be between 5 and 15 characters long")
    private String username;
    @Email(message = "Invalid email. Try again!")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Sorry, but the password must be at least 6 characters long.")
    private String password;
    @NotNull(message = "Passwords do not match")
    private String verifyPassword ;

    public User() { }

    public User(String username, String email, String password, String verifyPassword ) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword  = verifyPassword ;
    }

    private void checkPassword(String password, String verifyPassword){
        if(password != null && verifyPassword != null){
            if(password != verifyPassword)
                this.verifyPassword = null;
        }
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
        checkPassword(password, verifyPassword);
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword(password, verifyPassword);
    }
}
