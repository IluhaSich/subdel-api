package com.example.subdel_api.dtos.response;


import org.springframework.hateoas.server.core.Relation;

import java.util.List;
import java.util.Objects;

@Relation(collectionRelation = "users", itemRelation = "user")
public class UserResponse {
    private Long id;
    private String name;
    private List<DelicacyResponse> delicacies;

    public UserResponse() {
    }

    public UserResponse(Long id, String name, List<DelicacyResponse> delicacies) {
        this.id = id;
        this.name = name;
        this.delicacies = delicacies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DelicacyResponse> getDelicacies() {
        return delicacies;
    }

    public void setDelicacies(List<DelicacyResponse> delicacies) {
        this.delicacies = delicacies;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserResponse that = (UserResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(delicacies, that.delicacies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, delicacies);
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", delicacies=" + delicacies +
                '}';
    }
}
