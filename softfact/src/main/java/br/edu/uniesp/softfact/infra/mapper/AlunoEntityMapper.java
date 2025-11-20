package br.edu.uniesp.softfact.infra.mapper;

import br.edu.uniesp.softfact.application.aluno.AlunoResponse;
import br.edu.uniesp.softfact.domain.aluno.Aluno;
import br.edu.uniesp.softfact.infra.aluno.AlunoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlunoEntityMapper {

    @Mapping(target = "stacks", ignore = true)
    @Mapping(target = "certificados", ignore = true)
    AlunoEntity toEntity(Aluno dto);

    @Mapping(target = "stacks", ignore = true)
    @Mapping(target = "certificados", ignore = true)
    AlunoResponse toResponse(AlunoEntity entity);
}