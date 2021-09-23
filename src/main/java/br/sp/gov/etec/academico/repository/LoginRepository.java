package br.sp.gov.etec.academico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sp.gov.etec.academico.entity.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, Long>{
	
	LoginEntity findByLogin(String login);

}
