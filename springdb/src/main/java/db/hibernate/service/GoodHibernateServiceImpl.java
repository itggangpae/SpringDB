package db.hibernate.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import db.hibernate.dao.GoodHibernateDAO;
import db.hibernate.domain.Good;

@Service
public class GoodHibernateServiceImpl implements GoodHibernateService {

	@Autowired
	private GoodHibernateDAO goodDao;
	
	@Override
	@Transactional
	public void insertGood() {
		Good good = new Good();
		good.setCode(101);
		good.setName("로렉스 시계");
		good.setManufacture("스위스");
		good.setPrice(1500000);
		
		Calendar cal = new GregorianCalendar();
		good.setShelflife(new Date(cal.getTimeInMillis()));
		
		byte [] image = null;
		try {
			URL url = new URL("http://www.onlifezone.com/files/attach/images/962811/376/321/005/2.jpg");
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			int len = con.getContentLength();
			InputStream is = con.getInputStream();
			FileOutputStream fos = new FileOutputStream("2.jpg");
			while(true) {
				byte[] raster = new byte[len];
				int read = is.read(raster);
				if (read <= 0) {
					break;
				}
				fos.write(raster,0, read);
			}
			is.close();
			fos.close();
			con.disconnect();
			
			FileInputStream fis = new FileInputStream("2.jpg");
			image = new byte[fis.available()];
			fis.read(image);
			fis.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("이미지 가져오기 실패");
		}
		
		good.setImage(image);
		goodDao.insertGood(good);
	}

	@Transactional
	public void listGood() {
		List<Good> list = goodDao.listGood();
		for(Good good : list){
			System.out.println(good);
		}
	}	

	@Override
	@Transactional
	public void getGood(int code) {
		Good good = goodDao.getGood(code);
		System.out.println(good);
		
	}
	
	@Override
	@Transactional
	public void maxCode() {
		int maxCode = goodDao.maxCode();
		System.out.println(maxCode);
		
	}
	
	@Override
	@Transactional
	public void updateGood() {
		Good good = new Good();
		good.setCode(101);
		good.setName("낙지");
		good.setManufacture("영암");
		good.setPrice(10000);
		goodDao.updateGood(good);
	}

	@Override
	@Transactional
	public void deleteGood() {
		goodDao.deleteGood(101);
	}

}
