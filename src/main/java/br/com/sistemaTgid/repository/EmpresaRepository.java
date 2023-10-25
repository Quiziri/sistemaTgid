package br.com.sistemaTgid.repository;

import br.com.sistemaTgid.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, String> {

}
