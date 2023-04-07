package edu.sdccd.cisc191.template.controllers;

import edu.sdccd.cisc191.template.Vendor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VendorController {
    @GetMapping("/vendors")
    public String showVendors() {
        return "vendors";
    }
    @PostMapping("/vendors")
    public String addVendor(@Validated Vendor vendor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "vendors";
        }

        // TODO: call server
        return "redirect:/vendors";
    }
}
