package com.mappings.inheritancemappings.mappedsuperclass;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.boot.actuate.audit.listener.AuditListener;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Spring Data uses JPA's EntityListeners and callback methods to automatically update 
 * the CreatedBy, CreatedDate, LastModifiedBy, and LastModifiedDate properties.
 * 
 * @EnableJpaAuditing will enable the Spring Data JPA Auditing features for the application.  
 * This annotation has the capability of managing (persisting and updating) the date related audit
 * fields  such as @CreatedDate and @LastModifiedDate.
 * @EntityListeners will listen for the event occurred,and the relevant annotated method will get notified. 
 *
 */

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class,AuditListener.class})
public abstract class AuditModel implements Serializable {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private Date updatedAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
