package akidev.me.bookmyshow.services;

import akidev.me.bookmyshow.models.User;
import akidev.me.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String email){
        User user = new User();
        user.setEmail(email);
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
