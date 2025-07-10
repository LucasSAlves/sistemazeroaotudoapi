package br.com.lucas.projeto.dto;

import org.springframework.beans.BeanUtils;

import br.com.lucas.projeto.entity.PermissaoPerfilRecursoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PermissaoPerfilRecursoDTO {

    private Long id;
    private PerfilDTO perfil;
    private RecursoDTO recurso;

    public PermissaoPerfilRecursoDTO(PermissaoPerfilRecursoEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity != null) {
            if (entity.getPerfil() != null) {
                this.perfil = new PerfilDTO(entity.getPerfil());
            }

            if (entity.getRecurso() != null) {
                this.recurso = new RecursoDTO(entity.getRecurso());
            }
        }
    }
}
