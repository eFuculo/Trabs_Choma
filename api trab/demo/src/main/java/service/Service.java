package service;

import model.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import repository.Repo;
import model.Status;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repo repo;

    public Tarefa criarTarefa(Tarefa tarefa) {
        return repo.save(tarefa);
    }

    public List<Tarefa> listarTarefas(){
        return repo.findAll();
    }

    public Optional<Tarefa>getTarefaById(Long id){
        return repo.findById(id);
    }

    public Task atualizaTarefa(Long id, Tarefa atualizaTarefa) {
        Task tarefa = repo.findById(id).orElseThrow();
        tarefa.setTitulo(atualizaTarefa.getTitulo());
        tarefa.setDescricao(atualizaTarefa.getDescricao());
        tarefa.setPrioridade(atualizaTarefa.getPrioridade());
        tarefa.setPrazo(atualizaTarefa.getPrazo());
        return repo.save(tarefa);
    }

    public Tarefa moverTarefa(Long id){
        Task tarefa = repo.findById(id).orElseThrow();
        if (tarefa.getStatus() == Status.TODO) {
            tarefa.setStatus(Status.IN_PROGRESS);
        } else if (task.getStatus() == Status.IN_PROGRESS) {
            tarefa.setStatus(Status.DONE);
        }
        return Repo.save(tarefa);
    }

    public void deletarTarefa(Long id){
        repo.deleteById(id);
    }
}
