package com.example.demo1.myApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
@Service
public class ApiService {

	  private List<ApiData> demo = new ArrayList<>(Arrays.asList(
		new ApiData("01","Ramesh","Software Developer"),
		new ApiData("02","kamesh","Devops"),
		new ApiData("03","Ram","Software Developer"),
		new ApiData("04","Suresh","Software Developer"),
		new ApiData("05","Ramesh","Software Developer"),
		new ApiData("06","Ramesh","Software Developer")
		));
    public List<ApiData> demoApi(){
	return demo;
}
    public ApiData getData(String id) {
    	return demo.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }
	public void addData(ApiData data) {

		demo.add(data);
	}
	public void updateData(String id, ApiData updatedata) {
		for(int i=0;i<demo.size();i++)
		{
			ApiData t = demo.get(i);
			if(t.getId().equals(id)) {
				demo.set(i, updatedata);
				return;
			}
		}

	}
	public void deleteData(String id) {
		demo.removeIf(t -> t.getId().equals(id));
	}


}
