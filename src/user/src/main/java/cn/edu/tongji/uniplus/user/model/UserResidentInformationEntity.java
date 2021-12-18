package cn.edu.tongji.uniplus.user.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * UserResidentInformationEntity
 *
 * @author 卓正一
 * @since 2021/12/10 8:58 PM
 */
@Entity
@Table(name = "uniplus_user_resident_information", schema = "uniplus_user", catalog = "")
public class UserResidentInformationEntity {
    private long residentUserId;
    private String residentId;
    private String residentName;

    @Id
    @Column(name = "resident_user_id")
    public long getResidentUserId() {
        return residentUserId;
    }

    public void setResidentUserId(long residentUserId) {
        this.residentUserId = residentUserId;
    }

    @Basic
    @Column(name = "resident_id")
    public String getResidentId() {
        return residentId;
    }

    public void setResidentId(String residentId) {
        this.residentId = residentId;
    }

    @Basic
    @Column(name = "resident_name")
    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResidentInformationEntity that = (UserResidentInformationEntity) o;
        return residentUserId == that.residentUserId && Objects.equals(residentId, that.residentId) && Objects.equals(residentName, that.residentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(residentUserId, residentId, residentName);
    }
}
