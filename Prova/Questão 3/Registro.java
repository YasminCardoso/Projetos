import java.io.IOException;
import java.io.DataInput;
import java.io.DataOutput;
import java.nio.charset.Charset;

class Registro{

	private String chave;
	private String nome;
	private String email;
	private String telefone;

	public void leRegistro(DataInput din) throws IOException{

		byte chave[] = new byte[8];
		byte nome[] = new byte[40];
		byte email[] = new byte[40];
		byte telefone[] = new byte[11];

		din.readFully(chave);
		din.readFully(nome);
		din.readFully(email);
		din.readFully(telefone);
		din.readByte();

		Charset enc = Charset.forName("ISO-8859-1");

		this.chave = new String(chave, enc);
		this.nome = new String(nome, enc);
		this.email = new String(email, enc);
		this.telefone = new String(telefone, enc);
	}

	public void escreveRegistro(DataOutput dout) throws IOException{

		Charset enc = Charset.forName("ISO-8859-1");
		dout.write(this.chave.getBytes(enc));
		dout.write(this.nome.getBytes(enc));
		dout.write(this.email.getBytes(enc));
		dout.write(this.telefone.getBytes(enc));
		dout.write("\n".getBytes(enc));

	}

	public boolean terminaCom(String email, String fim){
		//String str = email.substring(email.indexOf("@"), email.length());
		if(email.contains(fim)){
			return true;
		}
		return false;
	}

	public String getChave(){
		return chave;
	}

	public String getNome(){
		return nome;
	}

	public String getEmail(){
		return email;
	}

	public String getTelefone(){
		return telefone;
	}

	public void setChave(String chave){
		this.chave = chave;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
}