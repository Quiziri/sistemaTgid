package br.com.sistemaTgid.callback;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class EmpresaCallback {
     public void callback(String mensagem, double valor, double taxa) {
         String webhookUrl = "https://webhook.site/0f35158b-8e9a-4518-952c-d2eab6369833";
        HttpURLConnection connection = null;
        try {
            URL url = new URL(webhookUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            String payload = "Mensagem: " + mensagem;

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = payload.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Callback realizado com sucesso.");
            } else {
                System.err.println("Erro ao realizar o callback. Código de resposta: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao realizar o callback: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}