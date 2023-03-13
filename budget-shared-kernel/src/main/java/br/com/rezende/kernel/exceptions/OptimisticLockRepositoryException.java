package br.com.rezende.kernel.exceptions;

public class OptimisticLockRepositoryException extends RuntimeException {

    public OptimisticLockRepositoryException(String message) {
        super(message);
    }

}
