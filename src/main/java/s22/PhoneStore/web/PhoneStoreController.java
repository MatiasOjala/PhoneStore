package s22.PhoneStore.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import s22.PhoneStore.domain.CoonditionRepository;
import s22.PhoneStore.domain.Phone;
import s22.PhoneStore.domain.PhoneRepository;



@Controller
public class PhoneStoreController {
	
	// Linkitetään repositoriot
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	@Autowired
	private CoonditionRepository condRepository;

	
	// Haetaan puhelin lista.
	@RequestMapping(value= {"/", "/phoneslist"})
	public String phonesList(Model model) {
	model.addAttribute("phone", phoneRepository.findAll());
	return "phoneslist";
	}
	
	// Määritetään puhelimen lisäys sivusto ja kenellä on oikeudet päästä sivulle.
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value= "/add")
	public String addPhone(Model model) {
		model.addAttribute("phone", new Phone());
		model.addAttribute("coonditions", condRepository.findAll());
		return "addphone";
	}
	
	// Määritetään tallennus ja kenellä on oikeudet.
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value= "/save", method = RequestMethod.POST)
	public String save(@Valid Phone phone, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("some error happened");
			return "addphone";
		}
		phoneRepository.save(phone);
		return "redirect:phoneslist";
	}
	
	// Määritetään puhelimen poisto mahdollisuus ja kenellä on oikeudet.
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePhone(@PathVariable("id") Long id, Model model) {
    	phoneRepository.deleteById(id);
        return "redirect:../phoneslist";
    } 
	
	// Määritetään puhelimen muokkaus ja kenellä on oikeudet.
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPhone(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("editphone", phoneRepository.findById(id));
    	model.addAttribute("coonditions", condRepository.findAll());
    	return "editphone";
	}
	// Määritetään pääsivu.
	@RequestMapping(value= {"/", "/mainpage"})
	public String mainpage(Model model) {
	return "mainpage";
	}
}
