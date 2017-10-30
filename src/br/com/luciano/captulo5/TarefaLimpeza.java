package br.com.luciano.captulo5;

class TarefaLimpeza implements Runnable {

	private Banheiro banheiro;

	TarefaLimpeza(Banheiro banheiro) {
		this.banheiro = banheiro;
	}
	
	public void run() {
		while(true) {
			this.banheiro.limpa();
			try {
				Thread.sleep(20000);
			} catch(InterruptedException e) {}
		}
	}

}