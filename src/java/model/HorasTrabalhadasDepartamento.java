package model;

import java.io.Serializable;

public class HorasTrabalhadasDepartamento implements Serializable {
    private int idDepartamento;
    private int horasTrab;
    private String departamento;
    
    public HorasTrabalhadasDepartamento(){
    }

    public int getHorasTrab() {
        return horasTrab;
    }

    public void setHorasTrab(int horasTrab) {
        this.horasTrab = horasTrab;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    
}
