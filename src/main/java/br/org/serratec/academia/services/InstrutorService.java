package br.org.serratec.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.academia.entities.Instrutor;
import br.org.serratec.academia.repositories.InstrutorRepository;

@Service
public class InstrutorService {

	@Autowired
	InstrutorRepository instrutorRepository;

	public List<Instrutor> findAll() {
		return instrutorRepository.findAll();
	}

	public Instrutor findById(Integer id) {
		return instrutorRepository.findById(id).orElse(null);
	}

	public Instrutor save(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}

	public Instrutor update(Integer id, Instrutor instrutor) {
		Instrutor entidade = instrutorRepository.getReferenceById(id);
		updateData(entidade, instrutor);
		return instrutorRepository.save(entidade);
	}

	private void updateData(Instrutor entidade, Instrutor instrutor) {
		entidade.setRg(instrutor.getRg());
		entidade.setNomeInstrutor(instrutor.getNomeInstrutor());
		entidade.setTelefone(instrutor.getTelefone());
		entidade.setTurma(instrutor.getTurma());

	}

	public Boolean delete(Integer id) {
		if (instrutorRepository.existsById(id)) {
			instrutorRepository.deleteById(id);
			Instrutor instrutorDeletado = instrutorRepository.findById(id).orElse(null);
			if (instrutorDeletado == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public long count() {
		return instrutorRepository.count();
	}
}