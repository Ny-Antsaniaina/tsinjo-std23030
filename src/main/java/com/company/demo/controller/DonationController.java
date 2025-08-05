package com.company.demo.controller;

import com.company.demo.models.Donation;
import com.company.demo.models.Donor;
import com.company.demo.models.Payment;
import com.company.demo.repository.DonationRepository;
import com.company.demo.repository.DonorRepository;
import com.company.demo.repository.PayementRepository;
import com.company.demo.repository.PaymentRepository;
import com.company.demo.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@Controller
public class DonationController {

    private final PaymentService paymentService;
    private final DonationRepository donationRepository;
    private final DonorRepository donorRepository;
    private final PayementRepository paymentRepository;

    public DonationController(PaymentService paymentService,
                              DonationRepository donationRepository,
                              DonorRepository donorRepository,
                              PayementRepository paymentRepository) {
        this.paymentService = paymentService;
        this.donationRepository = donationRepository;
        this.donorRepository = donorRepository;
        this.paymentRepository = paymentRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("donations", donationRepository.findAll());
        return "donation";
    }

    @PostMapping("/donation")
    public String createDonation(@RequestParam String email,
                                 @RequestParam String pspPaymentId) {


        Map<String, Object> response = paymentService.getPayment(email, pspPaymentId).block();

        if (response == null) {

            return "redirect:/?error=api";
        }

        String status = (String) response.get("verificationStatus");

        if (!"SUCCEEDED".equals(status)) {

            return "redirect:/?error=not_verified";
        }


        Donor donor = new Donor();
        donor.setEmail(email);
        donorRepository.save(donor);

        Payment payment = new Payment();
        payment.setPspPaymentId(pspPaymentId);
        payment.setStatus(status);
        payment.setPaymentDate(LocalDateTime.now());
        paymentRepository.save(payment);

        Donation donation = new Donation();
        donation.setDonor(donor);
        donation.setPayment(payment);
        donation.setDonationDate(LocalDateTime.now());
        donationRepository.save(donation);

        return "redirect:/";
    }
}
