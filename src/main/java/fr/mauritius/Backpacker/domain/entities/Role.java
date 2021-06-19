package fr.mauritius.Backpacker.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "role_id")
    private Long id;

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "by_default", nullable = false)
    private boolean byDefault;

    public Role() {
	//
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public boolean isByDefault() {
	return byDefault;
    }

    public void setByDefault(boolean byDefault) {
	this.byDefault = byDefault;
    }

    @Override
    public String toString() {
	return "Role [id=" + getId() + ", code=" + code + ", byDefault=" + byDefault + "]";
    }
}
