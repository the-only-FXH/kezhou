package action;
import java.io.IOException;
import java.util.List;
import util.Daohibernate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import po.Zhuce;

public class Zhuceaction{

	/*
	 * 创建对象  用于获取从前端传来的数据
	 */

	private Zhuce zhuce;
	private String zphone;
	public void test (HttpServletResponse res){
		try {
			res.getWriter().print("123/231");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}


	public Zhuce getZhuce() {
		return zhuce;
	}


	public void setZhuce(Zhuce zhuce) {
		this.zhuce = zhuce;
	}
   




	public String getZphone() {
		return zphone;
	}


	public void setZphone(String zphone) {
		this.zphone = zphone;
	}


	public String delete() {  //按主键删除	
		
		Daohibernate d=new Daohibernate();
		Zhuce zhuce1;
		zhuce1=d.findZhuceById(zphone);
         if(zhuce1!=null)
		{ 
        	 d.Zhuceremove(zphone);
        	 return "s";
		}
         else return "f";  
	}
	
	public String insert() {  //插入	
		Daohibernate d=new Daohibernate();
		Zhuce zhuce1;
		zhuce1=d.findZhuceById(zhuce.getZphone());
         if(zhuce1==null)
		{ 
       
        	 d.saveZhuce(zhuce);
        	 HttpServletRequest request=ServletActionContext.getRequest();
      	     request.getSession().setAttribute("zhuce", zhuce);
        	 
        	 return "s";
		}
         else return "f";  
	}
	
	public String select() {  //按主键查找
		Zhuce zhuce1=new Zhuce();
		Daohibernate d=new Daohibernate();
		zhuce1=d.findZhuceById(zphone);
		//System.out.print((book1==null));
    if(zhuce1==null)
        	 return "f";
		
         else{
        	
        	 HttpServletRequest request=ServletActionContext.getRequest();
     	    request.getSession().setAttribute("zhuce1", zhuce1);
        	 return "s"; 
         }  	  
	}
	
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
	
	
}
