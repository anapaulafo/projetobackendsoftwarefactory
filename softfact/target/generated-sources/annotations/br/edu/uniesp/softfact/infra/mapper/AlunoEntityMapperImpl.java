package br.edu.uniesp.softfact.infra.mapper;

import br.edu.uniesp.softfact.application.aluno.AlunoResponse;
import br.edu.uniesp.softfact.domain.aluno.Aluno;
import br.edu.uniesp.softfact.infra.aluno.AlunoEntity;
import br.edu.uniesp.softfact.shared.enums.Curso;
import br.edu.uniesp.softfact.shared.enums.Periodo;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-20T12:31:47-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Amazon.com Inc.)"
)
@Component
public class AlunoEntityMapperImpl implements AlunoEntityMapper {

    @Override
    public AlunoEntity toEntity(Aluno dto) {
        if ( dto == null ) {
            return null;
        }

        AlunoEntity.AlunoEntityBuilder alunoEntity = AlunoEntity.builder();

        alunoEntity.id( dto.getId() );
        alunoEntity.nome( dto.getNome() );
        alunoEntity.email( dto.getEmail() );
        alunoEntity.telefone( dto.getTelefone() );
        alunoEntity.curso( dto.getCurso() );
        alunoEntity.matricula( dto.getMatricula() );
        alunoEntity.periodo( dto.getPeriodo() );

        return alunoEntity.build();
    }

    @Override
    public AlunoResponse toResponse(AlunoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Set<Long> stacksIds = null;
        Long id = null;
        String nome = null;
        String email = null;
        String telefone = null;
        Curso curso = null;
        String matricula = null;
        Periodo periodo = null;

        stacksIds = AlunoEntityMapper.mapStacksIds( entity.getStacks() );
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
        telefone = entity.getTelefone();
        curso = entity.getCurso();
        matricula = entity.getMatricula();
        periodo = entity.getPeriodo();

        AlunoResponse alunoResponse = new AlunoResponse( id, nome, email, telefone, curso, matricula, periodo, stacksIds );

        return alunoResponse;
    }
}
