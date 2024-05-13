package service;

public interface IService<IService> {
    void add() throws InterruptedException;
    void edit() throws InterruptedException;
    void delete() throws InterruptedException;
    void show() throws InterruptedException;
    void findById() throws InterruptedException;
    void findByName() throws InterruptedException;
}
