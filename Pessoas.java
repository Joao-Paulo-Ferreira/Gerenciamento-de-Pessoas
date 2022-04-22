/**
 * Classe responsável pelo objeto Pessoas
 * @author João Paulo Ferreira de Moraes - TADS - 25/06/2021
 *
 */

public class Pessoas {
	
	private String nome;
	private String sobreNome;
	private String email;
	private long CPF;
	private int dataNascimento;
	private int dataCadastro;
	
	public Pessoas(String nome, String sobreNome, String email, 
			long CPF, int dataNascimento, int dataCadastro) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
		this.CPF = CPF;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;	
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return this.sobreNome;
	}
	
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public long getCPF() {
		return this.CPF;
	}

	public int getDataNascismento() {
		return this.dataNascimento;
	}
	
	public void setDataNascimento(int dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public int getDataCadastro() {
		return this.dataCadastro;
	}
	
	public void setDataCadastro(int dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public String toString() {
		String pessoa = String.format("%s;%s;%s;%d;%d;%d",
				this.nome, this.sobreNome, this.email, this.CPF, this.dataNascimento, this.dataCadastro);
		return pessoa;
	}
}
