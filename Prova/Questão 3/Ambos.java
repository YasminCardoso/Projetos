import java.io.RandomAccessFile;
import java.io.IOException;

class Ambos{
	
	public static void main(String args[]){

		try{

			RandomAccessFile arq1 = new RandomAccessFile("arq1D.dat", "rw");
			RandomAccessFile arq2 = new RandomAccessFile("arq2.dat", "rw");
			RandomAccessFile arq3 = new RandomAccessFile("arq3.dat", "rw");

			Registro r1 = new Registro();
			r1.leRegistro(arq1);
			Registro r2 = new Registro();
			r2.leRegistro(arq2);

			//System.out.println(arq1.getFilePointer());
			
			long inicio = 0;
			long meio;
			long fim = (arq2.length()/100) - 1;

			while(arq1.getFilePointer() < arq1.length()){

				while(inicio <= fim){

					meio = (inicio + fim)/2;
					arq2.seek(meio*100);
					r2.leRegistro(arq2);

					String s1 = r1.getChave().substring(0,r1.getChave().indexOf(" "));
					String s2 = r2.getChave().substring(0,r2.getChave().indexOf(" "));

					int i1 = Integer.parseInt(s1);
					int i2 = Integer.parseInt(s2);

					if(r1.getChave().equals(r2.getChave())){

						r2.escreveRegistro(arq3);
						break;

					}

					else if(i1 < i2){
						//System.out.println("Passou aqui");
						fim = meio - 1;					

					}
					else{
						//System.out.println("Passou aqui");
						inicio = meio + 1;

					}
				}

				r1.leRegistro(arq1);
				inicio = 0;
				fim = (arq2.length()/100) - 1;
				
			}

			arq1.close();
			arq2.close();
			arq3.close();

		}catch(IOException e){
			System.out.println("Erro: " + e.getMessage());
		}
	}
}