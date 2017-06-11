package model;

import java.io.Serializable;

public class HorasTrabalhadasFuncionario implements Serializable{
    private int cargaHorariaMin, horasFeitas, idFuncionario;
    
    public HorasTrabalhadasFuncionario() {
        
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getCargaHorariaMin() {
        return cargaHorariaMin;
    }

    public void setCargaHorariaMin(int cargaHorariaMin) {
        this.cargaHorariaMin = cargaHorariaMin;
    }

    public int getHorasFeitas() {
        return horasFeitas;
    }

    public void setHorasFeitas(int horasFeitas) {
        this.horasFeitas = horasFeitas;
    }
        
}
