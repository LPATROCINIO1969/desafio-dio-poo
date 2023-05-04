package br.com.dio.desafio.dominio;

public class Curso extends Conteudo {

    private double cargaHoraria;

    public Curso() {
    }

    public Curso(String nome, String descricao, double cargaHoraria){
        this.setTitulo(nome);
        this.setDescricao(descricao);
        this.setCargaHoraria(cargaHoraria);
    }

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }
}
