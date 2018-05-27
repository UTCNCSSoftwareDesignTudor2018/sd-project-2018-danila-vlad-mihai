package com.blood.business.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blood.business.dto.DonorDto;
import com.blood.data.entity.BloodBank;
import com.blood.data.entity.Donor;
import com.blood.data.repository.BloodBankRepository;
import com.blood.data.repository.DonorRepository;
import com.blood.presentation.controller.Observer;
import com.blood.business.service.Observable;

@Service
public class DonorService implements Observable {

	@Autowired
	DonorRepository donorRepository;
	@Autowired
	BloodBankRepository bloodBankRepository;

	private ArrayList<Observer> observerList = new ArrayList<Observer>();

	public DonorDto findDonorById(int id) {
		DonorDto donorDto = new DonorDto();
		donorDto.setDonorId(donorRepository.findByDonorId(id).getDonorId());
		donorDto.setDonorFirstname(donorRepository.findByDonorId(id).getDonorFirstname());
		donorDto.setDonorLastname(donorRepository.findByDonorId(id).getDonorLastname());
		donorDto.setDonorAvailability(donorRepository.findByDonorId(id).getDonorAvailability());
		donorDto.setBloodBank(donorRepository.findByDonorId(id).getBloodBank());
		donorDto.setAccounts(donorRepository.findByDonorId(id).getAccounts());
		return donorDto;
	}

	public List<DonorDto> getDonors() {

		List<DonorDto> donorDtoList = new ArrayList<>();
		List<Donor> donorList = donorRepository.findAll();
		for (Donor d : donorList) {
			DonorDto donorDto = new DonorDto();
			donorDto.setDonorFirstname(d.getDonorFirstname());
			donorDto.setDonorLastname(d.getDonorLastname());
			donorDto.setDonorId(d.getDonorId());
			donorDto.setDonorAvailability(d.getDonorAvailability());
			donorDto.setBloodBank(d.getBloodBank());
			donorDto.setAccounts(d.getAccounts());
			donorDtoList.add(donorDto);
		}
		return donorDtoList;
	}

	public List<DonorDto> getCompatibleDonors(String bloodType) {

		List<DonorDto> donorDtoList = new ArrayList<>();
		BloodBank bloodBank = bloodBankRepository.findByBloodType(bloodType);
		List<Donor> donorList = donorRepository.findAllByBloodBank(bloodBank);
		for (Donor d : donorList) {
			DonorDto donorDto = new DonorDto();
			donorDto.setDonorFirstname(d.getDonorFirstname());
			donorDto.setDonorLastname(d.getDonorLastname());
			donorDto.setDonorId(d.getDonorId());
			donorDto.setDonorAvailability(d.getDonorAvailability());
			donorDto.setBloodBank(d.getBloodBank());
			donorDto.setAccounts(d.getAccounts());
			donorDtoList.add(donorDto);
		}
		return donorDtoList;
	}

	public Donor createDonor(DonorDto donorDto) {
		Donor donor = new Donor.DonorBuilder().donorFirstname(donorDto.getDonorFirstname())
				.donorLastname(donorDto.getDonorLastname()).donorAvailability(donorDto.getDonorAvailability())
				.donorBloodBank(donorDto.getBloodBank()).build();
		Donor insertedDonor = donorRepository.save(donor);
		return insertedDonor;
	}

	public void deleteDonor(int id) {
		Donor donor = donorRepository.findByDonorId(id);
		donorRepository.delete(donor);
	}

	public void updateDonorAvailability(int id, String donorAvailability) {
		Donor donor = donorRepository.findByDonorId(id);
		donor.setDonorAvailability(donorAvailability);
		donorRepository.save(donor);
		if (donorAvailability == "true")
			notifyObservers("New donor is now available!\n" + donor.getDonorFirstname() + " " + donor.getDonorLastname()
					+ "\nBlood group: " + donor.getBloodBank().getBloodType() + "\nEmail:"
					+ donor.getAccounts().get(0).getAccountEmail() + "\nLocation: "
					+ donor.getAccounts().get(0).getAddresses());
		else
			notifyObservers("statesChanged");
	}

	public BloodBank getBloodBank(String type) {
		return bloodBankRepository.findByBloodType(type);
	}

	public ArrayList<Observer> getObserverList() {
		return observerList;
	}

	public void setObserverList(ArrayList<Observer> observerList) {
		this.observerList = observerList;
	}

	@Override
	public void registerObserver(Observer o) {
		observerList.add(o);

	}

	@Override
	public void unregisterObserver(Observer o) {
		observerList.remove(observerList.indexOf(o));

	}

	@Override
	public void notifyObservers(String message) {
		for (Iterator<Observer> it = observerList.iterator(); it.hasNext();) {
			Observer o = it.next();
			o.update(message);
		}

	}
}
