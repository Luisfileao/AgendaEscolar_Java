package poo_tarefa;

import java.util.Vector;

public class Disciplina {

    private String horario;
    private String Nome;
    private String professor;
    private Vector<Tarefa> listatarefas;

    public Disciplina(String horario, String Nome, String professor) {
        this.horario = horario;
        this.Nome = Nome;
        this.professor = professor;
        this.listatarefas = new Vector<>();
    }

    public String getHorario() {
        return horario;
    }

    public String getNome() {
        return Nome;
    }

    public String getProfessor() {
        return professor;
    }

    public Vector<Tarefa> getListatarefas() {
        return listatarefas;
    }

    public void setListatarefas(Tarefa novaTarefa) {
        this.listatarefas.add(novaTarefa);
    }
}
