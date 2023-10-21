package com.springproject.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_payment")
public class Payment implements Serializable {
	
		private static final long serialVersionUID = 1L;	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long ID;
		private Instant moment;
		
		@OneToOne
		@MapsId
		@JsonIgnore
		private Order order;
		
		public Payment() {
			
		}

		public Payment(Long ID, Instant moment, Order order) {
			super();
			this.ID = ID;
			this.moment = moment;
			this.order = order;
		}

		public Long getID() {
			return ID;
		}

		public void setID(Long ID) {
			this.ID = ID;
		}

		public Instant getMoment() {
			return moment;
		}

		public void setMoment(Instant moment) {
			this.moment = moment;
		}

		public Order getOrder() {
			return order;
		}

		public void setOrder(Order order) {
			this.order = order;
		}

		@Override
		public int hashCode() {
			return Objects.hash(ID);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Payment other = (Payment) obj;
			return Objects.equals(ID, other.ID);
		}

		@Override
		public String toString() {
			return "Payment [ID=" + ID + ", moment=" + moment + "]";
		}
		
		
}
