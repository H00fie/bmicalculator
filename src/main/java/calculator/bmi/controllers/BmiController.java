package calculator.bmi.controllers;

import calculator.bmi.model.User;
import calculator.bmi.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BmiController {

    @Autowired
    UsersRepository usersRepository;


    @RequestMapping("/index")
    public String landingPage() {
        return "index";
    }

    @RequestMapping(value = "/searchForm", method = RequestMethod.GET)
    public String searchFormPage() {

        return "searchForm";
    }


    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String formSubmit(@RequestParam() int heightParameter,
                             @RequestParam() int weightParameter,
                             @RequestParam() String sexParameter,
                             Model model) {

        User newUser = new User(heightParameter, weightParameter, sexParameter);
       /* if (!sexParameter.equals("M") && !sexParameter.equals("m") && !sexParameter.equals("K") && !sexParameter.equals("k")) {
            return "error";
        } else {*/
        int finalResult = (int) UsersRepository.bmiResult(heightParameter, weightParameter, sexParameter);
        newUser.setBmi((finalResult));
        usersRepository.addNewUser(newUser);
        model.addAttribute("myResult", finalResult);
        // model.addAttribute("myId", anotherId);
        return "result";
    }


    @RequestMapping(value = "/searchForm", method = RequestMethod.POST)
    public String searchFormSubmit(@RequestParam() int idParameter, Model model) {

        User foundId = usersRepository.getUserById(idParameter);
        model.addAttribute("idThatWasFound", foundId);
        return "idResult";


    }
}









