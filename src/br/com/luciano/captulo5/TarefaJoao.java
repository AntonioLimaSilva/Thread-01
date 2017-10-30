package br.com.luciano.captulo5;

class TarefaJoao implements Runnable {

	private Banheiro banheiro;

	TarefaJoao(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	public void run() {
		this.banheiro.fazNumero2();
	}
}