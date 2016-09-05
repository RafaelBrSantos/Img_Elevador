package br.com.img.control;

import java.util.HashSet;
import br.com.img.model.ElevadorVerificaModel;

public class ElevadorFactoryControl extends ElevadorVerificaModel {

	int qtd_Pessoas = 0;
	int andar_Atual = 0;
	HashSet<Integer> andares = new HashSet<>();
	String status_Porta =  "aberta";
	String movimento = "";
	
	public ElevadorFactoryControl() {}

	public void setQtd_Pessoas(int qtd_Pessoas) {
		this.qtd_Pessoas = qtd_Pessoas;
		verificadorQtdPessoas(qtd_Pessoas);
	}

	public int getAndar_Atual() {
		return andar_Atual;
	}

	public void setAndar_Atual(int andar_Atual) {
		this.andar_Atual = andar_Atual;
	}

	public HashSet<Integer> getAndares() {
		return andares;
	}

	public void setAndares(HashSet<Integer> andares){
		this.andares = andares;
		ajustarRota(andares, getAndar_Atual(), getMovimento());
	}

	public String getStatus_Porta() {
		return status_Porta;
	}

	public void setStatus_Porta(String status_Porta) {
		this.status_Porta = status_Porta;
	}

	public String getMovimento() {
		return movimento;
	}

	public void setMovimento(String movimento) {
		this.movimento = movimento;
	}

	public int getQtd_Pessoas() {
		return qtd_Pessoas;
	}

}