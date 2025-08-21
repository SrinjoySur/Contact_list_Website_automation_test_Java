package com.contact_list.api.model;

import lombok.Data;

@Data
public class Authenticate {
    private String email;
    private String password;
    public Authenticate(AuthBuilder builder){
        this.email=builder.email;
        this.password=builder.password;
    }
    public static class AuthBuilder{
        private String email;
        private String password;

        public AuthBuilder withEmail(String email) {
            this.email=email;
            return this;
        }
        public AuthBuilder withPassword(String password){
            this.password=password;
            return this;
        }
        public Authenticate build(){
            return new Authenticate(this);
        }
    }
}
