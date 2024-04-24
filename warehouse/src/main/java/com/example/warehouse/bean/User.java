package com.example.warehouse.bean;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String register_time;
    private String role;
    // Getters and setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRegister_time() {
        return register_time;
    }
    public void setRegister_time(String register_time) {
        this.register_time = register_time;
    }
}