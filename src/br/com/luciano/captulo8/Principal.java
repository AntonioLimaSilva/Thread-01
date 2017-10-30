package br.com.luciano.captulo8;

class Banheiro {
	public void fazNumero1() {
		String nome = Thread.currentThread().getName();
		System.out.println(nome + " = bateu na porta");

		synchronized(this) {
			//Aqui esta sincronizado o acesso será executado de forma atômica, de uma vez só!
			System.out.println(nome + " = Entrou no banheiro");
			try {
				Thread.sleep(5000);
			} catch(InterruptedException e) {}

			System.out.println(nome + " = Faz coisa rapida");
			System.out.println(nome + " = Deu descarga");
			System.out.println(nome + " = Lavou as maos");
			System.out.println(nome + " = saiu do banheiro");
		}
	}

	public void fazNumero2() {
		String nome = Thread.currentThread().getName();
		System.out.println(nome + " = bateu na porta");

		synchronized(this) {
			System.out.println(nome + " = Entrou no banheiro");
			try {
				Thread.sleep(10000);
			} catch(InterruptedException e) {}

			System.out.println(nome + " = Faz coisa demorada");
			System.out.println(nome + " = Deu descarga");
			System.out.println(nome + " = Lavou as maos");
			System.out.println(nome + " = saiu do banheiro");
		}
	}
}

class Principal {
	public static void main(String args[]) {

		Banheiro banheiro = new Banheiro();

		new Thread(()-> { 
			banheiro.fazNumero1(); 
		}, "Joao").start();

		new Thread(() -> {
			banheiro.fazNumero2();
		}, "Pedro").start();

	}
}