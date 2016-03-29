
package mundo;

import consultas.Cliente;
import org.hibernate.*;
import util.HibernateUtil;


/**
 *
 * @author Cristian Guerrero
 */
public class InmobiliariaDAO {
    //clase DAO
    private Session session;
    private Transaction tx;
    
    private void iniciarOperacion()throws HibernateException{
        session = HibernateUtil.getSessionFactory().openSession();
        tx= session.beginTransaction();
    }
    private void manejaException(HibernateException he){
        tx.rollback();
        throw new HibernateException("Error en la capa de accesos a datos", he);
    }
    public String guardarCliente(Cliente cliente){
        String cedula = "";
        try{
            iniciarOperacion();
            cedula= (String) session.save(cliente);
            tx.commit();
        }catch(HibernateException he){
            manejaException(he);
            throw he;
        }
        finally{
            session.close();
        }
        return cedula;
    }
    public void actualizarCliente(Cliente cliente) throws HibernateException{
        
        try{
            iniciarOperacion();
            session.update(cliente);
            tx.commit();
        }catch(HibernateException he){
            manejaException(he);
            throw he;
        }
        finally{
            session.close();
        }
    }
    public void eliminarContacto(Cliente cliente){
        try{
            iniciarOperacion();
            session.delete(cliente);
            tx.commit();
        }catch(HibernateException he){
            manejaException(he);
            throw he;
        }
        finally{
            session.close();
        }
    }
    
    public Cliente obtenerCliente(String cedula){
        Cliente cliente= null;
        try{
            iniciarOperacion();
            cliente= (Cliente )session.get(Cliente.class, cedula);
        }
        finally{
            session.close();
        }
        return cliente;
    }
}
