package br.com.img.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ElevadorVerificaModel {

	String mensagem;
	int andar_Final;
	boolean opcao = true;
	ArrayList<String> rota = new ArrayList<>();

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public int getAndar_Final() {
		return andar_Final;
	}

	public void setAndar_Final(int andar_Final) {
		this.andar_Final = andar_Final;
	}

	public boolean isOpcao() {
		return opcao;
	}

	public void setOpcao(boolean opcao) {
		this.opcao = opcao;
	}
	
	public ArrayList<String> getRota() {
		return rota;
	}

	public void setRota(ArrayList<String> rota) {
		this.rota = rota;
	}

	public void verificadorQtdPessoas(int qtd){
		
		if(qtd <= 0){
			setMensagem("NECESSÁRIO UMA PESSOA PARA O ELEVADOR FUNCIONAR");
			setOpcao(true);
		}else if(qtd > 8){
			setMensagem("QUANTIDADE EXCEDIDA");
			setOpcao(true);
		}else{
			setMensagem("-------- ELEVADOR FUNCIONANDO --------");
			setOpcao(false);
		}
		
	}	
	
	public void ajustarRota(HashSet<Integer> andares, int andar_Atual, String movimento) {

		ArrayList<Integer> ajusteAndares = new ArrayList<Integer>(andares);
		Collections.sort(ajusteAndares);

		if (movimento.equals("SUBINDO")){
			subir_Rota(ajusteAndares, andar_Atual);
		}else{
			descer_Rota(ajusteAndares, andar_Atual);
		}

	}
	
	public void subir_Rota(ArrayList<Integer> andares, int andar_Atual) {
		
		ArrayList<String> criarRota = new ArrayList<>();
		boolean andar = false;
		
		int posicaoFinal = andares.size() - 1;
		int andarFinal = andares.get(posicaoFinal);
		
		criarRota.add("\nELEVADOR SUBINDO\n");
		
		for(int i = andar_Atual; i <= andarFinal; i++){
			for(int j = 0; j < andares.size(); j++){
			
				if(andares.get(j) == i){
					andares.remove(j);
					andar = true;
					break;
				}
				
			}
			
			if(andar == true){
				criarRota.add("ANDAR " + i + " SELECIONADO");
			}else{
				criarRota.add("ANDAR " + i);
			}
			
			andar = false;

		}

		setAndar_Final(andarFinal);
		
		if(!andares.isEmpty()){
			
			int posicao = andares.get(0);
			
			if(posicao < andar_Atual){
			
				criarRota.add("\nELEVADOR DESCENDO\n");
				andar_Atual = andarFinal;
				
				for(int i = andar_Atual; i >= posicao; i--){
					for(int j = andares.size() - 1; j >= 0; j--){
				
						if(andares.get(j) == i){
							andares.remove(j);
							andar = true;
							break;
						}
						
					}
					
					if(andar == true){
						criarRota.add("ANDAR " + i + " SELECIONADO");
					}else{
						criarRota.add("ANDAR " + i);
					}
					
					andar = false;
				
				}
			}
			
			setAndar_Final(posicao);
			
		}
	
		setRota(criarRota);

	}
	
	public void descer_Rota(ArrayList<Integer> andares, int andar_Atual) {
		
		ArrayList<String> criarRota = new ArrayList<>();
		boolean andar = false;
		
		int andarFinal = andares.get(0);
		criarRota.add("\nELEVADOR DESCENDO\n");
	
		for(int i = andar_Atual; i >= andarFinal; i--){
			for(int j = andares.size() - 1; j >= 0; j--){
				
				if(andares.get(j) == i){
					andares.remove(j);
					andar = true;
					break;
				}
				
			}
			
			if(andar == true){
				criarRota.add("ANDAR " + i + " - SELECIONADO");
			}else{
				criarRota.add("ANDAR " + i);
			}
			
			andar = false;
		
		}
		
		andar_Atual = andarFinal;
		
		if(!andares.isEmpty()){
		
			int posicaoFinal = andares.size() - 1;
			andarFinal = andares.get(posicaoFinal);
			
			if(andarFinal > andar_Atual){
			
				criarRota.add("\nELEVADOR SUBINDO\n");
				
				for(int i = andar_Atual; i <= andarFinal; i++){
					for(int j = 0; j < andares.size(); j++){
				
						if(andares.get(j) == i){
							andares.remove(j);
							andar = true;
							break;
						}
						
					}
					
					if(andar == true){
						criarRota.add("ANDAR " + i + " - SELECIONADO");
					}else{
						criarRota.add("ANDAR " + i);
					}
					
					andar = false;
				
				}
			}
		}
		
		setAndar_Final(andarFinal);
		setRota(criarRota);
	
	}
	
}					