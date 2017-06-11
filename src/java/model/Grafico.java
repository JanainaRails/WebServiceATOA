package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Grafico implements Serializable {
    private String tipo;
    private List<String> labels = new ArrayList();
    private List<?> dados = new ArrayList(); 

    public Grafico() {

    }

    public String getTipo() { 
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<?> getDados() {
        return dados;
    }

    public void setDados(List<?> dados) {
        this.dados = dados;
    }
}
