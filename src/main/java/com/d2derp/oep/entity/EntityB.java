package com.d2derp.oep.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;


@Entity
public class EntityB {
  @Id
  @GeneratedValue
  private int myIdB;
  
  private String strB;
  
  @ManyToOne
  @JoinTable(name = "MY_JOIN_TABLE",
          joinColumns = {@JoinColumn(name = "MY_ENTITY_B_FK", insertable = false,
                  updatable = false, referencedColumnName = "myIdB")},
          inverseJoinColumns = {@JoinColumn(name = "MY_ENTITY_A_FK", insertable =false ,
                  updatable = false, referencedColumnName = "myIdA")}
  )
  private EntityA refEntityA;
public int getMyIdB() {
	return myIdB;
}
public void setMyIdB(int myIdB) {
	this.myIdB = myIdB;
}
public String getStrB() {
	return strB;
}
public void setStrB(String strB) {
	this.strB = strB;
}
public EntityA getRefEntityA() {
	return refEntityA;
}
public void setRefEntityA(EntityA refEntityA) {
	this.refEntityA = refEntityA;
}
}
