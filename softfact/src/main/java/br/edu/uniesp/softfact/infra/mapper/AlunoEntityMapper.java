package br.edu.uniesp.softfact.infra.mapper;

import br.edu.uniesp.softfact.application.aluno.AlunoResponse;
import br.edu.uniesp.softfact.domain.aluno.Aluno;
import br.edu.uniesp.softfact.infra.aluno.AlunoEntity;
import br.edu.uniesp.softfact.zo.old.stack.StackTecnologia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AlunoEntityMapper {

    // Mapper do DTO -> Entidade
    @Mapping(target = "stacks", ignore = true) // Ignora stacks ao criar/atualizar a entidade
    @Mapping(target = "certificados", ignore = true)
    AlunoEntity toEntity(Aluno dto);

    // Mapper da Entidade -> Response DTO
    @Mapping(target = "stacksIds", source = "stacks", qualifiedByName = "mapStacksIds")
    AlunoResponse toResponse(AlunoEntity entity);

    // Método auxiliar para extrair IDs das stacks
    @Named("mapStacksIds")
    static Set<Long> mapStacksIds(Set<StackTecnologia> stacks) {
        if (stacks == null) return Set.of();
        return stacks.stream()
                .map(StackTecnologia::getId)
                .collect(Collectors.toSet());
    }
}
