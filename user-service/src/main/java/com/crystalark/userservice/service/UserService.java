package com.crystalark.userservice.service;

import com.crystalark.userservice.DAO.UserDao;
import com.crystalark.userservice.DTO.UserDTO;
import com.crystalark.userservice.Exceptions.UserNotFoundException;
import com.crystalark.userservice.models.User;
import com.crystalark.userservice.utils.ObjectMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public final class UserService {

    @Autowired
    private UserDao dao;

    /**
     * <p>
     * Note: ObjectMapperUtility.mapAll(S,D.class) should be called source object and target class type as argument
     * </p>
     * 
     * @return list of all users of <code>List<UserDTO></code> type.
     */
    public Optional<List<UserDTO>> getAllUsers() {
        List<UserDTO> allUserDTOs = ObjectMapperUtility.mapAll((List<User>) dao.findAll(), UserDTO.class);
        return Optional.of(allUserDTOs);
    }

    /**
     * <p>
     * Note: ObjectMapperUtility.mapAll(S,D.class) should be called source object and target class type as argument
     * </p>
     * 
     * @param userDTO
     *            User details in JSON format
     * @return an object of <code>UserDTO</code> type.
     */
    public UserDTO saveUser(UserDTO userDTO) {
        User savedUser = dao.save(ObjectMapperUtility.map(userDTO, User.class));
        return Optional.of(ObjectMapperUtility.map(savedUser, UserDTO.class))
                .orElseThrow(() -> new UserNotFoundException(("Failed to save user : ")));
    }

    /**
     * <p>
     * Note: ObjectMapperUtility.mapAll(S,D.class) should be called source object and target class type as argument
     * </p>
     * 
     * @param id
     *            Id of the user to be retrieved
     * @return return a user by id of <code>UserDTO</code> type.
     */
    public UserDTO getUserById(long id) {
        return Optional.of(ObjectMapperUtility.map(dao.findById(id), UserDTO.class))
                .orElseThrow(() -> new UserNotFoundException("No users with matching id " + id));
        // return Optional.of(dao.findById(id)).get().orElseThrow(()-> new UserNotFoundException("No users with
        // match"));
    }

    /**
     * <p>
     * Note: ObjectMapperUtility.mapAll(S,D.class) should be called source object and target class type as argument
     * </p>
     * 
     * @param userDTO
     *            User details in JSON format
     * @param id
     *            User id to be updated
     * @return return an updated user of <code>UserDTO</code> type.
     */
    public UserDTO updateUser(UserDTO userDTO, long id) {
        User updatedUser = dao.findById(id).map(user -> dao.save(ObjectMapperUtility.map(userDTO, User.class)))
                .orElseThrow(() -> new UserNotFoundException("No users with matching id " + id));
        return ObjectMapperUtility.map(updatedUser, UserDTO.class);
    }
}