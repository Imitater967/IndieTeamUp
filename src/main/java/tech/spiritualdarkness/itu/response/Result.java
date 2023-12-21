package tech.spiritualdarkness.itu.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result<T,U extends IStatus> implements Serializable {
    U status;
    T data;

}
