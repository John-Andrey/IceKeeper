package com.tweb.icekeeper.Exception;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(Long id) {
        super("Progetto non trovato con ID: " + id);
    }
}
