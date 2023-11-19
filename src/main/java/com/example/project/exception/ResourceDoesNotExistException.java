package com.example.project.exception;

public class ResourceDoesNotExistException extends Exception {
    public ResourceDoesNotExistException(Integer resource) {
        super(resource + " does not exist!");
    }
}