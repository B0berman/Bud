package DAO;

public interface DAO<R, W> {
    W write(R bean);
    R read(W bean);
}
