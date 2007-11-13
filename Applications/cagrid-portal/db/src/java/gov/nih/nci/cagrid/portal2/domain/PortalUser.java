/**
 * 
 */
package gov.nih.nci.cagrid.portal2.domain;

import gov.nih.nci.cagrid.portal2.domain.dataservice.QueryInstance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author <a href="joshua.phillips@semanticbits.com">Joshua Phillips</a>
 * 
 */
@Entity
@Table(name = "portal_users")
@GenericGenerator(name = "id-generator", strategy = "native", parameters = { @Parameter(name = "sequence", value = "seq_portal_users") })
public class PortalUser extends AbstractDomainObject {

	private Person person;
	
	private String portalId;
	
	private String gridCredential;
	
	private String gridIdentity;
	
	private List<QueryInstance> queryInstances = new ArrayList<QueryInstance>();


	@ManyToOne
	@JoinColumn(name = "person_id")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Transient
	public String getGridCredential() {
		return gridCredential;
	}

	public void setGridCredential(String gridCredential) {
		this.gridCredential = gridCredential;
	}

	public String getPortalId() {
		return portalId;
	}

	public void setPortalId(String portalId) {
		this.portalId = portalId;
	}

	@OneToMany(mappedBy = "portalUser")
	@OrderBy("startTime")
	public List<QueryInstance> getQueryInstances() {
		return queryInstances;
	}

	public void setQueryInstances(List<QueryInstance> queryInstances) {
		this.queryInstances = queryInstances;
	}

	public String getGridIdentity() {
		return gridIdentity;
	}

	public void setGridIdentity(String gridIdentity) {
		this.gridIdentity = gridIdentity;
	}

}
