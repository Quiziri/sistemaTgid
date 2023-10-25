package br.com.sistemaTgid.repository;

import br.com.sistemaTgid.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
