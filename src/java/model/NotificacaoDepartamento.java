package model;

import java.io.Serializable;

public class NotificacaoDepartamento implements Serializable {
   private String[] departamentos;
   private int gerente;
   
   public NotificacaoDepartamento () {}

    public String[] getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(String[] departamentos) {
        this.departamentos = departamentos;
    }

    public int getGerente() {
        return gerente;
    }

    public void setGerente(int gerente) {
        this.gerente = gerente;
    }
   
   
}
