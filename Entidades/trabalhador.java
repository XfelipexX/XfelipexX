package Entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import enuns.nivelTrabalhador;

public class trabalhador {

    private String nome;
    private nivelTrabalhador nivel;
    private Double salarioBase;

    List<contratoPorHora> contrato = new ArrayList<>();
    
    public trabalhador() {
    }
    
    public trabalhador(String nome, nivelTrabalhador nivel, Double salarioBase, List<contratoPorHora> contrato) {
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.contrato = contrato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public nivelTrabalhador getNivel() {
        return nivel;
    }

    public void setNivel(nivelTrabalhador nivel) {
        this.nivel = nivel;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public List<contratoPorHora> getContrato() {
        return contrato;
    }

    public void setContrato(List<contratoPorHora> contrato) {
        this.contrato = contrato;
    }

    public void AdicionarContrato(contratoPorHora contratos){
        contrato.add(contratos);
    }
    public void ExcluirContrato(contratoPorHora contratos){
        contrato.remove(contratos);
    }
    public Double renda(Integer ano, Integer mes){
        Calendar cal = Calendar.getInstance();
        double soma = this.salarioBase;
        for (contratoPorHora c : contrato) {
            cal.setTime(c.getData());
            int c_ano = cal.get(Calendar.YEAR);
            int c_mes = 1 + cal.get(Calendar.MONTH);
            if(ano == c_ano && mes == c_mes){
                soma +=c.valorTotal();
            }
        }
        return soma;
    }

}
