package br.com.luciano.captulo8;

class Lista {
	private String[] elementos = new String[1000];
	private int indice;

	public synchronized void adicionarElemento(String elemento) {
		this.elementos[indice] = elemento;
		this.indice++;
	}

	public String pegaElemento(int indice) {
		return this.elementos[indice];
	}

	public int tamanho() {
		return this.elementos.length;
	}	
}

class TarefaAdicionaElemento implements Runnable {
	private Lista lista;
	private int numeroDaThread;

	TarefaAdicionaElemento(Lista lista, int numeroDaThread) {
		this.lista = lista;
		this.numeroDaThread = numeroDaThread;
	}

	public void run() {
		for(int i = 0; i < 100; i++)
			this.lista.adicionarElemento("Thread " + numeroDaThread + " - " + i);
	}

}

class Principal1 {
	public static void main(String args[]) {

		Lista lista = new Lista();

		for(int i = 0; i < 10; i++)
			new Thread(new TarefaAdicionaElemento(lista, i)).start();

		try { Thread.sleep(2000);}
		catch(InterruptedException e) {}

		for(int i = 0; i < lista.tamanho(); i++)
			System.out.println(i + " = " + lista.pegaElemento(i));

	}
}