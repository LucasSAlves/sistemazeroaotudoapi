package br.com.lucas.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.projeto.dto.PermissaoPerfilRecursoDTO;
import br.com.lucas.projeto.service.PermissaoPerfilRecursoService;

@RestController
@RequestMapping(value = "/permissao-perfil-recurso")
@CrossOrigin
public class PermissaoPerfilRecursoController {

	
	@Autowired
    private PermissaoPerfilRecursoService permissaoPerfilRecursoService;

	@GetMapping
    public List<PermissaoPerfilRecursoDTO> listarTodos() {
        return permissaoPerfilRecursoService.listarTodos();
    }

	@PostMapping
    public ResponseEntity<Void> inserir(@RequestBody PermissaoPerfilRecursoDTO permissaoPerfilRecurso) {
        permissaoPerfilRecursoService.inserir(permissaoPerfilRecurso);
        return ResponseEntity.ok().build();
    }
    
	@PutMapping
    public ResponseEntity<PermissaoPerfilRecursoDTO> alterar(@RequestBody PermissaoPerfilRecursoDTO permissaoPerfilRecurso) {
        var atualizado = permissaoPerfilRecursoService.alterar(permissaoPerfilRecurso);
        return ResponseEntity.ok(atualizado);
    }

	@DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        permissaoPerfilRecursoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

