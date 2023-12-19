package tech.spiritualdarkness.itu.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Result<T,U extends Status> implements Serializable {
    U status;
    T data;

}
