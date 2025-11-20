package br.edu.uniesp.softfact.application.mappers;

import br.edu.uniesp.softfact.application.aluno.AlunoUpdateRequest;
import br.edu.uniesp.softfact.domain.aluno.Aluno;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-20T12:31:47-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Amazon.com Inc.)"
)
@Component
public class AlunoUpdateMapperImpl implements AlunoUpdateMapper {

    @Override
    public Aluno toDomain(AlunoUpdateRequest request) {
        if ( request == null ) {
            return null;
        }

        Aluno.AlunoBuilder aluno = Aluno.builder();

        aluno.nome( request.nome() );
        aluno.email( request.email() );
        aluno.telefone( request.telefone() );
        aluno.curso( request.curso() );
        aluno.matricula( request.matricula() );
        aluno.periodo( request.periodo() );

        return aluno.build();
    }
}
