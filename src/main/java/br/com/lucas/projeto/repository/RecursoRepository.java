package br.com.lucas.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.lucas.projeto.entity.RecursoEntity;

public interface RecursoRepository extends JpaRepository<RecursoEntity, Long> {
}