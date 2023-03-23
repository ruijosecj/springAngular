package ruijosecj.clientesBackEnd.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ruijosecj.clientesBackEnd.model.entity.Cliente;
import ruijosecj.clientesBackEnd.model.repository.ClienteReppository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteReppository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(@Valid @RequestBody Cliente cliente){
		return repository.save(cliente);
	}
	
	@GetMapping("/{id}")
	public Cliente acharPorId(@PathVariable Integer id) {
		return repository.findById(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		repository
			.findById(id)
			.map(cliente -> {
				repository.delete(cliente);
				return Void.TYPE;
			})
			.orElseThrow(()-> new ResponseStatusException(HttpStatus.NO_CONTENT, "Cliente não encontrado."));
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Cliente acharPorId(@PathVariable Integer id, @Valid @RequestBody Cliente clienteAtualizar) {
		return repository
				.findById(id)
				.map(cliente -> {
					clienteAtualizar.setId(id);
					return repository.save(clienteAtualizar);
				})
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NO_CONTENT, "Cliente não encontrado."));
	}

}
