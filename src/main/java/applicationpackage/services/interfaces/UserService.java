package applicationpackage.services.interfaces;

import applicationpackage.data.User;

public interface UserService {

    void createUser(User user);
    User getUserBynameAndPassWord(String userName, String passWord);

}
