package com.cuenta.bancaria.model;

	import lombok.AllArgsConstructor;

	import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.extern.slf4j.Slf4j;

	@Getter
	@AllArgsConstructor
	@NoArgsConstructor
	@Slf4j
	
	public class Customer {
		
		private String id;
		
		private String firstName;
		
		private String lastName;
		
		private String document;
		
		private String type;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
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

		public String getDocument() {
			return document;
		}

		public void setDocument(String document) {
			this.document = document;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
		
		
	}


