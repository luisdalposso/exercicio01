package entities;

import java.util.Date;

public class HoraContrato {

	private Date data;
	private Double valorPorHora;
	private Integer horasTrab;

	public HoraContrato(Date data, Double valorPorHora, Integer horasTrab) {
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.horasTrab = horasTrab;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Integer getHorasTrab() {
		return horasTrab;
	}

	public void setHorasTrab(Integer horasTrab) {
		this.horasTrab = horasTrab;
	}

	public double valorTotal() {
		return valorPorHora * horasTrab;
	}

	public String toString() {
		return "HoraContrato [data=" + data + ", valorPorHora=" + valorPorHora + ", horasTrab=" + horasTrab
				+ ", valorTotal()=" + valorTotal() + "]";
	}

}
