package com.example.trabalhoKanban.model;

public enum UsersRole {
    ADMIN("admin"),
    USERS("users");

    private String role;

    UsersRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
