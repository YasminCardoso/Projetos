import java.io.RandomAccessFile;
import java.io.IOException;

class OrdenaDecrescente{
	public static void main(String args[]){

		try{
			RandomAccessFile arq1 = new RandomAccessFile("arq1.dat", "rw");
			RandomAccessFile arq2 = new RandomAccessFile("arq2.dat", "rw");

			Registro r = new Registro();
			//System.out.println(arq1.length());

			long aux = arq1.length() - 100;
			
			int contador = 0;

			while(aux >= 0){
				arq1.seek(aux);
				r.leRegistro(arq1);
				r.escreveRegistro(arq2);

				aux = aux - 100;
			}

			arq1.close();
			arq2.close();

		}catch(IOException e){
			System.out.println("Erro: " + e.getMessage());
		}
	}
}