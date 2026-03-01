package org.example.repository;

import org.example.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Repository
public class UserRepositoryImpl implements UserRepository{
    private List<User> users = new ArrayList<>();

    public UserRepositoryImpl(){
        users.add(new User(1L, "Kshitij yadav", "kshitij@meow.com"));
        users.add(new User(2L, "Avinash Dhanuka", "avinash@example.com"));
    }


    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(long id){
        return this.users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void save(User user) {
        this.users.add(user);
    }
}
