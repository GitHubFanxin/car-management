package pers.fanxin.carmanagement.module.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.fanxin.carmanagement.common.utils.Page;
import pers.fanxin.carmanagement.module.entity.Car;
import pers.fanxin.carmanagement.module.service.CarService;

@Controller
@RequestMapping("/manage")
public class CarController {

	@Autowired
	private CarService carService;

	@RequestMapping("/car")
	String carPage() {
		SecurityUtils.getSubject().checkRole("approver");
		return "car_manage";
	}

	@RequestMapping("/car/list")
	@ResponseBody
	public Object carList(HttpServletRequest request, int limit, int offset,
			String search) {
		List<Car> cars = carService.findCarsByPage(offset, limit, search);
		List<Object> results = new ArrayList<Object>();
		for (Car car : cars) {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("carId", car.getCarId());
			result.put("carNum", car.getCarNum());
			result.put("carName", car.getCarName());
			result.put("state", car.getState());
			if (car.getAvailable()) {
				result.put("available", "已启用");
			} else {
				result.put("available", "已禁用");
			}
			result.put("description", car.getDescription());
			results.add(result);
		}
		Page page = new Page();
		page.setRows(results);
		page.setTotal(carService.findCount(search));
		return page;
	}

	@RequestMapping("/car/add")
	@ResponseBody
	public Object carAdd(@RequestBody Car car) {
		if (carService.createCar(car) > 0) {
			return "{'state':true}";
		}
		return "{'state':false,'errMsg':'添加车辆失败'}";
	}

	@RequestMapping("/car/edit")
	@ResponseBody
	public Object carEdit(@RequestBody Car car) {
		carService.updateCar(car);
		return "{'state':true}";
	}

	@RequestMapping("/car/delete")
	@ResponseBody
	public Object carDelete(@RequestBody Car car) {
		carService.deleteCar(car);
		return "{'state':true}";
	}

	@RequestMapping("/car/forbid")
	@ResponseBody
	public Object carForbid(@RequestBody Car car) {
		Car newCar = carService.getCarById(car.getCarId());
		newCar.setAvailable(!newCar.getAvailable());
		carService.updateCar(newCar);
		return "{'state':true}";
	}
}
