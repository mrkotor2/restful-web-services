package com.training.rest.webservices.restfulwebservices.user;

import com.training.rest.webservices.restfulwebservices.user.exception.UserAlreadyExistsException;
import com.training.rest.webservices.restfulwebservices.user.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCounter = 3;

    static {
        users.add(new User(1, "Alex", new Date()));
        users.add(new User(2, "Damien", new Date()));
        users.add(new User(3, "Eugene", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
         throw new UserNotFoundException("User with id: " + id + " doesn't exist");
    }

    public User save(User newUser) {
        if (newUser.getId() == null) {
            newUser.setId(++usersCounter);
        } else {
            for (User user : users) {
                if (user.getId().equals(newUser.getId()))
                    throw new UserAlreadyExistsException("User with id " + newUser.getId() + " already exists");
            }
        }
        users.add(newUser);
        return newUser;
    }

    public void deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            } else {
                throw new UserNotFoundException("User with id: " + id + " doesn't exist");
            }
        }
    }
}

