package gov.nih.nci.cagrid.gridgrouper.common;

import java.rmi.RemoteException;

/**
 * GridGrouper Service
 *
 * This class is autogenerated, DO NOT EDIT.
 * 
 * @created by Introduce Toolkit version 1.0
 */
public interface GridGrouperI {

    public gov.nih.nci.cagrid.metadata.security.ServiceSecurityMetadata getServiceSecurityMetadata() throws RemoteException ;

  /**
   * Obtains a specified stem.
   *
   * @param stem
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws StemNotFoundFault
   *	The stem specified could not be found.
   */
  public gov.nih.nci.cagrid.gridgrouper.bean.StemDescriptor getStem(gov.nih.nci.cagrid.gridgrouper.bean.StemIdentifier stem) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.StemNotFoundFault ;

  /**
   * Obtains a list of child stems for a specified parent stem.
   *
   * @param parentStem
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws StemNotFoundFault
   *	The stem specified could not be found.
   */
  public gov.nih.nci.cagrid.gridgrouper.bean.StemDescriptor[] getChildStems(gov.nih.nci.cagrid.gridgrouper.bean.StemIdentifier parentStem) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.StemNotFoundFault ;

  /**
   * Obtains the parent stem for a specified stem.
   *
   * @param childStem
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws StemNotFoundFault
   *	The stem specified could not be found.
   */
  public gov.nih.nci.cagrid.gridgrouper.bean.StemDescriptor getParentStem(gov.nih.nci.cagrid.gridgrouper.bean.StemIdentifier childStem) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.StemNotFoundFault ;

  /**
   * Updates the information for a specified stem.
   *
   * @param stem
   * @param update
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws InsufficientPrivilegeFault
   *	The client does not have the required privileges needed to perform the request.
   * @throws StemModifyFault
   *	An error occurred updating the specified stem.
   */
  public gov.nih.nci.cagrid.gridgrouper.bean.StemDescriptor updateStem(gov.nih.nci.cagrid.gridgrouper.bean.StemIdentifier stem,gov.nih.nci.cagrid.gridgrouper.bean.StemUpdate update) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.InsufficientPrivilegeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.StemModifyFault ;

  /**
   * Obtains a list of subjects with a specified privilege on a specified stem.
   *
   * @param stem
   * @param privilege
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws StemNotFoundFault
   *	The stem specified could not be found.
   */
  public java.lang.String[] getSubjectsWithStemPrivilege(gov.nih.nci.cagrid.gridgrouper.bean.StemIdentifier stem,gov.nih.nci.cagrid.gridgrouper.bean.StemPrivilegeType privilege) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.StemNotFoundFault ;

  /**
   * Obtains a list of privileges for a specified subject on a specified stem.
   *
   * @param stem
   * @param subject
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws StemNotFoundFault
   *	The stem specified could not be found.
   */
  public gov.nih.nci.cagrid.gridgrouper.bean.StemPrivilege[] getStemPrivileges(gov.nih.nci.cagrid.gridgrouper.bean.StemIdentifier stem,java.lang.String subject) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.StemNotFoundFault ;

  /**
   * Returns whether or not a specified subject has a specified privilege on a specified stem.
   *
   * @param stem
   * @param subject
   * @param privilege
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws StemNotFoundFault
   *	The stem specified could not be found.
   */
  public boolean hasStemPrivilege(gov.nih.nci.cagrid.gridgrouper.bean.StemIdentifier stem,java.lang.String subject,gov.nih.nci.cagrid.gridgrouper.bean.StemPrivilegeType privilege) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.StemNotFoundFault ;

  /**
   * Grants a specified privilege to a specified subject on a specified stem.
   *
   * @param stem
   * @param subject
   * @param privilege
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws StemNotFoundFault
   *	The stem specified could not be found.
   * @throws GrantPrivilegeFault
   *	An error occurred in granting the privilege.
   * @throws InsufficientPrivilegeFault
   *	The client does not have the required privileges needed to perform the request.
   * @throws SchemaFault
   *	An unexpected schema error occurred in performing the request.
   */
  public void grantStemPrivilege(gov.nih.nci.cagrid.gridgrouper.bean.StemIdentifier stem,java.lang.String subject,gov.nih.nci.cagrid.gridgrouper.bean.StemPrivilegeType privilege) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.StemNotFoundFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GrantPrivilegeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.InsufficientPrivilegeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.SchemaFault ;

  /**
   * Revokes a specified privilege for specified subject on a specified stem.
   *
   * @param stem
   * @param subject
   * @param privilege
   * @throws StemNotFoundFault
   *	The stem specified could not be found.
   * @throws InsufficientPrivilegeFault
   *	The client does not have the required privileges needed to perform the request.
   * @throws RevokePrivilegeFault
   *	An error occurred in revoking the privilege.
   * @throws SchemaFault
   *	An unexpected schema error occurred in performing the request.
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   */
  public void revokeStemPrivilege(gov.nih.nci.cagrid.gridgrouper.bean.StemIdentifier stem,java.lang.String subject,gov.nih.nci.cagrid.gridgrouper.bean.StemPrivilegeType privilege) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.StemNotFoundFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.InsufficientPrivilegeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.RevokePrivilegeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.SchemaFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault ;

  /**
   * Adds a child stem to a specified stem.
   *
   * @param stem
   * @param extension
   * @param displayExtension
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws InsufficientPrivilegeFault
   *	The client does not have the required privileges needed to perform the request.
   * @throws StemAddFault
   *	An error occurred in adding the specified stem.
   * @throws StemNotFoundFault
   *	The stem specified could not be found.
   */
  public gov.nih.nci.cagrid.gridgrouper.bean.StemDescriptor addChildStem(gov.nih.nci.cagrid.gridgrouper.bean.StemIdentifier stem,java.lang.String extension,java.lang.String displayExtension) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.InsufficientPrivilegeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.StemAddFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.StemNotFoundFault ;

  /**
   * Deletes a specified stem.
   *
   * @param stem
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws InsufficientPrivilegeFault
   *	The client does not have the required privileges needed to perform the request.
   * @throws StemDeleteFault
   *	An error occurred in deleting the specified stem.
   * @throws StemNotFoundFault
   *	The stem specified could not be found.
   */
  public void deleteStem(gov.nih.nci.cagrid.gridgrouper.bean.StemIdentifier stem) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.InsufficientPrivilegeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.StemDeleteFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.StemNotFoundFault ;

  /**
   * Gets a specified group.
   *
   * @param group
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws GroupNotFoundFault
   *	The specified group cannot be found.
   */
  public gov.nih.nci.cagrid.gridgrouper.bean.GroupDescriptor getGroup(gov.nih.nci.cagrid.gridgrouper.bean.GroupIdentifier group) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GroupNotFoundFault ;

  /**
   * Gets the child groups for a specified stem.
   *
   * @param stem
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws StemNotFoundFault
   *	The stem specified could not be found.
   */
  public gov.nih.nci.cagrid.gridgrouper.bean.GroupDescriptor[] getChildGroups(gov.nih.nci.cagrid.gridgrouper.bean.StemIdentifier stem) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.StemNotFoundFault ;

  /**
   * Add a child group to a specified stem.
   *
   * @param stem
   * @param extension
   * @param displayExtension
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws GroupAddFault
   *	The specified group cannot be found.
   * @throws InsufficientPrivilegeFault
   *	The client does not have the required privileges needed to perform the request.
   */
  public gov.nih.nci.cagrid.gridgrouper.bean.GroupDescriptor addChildGroup(gov.nih.nci.cagrid.gridgrouper.bean.StemIdentifier stem,java.lang.String extension,java.lang.String displayExtension) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GroupAddFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.InsufficientPrivilegeFault ;

  /**
   * Delete a specified group.
   *
   * @param group
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws GroupNotFoundFault
   *	The specified group cannot be found.
   * @throws GroupDeleteFault
   *	An error occurred in deleting the specified group.
   * @throws InsufficientPrivilegeFault
   *	The client does not have the required privileges needed to perform the request.
   */
  public void deleteGroup(gov.nih.nci.cagrid.gridgrouper.bean.GroupIdentifier group) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GroupNotFoundFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GroupDeleteFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.InsufficientPrivilegeFault ;

  /**
   * Update the information for a specified group.
   *
   * @param group
   * @param update
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws GroupNotFoundFault
   *	The specified group cannot be found.
   * @throws GroupModifyFault
   *	An error occurred in modifying the specified group.
   * @throws InsufficientPrivilegeFault
   *	The client does not have the required privileges needed to perform the request.
   */
  public gov.nih.nci.cagrid.gridgrouper.bean.GroupDescriptor updateGroup(gov.nih.nci.cagrid.gridgrouper.bean.GroupIdentifier group,gov.nih.nci.cagrid.gridgrouper.bean.GroupUpdate update) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GroupNotFoundFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GroupModifyFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.InsufficientPrivilegeFault ;

  /**
   * Add a member to a specified group.
   *
   * @param group
   * @param subject
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws GroupNotFoundFault
   *	The specified group cannot be found.
   * @throws InsufficientPrivilegeFault
   *	The client does not have the required privileges needed to perform the request.
   * @throws MemberAddFault
   *	An error occurred adding a member to the specified group.
   */
  public void addMember(gov.nih.nci.cagrid.gridgrouper.bean.GroupIdentifier group,java.lang.String subject) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GroupNotFoundFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.InsufficientPrivilegeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.MemberAddFault ;

  /**
   * Gets the members of a specified group based on a specified member type (All, Immediate, Effective, or Composite)
   *
   * @param group
   * @param filter
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws GroupNotFoundFault
   *	The specified group cannot be found.
   */
  public gov.nih.nci.cagrid.gridgrouper.bean.MemberDescriptor[] getMembers(gov.nih.nci.cagrid.gridgrouper.bean.GroupIdentifier group,gov.nih.nci.cagrid.gridgrouper.bean.MemberFilter filter) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GroupNotFoundFault ;

  /**
   * Determines whether a specified subject is a member of a specified type (All, Immediate, Effective, or Composite) or a specified group.
   *
   * @param group
   * @param member
   * @param filter
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws GroupNotFoundFault
   *	The specified group cannot be found.
   */
  public boolean isMemberOf(gov.nih.nci.cagrid.gridgrouper.bean.GroupIdentifier group,java.lang.String member,gov.nih.nci.cagrid.gridgrouper.bean.MemberFilter filter) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GroupNotFoundFault ;

  /**
   * Gets the memberhships of a specified group based on a specified member type (All, Immediate, Effective, or Composite)
   *
   * @param group
   * @param filter
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws GroupNotFoundFault
   *	The specified group cannot be found.
   */
  public gov.nih.nci.cagrid.gridgrouper.bean.MembershipDescriptor[] getMemberships(gov.nih.nci.cagrid.gridgrouper.bean.GroupIdentifier group,gov.nih.nci.cagrid.gridgrouper.bean.MemberFilter filter) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GroupNotFoundFault ;

  /**
   * Deletes a member of a specified group
   *
   * @param group
   * @param member
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws InsufficientPrivilegeFault
   *	The client does not have the required privileges needed to perform the request.
   * @throws GroupNotFoundFault
   *	The specified group cannot be found.
   * @throws MemberDeleteFault
   *	An error occurred in deleting a member from a specified group. 
   */
  public void deleteMember(gov.nih.nci.cagrid.gridgrouper.bean.GroupIdentifier group,java.lang.String member) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.InsufficientPrivilegeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GroupNotFoundFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.MemberDeleteFault ;

  /**
   * Adds a composite member to a specified group
   *
   * @param type
   * @param composite
   * @param left
   * @param right
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws GroupNotFoundFault
   *	The specified group cannot be found.
   * @throws MemberAddFault
   *	An error occurred in adding a composite member to a specified group.
   * @throws InsufficientPrivilegeFault
   *	The client does not have the required privileges needed to perform the request.
   */
  public gov.nih.nci.cagrid.gridgrouper.bean.GroupDescriptor addCompositeMember(gov.nih.nci.cagrid.gridgrouper.bean.GroupCompositeType type,gov.nih.nci.cagrid.gridgrouper.bean.GroupIdentifier composite,gov.nih.nci.cagrid.gridgrouper.bean.GroupIdentifier left,gov.nih.nci.cagrid.gridgrouper.bean.GroupIdentifier right) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GroupNotFoundFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.MemberAddFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.InsufficientPrivilegeFault ;

  /**
   * Deletes a composite member from a specified group.
   *
   * @param group
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws GroupNotFoundFault
   *	The specified group cannot be found.
   * @throws InsufficientPrivilegeFault
   *	The client does not have the required privileges needed to perform the request.
   * @throws MemberDeleteFault
   *	An error occurred in deleting a composite member from a specified group.
   */
  public gov.nih.nci.cagrid.gridgrouper.bean.GroupDescriptor deleteCompositeMember(gov.nih.nci.cagrid.gridgrouper.bean.GroupIdentifier group) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GroupNotFoundFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.InsufficientPrivilegeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.MemberDeleteFault ;

  /**
   * Grant a specified privilege for a specified subject on a specified group.
   *
   * @param group
   * @param subject
   * @param privilege
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws GroupNotFoundFault
   *	The specified group cannot be found.
   * @throws GrantPrivilegeFault
   *	An error occurred in granting the privilege.
   * @throws InsufficientPrivilegeFault
   *	The client does not have the required privileges needed to perform the request.
   */
  public void grantGroupPrivilege(gov.nih.nci.cagrid.gridgrouper.bean.GroupIdentifier group,java.lang.String subject,gov.nih.nci.cagrid.gridgrouper.bean.GroupPrivilegeType privilege) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GroupNotFoundFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GrantPrivilegeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.InsufficientPrivilegeFault ;

  /**
   * Revoke a specified privilege for a specified subject on a specified group.
   *
   * @param group
   * @param subject
   * @param privilege
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws GroupNotFoundFault
   *	The specified group cannot be found.
   * @throws RevokePrivilegeFault
   *	An error occurred in revoking the privilege.
   * @throws InsufficientPrivilegeFault
   *	The client does not have the required privileges needed to perform the request.
   * @throws SchemaFault
   *	An unexpected schema error occurred in performing the request.
   */
  public void revokeGroupPrivilege(gov.nih.nci.cagrid.gridgrouper.bean.GroupIdentifier group,java.lang.String subject,gov.nih.nci.cagrid.gridgrouper.bean.GroupPrivilegeType privilege) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GroupNotFoundFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.RevokePrivilegeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.InsufficientPrivilegeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.SchemaFault ;

  /**
   * Gets a list of subject with a specified privilege on a specified group.
   *
   * @param group
   * @param privilege
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws GroupNotFoundFault
   *	The specified group cannot be found.
   */
  public java.lang.String[] getSubjectsWithGroupPrivilege(gov.nih.nci.cagrid.gridgrouper.bean.GroupIdentifier group,gov.nih.nci.cagrid.gridgrouper.bean.GroupPrivilegeType privilege) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GroupNotFoundFault ;

  /**
   * Gets a list of privileges for a specified subject on a specified group.
   *
   * @param group
   * @param subject
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws GroupNotFoundFault
   *	The specified group cannot be found.
   */
  public gov.nih.nci.cagrid.gridgrouper.bean.GroupPrivilege[] getGroupPrivileges(gov.nih.nci.cagrid.gridgrouper.bean.GroupIdentifier group,java.lang.String subject) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GroupNotFoundFault ;

  /**
   * Returns whether or not a specified subject has a specified privilege on a specified group.
   *
   * @param group
   * @param subject
   * @param privilege
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   * @throws GroupNotFoundFault
   *	The specified group cannot be found.
   */
  public boolean hasGroupPrivilege(gov.nih.nci.cagrid.gridgrouper.bean.GroupIdentifier group,java.lang.String subject,gov.nih.nci.cagrid.gridgrouper.bean.GroupPrivilegeType privilege) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.GroupNotFoundFault ;

  /**
   * Returns whether or not a specified subject is a member of a specified group.
   *
   * @param member
   * @param expression
   * @throws GridGrouperRuntimeFault
   *	An unexpected Grouper/Grid Grouper error occurred.
   */
  public boolean isMember(java.lang.String member,gov.nih.nci.cagrid.gridgrouper.bean.MembershipExpression expression) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault ;

  /**
   * Get information about a member.
   *
   * @param member
   * @throws GridGrouperRuntimeFault
   *	
   * @throws InsufficientPrivilegeFault
   *	
   */
  public gov.nih.nci.cagrid.gridgrouper.bean.MemberDescriptor getMember(java.lang.String member) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.InsufficientPrivilegeFault ;

  public gov.nih.nci.cagrid.gridgrouper.bean.GroupDescriptor[] getMembersGroups(java.lang.String member,gov.nih.nci.cagrid.gridgrouper.bean.MembershipType type) throws RemoteException, gov.nih.nci.cagrid.gridgrouper.stubs.types.GridGrouperRuntimeFault, gov.nih.nci.cagrid.gridgrouper.stubs.types.InsufficientPrivilegeFault ;

}
