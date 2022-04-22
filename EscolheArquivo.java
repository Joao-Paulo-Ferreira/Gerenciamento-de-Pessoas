/**
 * Classe que acessa o arquivo
 * @author João Paulo Ferreira de Moraes - 07/06/2021
 */

import javax.swing.JFileChooser;

public class EscolheArquivo {
	public static String getArquivo(){
		//retorna o caminho completo do arquivo selecionado
		JFileChooser arquivoPos = new JFileChooser();
		int resultado = arquivoPos.showOpenDialog(null);
		
		if (resultado == JFileChooser.CANCEL_OPTION){
			return null;
		} else{
			return arquivoPos.getSelectedFile().getAbsolutePath();
		}	
	}

}
