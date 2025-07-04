package br.com.lucas.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.projeto.entity.PerfilUsuarioEntity;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuarioEntity, Long> {

}
