package com.example.demo.Auth;

import com.example.demo.Authorized.jwtResponce;
import com.example.demo.Authorized.jwtUtil;
import com.example.demo.Registration.Payment;
import com.example.demo.Registration.Register;
import com.example.demo.Registration.RegisterRepository;
import com.example.demo.Return.ReturnedService;
import com.example.demo.Return.ReturnedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class Controller {
    @Autowired
    Service service;
    @Autowired
    ReturnedService returnedService;
    @Autowired
    RegisterRepository registerRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private jwtUtil jwtutil;

    @PostMapping(path = "login")

    public ReturnedUser login(@RequestBody LoginRequest loginRequest) {
        Boolean loggedIn = service.login(loginRequest);
        String useremail = loginRequest.email;
        ReturnedUser returnedUser1 = returnedService.getData(useremail);

        if (loggedIn) return returnedUser1;
        else {
            return null;
        }
    }

    @PostMapping(path = "tokenlogin")
    public ResponseEntity<jwtResponce> createToken(@RequestBody LoginRequest jwtRequest) {
        Boolean loggingin = service.login(jwtRequest);
        String email = jwtRequest.email;
        if (loggingin) {
            User user = userRepository.findOneByEmail(email);
            String token = this.jwtutil.generateToken(user);
            jwtResponce jwtresponce = new jwtResponce();
            jwtresponce.setToken(token);
            return new ResponseEntity<>(jwtresponce, HttpStatus.OK);
        } else {
            return null;
        }


    }

    @PostMapping(path = "signup")
    public String signup(@RequestBody SignupRequest signuprequest) {
        Boolean signedUp = service.signup(signuprequest);
        if (signedUp) return "Created a new user with email " + signuprequest.email;
        else {
            return "User with this email already exists";
        }
    }

    @PostMapping(path = "register")
    public String registerData(@RequestBody Register register) {
        String coursetype = register.courseType;
        String useremail = register.getEmail();
        ReturnedUser returnedUser1 = returnedService.getData(useremail);
        if (returnedUser1 == null) {
            return "please signup with your email";
        }
        if (coursetype.equals("mtech")) {
            return "your fees is 25000";
        }
        return "your fees is 50000";
    }

    @PostMapping(path = "payment")
    public String paymentCharge(@RequestBody Payment payment) {
        String coursetype = payment.getCourseType();
        String mail = payment.getEmail();
        Register register1 = registerRepository.findOneByEmail(mail);
        if (register1 == null) {
            return "please register with your email";
        }
        if (coursetype.equals("mtech")) {
            if (payment.getAmount().equals("25000")) {
                System.out.println("Registration Successful");
                return "welcome " + register1.getName();
            } else {
                return "please pay required amount";
            }
        } else if (coursetype.equals("btech")) {
            if (payment.getAmount().equals("50000")) {
                System.out.println("Registration Successful");
                return "welcome " + register1.getName();
            }
        }
        return "please enter correct amount";
    }

}



