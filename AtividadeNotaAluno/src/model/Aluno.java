package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.NomeIncorretoException;
import exceptions.NotaInvalidaException;

public class Aluno {
	private String nome;
	private List<Double> notas = new ArrayList<Double>();

	public Aluno() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws NomeIncorretoException {

		nome = nome.trim();

		if (nome.length() == 0 || nome.length() >= 100) {
			throw new NomeIncorretoException();
		}
		this.nome = nome;
	}

	public void setNome() throws NomeIncorretoException {
		throw new NomeIncorretoException();
	}

	public List<Double> getNotas() {
		return notas;
	}

	public void entraNota(double d) throws NotaInvalidaException {
		if (d <= 100 && d <= 30 && d >= 0 && retornaNotaTotal() + d <= 100) {
			notas.add(d);
		} else {
			throw new NotaInvalidaException();
		}
	}

	public void entraNota() {
		double d = 0;
		notas.add(d);

	}

	public double retornaNotaTotal() {
		double retorno = 0;

		for (Double double1 : notas) {
			retorno += double1;
		}

		return retorno;
	}

}
