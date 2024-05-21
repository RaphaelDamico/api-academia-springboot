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

import br.org.serratec.academia.entities.Turma;
import br.org.serratec.academia.services.TurmaService;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

	@Autowired
	TurmaService turmaService;

	@GetMapping
	public ResponseEntity<List<Turma>> findAll() {
		return new ResponseEntity<>(turmaService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Turma> findById(@PathVariable Integer id) {
		Turma turma = turmaService.findById(id);

		if (turma == null)
			return new ResponseEntity<>(turma, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(turma, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Turma> save(@RequestBody Turma turma) {
		return new ResponseEntity<>(turmaService.save(turma), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Turma> update(@PathVariable Integer id, @RequestBody Turma turma) {
		turma = turmaService.update(id, turma);
		return ResponseEntity.ok().body(turma);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		Boolean deletado = turmaService.delete(id);
		if (deletado)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}