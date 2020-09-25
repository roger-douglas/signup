package com.douglas.signup;

import com.douglas.signup.model.User;
import com.douglas.signup.service.UserService;
import com.douglas.signup.service.exception.InvalidUserException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

public class SignUpTest {

    UserService userService;

    @Before
    public void setup() {
        userService = new UserService();
    }

    @Test
    public void shouldReadSecret() throws InvalidUserException {
        String message = BuildConfig.SECRET;
        assertEquals("This is a super secret message", message);
    }

    @Test
    public void shouldRegisterUser() throws InvalidUserException {
        User user = userService.registerUser("Roger", "F", "123");
        assertNotNull(user);
    }

    @Test(expected = InvalidUserException.class)
    public void shouldNotRegisterUser_noFirstName() throws InvalidUserException {
        try {
            User user = userService.registerUser("", "F", "123");
            assertNull(user);
        } catch (Exception e) {
            assertEquals("First name field is empty.", e.getMessage());
            throw e;
        }
    }

    @Test(expected = InvalidUserException.class)
    public void shouldNotRegisterUser_noLasttName() throws InvalidUserException {
        try {
            User user = userService.registerUser("Roger", "", "123");
            assertNull(user);
        } catch (Exception e) {
            assertEquals("Last name field is empty.", e.getMessage());
            throw e;
        }
    }

    @Test(expected = InvalidUserException.class)
    public void shouldNotRegisterUser_noPassword() throws InvalidUserException {
        try {
            User user = userService.registerUser("Roger", "F", "");
            assertNull(user);
        } catch (Exception e) {
            assertEquals("Password field is empty.", e.getMessage());
            throw e;
        }
    }
}