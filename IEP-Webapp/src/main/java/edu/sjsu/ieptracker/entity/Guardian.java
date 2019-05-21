package edu.sjsu.ieptracker.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="GUARDIAN")
@NamedQueries({
        @NamedQuery(
                name = "findGuardianById",
                query = "from Guardian u where u.guardianID = :id"
        ),
        @NamedQuery(
                name = "findGuardianByStudentId",
                query = "from Guardian g where g.student.studentID = :id"
        ),
})
public class Guardian{

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private int guardianID;

        @Column(name = "guardianName") private String guardianName;
        @Column(name = "relation") private String relation;
        @Column(name = "contactNo") private String contactNo;
        @Column(name = "address") private String address;
        @Column(name = "primaryContact") private String primaryContact;
        @Column(name = "createDate") private String createDate;
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "studentID")
        private Student student;

        public Student getStudent() {
                return student;
        }

        public void setStudent(Student student) {
                this.student = student;
        }

        public int getGuardianID() {
                return guardianID;
        }

        public void setGuardianID(int guardianID) {
                this.guardianID = guardianID;
        }

        public String getGuardianName() {
                return guardianName;
        }

        public void setGuardianName(String guardianName) {
                this.guardianName = guardianName;
        }

        public String getRelation() {
                return relation;
        }

        public void setRelation(String relation) {
                this.relation = relation;
        }

        public String getContactNo() {
                return contactNo;
        }

        public void setContactNo(String contactNo) {
                this.contactNo = contactNo;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getPrimaryContact() {
                return primaryContact;
        }

        public void setPrimaryContact(String primaryContact) {
                this.primaryContact = primaryContact;
        }

        public String getCreateDate() {
                return createDate;
        }

        public void setCreateDate(String createDate) {
                this.createDate = createDate;
        }


}
