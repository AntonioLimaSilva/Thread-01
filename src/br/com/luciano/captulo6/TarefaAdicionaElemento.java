package br.com.luciano.captulo6;

class TarefaAdicionaElemento implements Runnable {

	private Lista lista;
	private int numeroDoThread;

	TarefaAdicionaElemento(Lista lista, int numeroDoThread) {
		this.lista = lista;
		this.numeroDoThread = numeroDoThread;
	}

	public void run() {		
		for(int i = 0; i < lista.tamanho(); i++)
			lista.adicionaElementos("Thread " + numeroDoThread + " - " +  i);
	}
		
}