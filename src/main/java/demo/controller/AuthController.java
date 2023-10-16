package demo.controller;

import demo.entity.Users;
import demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    UsersService usersService;
    @Autowired
    public AuthController(UsersService usersService){
        this.usersService = usersService;
    }
    /**
     * If we wanted to make Login/Registration endpoints,
     * we should be providing the user's info via the request body.
     *
     * (for register - all user info sent in the request body from registration page forms)
     * (for login - attempted username/password sent in the request body from login page forms)
     *
     * RESTful solution would be registration/login attempts as their own entities. Then, it would
     * make sense just to POST a new registration/login attempt, these are their own cohesive entities.
     *
     * I recommend a non-RESTful solution: just make POST login and POST registration endpoints that
     * directly manipulate the Users entity.
     */

    /**
     * I need to take in some username/password data and return either a 200 (if we were implementing
     * security, with a token as well) when the login is permitted or a 401 unauthorized if the login
     * should not be permitted.
     */
    @PostMapping("/login")
    public ResponseEntity<Users> attemptLogin(@RequestBody Users users){
        Users persistedUser = usersService.shouldPermitLogin(users);
        if(persistedUser != null){
            return new ResponseEntity<Users>(persistedUser, HttpStatus.OK);
        }else{
            return new ResponseEntity<Users>(persistedUser, HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * I need to take in a username/password data and respond with either a 200/201 when the registration
     * should be permitted (username is not in use, and username/password follow a minimum character limit.)
     * 400 when these conditions are not met.
     */
    @PostMapping("/registration")
    public ResponseEntity<Users> attemptRegistration(@RequestBody Users users){
        Users persistedUser = usersService.shouldPermitRegistration(users);
        if(persistedUser != null){
            return new ResponseEntity<Users>(persistedUser, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<Users>(persistedUser, HttpStatus.BAD_REQUEST);
        }
    }
}
