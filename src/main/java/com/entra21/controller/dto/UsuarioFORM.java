package com.entra21.controller.dto;

import com.entra21.model.Usuario;
import com.entra21.repositories.UsuarioRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioFORM {

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String nome;

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String email;

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String senha;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario converter(UsuarioRepository usuarioRepository) {
        Usuario usuario = usuarioRepository.findByNome(nome);
        return new Usuario(nome, email, senha);
    }
}
