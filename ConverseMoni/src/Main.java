import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        double valor;
        try {
            Scanner leitura = new Scanner(System.in);
            System.out.println("Qual moeda voce tem?");
            String minhaMoeda = leitura.nextLine();
            while (minhaMoeda.length() != 3 || !(minhaMoeda.matches("^((?=.*[a-z]).*)$")||minhaMoeda.matches("^((?=.*[A-Z]).*)$"))) {
                System.out.println("""                    
                        Favor inserir uma sigla de 3 letras 
                        Conferir o site https://www.ifcmarkets.com.br/about-forex/currencies-and-abbreviations"
                        """);
                System.out.println("Qual moeda voce tem?");
                minhaMoeda = leitura.nextLine();
            }
            System.out.println("Qual valor deseja converter?");
            valor = leitura.nextDouble();
            TratandoAPI converte = new TratandoAPI(minhaMoeda, valor);

        } catch (InputMismatchException e) {
            System.out.println("Favor inserir valor numerico na area de valor");
        }
    }
}
