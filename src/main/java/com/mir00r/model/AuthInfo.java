package com.mir00r.model;

/**
 * Created by Mir00r on 8/30/2017.
 */

public class AuthInfo {
    private String userType;
    private long roleId;
    private String roleName;
    private long userId;

    /**
     * @param userType
     * @param roleId
     * @param roleName
     * @param userId
     */
    public AuthInfo(String userType, long roleId, String roleName, long userId) {
        this.userType = userType;
        this.roleId = roleId;
        this.roleName = roleName;
        this.userId = userId;
    }

    /**
     * @return
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * @return
     */
    public long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    /**
     * @return
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * @return
     */
    public long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }
}
