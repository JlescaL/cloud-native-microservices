package com.crystalark.userservice.DAO;

import com.crystalark.userservice.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    Optional<List<User>> findByContact(String category);

    Optional<List<User>> findByUserName(String name);

    Optional<List<User>> findById(long id);

    Optional<User> findByUserNameAndContact(String UserName, String contact);
}
