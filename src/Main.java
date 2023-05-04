import br.com.dio.desafio.dominio.*;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char resposta = 'S';
        String nome;
        String descricao;
        String titulo;
        double cargaHoraria;
        int cont = 1;

        System.out.println("");
        System.out.println("**********************************************");
        System.out.println("**********  Desafio Bootcamp Java  ***********");
        System.out.println("**********************************************");


        // Definindo a entrada de dados para o bootcamp via terminal
        System.out.print("1. Entre com o nome do Bootcamp: ");
        nome = scanner.nextLine();
        System.out.print("2. Entre com a descricao do Bootcamp: ");
        descricao = scanner.nextLine();

        // Armazenar no objeto bootcamp
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome(nome);
        bootcamp.setDescricao(descricao);


        // Definindo a entrada de dados para os cursos do bootcamp
        // e guardando a lista de cursos na instancia bootcamp
        System.out.println("");
        System.out.println("**********************************************");
        System.out.println("************  Listagem de Cursos  ************");
        System.out.println("**********************************************");

        while (resposta == 'S') {
            System.out.print(">> Titulo do Curso " + cont + ": ");
            titulo = scanner.nextLine();
            System.out.print(">> Descricao do Curso " + cont  + ": ");
            descricao = scanner.nextLine();
            System.out.print(">> Carga Horaria do Curso " + cont  + ": ");
            cargaHoraria = scanner.nextDouble();
            Curso curso = new Curso(titulo,descricao,cargaHoraria);
            bootcamp.getConteudos().add(curso);
            System.out.println("=========================================");
            System.out.print(">>>> Deseja incluir outro curso? <S/N>");
            resposta = scanner.next().toUpperCase().charAt(0);
            String flag = scanner.nextLine();
            System.out.println("=========================================");
            cont++;
        }

        // Definindo a entrada e armazenamento de mentorias
        resposta ='S';
        cont = 1;
        System.out.println("");
        System.out.println("**********************************************");
        System.out.println("**********  Listagem de Mentorias  ***********");
        System.out.println("**********************************************");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        while (resposta == 'S') {
            System.out.print(">> Titulo da Mentoria " + cont + ": ");
            titulo = scanner.nextLine();
            System.out.print(">> Descricao da Mentoria " + cont  + ": ");
            descricao = scanner.nextLine();
            System.out.print(">> Data de realizacao da Monitoria " + cont  + ": ");
            LocalDate dataMentoria = LocalDate.parse(scanner.next(),formatter);
            Mentoria mentoria = new Mentoria(titulo,descricao,dataMentoria);
            bootcamp.getConteudos().add(mentoria);
            System.out.println("=========================================");
            System.out.print(">>>> Deseja incluir outra mentoria? <S/N>");
            resposta = scanner.next().toUpperCase().charAt(0);
            String flag = scanner.nextLine();
            System.out.println("=========================================");
            cont++;
        }

        // Definição da listagem de devs que participarão do bootcamp
        resposta ='S';
        cont = 1;
        System.out.println("");
        System.out.println("**********************************************");
        System.out.println("************  Listagem de DEVs  **************");
        System.out.println("**********************************************");

        while (resposta == 'S') {
            System.out.print(">> Nome do DEV " + cont + ": ");
            nome = scanner.nextLine().toUpperCase();
            Dev dev = new Dev();
            dev.setNome(nome);
            dev.inscreverBootcamp(bootcamp);
            System.out.println("=========================================");
            System.out.print(">>>> Deseja incluir outro DEV? <S/N>");
            resposta = scanner.next().toUpperCase().charAt(0);
            System.out.println("=========================================");
            String flag = scanner.nextLine();
            cont++;
        }

        // Simulando progressão aleatória ao longo do bootcamp
        for(Iterator<Dev> itDev = bootcamp.getDevsInscritos().iterator();itDev.hasNext();){
            boolean progressao = true;
            Dev devInscrito = itDev.next();
            while(progressao){
                devInscrito.progredir();
                Random valorAleatorio = new Random();
                progressao = valorAleatorio.nextBoolean();
            }
        }

        // Imprimindo a situação dos devs no bootcamp
        System.out.println("");
        System.out.println("***********************************************");
        System.out.println("Listagem de DEVs, Cursos Inscritos e Concluidos");
        System.out.println("***********************************************");

        Iterator itDev = bootcamp.getDevsInscritos().iterator();
        int contDev = 1;
        while (itDev.hasNext()){
            Dev dev = (Dev) itDev.next();
            System.out.println("Dev " + contDev + ":" + dev.getNome() + " - Total XP:" + dev.calcularTotalXp());
            System.out.println(">> Lista de Cursos inscritos");
            for(Iterator<Conteudo> itCursoInscrito = dev.getConteudosInscritos().iterator(); itCursoInscrito.hasNext();){
                Conteudo conteudo = itCursoInscrito.next();
                System.out.println("----> Titulo: " + conteudo.getTitulo() + " - Descricao: " + conteudo.getDescricao());
            }
            System.out.println(">> Lista de Cursos Concluidos");
            for(Iterator<Conteudo> itCursoConcluido = dev.getConteudosConcluidos().iterator(); itCursoConcluido.hasNext();){
                Conteudo conteudo = itCursoConcluido.next();
                System.out.println("----> Titulo: " + conteudo.getTitulo() + " - Descricao: " + conteudo.getDescricao());
            }
            contDev++;
        }


//        Curso curso1 = new Curso();
//        curso1.setTitulo("Curso de Java");
//        curso1.setDescricao("Introdução ao projeto desafio JAVA");
//        curso1.setCargaHoraria(8);
//
//        Curso curso2 = new Curso();
//        curso2.setTitulo("Curso de Js");
//        curso2.setDescricao("Introdução ao projeto desafio Js");
//        curso2.setCargaHoraria(4);

//        Mentoria mentoria = new Mentoria();
//        mentoria.setTitulo("Mentoria de Java");
//        mentoria.setDescricao("Mentoria todos os dias de 2a. a 6a.");
//        mentoria.setData(LocalDate.now());

//        System.out.println(curso1);
//        System.out.println(curso2);
//        System.out.println(mentoria);


//        bootcamp.getConteudos().add(curso1);
//        bootcamp.getConteudos().add(curso2);
//        bootcamp.getConteudos().add(mentoria);

//        Dev dev1 = new Dev();
//        dev1.setNome("Camila");
//        dev1.inscreverBootcamp(bootcamp);
//        System.out.println("Conteudos inscritos para Camila" + dev1.getConteudosInscritos());
//        dev1.progredir();
//        dev1.progredir();
//        System.out.println("Conteudos concluidos para Camila" + dev1.getConteudosConcluidos());
//        System.out.println("XP: " + dev1.calcularTotalXp());
//
//        Dev dev2 = new Dev();
//        dev2.setNome("João");
//        dev2.inscreverBootcamp(bootcamp);
//        System.out.println("Conteudos inscritos para João" + dev2.getConteudosInscritos());
//        dev2.progredir();
//        System.out.println("Conteudos concluidos para Joao" + dev2.getConteudosConcluidos());
//        System.out.println("XP: " + dev2.calcularTotalXp());

    }
}
