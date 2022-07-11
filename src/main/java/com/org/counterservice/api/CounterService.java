package com.org.counterservice.api;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.counterservice.service.entity.Counter;
import com.org.counterservice.service.impl.CounterImplService;
import com.org.counterservice.service.pojo.ApiResponse;
import com.org.counterservice.service.pojo.CounterView;
import com.org.counterservice.service.pojo.ResponseCodes;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/v1/counter")
public class CounterService {

	private Logger logger = LoggerFactory.getLogger(CounterService.class);
	
	@Autowired
	private CounterImplService service;

	@ApiParam(name = "counterID", required = true, value = "long")
	@Description("This method will return the counter details of matching param @counterId from the request")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCounterDetails(@RequestParam(required = true, value = "counterId") long counterId) {
		logger.info("Fetching the counter details for counterId- {}", counterId);
		Counter counter = null;
		try {
			counter = service.getCounterById(counterId);
			logger.debug("Output - {}", counter.toString());
		} catch (Exception e) {
			logger.info("Exception while fetching the details of counter with countrId - {}", counterId, e);
			ApiResponse response = new ApiResponse(ResponseCodes.RECORD_NOT_FOUND_MSG, ResponseCodes.RECORD_NOT_FOUND,
					e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
		return ResponseEntity.status(HttpStatus.OK).body(counter);
	}
	
	@Description("This method will return all the counter defined")
	@GetMapping(path="/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllCounterDetails() {
		logger.info("Fetching all the counter");
		List<Counter> counter = null;
		try {
			counter = service.getAllCounters();
			logger.debug("Output - {}", counter.toString());
		} catch (Exception e) {
			logger.info("Exception while fetching the counters", e);
			ApiResponse response = new ApiResponse(ResponseCodes.RECORD_NOT_FOUND_MSG, ResponseCodes.RECORD_NOT_FOUND,
					e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
		return ResponseEntity.status(HttpStatus.OK).body(counter);
	}

	@ApiParam(name = "counterView", required = true, value = "counterView")
	@Description("This method will create the counter")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createCounter(@Valid @RequestBody(required = true) CounterView counterView) {
		Counter count = new Counter();
		ApiResponse response = null;
		logger.info("Input received to create counter- {}", counterView.toString());
		count.setCounterDesc(counterView.getCounterDesc());
		count.setCounterValue(0l);
		try {
			service.saveOrUpdate(count);
		} catch (Exception e) {
			logger.info("Exception while creating the counter - {}", counterView, e);
			response = new ApiResponse(ResponseCodes.REQUEST_FAILED_MSG, ResponseCodes.REQUEST_FAILED, e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
		response = new ApiResponse(ResponseCodes.REQUEST_SUCCESS_MSG, ResponseCodes.REQUEST_SUCCESS, "Success");
		response.setOutPutObject(count);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@ApiParam(name = "counterView", required = true, value = "counterView")
	@Description("This method will increment the counter")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> incrementCounter(@Valid @RequestBody(required = true) CounterView counterView) {
		Counter count = new Counter();
		ApiResponse response = null;
		logger.info("Input received to increment counter- {}", counterView.toString());
		long counterId = counterView.getCounterId();
		try {
			count = service.getCounterById(counterId);
			count.setCounterValue(count.getCounterValue()+1);
			service.saveOrUpdate(count);
		} catch (Exception e) {
			logger.info("Exception while incrementing the counter - {}", counterView, e);
			response = new ApiResponse(ResponseCodes.REQUEST_FAILED_MSG, ResponseCodes.REQUEST_FAILED, e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
		response = new ApiResponse(ResponseCodes.REQUEST_SUCCESS_MSG, ResponseCodes.REQUEST_SUCCESS, "Success");
		response.setOutPutObject(count);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@ApiParam(name = "counterId", required = true, value = "long")
	@Description("This method will delete the counter")
	@DeleteMapping
	private ResponseEntity<?> deletecounter(@RequestParam(required = true, value = "counterId") long counterId) {
		try {
			logger.info("Deleting the counter with counterId- {}", counterId);
			service.delete(counterId);
		} catch (Exception e) {
			logger.info("Exception while deleting the counter with counterId - {}", counterId, e);
			ApiResponse response = new ApiResponse(ResponseCodes.RECORD_NOT_FOUND_MSG, ResponseCodes.RECORD_NOT_FOUND,
					e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
