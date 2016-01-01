package com.cs616;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 1345356 on 2015-11-30.
 */
@Entity
@Table(name = "defect")
public class Defect {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="defectid")
    private long defectId;

    @Column(name = "created")
    private Date created;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "createdby")
    private User createdBy;

    @Column(name = "modified")
    private Date modified;

    @Column(name = "summary")
    private String summary;

    @Column(name = "status")
    private Status status;

    @Column(name = "severity")
    private Severity severity;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "assignedto")
    private User assignedTo;

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public long getDefectId() {
        return defectId;
    }

    public void setDefectId(long defectId) {
        this.defectId = defectId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }
}
