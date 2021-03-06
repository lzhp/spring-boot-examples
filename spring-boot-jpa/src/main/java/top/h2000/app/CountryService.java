package top.h2000.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.collect.Iterables;
import top.h2000.utils.ApplicationConst;
import top.h2000.utils.CustomBussinessRuntimeException;

/**
 * CountryService 简短描述. Date: 2018-03-18 15:06:43.
 * 
 * @author: lizhipeng.
 * @description：一些描述
 */
@Service
@Transactional
public class CountryService {

  private CountryRepository repo;
  
  @Autowired
  public CountryService(CountryRepository repo) {
    this.repo = repo;    
  }


  /**
   * 得到一个country 
   *
   * Date: 2018-03-21 09:32:38 
   * @author lizhipeng 
   *
   * @param code
   * @return
   */
  @Transactional(readOnly = true)
  public Country getOne(String code) {

    Iterable<Country> countryList = repo.findAll();
    return Iterables.find(countryList, country -> country.getCode().equals(code), null);

  }
  
  /**
   * 测试错误
   * @Description: 
   *
   * Date: 2018-03-21 09:34:15 
   * @author lizhipeng 
   *
   */
  @Transactional(readOnly = true)
  public void getError() {

      throw new CustomBussinessRuntimeException(ApplicationConst.CONTRY_ERROR_CODE_001,"testid", "some error");
  }  

  public Iterable<Country> getCountryBeginWith(String code) {
    Iterable<Country> countryList = repo.findAll();
    return Iterables.filter(countryList, country -> country.getCode().startsWith(code));
  }

  @Transactional(readOnly = true)
  public Iterable<Country> getAll() {
    return repo.findAll();
  }
  
  @Transactional
  public Iterable<Country> writeData(Iterable<Country> list) {
    repo.saveAll(list);
    return repo.findAll();
  }  
}

