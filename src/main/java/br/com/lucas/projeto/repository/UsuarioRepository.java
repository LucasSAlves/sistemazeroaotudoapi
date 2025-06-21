package br.com.lucas.projeto.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.projeto.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}
