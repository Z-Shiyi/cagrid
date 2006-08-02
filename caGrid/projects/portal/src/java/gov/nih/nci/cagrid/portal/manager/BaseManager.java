package gov.nih.nci.cagrid.portal.manager;

import gov.nih.nci.cagrid.portal.exception.RecordNotFoundException;

import java.util.Collection;
import java.util.List;


/**
 * BaseManager Interface that all Managers
 * will implement
 * <p/>
 * Created by IntelliJ IDEA.
 * User: kherm
 * Date: Jun 29, 2006
 * Time: 6:13:24 PM
 * To change this template use File | Settings | File Templates.
 */
public interface BaseManager {
    /**
     * Returns All the persistent
     * object for given class
     *
     * @return List
     */
    public List loadAll(Class cls);

    public void saveAll(Collection objects);

    public void save(Object obj);
}
