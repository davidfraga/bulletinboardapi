package com.warning.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.warning.model.WarningModel;
import com.warning.repository.WarningModelRepository;
import com.warning.service.exception.ModelNotFoundException;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")

public class WarningModelService {
	private final WarningModelRepository warningModelRepository;
	
	

	public WarningModelService(WarningModelRepository warningModelRepository) {
		super();
		this.warningModelRepository = warningModelRepository;
		
	}

	
	/**
	 * Get all warnings
	 * @return List of WarningModel
	 */
	@GetMapping("/warnings")
	public List<WarningModel> listing() {
		return this.warningModelRepository.findAll();
	}

	/**
	 * Create new WarningModel
	 * @param newModel
	 * @return WarningModel created
	 */
	@PostMapping("/warning")
	WarningModel warningRegistration(@RequestBody WarningModel newModel) {
		newModel.setDate_published(new Date());
		return this.warningModelRepository.save(newModel);
		
	}
	
	/**
	 * Get WarningModel by ID
	 * @param id
	 * @return WarningModel
	 */
	@GetMapping("/warning/{id}")
	public WarningModel getOne(@PathVariable Integer id) {
		return this.warningModelRepository.findById(id).orElseThrow(() -> new ModelNotFoundException(id));
	}

	/**
	 * Update WarningModel by ID
	 * @param newModel
	 * @param id
	 * @return HttpStatus (OK or NOT_FOUND)
	 */
	@PutMapping("/warning/{id}")
	ResponseEntity<WarningModel> replaceModel(@RequestBody WarningModel newModel, @PathVariable Integer id) {
		Optional<WarningModel> oldwarning = this.warningModelRepository.findById(id);
        if(oldwarning.isPresent()){
        	WarningModel warningModel = oldwarning.get();
        	warningModel.setTitle(newModel.getTitle());
			warningModel.setDescription(newModel.getDescription());
			// If date_viewed is not set, define it now
			if(warningModel.getDate_viewed() == null) {
				warningModel.setDate_viewed(new Date());
			}
            this.warningModelRepository.save(warningModel);
            return new ResponseEntity<WarningModel>(warningModel, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	/**
	 * Deletes the WarningModel by ID
	 * @param id
	 * @return HttpStatus (OK or NOT_FOUND)
	 */
	@DeleteMapping("/warning/{id}")
	ResponseEntity<?> removeModel(@PathVariable Integer id) {
		Optional<WarningModel> warning = this.warningModelRepository.findById(id);
        if(warning.isPresent()){
        	warningModelRepository.delete(warning.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

}
