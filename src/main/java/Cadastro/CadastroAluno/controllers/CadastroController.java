package Cadastro.CadastroAluno.controllers;

import Cadastro.CadastroAluno.models.CadastroModel;
import Cadastro.CadastroAluno.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CadastroController {

    @Autowired
    private CadastroRepository cr;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String form(){
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String form(@Valid CadastroModel cadastroModel, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "verifique todos os campos.");
        }
        else if(cadastroModel.getNome().length() <= 2 ||
                cadastroModel.getMatricula().length() <= 2 ||
                cadastroModel.getSobrenome().length() <= 2){
            attributes.addFlashAttribute("mensagem", "Campos com no mínimo 3 caractéres.");
            return "redirect:/index";
        }
        else{
            cr.save(cadastroModel);
            attributes.addFlashAttribute("mensagem", "Aluno cadastrado.");
        }
        return "redirect:/index";
    }
}
