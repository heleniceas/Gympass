import java.text.DecimalFormat;
import java.util.List;

import com.gympass.controller.Estatisticas;
import com.gympass.domain.Corrida;
import com.gympass.domain.Voltas;

public class Teste {

	public static void main(String[] args) {


		List<Corrida> posicao = new Estatisticas().classificacaoGeral();
		 System.out.println("RANKING:");
		 DecimalFormat df = new DecimalFormat("###.###");
		
		for (int i = 0; i < posicao.size(); i++) {
	
			System.out.println("POSICAO:" + (i + 1) + " - PILOTO: " + posicao.get(i).getPiloto().getCodigo() + "-"
					+ posicao.get(i).getPiloto().getNome() + " - TEMPO CORRIDA:"
					+ posicao.get(i).getTempoCorridaFormatado() + " - VOLTAS COMPLETADAS:"
					+ posicao.get(i).getVoltas().size()+ " - VELOCIDADE MÉDIA: "+ df.format(posicao.get(i).getVelocidadeMedia()));

		}
		 System.out.println("-------------****--------------******-------------****--------------******");
		System.out.println("MELHOR VOLTA POR PILOTO:");
		//Descobrir a melhor volta de cada piloto
		List<Voltas> listaCorridaPiloto = new Estatisticas().getListaMelhorVoltaPiloto();
		
				for (int i = 0; i < listaCorridaPiloto.size(); i++) {
					
					System.out.println( "VOLTA : "
							+ listaCorridaPiloto.get(i).getTempoVoltaFormatado()+ " --- PILOTO: " + listaCorridaPiloto.get(i).getPiloto().getCodigo() + "-"
							+ listaCorridaPiloto.get(i).getPiloto().getNome() ) ;
							

				}

	
	 System.out.println("-------------****--------------******-------------****--------------******");
		System.out.println("MELHOR VOLTA CORRIDA:");
		
		Voltas melhorVolta = new Estatisticas().getListaMelhorVoltaCorrida();
		
	
			
			System.out.println( "VOLTA : "
					+ melhorVolta.getTempoVoltaFormatado()+ " --- PILOTO: " + melhorVolta.getPiloto().getCodigo() + "-"
					+ melhorVolta.getPiloto().getNome() ) ;
					

		
	}
}
