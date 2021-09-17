package com.entra21.controller.dto;

import com.entra21.model.Usuario;
import com.entra21.repositories.UsuarioRepository;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizarUsuarioDTO {

    @NotNull
    @NotEmpty
    @Length(min=5)
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario atualizar (Long id, UsuarioRepository usuarioRepository){
        Usuario usuario = usuarioRepository.getById(id);
        usuario.setNome(this.nome);
        return usuario;
    }
}
