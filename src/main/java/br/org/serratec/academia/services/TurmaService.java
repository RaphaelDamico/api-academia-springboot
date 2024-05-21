package br.org.serratec.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.academia.entities.Turma;
import br.org.serratec.academia.repositories.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	TurmaRepository turmaRepository;

	public List<Turma> findAll() {
		return turmaRepository.findAll();
	}

	public Turma findById(Integer id) {
		return turmaRepository.findById(id).orElse(null);
	}

	public Turma save(Turma turma) {
		return turmaRepository.save(turma);
	}

	public Turma update(Integer id, Turma turma) {
		Turma entidade = turmaRepository.getReferenceById(id);
		updateData(entidade, turma);
		return turmaRepository.save(entidade);
	}

	private void updateData(Turma entidade, Turma turma) {
		entidade.setNomeDisciplina(turma.getNomeDisciplina());
		entidade.setDiaSemana(turma.getDiaSemana());
		entidade.setInstrutor(turma.getInstrutor());

	}

	public Boolean delete(Integer id) {
		if (turmaRepository.existsById(id)) {
			turmaRepository.deleteById(id);
			Turma turmaDeletado = turmaRepository.findById(id).orElse(null);
			if (turmaDeletado == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public long count() {
		return turmaRepository.count();
	}
}