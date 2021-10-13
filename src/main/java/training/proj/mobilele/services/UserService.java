package training.proj.mobilele.services;

import training.proj.mobilele.models.service.UserRegistrationServiceModel;

public interface UserService {
    boolean userNameExists(String username);
    void registerUser(UserRegistrationServiceModel serviceModel);
}
