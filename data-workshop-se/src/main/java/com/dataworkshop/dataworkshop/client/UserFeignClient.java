/**
 * 
 */
package com.dataworkshop.dataworkshop.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dataworkshop.dataworkshop.dto.UserDTO;

/**
 * @author ramon
 *
 */
@Service
@FeignClient(name = "service-us")
public interface UserFeignClient {
	@GetMapping("/userAuth/{name}")
	public UserDTO finsUserByname(@PathVariable("name") String name) throws Exception; 
}
