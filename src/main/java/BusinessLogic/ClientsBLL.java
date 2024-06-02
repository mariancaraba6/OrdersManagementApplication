package BusinessLogic;

import DataAccess.ClientsDAO;
import Model.Clients;


import java.util.List;

/**
 * Class for the business logic of the Clients class.
 * It is used to call the methods that were implemented in the AbstractDAO class that were extended in the ClientsDAO class
 * @author maria
 * @since June 2024
 */
public class ClientsBLL {
    public static List<Clients> findAllClients() {
        ClientsDAO clientsDAO = new ClientsDAO();
        return clientsDAO.findAll();
    }

    public static Clients findClientById(int id) {
        ClientsDAO clientsDAO = new ClientsDAO();
        return clientsDAO.findById(id, "clientId");
    }

    public static void insertClient(Clients client) {
        ClientsDAO clientsDAO = new ClientsDAO();
        clientsDAO.insert(client);
    }

    public static void editClient (Clients client) {
        ClientsDAO clientsDAO = new ClientsDAO();
        clientsDAO.update(client, "clientId");
    }

    public static void deleteClient(int idToBeDeleted) {
        ClientsDAO clientsDAO = new ClientsDAO();
        clientsDAO.delete(idToBeDeleted, "clientId");
    }
}
