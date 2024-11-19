package controller;

import model.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.Service;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class Controller {

    @Autowired
    private Service service;

    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return service.criarTarefa(tarefa);
    }

    @GetMapping
    public List<Tarefa> listarTarefas() {
        return service.listarTarefas();
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return service.atualizaTarefa(id, tarefa);
    }

    @PutMapping("/{id}/move")
    public Tarefa moveTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return service.moverTarefa(id);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        service.deletarTarefa(id);
    }
}
