package com.backend.dao;

import java.util.List;

public interface Idao<T> {
    T registrarOdonlotolos(T t);
    List<T> listarOdontologos();
}
