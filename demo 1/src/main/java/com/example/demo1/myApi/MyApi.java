package com.example.demo1.myApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyApi {
@Autowired
     private ApiService apiService;
     private  SampleDb sampleDb;
	@RequestMapping("/myApi")
	public List<ApiData> demoApi() {
		return  apiService.demoApi();
	}

	@GetMapping("/myApi/{id}")
	public ApiData getData(@PathVariable String id) {
		return apiService.getData(id);
	}
	//create
	@PostMapping("/myApi")
   public void  addData( @RequestBody ApiData data){
	   apiService.addData(data);
   }
   //update
  @PutMapping("/myApi/{id}")
	   public void  updateData( @RequestBody ApiData updatedata, @PathVariable String id){
		   apiService.updateData(id , updatedata);

  }
  //delete
  @DeleteMapping("/myApi/{id}")
	public void deleteData(@PathVariable String id) {
	apiService.deleteData(id);
	}


}
	