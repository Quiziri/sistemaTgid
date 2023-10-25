package br.com.sistemaTgid.callback;

import java.util.function.Consumer;

public class ClienteCallback {
    private Consumer<String> callback;

    public void registrarCallback(Consumer<String> callback) {
        this.callback = callback;
    }

    public void realizarAcao(String mensagem) {
        if (callback != null) {
            callback.accept(mensagem);
        }
    }
}