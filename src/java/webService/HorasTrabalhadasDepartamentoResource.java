package webService;

import DAO.AtividadesConsolidadasDAO;
import DAO.RelatorioDepartamentoDAO;
import java.sql.Date;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.AtividadesConsolidadas;
import model.Grafico;
import model.HorasTrabalhadasDepartamento;
import model.HorasTrabalhadasFuncionario;


@Path("horasTrabalhadasDepartamento")
public class HorasTrabalhadasDepartamentoResource {

    @Context
    private UriInfo context;
    
    public HorasTrabalhadasDepartamentoResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/{id}")
    public Response getAtividadePorFunc(@PathParam("id") int id){
        AtividadesConsolidadasDAO aDAO = new AtividadesConsolidadasDAO();
        Grafico g = aDAO.buscarStatusAtividadesFuncionario(id);
        return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(g).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/{mes}/{ano}")
    public Response getHorasTrabalhadas(@PathParam("mes") int mes, @PathParam("ano") int ano) {
        RelatorioDepartamentoDAO aDAO = new RelatorioDepartamentoDAO();
        List<HorasTrabalhadasDepartamento> lista = aDAO.buscarAtividades(mes, ano);
        GenericEntity<List<HorasTrabalhadasDepartamento>> atividades = new GenericEntity<List<HorasTrabalhadasDepartamento>>(lista){};
        return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(atividades).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/horasTrabalhadasFuncionario/{mes}/{ano}")
    public Response getHorasTrabalhadasFuncionario(@PathParam("mes") int mes, @PathParam("ano") int ano) {
        RelatorioDepartamentoDAO aDAO = new RelatorioDepartamentoDAO();
        List<HorasTrabalhadasFuncionario> lista = aDAO.buscarHorasFuncionario(mes, ano);
        GenericEntity<List<HorasTrabalhadasFuncionario>> atividades = new GenericEntity<List<HorasTrabalhadasFuncionario>>(lista){};
        return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(atividades).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/{dataInicio}/{dataFim}/{idFunc}")
    public Response getAtividadesConsolidadas(@PathParam("dataInicio") Date dataInicio, @PathParam("dataFim") Date dataFim, @PathParam("idFunc") int idFunc){
        AtividadesConsolidadasDAO acDAO = new AtividadesConsolidadasDAO();
        List<AtividadesConsolidadas> lista = acDAO.buscaAtividadesConsolidadas(dataInicio, dataFim, idFunc);
        GenericEntity<List<AtividadesConsolidadas>> atividades = new GenericEntity<List<AtividadesConsolidadas>>(lista){};
        return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(atividades).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of HorasTrabalhadasResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
