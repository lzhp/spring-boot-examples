package top.h2000.app;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.base.Throwables;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import top.h2000.utils.CustomBussinessRuntimeException;

/**
 * CountryController 简短描述. 
 * Date: 2018-03-20 21:05:25.
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
  public ResponseEntity<Map<String, String>> handleException(CustomBussinessRuntimeException e) {

    log.error(Throwables.getStackTraceAsString(e));
    Map<String, String> result = Maps.newHashMap();
    result.put("exception", e.getMessage());
    result.put("error_code", e.getErrorCode());
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

