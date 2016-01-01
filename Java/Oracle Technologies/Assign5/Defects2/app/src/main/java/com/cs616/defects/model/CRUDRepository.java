package com.cs616.defects.model;

import java.io.IOException;
import java.util.List;

/**
 * Created by ian on 15-10-24.
 */
public interface CRUDRepository<R, T> {
    boolean create(T element) throws IOException;
    T read(R id) throws IOException;
    List<T> readAll() throws IOException;
    boolean update(T element) throws IOException;
    boolean delete(T element) throws IOException;
}
