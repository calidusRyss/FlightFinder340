package main.java.models.interfaces;

/**
 *
 * @author Teegan Krieger
 */
public interface IFileSystem {

    public <T> int create(T _obj);

    public <T> T[] load(Class<T> _klass);

    public <T> void update(T _obj, int _index);

    public <T> void delete(int _index, Class<T> _klass);
}
