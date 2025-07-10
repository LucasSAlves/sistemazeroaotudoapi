package br.com.lucas.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
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

import br.com.lucas.projeto.dto.PerfilDTO;
import br.com.lucas.projeto.service.PerfilService;

@RestController
@RequestMapping(value = "/perfil")
@CrossOrigin(origins = "http://localhost:3000")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public List<PerfilDTO> listarTodos() {
        return perfilService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<PerfilDTO> inserir(@RequestBody PerfilDTO perfil) {
        var salvo = perfilService.inserir(perfil.toEntity());
        return ResponseEntity.ok(new PerfilDTO(salvo));
    }
    
    @PutMapping
    public PerfilDTO alterar(@RequestBody PerfilDTO perfil) {
        return perfilService.alterar(perfil);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        try {
            perfilService.excluir(id);
            return ResponseEntity.noContent().build(); // 204 - sucesso sem conteúdo
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT) // 409 - conflito
                    .body("Não é possível excluir o perfil. Ele está vinculado a um ou mais usuários.");
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno ao tentar excluir o perfil.");
        }
    }
}