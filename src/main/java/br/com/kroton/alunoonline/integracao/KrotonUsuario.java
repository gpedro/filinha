package br.com.kroton.alunoonline.integracao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

import com.google.gson.annotations.SerializedName;

@ToString
@NoArgsConstructor
public class KrotonUsuario {

	@SerializedName("logou")
	private String autenticado;

	@Getter
	private int alunoNumFugas = 0;

	@Getter
	private int alunoMaxFugas = 0;

	private String cpf;
	private String cpfString;

	@SerializedName("alunoEndErrado")
	private String flagEnderecoErrado;

	@SerializedName("alunoValidaCadastro")
	private String flagValidaCadastro;

	@SerializedName("alunoAtualiCadastro")
	private String flagAtualizaCadastro;

	@SerializedName("contratoAceito")
	private String flagContratoAceito;

	@SerializedName("alunoPendenteFies")
	private String flagPendenteFies;

	private boolean parseSN(String s) {
		return (s.toUpperCase().trim() == "S");
	}

	public boolean isAutenticado() {
		return parseSN(this.autenticado);
	}

	public String getCpf() {
		if (cpfString == null) {
			cpfString = StringUtils
					.newStringUtf8(Base64.decodeBase64(this.cpf));
		}

		return cpfString;
	}

	public boolean isFlagEnderecoErrado() {
		return parseSN(this.flagEnderecoErrado);
	}

	public boolean isFlagValidaCadastro() {
		return parseSN(this.flagValidaCadastro);
	}

	public boolean isFlagAtualizaCadastro() {
		return parseSN(this.flagAtualizaCadastro);
	}

	public boolean isFlagContratoAceito() {
		return parseSN(this.flagContratoAceito);
	}

	public boolean isFlagPendenteFies() {
		return parseSN(this.flagPendenteFies);
	}
}
