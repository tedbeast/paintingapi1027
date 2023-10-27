import demo.Application;
import demo.entity.Users;
import demo.service.UsersService;
import org.apache.catalina.User;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
public class UsersServiceTest {

    /**
     * field injection is used here
     * there is also constructor or setter injection
     */
    @Autowired
    UsersService usersService;

    /**
     * when username is username and password is password, permit the login by passing back
     * a non-null user
     */
    /**
    @Test
    public void loginSuccessfulTest(){
        Users users = new Users("username", "password");
        Users actual = usersService.shouldPermitLogin(users);
        Assertions.assertNotNull(actual);
    }**/
    /**
     * Spring also provides the functionality needed to both test the controller layer (by sending
     * in fake requests) and also test the custom queries written in the repository layer (by using
     * its methods on an h2 in-memory database)
     *
     * It also provides easy ways to mock the behavior of any layer.
     */
}
