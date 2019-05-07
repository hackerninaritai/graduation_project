package com.example.demo.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lthung
 */
@Entity
@Table(name = "task")
@NamedQueries({
    @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),
    @NamedQuery(name = "Task.findByTaskId", query = "SELECT t FROM Task t WHERE t.taskId = :taskId"),
    @NamedQuery(name = "Task.findByTaskIdparent", query = "SELECT t FROM Task t WHERE t.taskIdparent = :taskIdparent"),
    @NamedQuery(name = "Task.findByTaskName", query = "SELECT t FROM Task t WHERE t.taskName = :taskName"),
    @NamedQuery(name = "Task.findByNameCreate", query = "SELECT t FROM Task t WHERE t.nameCreate = :nameCreate"),
    @NamedQuery(name = "Task.findByNameAssign", query = "SELECT t FROM Task t WHERE t.nameAssign = :nameAssign"),
    @NamedQuery(name = "Task.findByDateCreate", query = "SELECT t FROM Task t WHERE t.dateCreate = :dateCreate"),
    @NamedQuery(name = "Task.findByDeadlineDate", query = "SELECT t FROM Task t WHERE t.deadlineDate = :deadlineDate"),
    @NamedQuery(name = "Task.findByFinishDate", query = "SELECT t FROM Task t WHERE t.finishDate = :finishDate"),
    @NamedQuery(name = "Task.findByTaskState", query = "SELECT t FROM Task t WHERE t.taskState = :taskState"),
    @NamedQuery(name = "Task.findByDiscription", query = "SELECT t FROM Task t WHERE t.discription = :discription"),
    @NamedQuery(name = "Task.findByTaskOutput", query = "SELECT t FROM Task t WHERE t.taskOutput = :taskOutput")})
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "task_id")
    private Integer taskId;
    @Column(name = "task_idparent")
    private Integer taskIdparent;
    @Basic(optional = false)
    @Column(name = "task_name")
    private String taskName;
    @Basic(optional = false)
    @Column(name = "name_create")
    private String nameCreate;
    @Basic(optional = false)
    @Column(name = "name_assign")
    private String nameAssign;
    @Basic(optional = false)
    @Column(name = "date_create")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @Basic(optional = false)
    @Column(name = "deadline_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadlineDate;
    @Column(name = "finish_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishDate;
    @Column(name = "task_state")
    private Integer taskState;
    @Basic(optional = false)
    @Column(name = "discription")
    private String discription;
    @Column(name = "task_output")
    private String taskOutput;
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @ManyToOne(optional = false)
    private Project projectId;
  
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
    @ManyToOne(optional = false)
    private Staff staffId;
    
    public Task() {
    }

    public Task(Integer taskId) {
        this.taskId = taskId;
    }

    public Task(Integer taskId, String taskName, String nameCreate, String nameAssign, Date dateCreate, Date deadlineDate, String discription) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.nameCreate = nameCreate;
        this.nameAssign = nameAssign;
        this.dateCreate = dateCreate;
        this.deadlineDate = deadlineDate;
        this.discription = discription;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getTaskIdparent() {
        return taskIdparent;
    }

    public void setTaskIdparent(Integer taskIdparent) {
        this.taskIdparent = taskIdparent;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getNameCreate() {
        return nameCreate;
    }

    public void setNameCreate(String nameCreate) {
        this.nameCreate = nameCreate;
    }

    public String getNameAssign() {
        return nameAssign;
    }

    public void setNameAssign(String nameAssign) {
        this.nameAssign = nameAssign;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Integer getTaskState() {
        return taskState;
    }

    public void setTaskState(Integer taskState) {
        this.taskState = taskState;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getTaskOutput() {
        return taskOutput;
    }

    public void setTaskOutput(String taskOutput) {
        this.taskOutput = taskOutput;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public Staff getStaffId() {
		return staffId;
	}

	public void setStaffId(Staff staffId) {
		this.staffId = staffId;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (taskId != null ? taskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.taskId == null && other.taskId != null) || (this.taskId != null && !this.taskId.equals(other.taskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gdfgdfgdfg.Task[ taskId=" + taskId + " ]";
    }
    
}
