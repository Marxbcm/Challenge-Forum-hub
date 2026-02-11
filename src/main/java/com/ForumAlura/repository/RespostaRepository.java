package com.ForumAlura.repository;

import com.ForumHub.model.resposta.Resposta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepository  extends JpaRepository<Resposta, Long> {

    Page<Resposta> findAll(Pageable paginacao);
}

