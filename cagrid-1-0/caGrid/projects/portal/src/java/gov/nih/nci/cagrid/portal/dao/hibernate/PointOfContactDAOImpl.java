package gov.nih.nci.cagrid.portal.dao.hibernate;

import gov.nih.nci.cagrid.portal.dao.PointOfContactDAO;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kherm
 * Date: Sep 29, 2006
 * Time: 12:42:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class PointOfContactDAOImpl extends BaseDAOImpl
        implements PointOfContactDAO {

    /**
     * Will return a unique list
     * of Points Of Contact, excluding NCICB Application Support
     * <p/>
     * Unique by a combination of {Email,Role}
     *
     * @return List PointOfContacts
     */
    public List getUniquePeople() throws DataAccessException {

        //return getHibernateTemplate().find("from PointOfContact poc group by poc.email order by poc.firstName");
        String hqlStr = "from PointOfContact poc where poc.affiliation != 'NCICB Application Support' group by poc.email order by poc.firstName";
        return getHibernateTemplate().find(hqlStr);

    }

    public List keywordSearch(String keyword) {

        StringBuffer sb = new StringBuffer("from PointOfContact poc where poc.affliation != 'NCICB Application Support' and ");
        sb.append("poc.affiliation like '%").append(keyword.trim()).append("%'");
        sb.append(" or poc.email like '%").append(keyword.trim()).append("%'");
        sb.append(" or poc.firstName like '%").append(keyword.trim()).append("%'");
        sb.append(" or poc.lastName like '%").append(keyword.trim()).append("%'");
        sb.append(" or poc.phoneNumber like '%").append(keyword.trim()).append("%'");
        sb.append(" or poc.role like '%").append(keyword.trim()).append("%'");
        sb.append(" group by poc.email");
        _logger.debug("Finding Point of Contacts for keyword" + keyword);

        try {
            return getHibernateTemplate().find(sb.toString());
        } catch (DataAccessException e) {
            _logger.error(e);
            throw e;
        }

    }

}
