package br.com.luciano.captulo6;

import java.util.stream.*;

class Principal {
	public static void main(String args[]) {

		Lista lista = new Lista();

		for(int i = 0; i < 10; i++)
			new Thread(new TarefaAdicionaElemento(lista, i)).start();

		new Thread(new TarefaImprimir(lista)).start();

	}
}