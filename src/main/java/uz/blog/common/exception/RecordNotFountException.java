package uz.blog.common.exception;

public class RecordNotFountException extends RuntimeException{
    public RecordNotFountException(String name){
        super(name);
    }
}
