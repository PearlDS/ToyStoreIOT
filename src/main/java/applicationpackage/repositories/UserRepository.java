package applicationpackage.repositories;

import applicationpackage.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUserNameAndPassWord(String userName, String passWord);

    @Query("select u From User u where u.userName = ?1 and u.passWord = ?2")
    User getUserUserBynAdnpw(String userName, String passWord);
}
