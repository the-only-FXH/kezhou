package action;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;




import util.Daohibernate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;


















import po.Xiadan;


public class Xiadanaction{

	/*
	 * 创建对象  用于获取从前端传来的数据
	 */

	private Xiadan xiadan;
	private String phone;
	private String qhh;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void test (HttpServletResponse res){
		try {
			res.getWriter().print("123/231");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	public Xiadan getXiadan() {
		return xiadan;
	}

	public void setXiadan(Xiadan xiadan) {
		this.xiadan = xiadan;
	}
	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQhh() {
		return qhh;
	}

	public void setQhh(String qhh) {
		this.qhh = qhh;
	}

	public String delete() {  //按主键删除	
		Date date1=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd");
		String date=sdf.format(date1);
		String id=(phone+qhh+date);
		Daohibernate d=new Daohibernate();
		Xiadan xiadan1;
		xiadan1=d.findXiadanById(id);
         if(xiadan1!=null)
		{ 
        	 d.Xiadanremove(id);
        	 return "s";
		}
         else return "f";  
	}
	
	public String deleteById() {  //新版按主键删除	
		
	
		Daohibernate d=new Daohibernate();
		Xiadan xiadan1;
		System.out.print("id=:"+id);
		xiadan1=d.findXiadanById(id);
	
         if(xiadan1!=null)
		{ 
        	 d.Xiadanremove(id);
        	 return "s";
		}
         else return "f";  
	}
	
	public String insert() {  //插入	
		
		
		Date date1=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd");
		String date=sdf.format(date1);
		xiadan.setDate(date);
		String id;
		id=(xiadan.getPhone()+xiadan.getQhh()+xiadan.getDate());
		xiadan.setId(id);
		Daohibernate d=new Daohibernate();
		Xiadan xiadan1;
				xiadan1=d.findXiadanById(xiadan.getId());
         if(xiadan1==null)
		{ 
       
        	 d.saveXiadan(xiadan);
        	 HttpServletRequest request=ServletActionContext.getRequest();
      	     request.getSession().setAttribute("xiadan", xiadan);
        	 
        	 return "s";
		}
         else return "f"; 
	}
	
	public String select() {  //按主键查找
		Date date1=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd");
		String date=sdf.format(date1);		
		String id=(phone+qhh+date);
		Daohibernate d=new Daohibernate();
		Xiadan xiadan1;
		xiadan1=d.findXiadanById(id);
         if(xiadan1!=null)
		{ 
        	 HttpServletRequest request=ServletActionContext.getRequest();
      	     request.getSession().setAttribute("xiadan1", xiadan1);
        	 return "s";
		}
         else return "f";  
	}
	
	public String selectByPhone() {  //按电话号码查找
		Date date1=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd");
		String date=sdf.format(date1);		
		
		Daohibernate d=new Daohibernate();
		List<Xiadan> selectByPhoneList=d.findXiadanByPhone(phone,date);
	
         if(selectByPhoneList.size()!=0)
		{ 
        	 HttpServletRequest request=ServletActionContext.getRequest();
      	     request.getSession().setAttribute("selectByPhoneList", selectByPhoneList);
        	 return "s";
		}
         else return "f";  
	}
	
	

	public String selectbydate() {  //按日期查找
		
		Date date1=new Date();

		SimpleDateFormat sdf=new SimpleDateFormat("dd");

		String date=sdf.format(date1);
		int date3=Integer.parseInt(date);
		//String date=(date1.getDate()+"");
		String date2;
		if(date3<10)
		date2=("0"+(date3-1)+"");
		else
		date2=((date3-1)+"");
		/*
		 * 东区快递(dq)
		 */
		String dq1="12号楼圆通";
		String dq2="12号楼天天";
		String dq3="12号楼韵达";
		String dq4="12号楼中通";
		String dq5="12号楼申通";
		String dq6="12号楼宅急送";
		String dq7="12号楼黄马甲";
		String dq8="12号楼百世";
	
		
		/*
		 * 西区快递(xq)
		 */
		String xq1="1号楼顺丰";
		String xq2="京东";
		
		/*
		 * 东门菜鸟(cn)
		 
		String cn1="东门申通";
		String cn2="东门圆通";
		String cn3="东门天天";
		String cn4="东门当当";
		String cn5="东门宅急送";
		String cn6="东门优速";
		String cn7="东门黄马甲";
		*/
		
		/*
		 * 东区百世(bs)
		
		String bs1="东门百世";
	 */
		Daohibernate d=new Daohibernate();
		List<Xiadan> list = d.findXiadaninfo("date",date);//查询当天快递
		List<Xiadan> list2 = d.findXiadaninfo("date",date2);//查询昨天快递
		/*
		 * 查询东区12号楼快递
		 */
		List<Xiadan> list3 = d.findInfo3("kdlx", "date", dq1, dq2, dq3, dq4, dq5, dq6,dq7,dq8,date);
		/*
		 * 查询西区快递
		 */
		List<Xiadan> list4 = d.findInfo2("kdlx", "date", xq1,xq2,date);
		
		
		/*
		 * 查询东门菜鸟
		 
		List<Xiadan> list5 = d.findInfo4("kdlx", "date", cn1, cn2, cn3, cn4,cn5,cn6,cn7,date);
		*/
		
		/*
		 * 查询东门百世
		
		List<Xiadan> list6 = d.findInfo23("kdlx", "date", bs1,date);
		 */
		
        	 HttpServletRequest request=ServletActionContext.getRequest();
      	   request.getSession().setAttribute("list",list);
      	   request.getSession().setAttribute("count",list.size());
      	   
      	   request.getSession().setAttribute("list2",list2);
    	   request.getSession().setAttribute("count2",list2.size());
    	   
    	   request.getSession().setAttribute("list3",list3);
    	   request.getSession().setAttribute("count3",list3.size());
    	   
    	   request.getSession().setAttribute("list4",list4);
    	   request.getSession().setAttribute("count4",list4.size());
    	   
    	  /* request.getSession().setAttribute("list5",list5);
    	   request.getSession().setAttribute("count5",list5.size());*/
    	   
    	 /*  request.getSession().setAttribute("list6",list6);
    	   request.getSession().setAttribute("count6",list6.size());*/
        	 
    	   
    	   
    	   return "s";
        	 
	}
	
	/*
	public String update() {   //更新
		
		Daohibernate d=new Daohibernate();
			d.updateZhuce(zhuce);
			 HttpServletRequest request=ServletActionContext.getRequest();
	     	    request.getSession().setAttribute("zhuce", zhuce);
			return "s";
		
	}
	
	public String QueryAll(){
		Daohibernate d=new Daohibernate();
		List<Zhuce> query=d.QueryAll_zhuce();
		HttpServletRequest request=ServletActionContext.getRequest();
	    request.getSession().setAttribute("count", query.size());
	    request.getSession().setAttribute("allInfo", query);
		return "s";
	}
	*/
	
}
