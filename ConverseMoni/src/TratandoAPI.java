import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.lang.Double.parseDouble;

public class TratandoAPI {
    public TratandoAPI(String moeda, double valor) throws IOException, InterruptedException {
        try {
            String site = "https://v6.exchangerate-api.com/v6/a2762dd0e117f32ad5073205/latest/" + moeda;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(site))
                    .build();
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Moedas valores = new Gson().fromJson(response.body(), Moedas.class);

            Conversao teste = new Conversao();

            System.out.println("Valor em Dólar Americano = " +String.format("%.2f", teste.calcula(parseDouble(valores.conversion_rates().USD()), valor)));
            System.out.println("Valor em Euro = " +String.format("%.2f", teste.calcula(parseDouble(valores.conversion_rates().EUR()), valor)));
            System.out.println("Valor em Libra esterlina = " +String.format("%.2f", teste.calcula(parseDouble(valores.conversion_rates().GBP()), valor)));
            System.out.println("Valor em Iene = " +String.format("%.2f", teste.calcula(parseDouble(valores.conversion_rates().JPY()), valor)));
            System.out.println("Valor em Dólar Australiano = " +String.format("%.2f", teste.calcula(parseDouble(valores.conversion_rates().AUD()), valor)));
            System.out.println("Valor em Franco Suíço = " +String.format("%.2f", teste.calcula(parseDouble(valores.conversion_rates().CHF()), valor)));
            System.out.println("Valor em Dólar Canadense = " +String.format("%.2f", teste.calcula(parseDouble(valores.conversion_rates().CAD()), valor)));
            System.out.println("Valor em Real = " +String.format("%.2f", teste.calcula(parseDouble(valores.conversion_rates().BRL()), valor)));
        }catch (Exception e){
            System.out.println("Deu algum erro com API, tente mais tarde");
            System.out.println("Conferir o site https://www.ifcmarkets.com.br/about-forex/currencies-and-abbreviations");
        }
    }
//            return new Gson().fromJson(response.body(), Endereco.class);

}
