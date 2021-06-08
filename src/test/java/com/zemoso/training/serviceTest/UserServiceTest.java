package com.zemoso.training.serviceTest;

import com.zemoso.training.entity.User;
import com.zemoso.training.exception.ResourceNotFoundException;
import com.zemoso.training.repository.UserRepository;
import com.zemoso.training.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.AssertTrue;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest {

    @Autowired
    UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private User user;


    public User userData(String username, String password, boolean isAdmin, String name, long phone, String email, boolean isActive){
        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        user.setAdmin(isAdmin);
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setActive(isActive);

        return user;
    }

    @Test
    void createUserTest(){
        User newUser = userData("test1", "test112345", true, "test1", 987654345L, "test1@gmail.com", true);
        User createdUser = userService.createNewUser(newUser);
        Assertions.assertNotNull(createdUser);
    }

    @Test
    void getAllUsersTest(){
        User newUser = userData("test2", "test112345", true, "test2", 987654342L, "test2@gmail.com", true);
        userService.createNewUser(newUser);
        newUser = userData("test3", "test112345", true, "test3", 987654343L, "test3@gmail.com", true);
        userService.createNewUser(newUser);
        List<User> usersList = userService.getAllUsers();

        assertEquals(2, usersList.size(), 3);
    }

    @Test
    void getUserByUsernameTest(){
        User newUser = userData("test4", "test112345", true, "test4", 987654344L, "test4@gmail.com", true);
        userService.createNewUser(newUser);
        User user = userService.findUserByUserName(newUser.getUsername());

        assertEquals("test4", user.getUsername());
    }

    @Test
    void updateUserTest(){
        User newUser = userData("test5", "test112345", true, "test5", 987654346L, "test5@gmail.com", true);
        userService.createNewUser(newUser);

        newUser = userService.findUserByUserName(newUser.getUsername());

        newUser.setName("NameUpdated");
        newUser.setActive(false);
        User updatedUser = userService.updateUser(newUser);

        assertEquals("NameUpdated", updatedUser.getName());
        assertFalse(updatedUser.isActive());
    }

    @Test
    void updateUserExceptionTest(){
        User newUser = userData("test6", "test112345", true, "test5", 987654346L, "test5@gmail.com", true);
        userService.createNewUser(newUser);

        newUser = userService.findUserByUserName(newUser.getUsername());

        newUser.setUsername("");
        User finalNewUser = newUser;
        Assertions.assertThrows(Exception.class, () -> {
            userService.updateUser(finalNewUser);
        });
    }

    @Test()
    void getUserByUsernameExceptionTest(){
        User newUser = userData("test7", "test112345", true, "test7", 987654347L, "test7@gmail.com", true);
        userService.createNewUser(newUser);
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            userService.findUserByUserName("wrongusername");
        });
    }
}
