package com.example.demo.Auth;
import com.example.demo.Return.ReturnedRepository;
import com.example.demo.Return.ReturnedUser;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
    public class Service {
        @Autowired
        UserRepository userRepository;
        @Autowired
        ReturnedRepository returnedRepository;


        public Boolean login(LoginRequest loginRequest) {
            String email = loginRequest.email;
            String password = loginRequest.password;

            User user  = findUserByEmail(email);
            if(user == null){
                return false;
            }

            if(user.getPassword().equals(password)){
                return true;
            }
            return false;
        }

        private User findUserByEmail(String email) {
            User user = userRepository.findOneByEmail(email);
            return user;
        }

        public Boolean signup(SignupRequest signuprequest) {
            String email = signuprequest.email;
            User user = findUserByEmail(email);
            if(user != null){
                return false;
            }

            User newUser = new User(signuprequest.name, signuprequest.email, signuprequest.password, signuprequest.branch);
            ReturnedUser returnedUser =new ReturnedUser(signuprequest.email,signuprequest.name,signuprequest.branch);
            saveUserData(returnedUser);
            saveUser(newUser);
            return true;
        }

        private void saveUser(User newUser) {
            userRepository.save(newUser);
        }
        private void saveUserData(ReturnedUser returnedUser){
            returnedRepository.save(returnedUser);
        }
    }
