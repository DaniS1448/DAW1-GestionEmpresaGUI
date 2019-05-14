package modelo;

public class Departamento {
	private int codDepartamento;
	private String nomDepartamento;
	
	public Departamento(String nomDepartamento) {
		super();
		this.codDepartamento=0;
		this.nomDepartamento = nomDepartamento;
	}
	public Departamento(int codDepartamento,String nomDepartamento) {
		super();
		this.setCodDepartamento(codDepartamento);
		this.nomDepartamento = nomDepartamento;
	}
	public String getNomDepartamento() {
		return nomDepartamento;
	}

	public void setNomDepartamento(String nomDepartamento) {
		this.nomDepartamento = nomDepartamento;
	}

	
	public int getCodDepartamento() {
		return codDepartamento;
	}
	public void setCodDepartamento(int codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	@Override
	public String toString() {
		String s;
		if (this.codDepartamento==0) s=" - " + nomDepartamento;
		else s=" - " + this.codDepartamento + " - " + nomDepartamento;
		return s;
	}

	

}
