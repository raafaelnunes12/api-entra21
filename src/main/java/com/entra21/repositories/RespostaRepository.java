package com.entra21.repositories;

import com.entra21.model.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
    Resposta findByNome(String mensagem);
}
