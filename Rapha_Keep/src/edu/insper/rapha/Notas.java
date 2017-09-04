package edu.insper.rapha;

import java.util.Date;
import java.sql.Timestamp;



public class Notas {
	private Integer id;
	private String texto;
	private Timestamp timestamp;
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTexto() {
		return this.texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Timestamp getData() {
		System.out.println(this.timestamp);
		return this.timestamp;
	}
	public void setData(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
