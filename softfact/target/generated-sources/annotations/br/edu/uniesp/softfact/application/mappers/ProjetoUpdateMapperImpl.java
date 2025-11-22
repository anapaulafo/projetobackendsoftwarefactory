package br.edu.uniesp.softfact.application.mappers;

import br.edu.uniesp.softfact.application.projeto.ProjetoUpdateRequest;
import br.edu.uniesp.softfact.domain.projeto.Projeto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-22T08:24:51-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Amazon.com Inc.)"
)
@Component
public class ProjetoUpdateMapperImpl implements ProjetoUpdateMapper {

    @Override
    public void updateDomainFromRequest(ProjetoUpdateRequest request, Projeto projeto) {
        if ( request == null ) {
            return;
        }

        projeto.setNome( request.nome() );
        projeto.setDescricao( request.descricao() );
    }
}
