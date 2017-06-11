package model;

import java.io.Serializable;
import java.util.List;

public class PagamentoFuncionarios implements Serializable {
   private List<HorasTrabalhadasFuncionario> horasFuncionario;
   private List<Integer> departamentosEmAberto;
   
   public PagamentoFuncionarios () {}

    public List<HorasTrabalhadasFuncionario> getHorasFuncionario() {
        return horasFuncionario;
    }

    public void setHorasFuncionario(List<HorasTrabalhadasFuncionario> horasFuncionario) {
        this.horasFuncionario = horasFuncionario;
    }

    public List<Integer> getDepartamentosEmAberto() {
        return departamentosEmAberto;
    }

    public void setDepartamentosEmAberto(List<Integer> departamentosEmAberto) {
        this.departamentosEmAberto = departamentosEmAberto;
    }
   
   
}
