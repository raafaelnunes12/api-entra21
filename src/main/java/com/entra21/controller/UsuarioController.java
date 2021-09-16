package com.entra21.controller;

import com.entra21.controller.dto.*;
import com.entra21.model.Topico;
import com.entra21.model.Usuario;
import com.entra21.repositories.UsuarioRepository;
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
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public List<UsuarioDTO> listar(){
        List<Usuario> usuarioList = usuarioRepository.findAll();
        return UsuarioDTO.converter(usuarioList);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> gravar(@RequestBody @Valid UsuarioFORM usuarioFORM, UriComponentsBuilder uriComponentsBuilder){
        Usuario usuario = usuarioFORM.converter(usuarioRepository);
        usuarioRepository.save(usuario);

        URI uri = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()){
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UsuarioDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarUsuarioDTO form){
        Optional<Usuario> usuarioPesquisado = usuarioRepository.findById(id);
        if (usuarioPesquisado.isPresent()) {
            Usuario usuario = form.atualizar(id, usuarioRepository);
            return ResponseEntity.ok(new UsuarioDTO(usuario));
        }
        return ResponseEntity.notFound().build();
    }
}
