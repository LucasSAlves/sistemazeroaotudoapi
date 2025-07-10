package br.com.lucas.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.lucas.projeto.dto.PermissaoPerfilRecursoDTO;
import br.com.lucas.projeto.entity.PermissaoPerfilRecursoEntity;
import br.com.lucas.projeto.repository.PermissaoPerfilRecursoRepository;

@Service
public class PermissaoPerfilRecursoService {
		
		@Autowired
		 private PermissaoPerfilRecursoRepository permissaoPerfilRecursoRepository;
		
		public List<PermissaoPerfilRecursoDTO> listarTodos() {
			List<PermissaoPerfilRecursoEntity> permissaoPerfilRecursos = permissaoPerfilRecursoRepository.findAll();
			return permissaoPerfilRecursos.stream().map(PermissaoPerfilRecursoDTO::new).toList();
		}
		
		public void inserir(PermissaoPerfilRecursoDTO permissaoPerfilRecurso) {
			PermissaoPerfilRecursoEntity permissaoPerfilRecursoEntity = new PermissaoPerfilRecursoEntity(permissaoPerfilRecurso);
			permissaoPerfilRecursoRepository.save(permissaoPerfilRecursoEntity);
		}
		
		public PermissaoPerfilRecursoDTO alterar(PermissaoPerfilRecursoDTO permissaoPerfilRecurso) {
	        PermissaoPerfilRecursoEntity permissaoPerfilRecursoEntity = new PermissaoPerfilRecursoEntity(permissaoPerfilRecurso);
	        return new PermissaoPerfilRecursoDTO(permissaoPerfilRecursoRepository.save(permissaoPerfilRecursoEntity));
	    }
		
		public void excluir(Long id) {
			PermissaoPerfilRecursoEntity  permissaoPerfilRecursoEntity  = permissaoPerfilRecursoRepository.findById(id).get();
			permissaoPerfilRecursoRepository.delete(permissaoPerfilRecursoEntity);
		}
		
		public PermissaoPerfilRecursoDTO buscarPorId(Long id) {
			return new PermissaoPerfilRecursoDTO
					(permissaoPerfilRecursoRepository.findById(id).get());
		}
}
