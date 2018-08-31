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
	 * ��������  ���ڻ�ȡ��ǰ�˴���������
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

	public String delete() {  //������ɾ��	
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
	
	public String deleteById() {  //�°水����ɾ��	
		
	
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
	
	public String insert() {  //����	
		
		
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
	
	public String select() {  //����������
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
	
	public String selectByPhone() {  //���绰�������
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
	
	

	public String selectbydate() {  //�����ڲ���
		
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
		 * �������(dq)
		 */
		String dq1="12��¥Բͨ";
		String dq2="12��¥����";
		String dq3="12��¥�ϴ�";
		String dq4="12��¥��ͨ";
		String dq5="12��¥��ͨ";
		String dq6="12��¥լ����";
		String dq7="12��¥�����";
		String dq8="12��¥����";
	
		
		/*
		 * �������(xq)
		 */
		String xq1="1��¥˳��";
		String xq2="����";
		
		/*
		 * ���Ų���(cn)
		 
		String cn1="������ͨ";
		String cn2="����Բͨ";
		String cn3="��������";
		String cn4="���ŵ���";
		String cn5="����լ����";
		String cn6="��������";
		String cn7="���Ż����";
		*/
		
		/*
		 * ��������(bs)
		
		String bs1="���Ű���";
	 */
		Daohibernate d=new Daohibernate();
		List<Xiadan> list = d.findXiadaninfo("date",date);//��ѯ������
		List<Xiadan> list2 = d.findXiadaninfo("date",date2);//��ѯ������
		/*
		 * ��ѯ����12��¥���
		 */
		List<Xiadan> list3 = d.findInfo3("kdlx", "date", dq1, dq2, dq3, dq4, dq5, dq6,dq7,dq8,date);
		/*
		 * ��ѯ�������
		 */
		List<Xiadan> list4 = d.findInfo2("kdlx", "date", xq1,xq2,date);
		
		
		/*
		 * ��ѯ���Ų���
		 
		List<Xiadan> list5 = d.findInfo4("kdlx", "date", cn1, cn2, cn3, cn4,cn5,cn6,cn7,date);
		*/
		
		/*
		 * ��ѯ���Ű���
		
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
	public String update() {   //����
		
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
