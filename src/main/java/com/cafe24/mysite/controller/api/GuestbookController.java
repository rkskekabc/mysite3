package com.cafe24.mysite.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.mysite.dto.JSONResult;
import com.cafe24.mysite.service.GuestbookService;
import com.cafe24.mysite.vo.GuestbookVo;

@RestController("guestbookAPIController")
@RequestMapping("/api/guestbook")
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping(value="/list/{lastNo}", method=RequestMethod.GET)
	public JSONResult list(@PathVariable(value="lastNo") Long lastNo) {
		List<GuestbookVo> list = guestbookService.getContentList(lastNo);
		return JSONResult.success(list);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public JSONResult add(@RequestBody GuestbookVo guestbookVo) {
		guestbookService.writeContent(guestbookVo);
		return JSONResult.success(guestbookVo);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public JSONResult delete(@RequestBody GuestbookVo vo) {
		boolean result = guestbookService.deleteContent(vo);
		return JSONResult.success(result ? vo.getNo() : -1);
	}
	
}