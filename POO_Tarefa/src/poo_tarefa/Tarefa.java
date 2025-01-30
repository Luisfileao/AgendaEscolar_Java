package poo_tarefa;

import java.time.LocalDateTime;
import java.util.Date;

public class Tarefa {

    private String nome;
    private String descricao;
    private LocalDateTime deadline;
    private double valor;

    public Tarefa(String nome, String descricao, LocalDateTime deadline, double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.deadline = deadline;
        this.valor = 0.0;
    }

    public double getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
