package br.com.img.main;

import java.util.HashSet;
import javax.swing.JOptionPane;
import br.com.img.control.ElevadorFactoryControl;

public class ElevadorPrincipal {

	public static void main(String[] args) throws InterruptedException {
		
		ElevadorFactoryControl elevadorFactoryControl = new ElevadorFactoryControl();

		int opFinal = JOptionPane.YES_OPTION;
		
		while (opFinal == JOptionPane.YES_OPTION) {
		
			String[] opBotao = {"SUBIR","DESCER"};
			int opcao = JOptionPane.showOptionDialog(null, "PRESSIONE O BOTÃO", "ELEVADOR IMG", 0, JOptionPane.QUESTION_MESSAGE, null, opBotao, null);
			
			if(opcao != JOptionPane.CLOSED_OPTION){
			
				if(opcao == 0){
					elevadorFactoryControl.setMovimento("SUBINDO");
				}else{
					elevadorFactoryControl.setMovimento("DESCENDO");
				}
			
				while (elevadorFactoryControl.isOpcao()) {
					try {
						elevadorFactoryControl.setQtd_Pessoas(Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade de pessoas no elevador:")));
						System.out.println(elevadorFactoryControl.getMensagem());	
					} catch (Exception e) {			
						System.out.println("DEFINA A QUANTIDADE DE PESSOAS");
					}					
				}
				
				int andar_Atual = elevadorFactoryControl.getAndar_Atual();
				HashSet<Integer> andares = new HashSet<>();
				
				while (elevadorFactoryControl.getStatus_Porta().equals("aberta")) {
				
					int andar;
					
					try {
						andar = Integer.parseInt(
								JOptionPane.showInputDialog(null,
										"    -------- ESCOLHA OS ANDARES --------\n\n"
										+ "    | 20 |    | 19 |    | 18 |    | 17 |    | 16 |\n"
										+ "    | 15 |    | 14 |    | 13 |    | 12 |    | 11 |\n"
										+ "    | 10 |    | 09 |    | 08 |    | 07 |    | 06 |\n"
										+ "    | 05 |    | 04 |    | 03 |    | 02 |    | 01 |\n"
										+ "    | 00 |    | -1  |    | -2  |\n\n"
										+ " PARA FECHAR A PORTA CLIQUE EM CANCELAR"));
						
						if(andar >= -2 && andar <= 20 && andar != andar_Atual){				
							andares.add(andar);					
						}		
					} catch (Exception e) {
						
						if(andares.isEmpty()){
							System.out.println("NENHUM ANDAR SELECIONADO");
						}else{
							elevadorFactoryControl.setStatus_Porta("fechada");
							elevadorFactoryControl.setAndares(andares);
						}
						
					}			
				}
				
				new Thread();
				
				int i;
				
				for(i = 0; i < elevadorFactoryControl.getRota().size(); i++){
					Thread.sleep(1000);
					System.out.println(elevadorFactoryControl.getRota().get(i));
				}
				
				System.out.println("\nELEVADOR PARADO NO ANDAR " + elevadorFactoryControl.getAndar_Final() + "\n");
				
				elevadorFactoryControl.setAndar_Atual(elevadorFactoryControl.getAndar_Final());
				elevadorFactoryControl.setOpcao(true);
				elevadorFactoryControl.setStatus_Porta("aberta");
				
				opFinal = JOptionPane.showConfirmDialog(null, "DESEJA CONTINUAR UTILIZANDO O ELEVADOR?","ELEVADOR IMG",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
			}else{
				System.out.println("SISTEMA ENCERRADO.");
				opFinal = JOptionPane.NO_OPTION;
			}
		}
	}
}