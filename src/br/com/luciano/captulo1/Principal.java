package br.com.luciano.captulo1;

class Principal {
	public static void main(String args[]) {
		System.out.println("Executando o metodo main!!!");
		try {
			Thread.sleep(10000);
		}catch(InterruptedException e) {}

		Runnable tarefa = () -> System.out.println("Hello word");
		Thread executor = new Thread(tarefa);
		executor.start();
	}
}