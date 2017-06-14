package model;

import java.io.Serializable;
import java.util.Date;

public class Atividade implements Serializable {
    private int id, status, idDepart;
    private String nome, descricao;
    private Date inicioAtividade, fimAtividade, inicioRealizado, fimRealizado;
    private boolean consolidado;
    private TipoAtividade tipo;
    
    public Atividade(){
        
    }

    public int getIdDepart() {
        return idDepart;
    }

    public void setIdDepart(int idDepart) {
        this.idDepart = idDepart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoAtividade getTipo() {
        return tipo;
    }

    public void setTipo(TipoAtividade tipo) {
        this.tipo = tipo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getInicioAtividade() {
        return inicioAtividade;
    }

    public void setInicioAtividade(Date inicioAtividade) {
        this.inicioAtividade = inicioAtividade;
    }

    public Date getFimAtividade() {
        return fimAtividade;
    }

    public void setFimAtividade(Date fimAtividade) {
        this.fimAtividade = fimAtividade;
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

    public boolean isConsolidado() {
        return consolidado;
    }

    public void setConsolidado(boolean consolidado) {
        this.consolidado = consolidado;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }    
}
