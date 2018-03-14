package ma.seydou.jee8.learn.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="seats")
public class Seat {
	
	@Id
	private Long id;
	@Enumerated(EnumType.STRING)
	private SeatMaterial seatMaterial;
	@Embedded
	private SeatBelt seatBelt;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public SeatMaterial getSeatMaterial() {
		return seatMaterial;
	}
	public void setSeatMaterial(SeatMaterial seatMaterial) {
		this.seatMaterial = seatMaterial;
	}
	public SeatBelt getSeatBelt() {
		return seatBelt;
	}
	public void setSeatBelt(SeatBelt seatBelt) {
		this.seatBelt = seatBelt;
	}
	
	
}
