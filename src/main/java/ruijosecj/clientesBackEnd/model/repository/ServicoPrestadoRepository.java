package ruijosecj.clientesBackEnd.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ruijosecj.clientesBackEnd.model.entity.ServicoPrestado;

@Repository
public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {
	
	@Query("select s from ServicoPrestado s join s.cliente c where UPPER(c.nome) like UPPER( :nome) and MONTH(s.dataServico) = :mes")
	List<ServicoPrestado> findByNomeClienteAndMes(@Param("nome") String nome, @Param("mes") Integer mes);
}
