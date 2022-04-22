/**
 * Classe responsável pela leitura e escrita do arquivo, 
 * além de alterar uma pessoa do arquivo  ou buscá-la
 * @author João Paulo Ferreira de Moraes - TADS - 28/06/2021
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class GerenciaPessoas {
	public static String pathArquivo = EscolheArquivo.getArquivo();
	public static void escreverPessoas(Pessoas[] vetPessoas) {

		try {
			FileOutputStream arquivo = new FileOutputStream (pathArquivo);
			PrintWriter arq = new PrintWriter(arquivo);

			arq.println("Nome;SobreNome;Email;CPF;DataNascimento;DataCadastro");

			for(int i = 0; i < vetPessoas.length; i++) {
				arq.println(vetPessoas[i].toString());
			}

			arq.close();
			arquivo.close();
		}catch(Exception e) {
			System.out.println("Erro ao escrever o arquivo!");
		}
	}

	public static Pessoas[] lerPessoas() {
		Pessoas[] vetPessoas = null;
		try {
			FileInputStream arquivo = new FileInputStream (pathArquivo);
			InputStreamReader input = new InputStreamReader(arquivo);
			BufferedReader br = new BufferedReader (input);

			String registro;
			String[] vetCampos; 
			int qtdRegistros = 0;
			br.readLine();
			br.mark(100000);

			while(br.readLine() != null) {
				qtdRegistros++;
			}
			br.reset();

			if(qtdRegistros > 0) {
				vetPessoas = new Pessoas[qtdRegistros];

				for(int ind = 0; ind < qtdRegistros; ind++) {
					registro = br.readLine();
					vetCampos = registro.split(";");

					vetPessoas[ind] = new Pessoas(vetCampos[0], vetCampos[1], vetCampos[2], 
							Long.parseLong(vetCampos[3]), Integer.parseInt(vetCampos[4]),
							Integer.parseInt(vetCampos[5]));
				}
			}

			br.close();
			input.close();
			arquivo.close();

			return vetPessoas;
		}catch(Exception e) {
			System.out.println("Erro ao ler arquivo!" + e);
			return null;
		}
	}

	public static String listarPessoas(Pessoas [] vetPessoas) {
		String listagem = "";
		for (int ind = 0; ind < vetPessoas.length; ind++) {
			listagem += vetPessoas[ind].toString() + "\n";
		}
		return listagem;
	}

	public static void alterarPessoa(Pessoas[] vetPessoas, long cpf) {
		Scanner s = new Scanner(System.in);
		vetPessoas = lerPessoas();
		boolean encontrou = false;
		
		for(int i = 0; i < vetPessoas.length && encontrou == false; i++) {
			if(vetPessoas[i].getCPF() == cpf) {
				encontrou = true;
				System.out.println("O que deseja alterar? ");
				String resp = s.next().toUpperCase();
				
				if(resp.equals("NOME") || resp.equals("SOBRENOME") || resp.equals("EMAIL")
						|| resp.equals("DATANASC") || resp.equals("DATACAD")) {
					if(resp.equals("NOME")) {
						encontrou = true;
						System.out.println("Informe o novo nome: "); 
						vetPessoas[i].setNome(s.next());
					}
					if(resp.equals("SOBRENOME")) {
						encontrou = true;
						System.out.println("Informe o novo sobrenome: "); 
						vetPessoas[i].setSobreNome(s.next());
					}
					if(resp.equals("EMAIL")) {
						encontrou = true;
						System.out.println("Informe o novo email: "); 
						vetPessoas[i].setEmail(s.next());
					}
					if(resp.equals("DATANASC")) {
						encontrou = true;
						System.out.println("Informe a nova data de nascimento: "); 
						vetPessoas[i].setDataNascimento(s.nextInt());
					}
					if(resp.equals("DATACAD")) {
						encontrou = true;
						System.out.println("Informe a nova data de cadastro: "); 
						vetPessoas[i].setDataCadastro(s.nextInt());
					}
				}else {
					System.out.println("Atributo inexistente!");
				}
			}
		}
		escreverPessoas(vetPessoas);
	}
	
	public static void exibirPessoa(Pessoas[] vetPessoas, long cpf) {
		vetPessoas = lerPessoas();
		boolean encontrou = false;
		
		for(int i = 0; i < vetPessoas.length && encontrou == false; i++) {
			if(vetPessoas[i].getCPF() == cpf) {
				System.out.println("Nome;Sobrenome;Email;CPF;DataNascimento;DataCadastro\n" 
								+ vetPessoas[i].toString());
			}
		}
		
	}
	
}
