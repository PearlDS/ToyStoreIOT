package applicationpackage.services.implementations;

import applicationpackage.data.User;
import applicationpackage.repositories.UserRepository;
import applicationpackage.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSericeImpl implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserSericeImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        //if you want, you can try to encrypt passwords on this level
        userRepository.save(user);
    }

    @Override
    public User getUserBynameAndPassWord(String userName, String passWord) {
        return userRepository.findByUserNameAndPassWord(userName, passWord);
    }
}
