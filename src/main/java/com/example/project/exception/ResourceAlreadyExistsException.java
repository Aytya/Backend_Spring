package com.example.project.exception;

public class ResourceAlreadyExistsException extends Exception {
    public ResourceAlreadyExistsException(Integer resource) {
        super(resource + " already exists!");
    }
}
