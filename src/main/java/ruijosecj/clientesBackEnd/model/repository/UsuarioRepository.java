package ruijosecj.clientesBackEnd.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ruijosecj.clientesBackEnd.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Optional<Usuario> findByUsername(String username);
	
	// select count(*) > 0 from Usuario where username = :login
	boolean existsByUsername(String usuario);


}
