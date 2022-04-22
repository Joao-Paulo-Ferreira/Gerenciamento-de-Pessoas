/**
 * Classe com menu interativo com o usu�rio
 * @author Jo�o Paulo Ferreira de Moraes - TADS - 28/06/2021
 */

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		Pessoas[] vetPessoas;
		int opc;

		do {
			System.out.println("\n1 - Cadastrar pessoa"
					+ "\n2 - Alterar pessoa"
					+ "\n3 - Exibir pessoa"
					+ "\n4 - Listar pessoas"
					+ "\n0 - Encerrar aplica��o"
					+ "\n  Informe a op�ao: ");
			opc = s.nextInt();


			switch(opc) {
			case 1:
				System.out.println("\nInsira o quantas pessoas ir� cadastrar: ");
				int tamP = s.nextInt();

				vetPessoas = new Pessoas[tamP];
				for(int i = 0; i < vetPessoas.length; i++) {
					System.out.println("\nInforme o nome da pessoa: ");
					String nome = s.next();

					System.out.println("\nInforme o sobrenome do(a) " + nome + ": ");
					String sobreNome = s.next();

					System.out.println("\nInforme o Email do(a) " + nome + ": ");
					String email = s.next();

					System.out.println("\nInforme o CPF do(a) " + nome + ": ");
					long CPF = s.nextLong();

					System.out.println("Informe a data de nascimento do(a) " + nome + ": ");
					int dataNascimento = s.nextInt();

					System.out.println("\nInforme a data de cadastro do(a) " + nome + ": ");
					int dataCadastro = s.nextInt();

					vetPessoas[i] = new Pessoas(nome, sobreNome, email, CPF, 
							dataNascimento, dataCadastro);
				}
				GerenciaPessoas.escreverPessoas(vetPessoas);
				break;
			case 2:
				vetPessoas = GerenciaPessoas.lerPessoas();
				System.out.println("\nInforme o CPF que deseja alterar: ");
				long cpf = s.nextLong();
				GerenciaPessoas.alterarPessoa(vetPessoas, cpf);
				break;
			case 3:
				vetPessoas = GerenciaPessoas.lerPessoas();
				System.out.println("\nInforme o CPF que deseja exibir: ");
				long cpf1 = s.nextLong();
				GerenciaPessoas.exibirPessoa(vetPessoas, cpf1);
				break;
			case 4:
				vetPessoas = GerenciaPessoas.lerPessoas();
				String saida = GerenciaPessoas.listarPessoas(vetPessoas);
				
				if(vetPessoas == null) {
					System.out.println("Vetor n�o carregado!");
				}else {
					System.out.println("Lista Carregada!"
							+ "\nNome; SobreNome; Email; CPF; DataNascimento; DataCadastro"
							+ "\n" + saida);
				}
				break;
			case 0:
				System.out.println("\nAplica��o encerrada!");
				break;
			default:
				System.out.println("\nInforme uma op��o v�lida!");
			}
		}while(opc > 0 && opc < 5);
	}
}
