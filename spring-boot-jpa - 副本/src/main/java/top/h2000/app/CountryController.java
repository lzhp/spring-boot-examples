package top.h2000.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import top.h2000.utils.CustomBussinessRuntimeException;
import top.h2000.utils.CustomExceptionPojo;

/**
 * CountryController 简短描述. Date: 2018-03-20 21:05:25.
 * 
 * @author: lizhipeng.
 * @description：一些描述
 */
@CrossOrigin(origins = "*", allowCredentials = "true", maxAge = 4800)
@RestController
@Slf4j
@RequestMapping("/country")
public class CountryController {


  @Autowired
  private CountryService contryService;

  @ExceptionHandler({CustomBussinessRuntimeException.class})
  public ResponseEntity<CustomExceptionPojo> handleException(CustomBussinessRuntimeException e) {
    CustomExceptionPojo result = new CustomExceptionPojo(e);
    log.error(result.toString(), e);
    return new ResponseEntity<>(result, HttpStatus.SERVICE_UNAVAILABLE);
  }

  @RequestMapping("")
  public ResponseEntity<Iterable<Country>> getCountries() {
    Iterable<Country> contries = contryService.getAll();
    log.debug(contries.toString());
    return new ResponseEntity<>(contries, HttpStatus.OK);
  }

  @RequestMapping("/error")
  public void getCountry() {
    contryService.getError();
  }
}

