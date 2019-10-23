package com.d2derp.oep.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class EntityA {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int myIdA;
  private String strA;
  @OneToMany
  @JoinTable(name = "MY_JOIN_TABLE",
          joinColumns = {@JoinColumn(name = "MY_ENTITY_A_FK", referencedColumnName = "myIdA")},
          inverseJoinColumns = {@JoinColumn(name = "MY_ENTITY_B_FK", referencedColumnName = "myIdB")}
  )
  private List<EntityB> entityBList;
public int getMyIdA() {
	return myIdA;
}
public void setMyIdA(int myIdA) {
	this.myIdA = myIdA;
}
public String getStrA() {
	return strA;
}
public void setStrA(String strA) {
	this.strA = strA;
}
public List<EntityB> getEntityBList() {
	return entityBList;
}
public void setEntityBList(List<EntityB> entityBList) {
	this.entityBList = entityBList;
}

}