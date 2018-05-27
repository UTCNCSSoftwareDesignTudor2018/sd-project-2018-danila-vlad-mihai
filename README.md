DANILA VLAD-MIHAI

-> 	Layers + MVC

->	Observer DP: DonorService - Observable, PatientController - Observer. A patient is notified when a donor with compatible blood group is available
	
	Strategy DP: LoginController, in the context of Donor login vs. Patient login; The donor and patient controller classes will be responsible for encapsulating the ‘algorithm’ of handling the flow following the login confirmation(responsability of opening the proper frame).
	
	Builder DP: Make Patient and Donor creation more flexible.

->	Many-to-Many: addresses & accounts

	One-to-Many: blood_banks & donors, donors & accounts, patients & accounts
	
	One-to-One: accounts & logins
	
->	Spring, Hibernate, Maven

	Integration testing: Junit
	
	Unit tests: Mockito + JUnit
	
	Input validation: validation classes
	
	
	
