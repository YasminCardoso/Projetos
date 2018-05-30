import java.io.IOException;
import java.io.RandomAccessFile;

class TerminaCom{
	
	public static void main(String args[]){

		try{
			
			RandomAccessFile arq1 = new RandomAccessFile("arq1D.dat", "rw");
			RandomAccessFile arq2 = new RandomAccessFile("arq2.dat", "rw");
			Registro r = new Registro();
			long aux = 0;
			
			while(arq1.getFilePointer() < arq1.length()){
				r.leRegistro(arq1);
				if(r.terminaCom(r.getEmail(), "gmail.com")){
					r.escreveRegistro(arq2);
				}
			}

			arq1.close();
			arq2.close();

		}catch(IOException e){
			System.out.println("Erro: " + e.getMessage());
		}
	}
}