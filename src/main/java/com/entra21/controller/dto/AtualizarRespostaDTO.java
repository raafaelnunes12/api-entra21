package com.entra21.controller.dto;

import com.entra21.model.Resposta;
import com.entra21.repositories.RespostaRepository;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizarRespostaDTO {

    @NotNull
    @NotEmpty
    @Length(min=5)
    private String mensagem;

    public AtualizarRespostaDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public Resposta atualizar (Long id, RespostaRepository respostaRepository){
        Resposta resposta = respostaRepository.getById(id);
        resposta.setMensagem(this.mensagem);
        return resposta;
    }
}
