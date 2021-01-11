/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "Quiz1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quiz1.findAll", query = "SELECT q FROM Quiz1 q"),
    @NamedQuery(name = "Quiz1.findById", query = "SELECT q FROM Quiz1 q WHERE q.id = :id"),
    @NamedQuery(name = "Quiz1.findByQuestion", query = "SELECT q FROM Quiz1 q WHERE q.question = :question"),
    @NamedQuery(name = "Quiz1.findByA", query = "SELECT q FROM Quiz1 q WHERE q.a = :a"),
    @NamedQuery(name = "Quiz1.findByB", query = "SELECT q FROM Quiz1 q WHERE q.b = :b"),
    @NamedQuery(name = "Quiz1.findByC", query = "SELECT q FROM Quiz1 q WHERE q.c = :c"),
    @NamedQuery(name = "Quiz1.findByD", query = "SELECT q FROM Quiz1 q WHERE q.d = :d"),
    @NamedQuery(name = "Quiz1.findByAnswer", query = "SELECT q FROM Quiz1 q WHERE q.answer = :answer")})
public class Quiz1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Question")
    private String question;
    @Column(name = "A")
    private String a;
    @Column(name = "B")
    private String b;
    @Column(name = "C")
    private String c;
    @Column(name = "D")
    private String d;
    @Column(name = "Answer")
    private String answer;

    public Quiz1() {
    }

    public Quiz1(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quiz1)) {
            return false;
        }
        Quiz1 other = (Quiz1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Quiz1[ id=" + id + " ]";
    }
    
}
