// Import des classes nécessaires
import java.rmi.Naming;
import java.util.Scanner;

// Classe du client RMI
public class client {
    public static void main(String[] args) {
        try {
            // Recherche de l'objet distant en utilisant le nom "CalculatorService"
            calculette calculator = (calculette) Naming.lookup("rmi://localhost/CalculatorService");
            Scanner scanner = new Scanner(System.in); // Scanner pour les entrées utilisateur

            // Boucle pour les opérations du client
            while (true) {
                // Affichage du menu des opérations
                System.out.println("Choose operation:");
                System.out.println("1. Add");
                System.out.println("2. Subtract");
                System.out.println("3. Multiply");
                System.out.println("4. Divide");
                System.out.println("5. Quit");

                int choice = scanner.nextInt(); // Choix de l'opération par l'utilisateur

                // Condition pour quitter le programme
                if (choice == 5) {
                    System.out.println("Goodbye!");
                    break;
                }

                System.out.print("Enter first number: ");
                double x = scanner.nextDouble(); // Saisie du premier nombre
                System.out.print("Enter second number: ");
                double y = scanner.nextDouble(); // Saisie du deuxième nombre

                double result = 0; // Initialisation du résultat

                // Sélection de l'opération en fonction du choix de l'utilisateur
                switch (choice) {
                    case 1:
                        result = calculator.add(x, y);
                        break;
                    case 2:
                        result = calculator.subtract(x, y);
                        break;
                    case 3:
                        result = calculator.multiply(x, y);
                        break;
                    case 4:
                        result = calculator.divide(x, y);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        continue;
                }

                System.out.println("Result: " + result); // Affichage du résultat de l'opération
            }

        } catch (Exception e) {
            // Gestion des exceptions lors de l'exécution du client
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
