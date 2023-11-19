package com.example.project.dao;

import com.example.project.exception.ResourceAlreadyExistsException;
import com.example.project.exception.ResourceDoesNotExistException;
import com.example.project.model.Professor;
import com.example.project.repository.ProfessorRepository;
import com.example.project.service.ProfessorService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorDAO implements ProfessorService{

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public Professor save(Professor professor) throws ResourceAlreadyExistsException {
        Optional<Professor> optionalProfessor = professorRepository.findById(professor.getId());
        if(optionalProfessor.isPresent()) {
            throw new ResourceAlreadyExistsException(professor.getId());
        } else {
            return professorRepository.save(professor);
        }
    }

    @Override
    public Professor get(int id) throws ResourceDoesNotExistException {
        Optional<Professor> optionalProfessor = professorRepository.findById(id);
        if (optionalProfessor.isPresent()) {
            return optionalProfessor.get();
        }else throw new ResourceDoesNotExistException(id);
    }

    @Override
    public List<Professor> getAll() {
        List<Professor> professors = new ArrayList<>();
        professors.addAll((Collection<? extends Professor>) professorRepository.findAll());
        return professors;
    }

    @Override
    public void delete(int id) throws ResourceDoesNotExistException{
        Optional<Professor> optionalProfessor = professorRepository.findById(id);
        optionalProfessor.ifPresent(professor -> professorRepository.deleteById(id));
        optionalProfessor.orElseThrow(() -> new ResourceDoesNotExistException(id));
    }

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Professor> search(String keyword) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Professor> query = currentSession.createQuery("FROM Professor p WHERE p.name LIKE :nameprof OR p.qualification LIKE :qualification OR p.department LIKE :dep ", Professor.class)
                .setParameter("nameprof","%"+keyword+"%")
                .setParameter("dep","%"+keyword+"%")
                .setParameter("gender","%"+keyword+"%");

        List<Professor> list = query.getResultList();
        return list;
    }

    @Override
    public Professor update(Professor professor) {
        return professorRepository.save(professor);
    }

}
