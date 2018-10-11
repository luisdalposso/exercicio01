package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import enums.TipoTrabalhador;

public class Trabalhador {

	private String nome;
	private TipoTrabalhador tipoTrab;
	private Double salarioBase;

	private Departamento departamento;
	private List<HoraContrato> contratos = new ArrayList<>();;

	public Trabalhador(String nome, TipoTrabalhador tipotrab, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.tipoTrab = tipotrab;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoTrabalhador getTipoTrab() {
		return tipoTrab;
	}

	public void setTipotrab(TipoTrabalhador tipoTrab) {
		this.tipoTrab = tipoTrab;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HoraContrato> getContratos() {
		return contratos;
	}

	public void addContrato(HoraContrato contrato) {
		contratos.add(contrato);
	}

	public void removeContrato(HoraContrato contrato) {
		contratos.remove(contrato);
	}

	public double receita(int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();

		for (HoraContrato con : contratos) {
			cal.setTime(con.getData());
			int con_ano = cal.get(Calendar.YEAR);
			int con_mes = 1 + cal.get(Calendar.MONTH);

			if (ano == con_ano && mes == con_mes) {
				soma += con.valorTotal();
			}
		}
		return soma;
	}

	@Override
	public String toString() {
		return "Trabalhador [nome=" + nome + ", tipoTrab=" + tipoTrab + ", salarioBase=" + salarioBase
				+ ", departamento=" + departamento + ", contratos=" + contratos + "]";
	}

	
	
}
