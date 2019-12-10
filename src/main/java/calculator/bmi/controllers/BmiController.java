package calculator.bmi.controllers;

import calculator.bmi.model.User;
import calculator.bmi.repository.UsersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Controller
public class BmiController {


    @RequestMapping("/index")
    public String landingPage(){
        return "index";
    }

    @RequestMapping(value = "/searchForm", method = RequestMethod.GET)
    public String searchFormPage(){

        return "searchForm";
    }



    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String formSubmit(@RequestParam() double heightParameter,
                             @RequestParam() double weightParameter,
                             @RequestParam() char sexParameter,
                             Long addedId,
                             Long addedBmi,
                             Model model){
        Random random = new Random();
        int anotherId = random.nextInt(8999)+1000;
        for (int i = 0; i < UsersRepository.usersList.size(); i++) {
            if (UsersRepository.usersList.get(i).getId() == anotherId) {
                anotherId = random.nextInt(8999) + 1000;
            }
        }
        User newUser = new User(heightParameter, weightParameter, sexParameter, addedId, addedBmi); // apka mówi, że nie idParameter nie istnieje...
        if (sexParameter != 'M' && sexParameter != 'm' && sexParameter != 'K' && sexParameter != 'k'){
            return "error";
        }else {
            UsersRepository.addNewUser(newUser);                                                // więc może on nie dodaje wyników do listy?
            newUser.setId((long) anotherId);                                                    // spróbuj może prznieść to w metodę
            double finalResult = UsersRepository.bmiResult(heightParameter, weightParameter, sexParameter);
            newUser.setBmi((long) finalResult);
            BigDecimal bd = new BigDecimal(finalResult).setScale(0, 1);
            model.addAttribute("myResult", bd);
            model.addAttribute("myId", anotherId);
            return "result";
        }
    }

    @RequestMapping(value = "/searchForm", method = RequestMethod.POST)
    public String searchFormSubmit(@RequestParam() Long idParameter, Model model){
        List<User> foundId = UsersRepository.getUserById(idParameter);
        model.addAttribute("idThatWasFound", foundId);
        return "idResult";

    }




}
