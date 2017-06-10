package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.HorasTrabalhadasDepartamento;

public class RelatorioDepartamentoDAO {
    private final static String HORASTRABALHADASDEPART = "SELECT idDepart, sum(TIMESTAMPDIFF(HOUR, inicioRealizado, fimRealizado)) FROM atividade WHERE MONTH(inicioRealizado) = ? AND YEAR(inicioRealizado) = ? GROUP BY idDepart";
    
    public List<HorasTrabalhadasDepartamento> buscarAtividades(int mes, int ano){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<HorasTrabalhadasDepartamento> lista = new ArrayList();
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
                System.out.println("DAO " + htd.getIdDepartamento() +" -- "+ htd.getHorasTrab());
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
        return lista;
    }
}
