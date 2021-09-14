package com.entra21.controller;

import com.entra21.controller.dto.TopicoDTO;
import com.entra21.model.*;
import com.entra21.repositories.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    TopicoRepository topicoRepository;

    @GetMapping
    public List<TopicoDTO> listar(String nomeCurso) {
        List<Topico> topicoList;

        if (nomeCurso == null) {
            topicoList = topicoRepository.findAll();
        } else {
            topicoList = topicoRepository.carregarPorNomeDoCurso(nomeCurso);
        }
        return TopicoDTO.converter(topicoList);
    }
}