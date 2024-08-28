package com.ESFE.Asistencia.controladores;
import com.ESFE.Asistencia.entidades.Docente;
import com.ESFE.Asistencia.servicios.interfaces.iDocenteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/docentes")
public class DocenteController {
    @Autowired
    private iDocenteServices docenteServices;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1) - 1;
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        Page<Docente> docentes = docenteServices.BuscarTodosPaginados(pageable);
        model.addAttribute("docentes", docentes);

        int totalPage = docentes.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pageNumber = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());

            model.addAttribute("pageNumber", pageNumber);
        }
        return "docente/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("docente", new Docente());
        return "docente/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("docente") Docente docente, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("docente", docente);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error");
            return "docente/create";
        }

        docenteServices.CrearOeditar(docente);
        attributes.addFlashAttribute("msg", "Docente creado correctamente");
        return "redirect:/docentes";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model) {
        Optional<Docente> docenteOpt = docenteServices.BuscarPorId(id);
        if (docenteOpt.isPresent()) {
            model.addAttribute("docente", docenteOpt.get());
            return "docente/details";
        } else {
            return "redirect:/docentes";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Optional<Docente> docenteOpt = docenteServices.BuscarPorId(id);
        if (docenteOpt.isPresent()) {
            model.addAttribute("docente", docenteOpt.get());
            return "docente/edit";
        } else {
            return "redirect:/docentes";
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model) {
        Optional<Docente> docenteOpt = docenteServices.BuscarPorId(id);
        if (docenteOpt.isPresent()) {
            model.addAttribute("docente", docenteOpt.get());
            return "docente/delete";
        } else {
            return "redirect:/docentes";
        }
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("docente") Docente docente, RedirectAttributes attributes) {
        docenteServices.EliminarPorId(docente.getId());
        attributes.addFlashAttribute("msg", "Docente eliminado correctamente");
        return "redirect:/docentes";
    }
}


