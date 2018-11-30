package com.example.demotask;

import com.example.demotask.models.RegistrModel;
import com.example.demotask.models.TelbookModel;
import com.example.demotask.models.UsersModel;
import com.example.demotask.repos.TelbookRepo;
import com.example.demotask.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

    private String username;

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private TelbookRepo telbookRepo;

    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showForm(Model model) {

        RegistrModel usersModel = new RegistrModel();
        model.addAttribute("user", usersModel);
        model.addAttribute("error", "");

        return "registr";
    }

    @RequestMapping(value = "/processForm", method = RequestMethod.POST)
    public String processForm(@ModelAttribute(value = "user") RegistrModel user, Model model) {
        UsersModel usersModel = new UsersModel();

        UsersModel users = usersRepo.findByUserName(user.getUsername());
        if(users!=null){
            model.addAttribute("user",new RegistrModel());
            model.addAttribute("error", "this username is already in use");
            return "registr";
        }

        if(user.getCon_password().equals(user.getPassword())){
            usersModel.setUserName(user.getUsername());
            usersModel.setPassword(user.getPassword());
            usersRepo.save(usersModel);
        } else {
            model.addAttribute("user",new RegistrModel());
            model.addAttribute("error", "password doesn't match");
            return "registr";
        }


        model.addAttribute("user", usersModel);

        return "bookpage";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String signIn(Model model) {

        UsersModel usersModel = new UsersModel();
        model.addAttribute("user", usersModel);
        model.addAttribute("error", "");

        return "signin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(value = "user") UsersModel user, Model model) {

        UsersModel asd = usersRepo.findByUserName(user.getUserName());
        if(asd == null){
            UsersModel usersModel = new UsersModel();
            model.addAttribute("user", usersModel);

            model.addAttribute("error", "username doesn't exist");
            return "signin";
        }
        if (asd.getPassword().equals(user.getPassword())) {
            model.addAttribute("user", asd);
            TelbookModel telbookModel = new TelbookModel();
            model.addAttribute("book", telbookModel);
            System.out.println("U ARE FUCKING BITCH");
            username = asd.getUserName();
            return "bookpage";
        }

        UsersModel usersModel = new UsersModel();
        model.addAttribute("user", usersModel);

        model.addAttribute("error", "wrong password");
        return "signin";

    }

    @RequestMapping(value = "/createBook", method = RequestMethod.POST)
    public String createBook(@ModelAttribute(value = "book") TelbookModel book, Model model){
        UsersModel usersModel = usersRepo.findByUserName(username);

        model.addAttribute("book", book);
        model.addAttribute("user", usersModel);
        return "bookpage";
    }
}
