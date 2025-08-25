package com.contact_list.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User {
    private String _id;
    private String firstName;
    private String lastName;
    private String email;
    private String __v;
    public User(UserBuilder builder){
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.email=builder.email;
    }
    public static class UserBuilder{
        private String firstName;
        private String lastName;
        private String email;
        public UserBuilder(){
        }
        public UserBuilder withFirstName(String firstName){
            this.firstName=firstName;
            return this;
        }
        public UserBuilder withLastName(String lastName){
            this.lastName=lastName;
            return this;
        }
        public UserBuilder withEmail(String email){
            this.email=email;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }
}
