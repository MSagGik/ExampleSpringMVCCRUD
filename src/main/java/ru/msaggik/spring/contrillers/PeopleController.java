package ru.msaggik.spring.contrillers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.msaggik.spring.dao.PeopleDAO;

@Controller
@RequestMapping("/people")
public class PeopleController {
    // внедрение бина PeopleDAO в данный контроллер
    private final PeopleDAO peopleDAO;
    @Autowired
    public PeopleController(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }
    // получение списка всех пользователей из DAO и передача его в представление
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", peopleDAO.index());
        return "people/index";
    }
    // получение информации одного пользователя по id из DAO и передача её в представление
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", peopleDAO.show(id));
        return "people/show";
    }
}
