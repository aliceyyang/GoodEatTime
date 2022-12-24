package com.tibame.tga104.reservation.service.impl;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.core.MailService;
import com.tibame.tga104.member.dao.impl.MemberDAOImpl;
import com.tibame.tga104.member.vo.MemberVO;
import com.tibame.tga104.reservation.dao.impl.ReservationDaoImpl;
import com.tibame.tga104.reservation.service.ReservationService;
import com.tibame.tga104.reservation.vo.MemberReserveInfVO;
import com.tibame.tga104.reservation.vo.ReservationDetailVO;
import com.tibame.tga104.reservation.vo.ReservationVO;
import com.tibame.tga104.reservation.vo.RestaurantReservationInfVO;
import com.tibame.tga104.restaurant.dao.impl.RestaurantDaoImpl;
import com.tibame.tga104.restaurant.vo.RestaurantVO;


@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDaoImpl dao;

	@Autowired
	private MemberDAOImpl memberDao;
	
	@Autowired	
	private RestaurantDaoImpl restaurantDao;
	
	@Override
	public ReservationVO bookTable(ReservationVO reservationVO) {
		ReservationVO result = null;
		if (new MemberVO().getMemberNo() != null) {
			result = dao.insert(reservationVO);
		}
		return result;
	}

	@Override
	public List<ReservationVO> findByDate(java.sql.Date reserveDate) {
		return dao.findByReserveDate(reserveDate);
	}

	@Override
	public List<ReservationVO> getAll() {
		return dao.getAll();
	}

	@Override
	public List<MemberReserveInfVO> findByMemberNO(Integer memberNo) {
		return dao.findByMemeberNo(memberNo);
	}

	@Override
	public List<ReservationDetailVO> findByRestaurantNoAndDate(Integer restaurantNo, java.sql.Date date) {
		if (date != null && restaurantNo != null) {
			return dao.findByRestaurantNoAndDate(restaurantNo, date);
		}
		return null;
	}

	@Override
	public List<RestaurantReservationInfVO> findByReserveDate(Integer restaurantNo, Date date) {
		if(date != null && restaurantNo != null) {
			return dao.findbyResveDate(restaurantNo, date);
		}
		return null;
	}

	@Override
	public boolean changeStatus(Integer reserveNo,String reserveStatus) {
		if(reserveNo != null) {
			return dao.updateStatus(reserveNo, reserveStatus);
		}
		return false;
	}
	
	@Override
	public boolean reservation(ReservationVO reservationVO) {
		if(reservationVO != null) {
			dao.insert(reservationVO);
	
			MemberVO member = memberDao.selectByMemberNo(reservationVO.getMemberNo());
			RestaurantVO restaurant = restaurantDao.findByPrimaryKey(reservationVO.getRestaurantNo());
			
			String to = member.getMail();
			String subject = "好食光-訂位成功通知";
			DateFormat dateFormat = new SimpleDateFormat("yyyy/dd/MM");
			Date date = reservationVO.getReserveDate();        
			String dateToStr = dateFormat.format(date);
			String remark = null;
			if (reservationVO.getRemark() == null) {
				remark = "無";
			}else {
				remark = reservationVO.getRemark();
			}
			String messageText = member.getName() +"先生/小姐 您好：您於好食光網站上的訂位訂單已經成立。"
					+"以下是您的訂位資訊：<br>"
					+"餐廳：" + restaurant.getRestaurantName() + "<br>"
					+"地址：" + restaurant.getRestaurantAddr() + "<br>"
					+"日期：" + dateToStr + "<br>"
					+"時間：" + reservationVO.getReserveTime() + "<br>"
					+"人數：" + reservationVO.getReserveNum() + "<br>"
					+"電話：" + member.getTel() + "<br>"
					+"備註：" + remark + "<br><br>"
					+"座位將會為您保留10分鐘，逾時取消不另行通知，謝謝！";
			try {
				MailService.sendMail(to, subject, messageText);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			

			return true;
		}
		return false;
	}
	
}
