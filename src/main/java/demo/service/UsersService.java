package demo.service;

import demo.entity.Users;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    /**
     * Returns the Users object when login should be successful, null if unsuccessful.
     * TODO: refactor to checking the database for the matching Users entity.
     */
    public Users shouldPermitLogin(Users users){
        if(users.getUsername().equals("username") && users.getPassword().equals("password")){
            return users;
        }else{
            return null;
        }
    }

    /**
     * Return the full user object when the new user is valid for registration AND the users has
     * been saved to the database.
     * Return null if the user object is not valid for registration, the users should NOT be saved to the
     * database in this case. (the JPARepository .save() method also is used in updates, so if we
     * erroneously save a user when the username is already in use, we'd just end up overwriting the
     * existing user's password.... probably very bad)
     *
     * TODO: check if the users entity username already is in use in the database, also,
     * check that the username/password are valid (contain a minimum character count).
     * @param users
     * @return
     */
    public Users shouldPermitRegistration(Users users){
        return null;
    }
}
