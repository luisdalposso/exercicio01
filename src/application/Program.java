package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Departamento;
import entities.Trabalhador;
import enums.TipoTrabalhador;
import entities.HoraContrato;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Entre com o nome do departamento:");
		String nomeDepartamento = sc.nextLine();

		System.out.print("-- INFORMAÇÕES DO TRABALHADOR --\n");
		System.out.println("NOME:");
		String nomeTrabalhador = sc.nextLine();
		System.out.println("NÍVEL:");
		String nivelTrabalhador = sc.nextLine();
		System.out.println("SALÁRIO BASE:");
		double salarioBase = sc.nextDouble();

		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, TipoTrabalhador.valueOf(nivelTrabalhador),
				salarioBase, new Departamento(nomeDepartamento));

		System.out.println("Quantos contratos foram realizados?");
		int qtdCon = sc.nextInt();

		for (int i = 0; i < qtdCon; i++) {
			System.out.println("Entre com as informações do contrato #" + i + " :");
			System.out.println("Data no formato (DD/MM/AAAA):");
			Date dataCon = sdf.parse(sc.next());
			System.out.println();

			System.out.println("Valor por hora:");
			double valorHora = sc.nextDouble();

			System.out.println("Quantidade de horas trabalhadas:");
			int qtdHoras = sc.nextInt();

			HoraContrato contrato = new HoraContrato(dataCon, valorHora, qtdHoras);
			trabalhador.addContrato(contrato);

		}

		System.out.println("Qual a data a ser pesquisada?\nNo formato MM/AAAA");
		String mesAno = sc.next();

		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));

		System.out.println("NOME: " + trabalhador.getNome());
		System.out.println("DEPARTAMENTO: " + trabalhador.getDepartamento().getNome());
		System.out.println("NÍVEL: " + trabalhador.getTipoTrab());
		System.out.println("SALÁRIO BASE: " + trabalhador.getSalarioBase());
		System.out.println("GANHOS NO MÊS PROCURADO: R$" + trabalhador.receita(ano, mes));

		sc.close();

	}

}
