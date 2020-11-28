package main.java.Views;
/*
Last updated 10-28-2020.
This is an interface for getting data from from some source. Itended use is input fields in a JFrame.
Contributors-Michael
*/

import main.java.models.general.Property;

/**
 *
 * @author Callidus
 */
public interface IInputFieldCollector {

    public Property[] getFields();

}
