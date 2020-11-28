package main.java.models.interfaces;

/**
 *
 * @author Teegan Krieger
 */
public interface IFileSystem {

    public <T> int create(T _obj);

    public <T> T[] load();

    public <T> void update(T _obj, int _index);

    public void delete(int _index);
}
