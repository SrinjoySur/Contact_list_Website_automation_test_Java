package com.contact_list.api.model;
import lombok.Data;
@Data
public class Register {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    public Register(RegisterBuilder builder){
        this.firstName = builder.firstName;
        this.lastName= builder.lastName;
        this.email=builder.email;
        this.password=builder.password;
    }
    public static class RegisterBuilder{
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        public RegisterBuilder(){
        }
        public RegisterBuilder withFirstName(String firstName){
            this.firstName=firstName;
            return this;
        }
        public RegisterBuilder withLastName(String lastName){
            this.lastName=lastName;
            return this;
        }
        public RegisterBuilder withEmail(String email){
            this.email=email;
            return this;
        }
        public RegisterBuilder withPassword(String password){
            this.password=password;
            return this;
        }
        public Register build(){
            return new Register(this);
        }
    }
}
