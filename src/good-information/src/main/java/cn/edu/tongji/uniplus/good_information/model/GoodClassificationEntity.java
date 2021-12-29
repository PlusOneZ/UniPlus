package cn.edu.tongji.uniplus.good_information.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "good_classification", schema = "uniplus_good_information", catalog = "")
public class GoodClassificationEntity {
    private int classificationId;
    private String classificationDescription;

    @Id
    @Column(name = "classification_id")
    public int getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(int classificationId) {
        this.classificationId = classificationId;
    }

    @Basic
    @Column(name = "classification_description")
    public String getClassificationDescription() {
        return classificationDescription;
    }

    public void setClassificationDescription(String classificationDescription) {
        this.classificationDescription = classificationDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodClassificationEntity that = (GoodClassificationEntity) o;
        return classificationId == that.classificationId && Objects.equals(classificationDescription, that.classificationDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classificationId, classificationDescription);
    }
}
