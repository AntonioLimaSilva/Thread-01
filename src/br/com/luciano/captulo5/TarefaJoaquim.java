package br.com.luciano.captulo5;

class TarefaJoaquim implements Runnable {

	private Banheiro banheiro;

	TarefaJoaquim(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	public void run() {
		this.banheiro.fazNumero1();
	}
}