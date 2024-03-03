// Définition de l'interface pour la calculatrice RMI
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface calculette extends Remote {
    // Déclaration des méthodes qui seront disponibles pour les clients distants

    // Méthode pour l'addition de deux nombres
    double add(double x, double y) throws RemoteException;

    // Méthode pour la soustraction de deux nombres
    double subtract(double x, double y) throws RemoteException;

    // Méthode pour la multiplication de deux nombres
    double multiply(double x, double y) throws RemoteException;

    // Méthode pour la division de deux nombres
    double divide(double x, double y) throws RemoteException;
}
