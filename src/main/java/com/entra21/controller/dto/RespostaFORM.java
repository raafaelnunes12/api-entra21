package com.entra21.controller.dto;

import com.entra21.model.Resposta;
import com.entra21.model.Topico;
import com.entra21.model.Usuario;
import com.entra21.repositories.RespostaRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RespostaFORM {

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String mensagem;
    @NotNull
    @NotEmpty
    @Length(min = 5)
    private Topico topico;
    @NotNull
    @NotEmpty
    @Length(min = 5)
    private Usuario autor;

    public String getMensagem() {
        return mensagem;
    }

    public Topico getTopico() {
        return topico;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Resposta converter(RespostaRepository respostaRepository) {
        Resposta resposta = respostaRepository.findByNome(mensagem);
        return new Resposta(mensagem);
    }
}
