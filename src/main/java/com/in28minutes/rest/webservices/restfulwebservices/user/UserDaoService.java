package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class UserDaoService {

    private static final List<User> users = new ArrayList<>();
    private static final AtomicInteger userCount = new AtomicInteger(3);

    static {
        users.add(new User(1, "Adam", LocalDate.of(1985, 3, 20)));
        users.add(new User(2, "Eve", LocalDate.of(1990, 9, 15)));
        users.add(new User(3, "Jack", LocalDate.of(1975, 8, 25)));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(userCount.incrementAndGet());
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {

        return users.stream()
                .filter( curr -> curr.getId().equals(id)
        ).findFirst().orElse(null);

    }

    public void deleteById(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
