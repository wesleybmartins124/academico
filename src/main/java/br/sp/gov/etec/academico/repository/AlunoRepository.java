package br.sp.gov.etec.academico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sp.gov.etec.academico.dto.AlunoEntity;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long>{

}
