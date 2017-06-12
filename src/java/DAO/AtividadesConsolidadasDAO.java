package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.AtividadesConsolidadas;
import java.sql.Date;
import java.util.Calendar;
import model.Atividade;
import model.Grafico;
import model.TipoAtividade;

public class AtividadesConsolidadasDAO {
    private final static String ATIVIDADES ="SELECT atividade.idFuncionario, tipoatividade.nome, atividade.nome, atividade.inicioRealizado, atividade.fimRealizado FROM atividade, tipoatividade WHERE atividade.inicioRealizado BETWEEN ? AND ? AND atividade.idTipo = tipoatividade.id AND consolidado = 1 AND idFuncionario = ?";
    private final static String ATIVIDADESFUNCIONARIO = "SELECT * FROM atividade WHERE idFuncionario = ?";
    
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
    
    public Grafico buscarStatusAtividadesFuncionario(int idFuncionario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Grafico g = new Grafico();
        List<String> labels = new ArrayList();
        List<Integer> dados = new ArrayList();
  
        labels.add("Em espera");
        labels.add("Em andamento");
        labels.add("Finalizada");
        labels.add("Atrasada");

        dados.add(0, 0);
        dados.add(1, 0);
        dados.add(2, 0);
        dados.add(3, 0);
        List<Atividade> lista = new ArrayList();
        try{
            System.out.println("começando a conexão ...");
            conn = new ConnectionFactory().getConnection();
            stmt = conn.prepareStatement(ATIVIDADESFUNCIONARIO);
            stmt.setInt(1, idFuncionario);
            rs = stmt.executeQuery();
            while(rs.next()){
                TipoAtividade tipo = new TipoAtividade();
                Atividade ativ = new Atividade();
                ativ.setInicioAtividade(rs.getDate("inicioAtividade"));
                ativ.setFimAtividade(rs.getDate("fimAtividade"));
                ativ.setInicioRealizado(rs.getDate("inicioRealizado"));
                ativ.setFimRealizado(rs.getDate("fimRealizado"));
                Calendar calendar = Calendar.getInstance();
                java.util.Date current = calendar.getTime();
                
                if(rs.getDate(9) == null && current.getTime() < rs.getDate(8).getTime())
                    ativ.setStatus(2);
                if(rs.getDate(9) == null && current.getTime() < rs.getDate(8).getTime())
                    ativ.setStatus(2);
                else if(rs.getDate(9) == null && rs.getDate(10) == null)
                    ativ.setStatus(1);
                else if(rs.getDate(10) == null && current.getTime() == rs.getDate(8).getTime())
                    ativ.setStatus(2);
                else if(rs.getDate(10) == null && current.getTime() > rs.getDate(8).getTime())
                    ativ.setStatus(4);
                else if(rs.getDate(9) != null && rs.getDate(10) == null)
                    ativ.setStatus(2);
                else if(rs.getDate(10) == null && current.getTime() > rs.getDate(8).getTime())
                    ativ.setStatus(4);
                else
                    ativ.setStatus(3);
                
                int aux = dados.get(ativ.getStatus()-1)+1;
                dados.set(ativ.getStatus()-1, aux);

            }
            g.setDados(dados);
            g.setLabels(labels);
            
            System.out.println("adicionado na lista!");
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
        return g;
    }
   
}
