package main.java.models.interfaces;

/**
 * Interface that defines general functionality of a Persistent Data Store Translator
 * @author Teegan Krieger
 */
public interface IDataStore {

    public <T> int create(T _obj);

    public <T> T[] load(Class<T> _klass);

    public <T> void update(T _obj, int _index, boolean save);

    public <T> void delete(int _index, Class<T> _klass);
}
