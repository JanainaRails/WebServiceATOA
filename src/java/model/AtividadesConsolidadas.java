package model;

import java.util.Date;

public class AtividadesConsolidadas {
    private int idFuncionario;
    private String tipo, atividade, nomeFuncionario;
    private Date inicioRealizado, fimRealizado;
    
    public AtividadesConsolidadas(){
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public Date getInicioRealizado() {
        return inicioRealizado;
    }

    public void setInicioRealizado(Date inicioRealizado) {
        this.inicioRealizado = inicioRealizado;
    }

    public Date getFimRealizado() {
        return fimRealizado;
    }

    public void setFimRealizado(Date fimRealizado) {
        this.fimRealizado = fimRealizado;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }
}
