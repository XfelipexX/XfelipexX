package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entidades.Departamento;
import Entidades.contratoPorHora;
import Entidades.trabalhador;
import enuns.nivelTrabalhador;

public class app {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("qual e o nome do departamento: ");
        String nomedepartamento = sc.nextLine();
        System.out.println();
        
        System.out.println("dados do trabalhador: ");
        
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Nivel: ");
        String nivel = sc.nextLine();
        System.out.print("salario base: ");
        double salarioBase = sc.nextDouble();
        System.out.println();

        trabalhador trabalhador = new trabalhador(nome, nivelTrabalhador.valueOf(nivel), salarioBase, new Departamento(nomedepartamento));

        System.out.print("quantidade de contratos: ");
        int n = sc.nextInt();
        System.out.println();

        for (int i = 1; i <= n; i++) {
            
            System.out.println("contrato #" + i);
            System.out.print("Data(dd/MM/yyyy): ");
            Date datacontrato = sdf.parse(sc.next());
            System.out.print("valor por horas: ");
            double valorporhoras = sc.nextInt();
            System.out.print("duracao(horas): ");
            int duracao = sc.nextInt();

            contratoPorHora contrato = new contratoPorHora(datacontrato, valorporhoras, duracao);
            trabalhador.AdicionarContrato(contrato);
        }

        System.out.println();
        System.out.print("entre com o mes do calculo de renda(DD/yyyy): ");
        String crenda = sc.next();
        
        int mes = Integer.parseInt(crenda.substring(0, 2));
        int ano = Integer.parseInt(crenda.substring(3));

        System.out.println();
        System.out.println("Nome: " + trabalhador.getNome());
        System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
        System.out.println("Renda em " + mes + "/" + ano + ": " + String.format("%.2f", trabalhador.renda(ano, mes)));
  
    }
    
}