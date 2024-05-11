package br.com.fiap.empregados.controllers;

import br.com.fiap.empregados.dto.DepartamentoDTO;
import br.com.fiap.empregados.dto.EmpregadoDTO;
import br.com.fiap.empregados.dto.ProjetoDTO;
import br.com.fiap.empregados.services.DepartamentoService;
import br.com.fiap.empregados.services.EmpregadoService;
import br.com.fiap.empregados.services.ProjetoService;
import jakarta.validation.Valid;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/empregados")
public class EmpregadoController {

    @Autowired
    private EmpregadoService service;

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private ProjetoService projetoService;

    @ModelAttribute("projetos")
    public List<ProjetoDTO> projetos() {
        return projetoService.findAll();
    }

    @ModelAttribute("departamentos")
    public List<DepartamentoDTO> departamentos(){
        return departamentoService.findAll();
    }

    @GetMapping("/form")
    public String loadForm(Model model){
        EmpregadoDTO empregadoDTO = new EmpregadoDTO();
        model.addAttribute("empregadoDTO", empregadoDTO);
        List<DepartamentoDTO> departamentos = departamentoService.findAll();
        model.addAttribute("departamentos", departamentos); // Adicionar departamentos ao modelo
        return "empregado/novo-empregado";
    }


    @PostMapping()
    public String insert(@Valid EmpregadoDTO empregadoDTO,
                         BindingResult result,
                         RedirectAttributes attributes){
        if (result.hasErrors()){
            return "empregado/novo-empregado";
        }
        empregadoDTO = service.insert(empregadoDTO);
        attributes.addFlashAttribute("mensagem", "Empregado salvo com sucesso");
        return "redirect:/empregados/form";
    }

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("empregados", service.findAll());
        return "/empregado/listar-empregados";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model){
        EmpregadoDTO empregadoDTO = service.findById(id);
        model.addAttribute("empregadoDTO", empregadoDTO);
        return "/empregado/editar-empregado";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") Long id,
                           @Valid EmpregadoDTO empregadoDTO,
                           BindingResult result) {
        if (result.hasErrors()) {
            empregadoDTO.setId(id);
            return "/empregado/editar-empregado";
        }
        service.update(id, empregadoDTO);
        return "redirect:/empregados";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id, Model model){
        service.delete(id);
        return "redirect:/empregados";
    }
}
