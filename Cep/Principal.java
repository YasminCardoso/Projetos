import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

class Principal {
	
	public static void main(String args[]) {

		try {
		RandomAccessFile arq = new RandomAccessFile("cep_ordenado.dat", "r");
		Scanner sc = new Scanner(System.in);
		Endereco endereco = new Endereco();

		String cep, aux;
		long ini = 0;
		long mei;
		long fim = (arq.length() / 300)-1;
		boolean achou = false;

		System.out.print("Digite o CEP: ");
		cep = sc.nextLine();
		

		//Código Busca Binária

		while(ini <= fim) {

			mei = (ini + fim)/2;
			arq.seek(mei * 300);
			endereco.lerEndereco(arq);
			aux = endereco.getCEP();

			if(aux.compareTo(cep) < 0) {
				ini = mei + 1;
			}
			else if(aux.compareTo(cep) > 0) {
				fim = mei - 1;
			}

			else {

				achou = true;
				break;
			}			

		}

		if (achou) {
			System.out.println("CEP encontrado!");
			System.out.println("Endereço: ");
			System.out.println("Logradouro: " + endereco.getLogradouro());
			System.out.println("Bairro: " + endereco.getBairro());
			System.out.println("Cidade: " + endereco.getCidade());
			System.out.println("Estado: " + endereco.getEstado());
			System.out.println("Sigla: " + endereco.getSigla());
			System.out.println("CEP: " + endereco.getCEP());
			arq.close();
		}
		else {
			System.out.println("CEP não encontrado!");
		}

	} catch(IOException e) {
		System.out.println("Erro: " + e.getMessage());
	}


	}
}
