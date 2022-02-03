package applicationpackage.controllers.implementations;

import applicationpackage.controllers.interfaces.HelloController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloControllerImpl implements HelloController {

    @Override
    @GetMapping("hi1")
    public String helloMethod1() {
        return "test";
    }

    @Override
    @GetMapping("hi2")
    public ModelAndView helloMethod2() {
        String mars = "Mars";
        return new ModelAndView("test", "planet",mars);
    }

    @Override
    @GetMapping("hi3")
    public String helloMethod3(Model model) {

        model.addAttribute("planet", "Mars");
        model.addAttribute("planet2", "Venus");

        return "test";
    }
}
