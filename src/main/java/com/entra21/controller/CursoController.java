package com.entra21.controller;

import com.entra21.model.Categoria;
import com.entra21.model.Curso;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class CursoController {

    @RequestMapping("/cursos")
    @ResponseBody
    public List<Curso> listarTudo(){
        Curso springWeb = new Curso(1L, "Spring web", new Categoria(1, "Programacao"));
        Curso postgreSQL = new Curso(2L, "PostgreSQL", new Categoria(2, "BD"));
        Curso css = new Curso(3L, "CSS", new Categoria(3, "Design"));
        return Arrays.asList(springWeb, postgreSQL, css);
    }

    public void salvar(){

    }
}
