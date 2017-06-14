package DAO;

import model.Notificacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotificacaoDAO {
    private final static String SELECAO = "SELECT * FROM notificacao";
    private final static String LIDA = "UPDATE notificacao SET lida = TRUE WHERE id = ?";
    private final static String INSERE = "INSERT INTO notificacao(idFuncionario, idGerente, titulo, descricao, lida) VALUES (?, ?, ?, ?, FALSE)";
    
    public List<Notificacao> buscarNotificacoes(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Notificacao> lista = new ArrayList();
        try{
            System.out.println("começando a conexão ...");
            conn = new ConnectionFactory().getConnection();
            stmt = conn.prepareStatement(SELECAO);           
            rs = stmt.executeQuery();
            while(rs.next()){
                Notificacao not = new Notificacao();
                not.setId(rs.getInt(1));
                not.setIdFuncionario(rs.getInt(2));
                not.setIdGerente(rs.getInt(3));
                not.setTitulo(rs.getString(4));
                not.setDescricao(rs.getString(5));
                not.setLida(rs.getBoolean(6));
                lista.add(not);
            }
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
        return lista;
    }
    
    public boolean marcarLida(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean lida = true;
        try{
            conn = new ConnectionFactory().getConnection();
            stmt = conn.prepareStatement(LIDA);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Erro SQL: " + e);
            lida = false;
        }finally{
            try{
                stmt.close();
                conn.close();
            }catch(Exception e){
                System.out.println("Erro: "+e.getMessage());
            }
        }
        return lida;
    }
    
    public boolean inserirNotificacao(Notificacao not){
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean inserido = true;
        try{
            conn = new ConnectionFactory().getConnection();
            stmt = conn.prepareStatement(INSERE);
            stmt.setInt(1, not.getIdFuncionario());
            stmt.setInt(2, not.getIdGerente());
            stmt.setString(3, not.getTitulo());
            stmt.setString(4, not.getDescricao());
            stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Erro SQL: " + e);
            inserido = false;
        }finally{
            try{
                stmt.close();
                conn.close();
            }catch(Exception e){
                System.out.println("Erro: "+e.getMessage());
                inserido = false;
            }
        }
        return inserido;
    }
}

