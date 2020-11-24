package ru.geekbrains.java3;

import java.util.Collection;

public interface Service<T> {
    T findById(int id);
    Collection<T> findAll();
    int save(T o);
}
