package poo_tarefa;

import java.util.Vector;

public class Login {

    private String ra;
    private String senha;

    private Disciplina portugues;
    private Disciplina matematica;
    private Disciplina geografia;
    private Disciplina historia;
    private Disciplina biologia;

    public String getSenha() {
        return senha;
    }

    public Login(String ra, String senha) {
        this.ra = ra;
        this.senha = senha;
        inicializaDisciplinas();
    }

    public String getRa() {
        return ra;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void inicializaDisciplinas(){
        this.portugues = new Disciplina("9:10 as 10:50 - Terca-Feira", "Portugues", "Denise");
        this.matematica = new Disciplina("7:00 as 8:40 - Quarta-Feira || 10:50 as 11:40 - Sexta-Feira", "Portugues", "Pollyanna");
        this.geografia = new Disciplina("7:00 as 8:40 - Sexta-Feira", "Geografia", "Fabricio");
        this.historia = new Disciplina("15:10 as 16:50 - Terça-Feira", "Historia", "Pablo");
        this.biologia = new Disciplina("10:50 as 11h40 - Terca-Feira || 9:10 as 10:50 - Quinta-Feira", "Biologia", "Leandro");
    }

    public Disciplina getPortugues() {
        return portugues;
    }

    public Disciplina getMatematica() {
        return matematica;
    }

    public Disciplina getGeografia() {
        return geografia;
    }

    public Disciplina getHistoria() {
        return historia;
    }

    public Disciplina getBiologia() {
        return biologia;
    }

    public void setPortugues(Tarefa novaTarefa) {
        this.portugues.setListatarefas(novaTarefa);
    }

    public void setMatematica(Tarefa novaTarefa) {
        this.matematica.setListatarefas(novaTarefa);
    }

    public void setGeografia(Tarefa novaTarefa) {
        this.geografia.setListatarefas(novaTarefa);
    }

    public void setHistoria(Tarefa novaTarefa) {
        this.historia.setListatarefas(novaTarefa);
    }

    public void setBiologia(Tarefa novaTarefa) {
        this.biologia.setListatarefas(novaTarefa);
    } 
}
