/**
 * 
 */
package gov.nih.nci.cagrid.portal.domain.metadata.service;

import gov.nih.nci.cagrid.portal.domain.AbstractDomainObject;
import gov.nih.nci.cagrid.portal.domain.metadata.dataservice.XMLSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author <a href="joshua.phillips@semanticbits.com">Joshua Phillips</a>
 *
 */
@Entity
@Table(name = "ctx_prop")
@GenericGenerator(name="id-generator", strategy = "native",
    parameters = {
        @Parameter(name="sequence", value="seq_ctx_prop")
    }
)
public class ContextProperty extends AbstractDomainObject {
	
	private XMLSchema xmlSchema;
	private String name;
	private String description;
	private ServiceContext serviceContext;

	@ManyToOne
	public ServiceContext getServiceContext() {
		return serviceContext;
	}
	public void setServiceContext(ServiceContext serviceContext) {
		this.serviceContext = serviceContext;
	}
	
	@Column(length = 4000)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne
	@JoinColumn(name = "schema_id")
	public XMLSchema getXmlSchema() {
		return xmlSchema;
	}
	public void setXmlSchema(XMLSchema xmlSchema) {
		this.xmlSchema = xmlSchema;
	}
}
