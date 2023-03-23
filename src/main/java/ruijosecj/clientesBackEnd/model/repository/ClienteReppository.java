package ruijosecj.clientesBackEnd.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ruijosecj.clientesBackEnd.model.entity.Cliente;

@Repository
public interface ClienteReppository extends JpaRepository<Cliente, Integer> {

	

}
