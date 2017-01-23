package model.dao;

/**
 * Created by Sergiy on 12/4/16.
 */

//Create generic DAO interface which has methods:
//        create(T t), T get(int id), update(T t),
//        delete(int id) under the dao directory


public interface Dao<T> {

    void create (T t);
    T get (int id);
    void update (T t);
    void delete (int id);

}
