package com.entra21.controller;

import com.entra21.model.Categoria;
import com.entra21.model.Curso;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class CategoriaController {

    @RequestMapping("/categoria")
    @ResponseBody
    public List<Categoria> listarTudo() {
        Categoria programacao = new Categoria(1, "JAVA");
        Categoria design = new Categoria(2, "UX");
        return Arrays.asList(programacao, design);
    }
}
