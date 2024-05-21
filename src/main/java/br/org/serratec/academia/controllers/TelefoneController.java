package br.org.serratec.academia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.academia.entities.Telefone;
import br.org.serratec.academia.services.TelefoneService;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {

	@Autowired
	TelefoneService telefoneService;

	@GetMapping
	public ResponseEntity<List<Telefone>> findAll() {
		return new ResponseEntity<>(telefoneService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Telefone> findById(@PathVariable Integer id) {
		Telefone telefone = telefoneService.findById(id);

		if (telefone == null)
			return new ResponseEntity<>(telefone, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(telefone, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Telefone> save(@RequestBody Telefone telefone) {
		return new ResponseEntity<>(telefoneService.save(telefone), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Telefone> update(@PathVariable Integer id, @RequestBody Telefone telefone) {
		telefone = telefoneService.update(id, telefone);
		return ResponseEntity.ok().body(telefone);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		Boolean deletado = telefoneService.delete(id);
		if (deletado)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}