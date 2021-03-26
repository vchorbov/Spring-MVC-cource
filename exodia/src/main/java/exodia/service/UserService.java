package exodia.service;

import exodia.models.service.UserServiceModel;

public interface UserService {

    boolean registerUser(UserServiceModel userServiceModel);

    UserServiceModel loginUser(UserServiceModel userServiceModel);
}
