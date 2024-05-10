package relucky.code.service;

import relucky.code.model.entity.User;

import java.util.List;

public interface UserService {
    Object getMe();
    User save();
    User getById(Long id);
    List<User> getAll();
}
