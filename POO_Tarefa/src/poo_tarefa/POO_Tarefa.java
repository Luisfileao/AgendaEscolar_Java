//Autores do Trabalho: Felipe Cardoso, Luís Filipe e Pedro Polido

package poo_tarefa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class POO_Tarefa {

    public static void main(String[] args) throws ParseException {
        Scanner entrada = new Scanner(System.in);

        Vector<Login> usuarios = new Vector<>();
        Login usuariologado = null;
        int controlador = 0;
        int inicioRA = 0;
        int numeroinicial = 0;
        int posicaoTarefa = 0;

        while (true) {
            controlador = 0;
            System.out.println("Escolha a opcao:");
            System.out.println("1 - Logar;");
            System.out.println("2 - Cadastrar.");
            int opcaoinicial = entrada.nextInt();
            System.out.println("");

            while (opcaoinicial > 2 || opcaoinicial < 1) {
                System.out.print("Opcao inexistente. Informe novamente: ");
                opcaoinicial = entrada.nextInt();
                System.out.println("");
            }

            switch (opcaoinicial) {
                case 1:                    
                    System.out.println("Digite as informacoes nos campos abaixo:");
                    System.out.println("");

                    System.out.print("Nome: ");
                    String name = entrada.next();

                    entrada.skip("\n");

                    System.out.print("RA: ");
                    String ra = entrada.nextLine();

                    System.out.print("Senha: ");
                    String senha = entrada.next();

                    System.out.print("Numero inicial do RA informado pelo sistema: ");
                    numeroinicial = entrada.nextInt();
                    System.out.println("");

                    Login usuarioComparacao = usuarios.get(numeroinicial);

                    boolean resultadosenha = (usuarioComparacao.getSenha()).equalsIgnoreCase(senha);
                    boolean resultadoRA = (usuarioComparacao.getRa()).equalsIgnoreCase(ra);

                    if (resultadosenha == false || resultadoRA == false) {
                        System.out.println("Senha ou RA incorretos.");
                        System.out.println("");

                        controlador = 1;

                        break;
                    }

                    usuariologado = usuarios.get(numeroinicial);
                    usuariologado = AutoExclusao(usuariologado);

                    break;

                case 2:
                    System.out.println("Digite as informacoes nos campos abaixo:");
                    System.out.println("");

                    System.out.print("Nome: ");
                    String nome = entrada.next();

                    entrada.skip("\n");

                    System.out.println("O numero inicial do seu RA sera " + inicioRA + ".");
                    System.out.print("RA: " + inicioRA);
                    String RA = entrada.nextLine();
                    String parteinicial = Integer.toString(inicioRA);
                    RA = parteinicial.concat(RA);

                    System.out.print("Senha: ");
                    String Senha = entrada.next();
                    System.out.println("");

                    usuariologado = new Login(RA, Senha);
                    usuarios.add(inicioRA, usuariologado);

                    numeroinicial = inicioRA;
                    inicioRA++;

                    break;
            }

            String opc = "Nao";

            while (opc.equalsIgnoreCase("Nao") && controlador == 0) {
                System.out.println("Escolha:");
                System.out.println("1 - Adicionar uma nova tarefa;");
                System.out.println("2 - Visualizar as tarefas do dia;");
                System.out.println("3 - Visualizar as tarefas da semana;");
                System.out.println("4 - Remover tarefa da lista.");
                int escolha = entrada.nextInt();
                System.out.println("");

                while (escolha > 4 || escolha < 1) {
                    System.out.print("Opcao Inexistente. Informe novamente: ");
                    escolha = entrada.nextInt();
                    System.out.println("");
                }

                switch (escolha) {
                    case 1:
                        System.out.println("Em qual materia voce gostaria de adicionar uma nova tarefa?");
                        System.out.println("1 - Portugues;");
                        System.out.println("2 - Matematica;");
                        System.out.println("3 - Geografia;");
                        System.out.println("4 - Historia;");
                        System.out.println("5 - Biologia.");
                        int materiaEscolhida = entrada.nextInt();
                        System.out.println("");

                        while (materiaEscolhida > 5 || materiaEscolhida < 1) {
                            System.out.print("Opcao Inexistente. Informe novamente: ");
                            materiaEscolhida = entrada.nextInt();
                            System.out.println("");
                        }

                        switch (materiaEscolhida) {
                            case 1:
                                usuariologado.setPortugues(addTarefa());
                                break;

                            case 2:
                                usuariologado.setMatematica(addTarefa());
                                break;

                            case 3:
                                usuariologado.setGeografia(addTarefa());
                                break;

                            case 4:
                                usuariologado.setHistoria(addTarefa());
                                break;

                            case 5:
                                usuariologado.setBiologia(addTarefa());
                                break;

                        }

                        break;

                    case 2:
                        LocalDateTime hoje = LocalDateTime.now();

                        Vector<Tarefa> tarefasDiarias = new Vector<>();

                        System.out.print("Tarefas de Portugues do dia: ");
                        for (int i = 0; i < usuariologado.getPortugues().getListatarefas().size(); i++) {
                            if ((usuariologado.getPortugues().getListatarefas().get(i).getDeadline().getDayOfMonth()) == hoje.getDayOfMonth()) {
                                tarefasDiarias.add(usuariologado.getPortugues().getListatarefas().get(i));
                            }
                        }
                        System.out.println(tarefasDiarias);
                        tarefasDiarias.removeAllElements();

                        System.out.print("Tarefas de Matematica do dia: ");
                        for (int i = 0; i < usuariologado.getMatematica().getListatarefas().size(); i++) {
                            if ((usuariologado.getMatematica().getListatarefas().get(i).getDeadline().getDayOfMonth()) == hoje.getDayOfMonth()) {
                                tarefasDiarias.add(usuariologado.getMatematica().getListatarefas().get(i));
                            }
                        }
                        System.out.println(tarefasDiarias);
                        tarefasDiarias.removeAllElements();

                        System.out.print("Tarefas de Geografia do dia: ");
                        for (int i = 0; i < usuariologado.getGeografia().getListatarefas().size(); i++) {
                            if ((usuariologado.getGeografia().getListatarefas().get(i).getDeadline().getDayOfMonth()) == hoje.getDayOfMonth()) {
                                tarefasDiarias.add(usuariologado.getGeografia().getListatarefas().get(i));
                            }
                        }
                        System.out.println(tarefasDiarias);
                        tarefasDiarias.removeAllElements();

                        System.out.print("Tarefas de Historia do dia: ");
                        for (int i = 0; i < usuariologado.getHistoria().getListatarefas().size(); i++) {
                            if ((usuariologado.getHistoria().getListatarefas().get(i).getDeadline().getDayOfMonth()) == hoje.getDayOfMonth()) {
                                tarefasDiarias.add(usuariologado.getHistoria().getListatarefas().get(i));
                            }
                        }
                        System.out.println(tarefasDiarias);
                        tarefasDiarias.removeAllElements();

                        System.out.print("Tarefas de Biologia do dia: ");
                        for (int i = 0; i < usuariologado.getBiologia().getListatarefas().size(); i++) {
                            if ((usuariologado.getBiologia().getListatarefas().get(i).getDeadline().getDayOfMonth()) == hoje.getDayOfMonth()) {
                                tarefasDiarias.add(usuariologado.getBiologia().getListatarefas().get(i));
                            }
                        }
                        System.out.println(tarefasDiarias);
                        tarefasDiarias.removeAllElements();
                        System.out.println("");

                        break;

                    case 3:
                        Vector<Tarefa> tarefasSemana = new Vector<>();
                        Date agora = new Date();
                        Calendar calendario = Calendar.getInstance();

                        int diadasemana = calendario.get(Calendar.DAY_OF_WEEK);
                        int acresDias = 7 - diadasemana;
                        calendario.add(Calendar.DAY_OF_WEEK, acresDias);
                        calendario.set(Calendar.HOUR_OF_DAY, 23);
                        calendario.set(Calendar.MINUTE, 59);
                        Date sextaNoite = calendario.getTime();

                        long tempoFinalDaSemana = sextaNoite.getTime();
                        long tarefaFim = 0;

                        System.out.println("Tarefas de Portugues da Semana: ");
                        for (int i = 0; i < usuariologado.getPortugues().getListatarefas().size(); i++) {
                            ZonedDateTime conversao = ZonedDateTime.of(usuariologado.getPortugues().getListatarefas().get(i).getDeadline(), ZoneId.systemDefault());
                            tarefaFim = conversao.toInstant().toEpochMilli();

                            if (tempoFinalDaSemana >= tarefaFim) {
                                tarefasSemana.add(usuariologado.getPortugues().getListatarefas().get(i));
                            }
                        }
                        System.out.println(tarefasSemana);
                        tarefasSemana.removeAllElements();

                        System.out.println("Tarefas de Matematica da Semana: ");
                        for (int i = 0; i < usuariologado.getMatematica().getListatarefas().size(); i++) {
                            ZonedDateTime conversao = ZonedDateTime.of(usuariologado.getMatematica().getListatarefas().get(i).getDeadline(), ZoneId.systemDefault());
                            tarefaFim = conversao.toInstant().toEpochMilli();

                            if (tempoFinalDaSemana >= tarefaFim) {
                                tarefasSemana.add(usuariologado.getMatematica().getListatarefas().get(i));
                            }
                        }
                        System.out.println(tarefasSemana);
                        tarefasSemana.removeAllElements();

                        System.out.println("Tarefas de Geografia da Semana: ");
                        for (int i = 0; i < usuariologado.getGeografia().getListatarefas().size(); i++) {
                            ZonedDateTime conversao = ZonedDateTime.of(usuariologado.getGeografia().getListatarefas().get(i).getDeadline(), ZoneId.systemDefault());
                            tarefaFim = conversao.toInstant().toEpochMilli();

                            if (tempoFinalDaSemana >= tarefaFim) {
                                tarefasSemana.add(usuariologado.getGeografia().getListatarefas().get(i));
                            }
                        }
                        System.out.println(tarefasSemana);
                        tarefasSemana.removeAllElements();

                        System.out.println("Tarefas de Historia da Semana: ");
                        for (int i = 0; i < usuariologado.getHistoria().getListatarefas().size(); i++) {
                            ZonedDateTime conversao = ZonedDateTime.of(usuariologado.getHistoria().getListatarefas().get(i).getDeadline(), ZoneId.systemDefault());
                            tarefaFim = conversao.toInstant().toEpochMilli();

                            if (tempoFinalDaSemana >= tarefaFim) {
                                tarefasSemana.add(usuariologado.getHistoria().getListatarefas().get(i));
                            }
                        }
                        System.out.println(tarefasSemana);
                        tarefasSemana.removeAllElements();

                        System.out.println("Tarefas de Biologia da Semana: ");
                        for (int i = 0; i < usuariologado.getBiologia().getListatarefas().size(); i++) {
                            ZonedDateTime conversao = ZonedDateTime.of(usuariologado.getBiologia().getListatarefas().get(i).getDeadline(), ZoneId.systemDefault());
                            tarefaFim = conversao.toInstant().toEpochMilli();

                            if (tempoFinalDaSemana >= tarefaFim) {
                                tarefasSemana.add(usuariologado.getBiologia().getListatarefas().get(i));
                            }
                        }
                        System.out.println(tarefasSemana);
                        tarefasSemana.removeAllElements();

                        break;

                    case 4:
                        System.out.println("De qual matéria voce gostaria de encerrar a tarefa?");
                        System.out.println("1 - Portugues;");
                        System.out.println("2 - Matematica;");
                        System.out.println("3 - Geografia;");
                        System.out.println("4 - Historia;");
                        System.out.println("5 - Biologia.");                        
                        int materia = entrada.nextInt();
                        
                        while(materia < 1 || materia > 5){
                            System.out.print("Opcao Inexistente. Digite Novamente: ");
                            materia = entrada.nextInt();
                        }

                        switch (materia) {
                            case 1:
                                System.out.println(usuariologado.getPortugues().getListatarefas());
                                System.out.print("Qual a posicao da tarefa que voce deseja excluir (1,2,...)? ");
                                posicaoTarefa = entrada.nextInt();                                
                                
                                usuariologado.getPortugues().getListatarefas().remove(usuariologado.getPortugues().getListatarefas().remove(posicaoTarefa-1));

                                break;

                            case 2:
                                System.out.println(usuariologado.getMatematica().getListatarefas());
                                System.out.print("Qual a posicao da tarefa que voce deseja excluir (1,2,...)? ");
                                posicaoTarefa = entrada.nextInt();                                
                                
                                usuariologado.getMatematica().getListatarefas().remove(usuariologado.getMatematica().getListatarefas().remove(posicaoTarefa-1));

                                break;
                                
                            case 3:
                                System.out.println(usuariologado.getGeografia().getListatarefas());
                                System.out.print("Qual a posicao da tarefa que voce deseja excluir (1,2,...)? ");
                                posicaoTarefa = entrada.nextInt();                                
                                
                                usuariologado.getGeografia().getListatarefas().remove(usuariologado.getGeografia().getListatarefas().remove(posicaoTarefa-1));

                                break;

                            case 4:
                                System.out.println(usuariologado.getHistoria().getListatarefas());
                                System.out.print("Qual a posicao da tarefa que voce deseja excluir (1,2,...)? ");
                                posicaoTarefa = entrada.nextInt();                                
                                
                                usuariologado.getHistoria().getListatarefas().remove(usuariologado.getHistoria().getListatarefas().remove(posicaoTarefa-1));

                                break;

                            case 5:
                                System.out.println(usuariologado.getBiologia().getListatarefas());
                                System.out.print("Qual a posicao da tarefa que voce deseja excluir (1,2,...)? ");
                                posicaoTarefa = entrada.nextInt();                                
                                
                                usuariologado.getBiologia().getListatarefas().remove(usuariologado.getBiologia().getListatarefas().remove(posicaoTarefa-1));

                                break;
                        }
                }   
                                
                usuarios.set(numeroinicial, usuariologado); //Atualizar os dados do usuário no vetor de usuários.             

                entrada.skip("\n");
                System.out.print("Deseja sair da sua conta (Sim/Nao)? ");
                opc = entrada.nextLine();
                System.out.println("");

                while (!opc.equalsIgnoreCase("Sim") && !opc.equalsIgnoreCase("Nao")) {
                    System.out.print("Opcao inexistente. Informe novamente: ");
                    opc = entrada.nextLine();
                    System.out.println("");
                }

                if (opc.equalsIgnoreCase("Sim")) {
                    usuariologado = null;
                }

            }

        }
    }

    public static Tarefa addTarefa() throws ParseException {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Preencha as informacoes abaixo sobre a nova tarefa: ");

        System.out.print("Nome: ");
        String nome = entrada.next();
        entrada.skip("\n");
        System.out.println("");

        System.out.print("Descricao: ");
        String descricao = entrada.nextLine();
        System.out.println("");

        System.out.print("Data limite (dd/MM/yyyy): ");
        String data = entrada.nextLine();
        System.out.print("Hora limite (HH:mm:ss): ");
        String hora = entrada.nextLine();

        LocalDate datalimite = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalTime horalimite = LocalTime.parse(hora);
        LocalDateTime deadline = datalimite.atTime(horalimite);
        System.out.println("");

        System.out.print("Valor: ");
        int valor = entrada.nextInt();
        System.out.println("");

        Tarefa novaTarefa = new Tarefa(nome, descricao, deadline, valor);

        return novaTarefa;
    }

    public static Login AutoExclusao(Login usuario) {
        Calendar calendar = Calendar.getInstance();
        Date diaAtual = calendar.getTime();
        long momentoAtual = diaAtual.getTime();
        long momentoFinalDeadline = 0;

        for (int i = 0; i < usuario.getPortugues().getListatarefas().size(); i++) {
            ZonedDateTime conversao = ZonedDateTime.of(usuario.getPortugues().getListatarefas().get(i).getDeadline(), ZoneId.systemDefault());
            momentoFinalDeadline = conversao.toInstant().toEpochMilli();

            if (momentoFinalDeadline <= momentoAtual) {
                usuario.getPortugues().getListatarefas().remove(i);
            }
        }

        for (int i = 0; i < usuario.getMatematica().getListatarefas().size(); i++) {
            ZonedDateTime conversao = ZonedDateTime.of(usuario.getMatematica().getListatarefas().get(i).getDeadline(), ZoneId.systemDefault());
            momentoFinalDeadline = conversao.toInstant().toEpochMilli();

            if (momentoFinalDeadline <= momentoAtual) {
                usuario.getMatematica().getListatarefas().remove(i);
            }
        }

        for (int i = 0; i < usuario.getGeografia().getListatarefas().size(); i++) {
            ZonedDateTime conversao = ZonedDateTime.of(usuario.getGeografia().getListatarefas().get(i).getDeadline(), ZoneId.systemDefault());
            momentoFinalDeadline = conversao.toInstant().toEpochMilli();

            if (momentoFinalDeadline <= momentoAtual) {
                usuario.getGeografia().getListatarefas().remove(i);
            }
        }

        for (int i = 0; i < usuario.getHistoria().getListatarefas().size(); i++) {
            ZonedDateTime conversao = ZonedDateTime.of(usuario.getHistoria().getListatarefas().get(i).getDeadline(), ZoneId.systemDefault());
            momentoFinalDeadline = conversao.toInstant().toEpochMilli();

            if (momentoFinalDeadline <= momentoAtual) {
                usuario.getHistoria().getListatarefas().remove(i);
            }
        }

        for (int i = 0; i < usuario.getBiologia().getListatarefas().size(); i++) {
            ZonedDateTime conversao = ZonedDateTime.of(usuario.getBiologia().getListatarefas().get(i).getDeadline(), ZoneId.systemDefault());
            momentoFinalDeadline = conversao.toInstant().toEpochMilli();

            if (momentoFinalDeadline <= momentoAtual) {
                usuario.getBiologia().getListatarefas().remove(i);
            }
        }

        return usuario;
    }
}
