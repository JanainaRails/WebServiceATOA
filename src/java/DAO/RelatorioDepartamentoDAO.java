package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.HorasTrabalhadasDepartamento;
import model.HorasTrabalhadasFuncionario;

public class RelatorioDepartamentoDAO {
    private final static String HORASTRABALHADASDEPART = "SELECT idDepart, sum(TIMESTAMPDIFF(HOUR, inicioRealizado, fimRealizado)) FROM atividade WHERE MONTH(inicioRealizado) = ? AND YEAR(inicioRealizado) = ? GROUP BY idDepart";
    private final static String HORASTRABALHADSPORFUNC = "SELECT idFuncionario, sum(TIMESTAMPDIFF(HOUR, inicioRealizado, fimRealizado)), fimRealizado, idDepart FROM atividade WHERE MONTH(inicioRealizado) = ? AND YEAR(inicioRealizado) = ? GROUP BY idFuncionario";
    private final static String FECHAMENTOEMABERTO = "SELECT idDepart, count(*) FROM atividade WHERE MONTH(inicioRealizado) = ? AND YEAR(inicioRealizado) = ? AND fimRealizado IS NULL GROUP BY idDepart";
    
    public List<HorasTrabalhadasDepartamento> buscarAtividades(int mes, int ano) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<HorasTrabalhadasDepartamento> lista = new ArrayList();
        boolean fimRealizadoNull = false;
        try{
            conn = new ConnectionFactory().getConnection();
            stmt = conn.prepareStatement(HORASTRABALHADASDEPART);
            stmt.setInt(1, mes);
            stmt.setInt(2, ano);
            rs = stmt.executeQuery();
            while(rs.next()){
                HorasTrabalhadasDepartamento htd = new HorasTrabalhadasDepartamento();
                htd.setIdDepartamento(rs.getInt(1));
                htd.setHorasTrab(rs.getInt(2));
                lista.add(htd);
            }
        }catch (SQLException e){
            System.out.println("Erro SQL: " + e);
        }finally{
            try{
                stmt.close();
                conn.close();
                rs.close();
            }catch(Exception e){
                System.out.println("Error "+e.getMessage());
            }
        }
        return fimRealizadoNull ? null : lista;
       
    }
    
    public List<Integer> DepartamentosEmAberto(int mes, int ano) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Integer> lista = new ArrayList();
        try{
            conn = new ConnectionFactory().getConnection();
            stmt = conn.prepareStatement(FECHAMENTOEMABERTO);
            stmt.setInt(1, mes);
            stmt.setInt(2, ano);
            rs = stmt.executeQuery();
            while(rs.next()) {
                if(rs.getInt(2) == 0)
                    break;
                lista.add(rs.getInt(1));
            }
        }catch (SQLException e){
            System.out.println("Erro SQL: " + e);
        }finally{
            try{
                stmt.close();
                conn.close();
                rs.close();
            }catch(Exception e){
                System.out.println("Error "+e.getMessage());
            }
        }
        return lista;
    }
    
    public List<HorasTrabalhadasFuncionario> buscarHorasFuncionario(int mes, int ano) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<HorasTrabalhadasFuncionario> lista = new ArrayList();
        try{
            conn = new ConnectionFactory().getConnection();
            stmt = conn.prepareStatement(HORASTRABALHADSPORFUNC);
            stmt.setInt(1, mes);
            stmt.setInt(2, ano);
            rs = stmt.executeQuery();
            while(rs.next()){               
                HorasTrabalhadasFuncionario htf = new HorasTrabalhadasFuncionario();
                htf.setIdFuncionario(rs.getInt(1));
                htf.setHorasFeitas(rs.getInt(2));
                lista.add(htf);
            }
        }catch (SQLException e){
            System.out.println("Erro SQL: " + e);
        }finally{
            try{
                stmt.close();
                conn.close();
                rs.close();
            }catch(Exception e){
                System.out.println("Error "+e.getMessage());
            }
        }
        return lista;
    }
}
