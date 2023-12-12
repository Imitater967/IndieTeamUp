package tech.spiritualdarkness.itu.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Result<T> implements Serializable {
    ResultStatus resultStatus;
    T data;

}
