package com.tweb.icekeeper.Exception;

public class GlacierNotFoundException  extends  RuntimeException {
    public GlacierNotFoundException(Long id) {
        super("Glacier non trovato con ID: " + id);
    }
}