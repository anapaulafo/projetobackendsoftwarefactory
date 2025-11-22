package br.edu.uniesp.softfact.application.mappers;

import br.edu.uniesp.softfact.application.projeto.ProjetoCreateRequest;
import br.edu.uniesp.softfact.domain.projeto.Projeto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-22T08:24:51-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Amazon.com Inc.)"
)
@Component
public class ProjetoCreateMapperImpl implements ProjetoCreateMapper {

    @Override
    public Projeto toDomain(ProjetoCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        Projeto.ProjetoBuilder projeto = Projeto.builder();

        projeto.nome( request.nome() );
        projeto.descricao( request.descricao() );

        return projeto.build();
    }
}
