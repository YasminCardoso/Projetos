import java.io.IOException;
import java.io.DataInput;
import java.nio.charset.Charset;

class Endereco {
	
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;
	private String sigla;
	private String cep;

	public Long tamanhoLinha() {

		return 300L;
	}

	public void lerEndereco(DataInput din) throws IOException {

		byte logradouro[] = new byte[72];
		byte bairro[] = new byte[72];
		byte cidade[] = new byte[72];
		byte estado[] = new byte[72];
		byte sigla[] = new byte[2];
		byte cep[] = new byte[8];

		din.readFully(logradouro);
		din.readFully(bairro);
		din.readFully(cidade);
		din.readFully(estado);
		din.readFully(sigla);
		din.readFully(cep);
		din.readByte(); // Ultimo espaco em branco 
		din.readByte(); // Quebra de linha

		Charset enc = Charset.forName("ISO-8859-1");

		this.logradouro = new String(logradouro,enc);
		this.bairro = new String(bairro,enc);
		this.cidade = new String(cidade,enc);
		this.estado = new String(estado,enc);
		this.sigla = new String(sigla,enc);
		this.cep = new String(cep,enc);


	}

	public String getLogradouro() {

		return logradouro;
	}

	public String getBairro() {

		return bairro;
	}

	public String getCidade() {

		return cidade;
	}

	public String getEstado() {

		return estado;
	}

	public String getSigla() {

		return sigla;
	}

	public String getCEP() {

		return cep;
	}
}