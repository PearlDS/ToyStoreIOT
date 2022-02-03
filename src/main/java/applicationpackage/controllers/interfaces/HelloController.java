package applicationpackage.controllers.interfaces;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface HelloController {

    String helloMethod1();

    ModelAndView helloMethod2();

    String helloMethod3 (Model model);
}
