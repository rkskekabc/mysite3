package com.cafe24.mysite.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.cafe24.mysite.vo.GuestbookVo;

@Service
public class GuestbookService2 {
	public List<GuestbookVo> getContentsList(int i) {
		GuestbookVo first = new GuestbookVo(1L, "user1", "1234", "test1", "2019-0710 12:00:00");
		GuestbookVo second = new GuestbookVo(1L, "user2", "1234", "test2", "2019-0710 12:00:00");
		
		List<GuestbookVo> list = new ArrayList<GuestbookVo>();
		list.add(first);
		list.add(second);
		
		return list;
	}

	public GuestbookVo addContents(GuestbookVo guestbookVo) {
		guestbookVo.setNo(10L);
		guestbookVo.setRegDate("2019-07-10 00:00:00");
		return guestbookVo;
	}

	public Long deleteContents(Long no, String  password) {
		return no;
	}

}
