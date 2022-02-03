package applicationpackage.controllers.implementations;

import applicationpackage.controllers.interfaces.UserController;
import applicationpackage.data.User;
import applicationpackage.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserControllerImpl implements UserController {


    private UserService userService;

    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @GetMapping("login")
    public String goToLoginPage(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("currentUser")==null) {
            model.addAttribute("user", new User("", "", null));
            return "login";
        }
        else return "redirect:productsbs";
    }

    @Override
    @PostMapping("login2")
    public String login(@ModelAttribute("user") User userReceived, HttpSession httpSession) {

        User userfound = userService.getUserBynameAndPassWord(userReceived.getUserName(), userReceived.getPassWord());
        if (userfound== null) {
            return "redirect:login";
        }
        else {
            httpSession.setAttribute("currentUser", userfound.getUserName());
        }

        return "redirect:productsbs";
    }


    public String logout( HttpSession httpSession){

        httpSession.setAttribute("currentUser", null);
        return "redirect:login";
    }
}
