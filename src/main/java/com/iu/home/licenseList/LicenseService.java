package com.iu.home.licenseList;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.home.util.Pager;

@Service
public class LicenseService {
	
	@Autowired
	private LicenseDAO licenseDAO;
	
	public List<LicenseDTO> getList(Pager pager) throws Exception{
		Long totalCount = licenseDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		
		return licenseDAO.getList(pager);
	}
	public Long getCount(Pager pager) throws Exception{
		return licenseDAO.getCount(pager);
	}
	public int setHits(LicenseDTO licenseDTO) throws Exception{
		return licenseDAO.setHits(licenseDTO);
	}
	
	public LicenseDTO getLicenseName(LicenseDTO licenseDTO) throws Exception{
		return licenseDAO.getLicenseName(licenseDTO);
	}
	
	public List<LicenseDTO> getDetailBook(LicenseDTO licenseDTO) throws Exception{
		
		return licenseDAO.getDetailBook(licenseDTO);
	}
	
	public List<LicenseDTO> getDetailVideo(LicenseDTO licenseDTO) throws Exception{
		
		return licenseDAO.getDetailVideo(licenseDTO);
	}
	
	public List<LicenseDTO> getDetailJob(LicenseDTO licenseDTO) throws Exception{
		
		return licenseDAO.getDetailJob(licenseDTO);
	}
	
	public List<ScheduleDTO> getDetailSchedule(LicenseDTO licenseDTO) throws Exception{
		
		return licenseDAO.getDetailSchedule(licenseDTO);
	}
	public int setUpdate(ArrDTO arrDTO) throws Exception{
		if(arrDTO.getSbvj().equals("s")) {			
			for(int i=0;i<arrDTO.getArr1().size();i++) {
				Long scheduleNum = licenseDAO.getScheduleNum(arrDTO).get(i).getScheduleNum();
				ScheduleDTO scheduleDTO = new ScheduleDTO();
				scheduleDTO.setScheduleNum(scheduleNum);
				scheduleDTO.setScheduleName(arrDTO.getArr1().get(i));
				scheduleDTO.setScheduleDate(arrDTO.getArr2().get(i));
				licenseDAO.setUpdateSchedule(scheduleDTO);
			}
		}else if(arrDTO.getSbvj().equals("b")) {//booknum,bookname,bookprice
			for(int i=0;i<arrDTO.getArr1().size();i++) {
				Long bookNum = licenseDAO.getBookNum(arrDTO).get(i).getBookNum();
				BookDTO bookDTO = new BookDTO();
				bookDTO.setBookNum(bookNum);
				bookDTO.setBookName(arrDTO.getArr1().get(i));
				bookDTO.setBookPrice(Long.parseLong(arrDTO.getArr2().get(i)));
				licenseDAO.setUpdateBook(bookDTO);
			}
		}else if(arrDTO.getSbvj().equals("v")) {//videonum,videotitle,videolink
			for(int i=0;i<arrDTO.getArr1().size();i++) {
				Long videoNum = licenseDAO.getVideoNum(arrDTO).get(i).getVideoNum();
				VideoDTO videoDTO = new VideoDTO();
				videoDTO.setVideoNum(videoNum);
				videoDTO.setVideoTitle(arrDTO.getArr1().get(i));
				videoDTO.setVideoLink(arrDTO.getArr2().get(i));
				licenseDAO.setUpdateVideo(videoDTO);
			}
		}else if(arrDTO.getSbvj().equals("j")) {//jobnum,jobname,jobintro
			for(int i=0;i<arrDTO.getArr1().size();i++) {
				Long jobNum = licenseDAO.getJobNum(arrDTO).get(i).getJobNum();
				JobDTO jobDTO = new JobDTO();
				jobDTO.setJobNum(jobNum);
				
				System.out.println(i+arrDTO.getArr1().get(i));
				System.out.println(i+arrDTO.getArr2().get(i));
				
				jobDTO.setJobName(arrDTO.getArr1().get(i));
				jobDTO.setJobIntro(arrDTO.getArr2().get(i));
				
				System.out.println(i+jobDTO.getJobName());
				System.out.println(i+jobDTO.getJobIntro());
				
				licenseDAO.setUpdateJob(jobDTO);
			}
		}
		return 1;
	}
	

}
