package com.example.trabalhoKanban.service;

import com.example.trabalhoKanban.model.Tarefa;
import com.example.trabalhoKanban.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> obterTodasTarefas() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> obterTarefaPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    public Tarefa criarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Tarefa atualizarTarefa(Long id, Tarefa detalhesTarefa) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com ID: " + id));

        tarefa.setTitulo(detalhesTarefa.getTitulo());
        tarefa.setDescricao(detalhesTarefa.getDescricao());
        tarefa.setStatus(detalhesTarefa.getStatus());
        tarefa.setPrioridade(detalhesTarefa.getPrioridade());
        tarefa.setCriadoEm(java.time.LocalDateTime.now());

        return tarefaRepository.save(tarefa);
    }

    public void excluirTarefa(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com ID: " + id));
        tarefaRepository.delete(tarefa);
    }
}
