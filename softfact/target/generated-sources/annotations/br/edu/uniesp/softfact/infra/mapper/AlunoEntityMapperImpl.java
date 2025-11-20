package br.edu.uniesp.softfact.infra.mapper;

import br.edu.uniesp.softfact.application.aluno.AlunoResponse;
import br.edu.uniesp.softfact.domain.aluno.Aluno;
import br.edu.uniesp.softfact.infra.aluno.AlunoEntity;
import br.edu.uniesp.softfact.shared.enums.Curso;
import br.edu.uniesp.softfact.shared.enums.Periodo;
import br.edu.uniesp.softfact.zo.old.certificado.Certificado;
import br.edu.uniesp.softfact.zo.old.stack.StackTecnologia;
import br.edu.uniesp.softfact.zo.old.stack.dto.StackResumo;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-20T09:08:00-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
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
        Set<StackTecnologia> set = dto.getStacks();
        if ( set != null ) {
            alunoEntity.stacks( new LinkedHashSet<StackTecnologia>( set ) );
        }
        Set<Certificado> set1 = dto.getCertificados();
        if ( set1 != null ) {
            alunoEntity.certificados( new LinkedHashSet<Certificado>( set1 ) );
        }

        return alunoEntity.build();
    }

    @Override
    public AlunoResponse toResponse(AlunoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        String email = null;
        String telefone = null;
        Curso curso = null;
        String matricula = null;
        Periodo periodo = null;
        Set<StackResumo> stacks = null;

        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
        telefone = entity.getTelefone();
        curso = entity.getCurso();
        matricula = entity.getMatricula();
        periodo = entity.getPeriodo();
        stacks = stackTecnologiaSetToStackResumoSet( entity.getStacks() );

        AlunoResponse alunoResponse = new AlunoResponse( id, nome, email, telefone, curso, matricula, periodo, stacks );

        return alunoResponse;
    }

    protected StackResumo stackTecnologiaToStackResumo(StackTecnologia stackTecnologia) {
        if ( stackTecnologia == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        String categoria = null;

        id = stackTecnologia.getId();
        nome = stackTecnologia.getNome();
        categoria = stackTecnologia.getCategoria();

        StackResumo stackResumo = new StackResumo( id, nome, categoria );

        return stackResumo;
    }

    protected Set<StackResumo> stackTecnologiaSetToStackResumoSet(Set<StackTecnologia> set) {
        if ( set == null ) {
            return null;
        }

        Set<StackResumo> set1 = LinkedHashSet.newLinkedHashSet( set.size() );
        for ( StackTecnologia stackTecnologia : set ) {
            set1.add( stackTecnologiaToStackResumo( stackTecnologia ) );
        }

        return set1;
    }
}
