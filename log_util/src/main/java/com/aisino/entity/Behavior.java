package com.aisino.entity;

import java.io.Serializable;
import java.util.Date;

public class Behavior implements Serializable {
    private Long id;

    private String taxcode;

    private Integer machineno;

    private String module;

    private String moduletype;

    private String modulefather;

    private Date time;

    private String action;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaxcode() {
        return taxcode;
    }

    public void setTaxcode(String taxcode) {
        this.taxcode = taxcode == null ? null : taxcode.trim();
    }

    public Integer getMachineno() {
        return machineno;
    }

    public void setMachineno(Integer machineno) {
        this.machineno = machineno;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    public String getModuletype() {
        return moduletype;
    }

    public void setModuletype(String moduletype) {
        this.moduletype = moduletype == null ? null : moduletype.trim();
    }

    public String getModulefather() {
        return modulefather;
    }

    public void setModulefather(String modulefather) {
        this.modulefather = modulefather == null ? null : modulefather.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", taxcode=").append(taxcode);
        sb.append(", machineno=").append(machineno);
        sb.append(", module=").append(module);
        sb.append(", moduletype=").append(moduletype);
        sb.append(", modulefather=").append(modulefather);
        sb.append(", time=").append(time);
        sb.append(", action=").append(action);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Behavior other = (Behavior) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTaxcode() == null ? other.getTaxcode() == null : this.getTaxcode().equals(other.getTaxcode()))
            && (this.getMachineno() == null ? other.getMachineno() == null : this.getMachineno().equals(other.getMachineno()))
            && (this.getModule() == null ? other.getModule() == null : this.getModule().equals(other.getModule()))
            && (this.getModuletype() == null ? other.getModuletype() == null : this.getModuletype().equals(other.getModuletype()))
            && (this.getModulefather() == null ? other.getModulefather() == null : this.getModulefather().equals(other.getModulefather()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getAction() == null ? other.getAction() == null : this.getAction().equals(other.getAction()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTaxcode() == null) ? 0 : getTaxcode().hashCode());
        result = prime * result + ((getMachineno() == null) ? 0 : getMachineno().hashCode());
        result = prime * result + ((getModule() == null) ? 0 : getModule().hashCode());
        result = prime * result + ((getModuletype() == null) ? 0 : getModuletype().hashCode());
        result = prime * result + ((getModulefather() == null) ? 0 : getModulefather().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getAction() == null) ? 0 : getAction().hashCode());
        return result;
    }
}