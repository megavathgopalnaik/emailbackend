package emailFunction.entity;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="tbl_appointment")
public class BookingAppointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 
	 @Column(name="first_name")
	  private String firstName;
	 
	 @Column(name="last_name")
      private String  lastName;
      private String gender;
      private String mobile;
      @Column(name="address")
      private String address;
      private String email;
      
      @Column(name="birth_date")
      private String birthDate;
   
     @Column(name="appointment_date")
     private String appointmentDate;
     
     @Column(name="appointment_time")
     private String   appointmentTime;
     
     
    


	private String injury;
     @Enumerated(EnumType.STRING)
     @Column(name="appointment_status")
     private AppointmentStatus appointmentStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getInjury() {
		return injury;
	}

	public void setInjury(String injury) {
		this.injury = injury;
	}

	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	@Override
	public String toString() {
		return "BookingAppointment [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", mobile=" + mobile + ", address=" + address + ", email=" + email + ", birthDate="
				+ birthDate + ", appointmentDate=" + appointmentDate + ", appointmentTime=" + appointmentTime
				+ ", injury=" + injury + ", appointmentStatus=" + appointmentStatus + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, appointmentDate, appointmentStatus, appointmentTime, birthDate, email, firstName,
				gender, id, injury, lastName, mobile);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingAppointment other = (BookingAppointment) obj;
		return Objects.equals(address, other.address) && Objects.equals(appointmentDate, other.appointmentDate)
				&& appointmentStatus == other.appointmentStatus
				&& Objects.equals(appointmentTime, other.appointmentTime) && Objects.equals(birthDate, other.birthDate)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(gender, other.gender) && id == other.id && Objects.equals(injury, other.injury)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(mobile, other.mobile);
	}


	
}