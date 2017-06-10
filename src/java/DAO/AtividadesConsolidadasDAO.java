package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.AtividadesConsolidadas;
import java.util.Date;

public class AtividadesConsolidadasDAO {
    private final static String ATIVIDADES ="SELECT atividade.idFuncionario, tipoatividade.nome, atividade.nome, atividade.inicioRealizado, atividade.fimRealizado FROM atividade, tipoatividade WHERE atividade.inicioRealizado BETWEEN ? AND ? AND atividade.idTipo = tipoatividade.id AND consolidado = 1 AND idFuncionario = ?";

    public List<AtividadesConsolidadas> buscaAtividadesConsolidadas(Date dataInicio, Date dataFim, int idFuncionario){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<AtividadesConsolidadas> lista = new ArrayList();
        try{
            conn = new ConnectionFactory().getConnection();
            stmt = conn.prepareStatement(ATIVIDADES);
            stmt.setDate(1, (java.sql.Date) dataInicio);
            stmt.setDate(2, (java.sql.Date) dataFim);
            stmt.setInt(3, idFuncionario);
            rs = stmt.executeQuery();
            while(rs.next()){
                AtividadesConsolidadas ac = new AtividadesConsolidadas();
                ac.setIdFuncionario(rs.getInt(1));
                ac.setTipo(rs.getString(2));
                ac.setAtividade(rs.getString(3));
                ac.setInicioRealizado(rs.getDate(4));
                ac.setFimRealizado(rs.getDate(5));
                System.out.println("ID FUNCIONARIO: "+ ac.getIdFuncionario());
                System.out.println("TIPO ATIVIDADE: "+ ac.getTipo());
                System.out.println("ATIVIDADE: "+ ac.getAtividade());
                System.out.println("INICIO REALIZADO: "+ ac.getInicioRealizado());
                System.out.println("FIM REALIZADO: "+ ac.getFimRealizado());
                lista.add(ac);
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
