package br.com.lucas.projeto.dto;

import org.springframework.beans.BeanUtils;

import br.com.lucas.projeto.entity.PerfilEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PerfilDTO {

	private Long id;
	
	private String descricao;
	
	public PerfilDTO(PerfilEntity perfil) {
		BeanUtils.copyProperties(perfil, this);
	}
	
	public PerfilEntity toEntity() {
	    PerfilEntity entity = new PerfilEntity();
	    BeanUtils.copyProperties(this, entity);
	    return entity;
	}
}
