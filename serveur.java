// Import des classes nécessaires
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Implémentation de l'interface calculette qui définit les méthodes de la calculatrice
public class serveur extends UnicastRemoteObject implements calculette {
    protected serveur() throws RemoteException {
        super();
    }

    // Implémentation des méthodes de l'interface calculette
    @Override
    public double add(double x, double y) throws RemoteException {
        return x + y;
    }

    @Override
    public double subtract(double x, double y) throws RemoteException {
        return x - y;
    }

    @Override
    public double multiply(double x, double y) throws RemoteException {
        return x * y;
    }

    @Override
    public double divide(double x, double y) throws RemoteException {
        if (y == 0) {
            throw new RemoteException("Cannot divide by zero");
        }
        return x / y;
    }

    // Méthode principale pour démarrer le serveur
    public static void main(String[] args) {
        try {
            // Création du registre RMI sur le port 1099
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            // Création de l'instance du serveur
            serveur server = new serveur();
            // Liaison de l'objet distant avec le nom "CalculatorService"
            java.rmi.Naming.rebind("CalculatorService", server);
            System.out.println("Server is running..."); // Affichage du message de démarrage du serveur
        } catch (Exception e) {
            // Gestion des exceptions lors du démarrage du serveur
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
