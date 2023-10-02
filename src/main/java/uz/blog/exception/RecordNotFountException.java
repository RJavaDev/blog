package uz.blog.exception;

public class RecordNotFountException extends RuntimeException{
    public RecordNotFountException(String name){
        super(name);
    }
}
