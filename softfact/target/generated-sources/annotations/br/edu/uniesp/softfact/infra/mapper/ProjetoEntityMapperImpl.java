package br.edu.uniesp.softfact.infra.mapper;

import br.edu.uniesp.softfact.application.aluno.AlunoResponse;
import br.edu.uniesp.softfact.application.projeto.ProjetoResponse;
import br.edu.uniesp.softfact.domain.aluno.Aluno;
import br.edu.uniesp.softfact.domain.projeto.Projeto;
import br.edu.uniesp.softfact.infra.aluno.AlunoEntity;
import br.edu.uniesp.softfact.infra.projeto.ProjetoEntity;
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
    date = "2025-11-22T08:33:13-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Amazon.com Inc.)"
)
@Component
public class ProjetoEntityMapperImpl implements ProjetoEntityMapper {

    @Override
    public ProjetoEntity toEntity(Projeto dto) {
        if ( dto == null ) {
            return null;
        }

        ProjetoEntity.ProjetoEntityBuilder projetoEntity = ProjetoEntity.builder();

        projetoEntity.id( dto.getId() );
        projetoEntity.nome( dto.getNome() );
        projetoEntity.descricao( dto.getDescricao() );
        projetoEntity.alunos( alunoSetToAlunoEntitySet( dto.getAlunos() ) );
        Set<StackTecnologia> set1 = dto.getStacks();
        if ( set1 != null ) {
            projetoEntity.stacks( new LinkedHashSet<StackTecnologia>( set1 ) );
        }

        return projetoEntity.build();
    }

    @Override
    public ProjetoResponse toResponse(ProjetoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        String descricao = null;
        Set<AlunoResponse> alunos = null;
        Set<StackResumo> stacks = null;

        id = entity.getId();
        nome = entity.getNome();
        descricao = entity.getDescricao();
        alunos = alunoEntitySetToAlunoResponseSet( entity.getAlunos() );
        stacks = stackTecnologiaSetToStackResumoSet( entity.getStacks() );

        ProjetoResponse projetoResponse = new ProjetoResponse( id, nome, descricao, alunos, stacks );

        return projetoResponse;
    }

    @Override
    public Projeto toDomain(ProjetoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Projeto.ProjetoBuilder projeto = Projeto.builder();

        projeto.id( entity.getId() );
        projeto.nome( entity.getNome() );
        projeto.descricao( entity.getDescricao() );
        projeto.alunos( alunoEntitySetToAlunoSet( entity.getAlunos() ) );
        Set<StackTecnologia> set1 = entity.getStacks();
        if ( set1 != null ) {
            projeto.stacks( new LinkedHashSet<StackTecnologia>( set1 ) );
        }

        return projeto.build();
    }

    protected AlunoEntity alunoToAlunoEntity(Aluno aluno) {
        if ( aluno == null ) {
            return null;
        }

        AlunoEntity.AlunoEntityBuilder alunoEntity = AlunoEntity.builder();

        alunoEntity.id( aluno.getId() );
        alunoEntity.nome( aluno.getNome() );
        alunoEntity.email( aluno.getEmail() );
        alunoEntity.telefone( aluno.getTelefone() );
        alunoEntity.curso( aluno.getCurso() );
        alunoEntity.matricula( aluno.getMatricula() );
        alunoEntity.periodo( aluno.getPeriodo() );
        Set<Certificado> set = aluno.getCertificados();
        if ( set != null ) {
            alunoEntity.certificados( new LinkedHashSet<Certificado>( set ) );
        }

        return alunoEntity.build();
    }

    protected Set<AlunoEntity> alunoSetToAlunoEntitySet(Set<Aluno> set) {
        if ( set == null ) {
            return null;
        }

        Set<AlunoEntity> set1 = LinkedHashSet.newLinkedHashSet( set.size() );
        for ( Aluno aluno : set ) {
            set1.add( alunoToAlunoEntity( aluno ) );
        }

        return set1;
    }

    protected AlunoResponse alunoEntityToAlunoResponse(AlunoEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        String email = null;
        String telefone = null;
        Curso curso = null;
        String matricula = null;
        Periodo periodo = null;

        id = alunoEntity.getId();
        nome = alunoEntity.getNome();
        email = alunoEntity.getEmail();
        telefone = alunoEntity.getTelefone();
        curso = alunoEntity.getCurso();
        matricula = alunoEntity.getMatricula();
        periodo = alunoEntity.getPeriodo();

        Set<Long> stacksIds = null;

        AlunoResponse alunoResponse = new AlunoResponse( id, nome, email, telefone, curso, matricula, periodo, stacksIds );

        return alunoResponse;
    }

    protected Set<AlunoResponse> alunoEntitySetToAlunoResponseSet(Set<AlunoEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<AlunoResponse> set1 = LinkedHashSet.newLinkedHashSet( set.size() );
        for ( AlunoEntity alunoEntity : set ) {
            set1.add( alunoEntityToAlunoResponse( alunoEntity ) );
        }

        return set1;
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

    protected Aluno alunoEntityToAluno(AlunoEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        Aluno.AlunoBuilder aluno = Aluno.builder();

        aluno.id( alunoEntity.getId() );
        aluno.nome( alunoEntity.getNome() );
        aluno.email( alunoEntity.getEmail() );
        aluno.telefone( alunoEntity.getTelefone() );
        aluno.curso( alunoEntity.getCurso() );
        aluno.matricula( alunoEntity.getMatricula() );
        aluno.periodo( alunoEntity.getPeriodo() );
        Set<Certificado> set = alunoEntity.getCertificados();
        if ( set != null ) {
            aluno.certificados( new LinkedHashSet<Certificado>( set ) );
        }

        return aluno.build();
    }

    protected Set<Aluno> alunoEntitySetToAlunoSet(Set<AlunoEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<Aluno> set1 = LinkedHashSet.newLinkedHashSet( set.size() );
        for ( AlunoEntity alunoEntity : set ) {
            set1.add( alunoEntityToAluno( alunoEntity ) );
        }

        return set1;
    }
}
