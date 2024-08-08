package Model;
import java.time.LocalDate;  
import java.time.Period;  

import java.util.Date;

public class Pessoa {
	private String nome;
	private char sexo;
	private LocalDate dataNasc;
	private String rg;
	private String cpf;
	private double salario;
	private int tempoContribuicao;
	private String areaTrabalho;
	
	public int getIdade() {
		LocalDate curDate = LocalDate.now();
		Period period = Period.between(this.dataNasc, curDate);
		
		return period.getYears();
	
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSalario() {
		return round(salario,2);
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public int getTempoContribuicao() {
		return tempoContribuicao;
	}
	public void setTempoContribuicao(int tempoContribuicao) {
		this.tempoContribuicao = tempoContribuicao;
	}
	public String getAreaTrabalho() {
		return areaTrabalho;
	}
	public void setAreaTrabalho(String areaTrabalho) {
		this.areaTrabalho = areaTrabalho;
	}
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", sexo=" + sexo + ", dataNasc=" + dataNasc + ", rg=" + rg + ", cpf=" + cpf
				+ ", salario=" + salario + ", tempoContribuicao=" + tempoContribuicao + ", areaTrabalho=" + areaTrabalho
				+ "]";
	}
	public Pessoa(String nome, char sexo, LocalDate dataNasc, String rg, String cpf, double salario, int tempoContribuicao,
			String areaTrabalho) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.dataNasc = dataNasc;
		this.rg = rg;
		this.cpf = cpf;
		this.salario = salario;
		this.tempoContribuicao = tempoContribuicao;
		this.areaTrabalho = areaTrabalho;
	}
	
	public Pessoa() {}

	
	public String calcSalarioAnual() {
		return String.valueOf(round(this.salario * 12,2)) ;
	}
	public String calcSalarioAnualImposto() {
		if(this.salario<2112.00) {
			return String.valueOf(round(this.salario *12,2));
		}
		else if(this.salario<2826.66) {
			return  String.valueOf(round(this.salario * 0.925 * 12,2));
		}
		else if(this.salario<3751.06) {
			return String.valueOf(round(this.salario * 0.85 * 12,2));
		}
		else if(this.salario<4664.69) {
			return String.valueOf(round(this.salario * 0.775 *12,2));
		}
		else return String.valueOf(round(this.salario * 0.725 *12,2)) ;
	}
	public String calcAposentadoria() {
		LocalDate curDate = LocalDate.now();
		Period period = Period.between(this.dataNasc, curDate);
		
		//RURAL
		if(this.areaTrabalho.equals("rural")) {
			
			//HOMEM RURAL
			if(this.sexo == 'm') {
				if(this.tempoContribuicao>= 15 && period.getYears()>=60 ) {
					return "Você já pode se aposentar!";
				}
				else return "Você ainda não pode se aposentar!";
			}
			else {
				//MULHER RURAL
				if(this.tempoContribuicao>=15 && period.getYears()>=55) {
					return "Você já pode se aposentar!";
				}
				else return "Você ainda não pode se aposentar!";
			}
		}
		
		//URBANO
		else{
				
			//HOMEM URBANO
			if(this.sexo=='m') {
				if(this.tempoContribuicao>=15 && period.getYears()>=65) {
					return "Você já pode se aposentar!";
				}
				else return "Você ainda não pode se aposentar!";
			}
			
			//MULHER URBANO
			else {
				if(this.tempoContribuicao>=15 && period.getYears()>=62) {
					return "Você já pode se aposentar!";
				}
				else return "Você ainda não pode se aposentar!";
				
			}
		}
		
	}
	public String calcSalarioAposentadoria() {
		
		if(this.calcAposentadoria().equals("Você já pode se aposentar!")) {
		
		if(this.sexo=='m') {
			if(this.tempoContribuicao>20) {
				return String.valueOf((this.salario*(0.6+(this.tempoContribuicao-20)*0.02)));
			}
			else return String.valueOf(this.salario*0.6);
		}
		else {
			if(this.tempoContribuicao>15) {
				return String.valueOf((this.salario*(0.6+(this.tempoContribuicao-15)*0.02)));
			}
			else return String.valueOf(this.salario*0.6);
		}
		
	}
		else return "Você ainda não é aposentado!";
}
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
	
	
