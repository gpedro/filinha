package br.com.kroton.alunoonline.integracao;

import java.io.IOException;

import com.google.gson.Gson;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class KrotonLogin {

    public static KrotonUsuario autentica(String usuario, String senha) {
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormEncodingBuilder()
                .add("waclogin", usuario).add("wacsenha", senha).build();
        Request request = new Request.Builder()
                .url("http://alunoonline.kroton.com.br/portais/portalaluno/login/action/valida.php")
                .post(formBody).build();

        Response response;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String body = response.body().string();
                body = body.substring(body.indexOf("{"),
                        body.lastIndexOf("}") + 1);
                body = body.replaceAll("'", "\"");

                Gson gson = new Gson();
                return gson.fromJson(body, KrotonUsuario.class);
            } else {
                throw new IOException("Unexpected code " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
