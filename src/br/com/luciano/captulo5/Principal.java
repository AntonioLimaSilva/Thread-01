package br.com.luciano.captulo5;

class Principal {
	public static void main(String args[]) {

		Banheiro banheiro = new Banheiro();

		Thread tarefaDoJoao = new Thread(new TarefaJoao(banheiro), "Joao");
		Thread tarefaDoJoaquim = new Thread(new TarefaJoaquim(banheiro), "Joaquim");
		Thread tarefaDaLimpeza = new Thread(new TarefaLimpeza(banheiro), "Limpeza");

		tarefaDoJoao.start();
		tarefaDoJoaquim.start();
		/*Daemon são threads para executar tarefas ou serviços secundários
		* daemons serão automaticamente desligados quando todas as outras threads terminaram.
		*/
		tarefaDaLimpeza.setDaemon(true);
		tarefaDaLimpeza.start();
	}
}