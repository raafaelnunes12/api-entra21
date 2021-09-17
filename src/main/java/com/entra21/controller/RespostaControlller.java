package com.entra21.controller;

import com.entra21.controller.dto.AtualizarRespostaDTO;
import com.entra21.controller.dto.RespostaDTO;
import com.entra21.controller.dto.RespostaFORM;
import com.entra21.model.Resposta;
import com.entra21.repositories.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resposta")
public class RespostaControlller {

    @Autowired
    RespostaRepository respostaRepository;

    @GetMapping
    public List<RespostaDTO> listar(){
        List<Resposta> respostaList = respostaRepository.findAll();
        return RespostaDTO.converter(respostaList);
    }

    @PostMapping
    public ResponseEntity<RespostaDTO> gravar(@RequestBody @Valid RespostaFORM respostaFORMFORM, UriComponentsBuilder uriComponentsBuilder){
        Resposta resposta = respostaFORMFORM.converter(respostaRepository);
        respostaRepository.save(resposta);

        URI uri = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(resposta.getId()).toUri();
        return ResponseEntity.created(uri).body(new RespostaDTO(resposta));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Resposta> resposta = respostaRepository.findById(id);

        if (resposta.isPresent()){
            respostaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<RespostaDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarRespostaDTO form){
        Optional<Resposta> respostaPesquisada = respostaRepository.findById(id);
        if (respostaPesquisada.isPresent()) {
            Resposta resposta = form.atualizar(id, respostaRepository);
            return ResponseEntity.ok(new RespostaDTO(resposta));
        }
        return ResponseEntity.notFound().build();
    }

}
