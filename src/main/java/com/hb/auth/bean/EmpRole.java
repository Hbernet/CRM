package com.sample;


public class EmpRole {

  private long erid;
  private long roleFk;
  private long empFk;
  private String erdis;


  public long getErid() {
    return erid;
  }

  public void setErid(long erid) {
    this.erid = erid;
  }


  public long getRoleFk() {
    return roleFk;
  }

  public void setRoleFk(long roleFk) {
    this.roleFk = roleFk;
  }


  public long getEmpFk() {
    return empFk;
  }

  public void setEmpFk(long empFk) {
    this.empFk = empFk;
  }


  public String getErdis() {
    return erdis;
  }

  public void setErdis(String erdis) {
    this.erdis = erdis;
  }

}
