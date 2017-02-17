package com.sai.agro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.sai.agro.bean.AccountTypeBean;
import com.sai.agro.bean.AccountsBean;
import com.sai.agro.bean.CatagoryBean;
import com.sai.agro.bean.DistrictBean;
import com.sai.agro.bean.EmailBean;
import com.sai.agro.bean.MaterialReceivedEntryBean;
import com.sai.agro.bean.MaterialReceivedEntryProductBean;
import com.sai.agro.bean.PackingBean;
import com.sai.agro.bean.PhoneBean;
import com.sai.agro.bean.ProductBean;
import com.sai.agro.bean.ProductOpeningStockBean;
import com.sai.agro.bean.RouteCodeBean;
import com.sai.agro.bean.StateBean;
import com.sai.agro.bean.TechnicalNameBean;
import com.sai.agro.bean.UserBean;
import com.sai.agro.model.AccountType;
import com.sai.agro.model.Accounts;
import com.sai.agro.model.Catagory;
import com.sai.agro.model.District;
import com.sai.agro.model.Email;
import com.sai.agro.model.MaterialReceivedEntry;
import com.sai.agro.model.MaterialReceivedEntryProduct;
import com.sai.agro.model.Packing;
import com.sai.agro.model.Phone;
import com.sai.agro.model.Product;
import com.sai.agro.model.ProductOpeningStock;
import com.sai.agro.model.RouteCode;
import com.sai.agro.model.State;
import com.sai.agro.model.TechnicalName;
import com.sai.agro.model.User;
import com.sai.agro.service.AccountTypeService;
import com.sai.agro.service.AccountsService;
import com.sai.agro.service.CatagoryService;
import com.sai.agro.service.DistrictService;
import com.sai.agro.service.EmailService;
import com.sai.agro.service.MaterialReceivedEntryProductService;
import com.sai.agro.service.MaterialReceivedEntryService;
import com.sai.agro.service.PackingService;
import com.sai.agro.service.PhoneService;
import com.sai.agro.service.ProductOpeningStockService;
import com.sai.agro.service.ProductService;
import com.sai.agro.service.RouteCodeService;
import com.sai.agro.service.StateService;
import com.sai.agro.service.TechnicalNameService;
import com.sai.agro.service.UserService;


@Controller
public class TenderController {

//	private Logger logger = Logger.getLogger(TenderController.class);
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PackingService packingService;
	
	@Autowired
	private TechnicalNameService technicalNameService;
	
	@Autowired
	private CatagoryService catagoryService;
	
	@Autowired
	private AccountTypeService accountTypeService;
	
	@Autowired
	private DistrictService districtService;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private RouteCodeService routeCodeService;
	
	@Autowired
	private AccountsService accountsService;
	
	@Autowired
	private PhoneService phoneService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductOpeningStockService productOpeningStockService;
	
	@Autowired
	private MaterialReceivedEntryService materialReceivedEntryService;
	
	@Autowired
	private MaterialReceivedEntryProductService materialReceivedEntryProductService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, false));
	}
	
	//Product - page
	@RequestMapping(value="/productInformationMaster", method= RequestMethod.POST)
	public ModelAndView productInformationMaster(){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("product", new Product());
		model.put("packingList", preparePackingList(packingService.listPacking()));
		model.put("technicalList", prepareTechnicalList(technicalNameService.listTechnicalNames()));
		model.put("catagoryList", prepareCatagoryList(catagoryService.listCatagory()));
		return new ModelAndView("productInformationMaster",model);
	}
	
	//Save Product
	@RequestMapping(value="/saveProductInformation", method= RequestMethod.POST)
	public ModelAndView saveProductInformationMaster(@ModelAttribute("productInformation") ProductBean productBean,
			BindingResult result,Model model){
     Product product=prepareProductModel(productBean);
     productService.addProduct(product);
     model.addAttribute("product", new Product());
     model.addAttribute("packingList", preparePackingList(packingService.listPacking()));
	 model.addAttribute("technicalList", prepareTechnicalList(technicalNameService.listTechnicalNames()));
	 model.addAttribute("catagoryList", prepareCatagoryList(catagoryService.listCatagory()));
	 return new ModelAndView("productInformationMaster");
	}
	
	//Product List
	@RequestMapping(value="/productList", method = RequestMethod.POST)
	public ModelAndView listProducts() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("productList",  prepareListofProductBean(productService.listProducts()));
		return new ModelAndView("productList", model);
	}
	
    //Edit Product
	@RequestMapping(value="/editProduct", method = RequestMethod.POST)
	public ModelAndView editProduct(@ModelAttribute("productInformation") ProductBean productBean,
			BindingResult result,Model model1) {
		System.out.println("The value of Id form Edit Product:"+productBean.getProduct_id());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("packingList", preparePackingList(packingService.listPacking()));
		model.put("technicalList", prepareTechnicalList(technicalNameService.listTechnicalNames()));
		model.put("catagoryList", prepareCatagoryList(catagoryService.listCatagory()));
		model.put("product",  prepareProductBean(productService.getProduct(productBean.getProduct_id())));
		return new ModelAndView("productInformationMaster",model);
	}
	
	@RequestMapping(value="/deleteProduct", method = RequestMethod.POST)
	public ModelAndView deleteProduct(@RequestParam("id") String product_id) {
		System.out.println("The value of Id"+product_id);
		productService.deleteProduct(Integer.parseInt(product_id));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("productList",  prepareListofProductBean(productService.listProducts()));
		return new ModelAndView("productList",model);
	}
	
    //Product Methods
	private Object preparePackingList(List<Packing> listPacking) {
		Map<Integer,String> packingList = new LinkedHashMap<Integer,String>();
		for(Packing packing:listPacking)
		{
			packingList.put(packing.getPacking_id(), packing.getPacking_name());
		}
		return packingList;
	}
	private Object prepareTechnicalList(List<TechnicalName> listTechnicalNames) {
		Map<Integer,String> technicalList = new LinkedHashMap<Integer,String>();
		for(TechnicalName technicalName:listTechnicalNames)
		{
			technicalList.put(technicalName.getTechnical_id(), technicalName.getTechnical_name());
		}
		return technicalList;
	}
	private Object prepareCatagoryList(List<Catagory> listCatagory) {
		Map<Integer,String> catagoryList = new LinkedHashMap<Integer,String>();
		for(Catagory catgory:listCatagory)
		{
			catagoryList.put(catgory.getCatagory_id(),catgory.getCatagory_name());
		}
		return catagoryList;
	}
	private Product prepareProductModel(ProductBean productBean) {
		Product product=new Product();
		product.setProduct_id(productBean.getProduct_id());
		System.out.println("prepareModel id value:"+productBean.getProduct_id());
		product.setProduct_code(productBean.getProduct_code());
		product.setProduct_name(productBean.getProduct_name());
		product.setPacking_id(productBean.getPacking_id());
		product.setTechnical_id(productBean.getTechnical_id());
		product.setCompany_code(productBean.getCompany_code());
		product.setCatagory_id(productBean.getCatagory_id());
		product.setQuantity_on_hand(productBean.getQuantity_on_hand());
		product.setPurchase_rate(productBean.getPurchase_rate());
		product.setSale_rate(productBean.getSale_rate());
		product.setMrp(productBean.getMrp());
		product.setVat(productBean.getVat());
		productBean.setProduct_id(null);
		return product;
	}
	private List<ProductBean> prepareListofProductBean(List<Product> listProducts) {
		List<ProductBean> productBeanList=null;
		if(listProducts != null && !listProducts.isEmpty())
		{
			productBeanList=new ArrayList<ProductBean>();
	        ProductBean productBean=null;
	        for(Product product:listProducts)
	        {
	        	productBean=new ProductBean();
	        	productBean.setProduct_id(product.getProduct_id());
	        	productBean.setProduct_code(product.getProduct_code());
	        	productBean.setProduct_name(product.getProduct_name());
	        	productBean.setPacking_id(product.getPacking_id());
	        	productBean.setCatagory_id(product.getCatagory_id());
	        	productBean.setTechnical_id(product.getTechnical_id());
	        	productBean.setCompany_code(product.getCompany_code());
	        	productBean.setQuantity_on_hand(product.getQuantity_on_hand());
	        	productBean.setPurchase_rate(product.getPurchase_rate());
	        	productBean.setSale_rate(product.getSale_rate());
	        	productBean.setMrp(product.getMrp());
	        	productBean.setVat(product.getVat());
	        	productBeanList.add(productBean);
	        }
		}
		return productBeanList;
	}
	private Object prepareProductBean(Product product) {
		ProductBean productBean=new ProductBean();
    	productBean.setProduct_code(product.getProduct_code());
    	productBean.setProduct_name(product.getProduct_name());
    	productBean.setPacking_id(product.getPacking_id());
    	productBean.setCatagory_id(product.getCatagory_id());
    	productBean.setTechnical_id(product.getTechnical_id());
    	productBean.setCompany_code(product.getCompany_code());
    	productBean.setQuantity_on_hand(product.getQuantity_on_hand());
    	productBean.setPurchase_rate(product.getPurchase_rate());
    	productBean.setSale_rate(product.getSale_rate());
    	productBean.setMrp(product.getMrp());
    	productBean.setVat(product.getVat());
    	productBean.setProduct_id(product.getProduct_id());
//    	System.out.println("product_id"+product.getProduct_id());
		return productBean;
	}
	//End of Product
	
	//Packing
	@RequestMapping(value = "/packing", method = RequestMethod.POST)
	public ModelAndView packing(@ModelAttribute("packing") PackingBean packingBean,BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("product", new Packing());
		return new ModelAndView("packing",model);
	}
	
	@RequestMapping(value = "/savePacking", method = RequestMethod.POST)
	public ModelAndView savePacking(@ModelAttribute("packing") PackingBean packingBean,BindingResult result) {
		Packing packing=prepareModel(packingBean);
		packingService.addPacking(packing);
		return new ModelAndView("redirect:packing.html");
	}
	
	@RequestMapping(value = "/editPacking", method = RequestMethod.POST)
	public ModelAndView editPacking(@ModelAttribute("packing") PackingBean packingBean,BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("packing", preparePackingBean(packingService.getPacking(packingBean.getPacking_id())));
		return new ModelAndView("packing",model);
	}
	
	@RequestMapping(value = "/deletePacking", method = RequestMethod.POST)
	public ModelAndView deletePacking(@ModelAttribute("packing") PackingBean packingBean,BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		packingService.deletePacking(packingBean.getPacking_id());
		model.put("packingList", preparePackingBeanList(packingService.listPacking()));
		return new ModelAndView("packingList",model);
	}
	
	@RequestMapping(value = "/packingList", method = RequestMethod.POST)
	public ModelAndView listPacking(@ModelAttribute("packing") PackingBean packingBean,BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("packingList", preparePackingBeanList(packingService.listPacking()));
		return new ModelAndView("packingList",model);
	}
	
	private Packing prepareModel(PackingBean packingBean) {
		Packing packing=new Packing();
	    packing.setPacking_id(packingBean.getPacking_id());  
	    packing.setPacking_name(packingBean.getPacking_name());
		return packing;
	}
	
	private PackingBean preparePackingBean(Packing packing) {
        PackingBean packingBean=new PackingBean();
        packingBean.setPacking_id(packing.getPacking_id());
        packingBean.setPacking_name(packing.getPacking_name());
		return packingBean;
	}
	
	private Object preparePackingBeanList(List<Packing> listPacking) {
		List<PackingBean> packingBeanList=new ArrayList<PackingBean>();	
		for(Packing packing:listPacking)
		{
			PackingBean packingBean=new PackingBean();
			packingBean.setPacking_id(packing.getPacking_id());
			packingBean.setPacking_name(packing.getPacking_name());
			packingBeanList.add(packingBean);
		}
		return packingBeanList;
	}
    //End Packing

	//Technical 

	@RequestMapping(value="/technical", method= RequestMethod.POST)
	public ModelAndView technical(@ModelAttribute("productInformation") TechnicalNameBean technicalNameBean){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("technical", new TechnicalName());
//		model.put("technicalList", prepareListTechnical(technicalNameService.listTechnicalNames()));
		return new ModelAndView("technical",model);
	}
	
	@RequestMapping(value="/saveTechnical", method= RequestMethod.POST)
	public ModelAndView saveTechnical(@ModelAttribute("productInformation") TechnicalNameBean technicalNameBean,BindingResult result,Model model){
//		Map<String, Object> model = new HashMap<String, Object>();
		TechnicalName technicalName=prepareTechnicalName(technicalNameBean);
		technicalNameService.addTechnicalName(technicalName);
//		model.put("technical", new TechnicalName());
//		model.put("technicalList", prepareListTechnical(technicalNameService.listTechnicalNames()));
		model.addAttribute("technical" ,new TechnicalName());
		return new ModelAndView("technical");
	}
	
	@RequestMapping(value="/technicalList", method= RequestMethod.POST)
	public ModelAndView technicalList(@ModelAttribute("productInformation") TechnicalNameBean technicalNameBean){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("technical", new TechnicalName());
		model.put("technicalList", prepareListTechnical(technicalNameService.listTechnicalNames()));
		return new ModelAndView("technicalList",model);
	}
	
	@RequestMapping(value="/editTechnical", method= RequestMethod.POST)
	public ModelAndView editTechnical(@ModelAttribute("technical") TechnicalNameBean technicalNameBean){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("technical", prepareTechnicalNameBean(technicalNameService.getTechnicalName(technicalNameBean.getTechnical_id())));
		return new ModelAndView("technical",model);
	}
	
	@RequestMapping(value="/deleteTechnical", method= RequestMethod.POST)
	public ModelAndView deleteTechnical(@ModelAttribute("technical") TechnicalNameBean technicalNameBean){
		Map<String, Object> model = new HashMap<String, Object>();
		technicalNameService.deleteTechnicalName(technicalNameBean.getTechnical_id());
		model.put("technical", new TechnicalName());
		model.put("technicalList", prepareListTechnical(technicalNameService.listTechnicalNames()));
		return new ModelAndView("technicalList",model);
	}
	
	
	private TechnicalName prepareTechnicalName(TechnicalNameBean technicalNameBean) {
		TechnicalName technicalName=new TechnicalName();
		technicalName.setTechnical_id(technicalNameBean.getTechnical_id());
		technicalName.setTechnical_name(technicalNameBean.getTechnical_name());
		technicalNameBean.setTechnical_id(null);
		return technicalName;
	}


	private TechnicalNameBean prepareTechnicalNameBean(TechnicalName technicalName) {
		TechnicalNameBean technicalNameBean=new TechnicalNameBean();
		technicalNameBean.setTechnical_id(technicalName.getTechnical_id());
		technicalNameBean.setTechnical_name(technicalName.getTechnical_name());
		return technicalNameBean;
	}
	
	private Object prepareListTechnical(List<TechnicalName> listTechnicalNames) {
		List<TechnicalNameBean> technicalBeanList=new ArrayList<TechnicalNameBean>();
		for(TechnicalName technicalName:listTechnicalNames)
		{
			TechnicalNameBean technicalBean=new TechnicalNameBean();
			technicalBean.setTechnical_id(technicalName.getTechnical_id());
			technicalBean.setTechnical_name(technicalName.getTechnical_name());
			technicalBeanList.add(technicalBean);
		}
		return technicalBeanList;
	}
    //End Technical	
	
	
	@RequestMapping(value = "/accounts", method = RequestMethod.POST)
	public ModelAndView accounts(@ModelAttribute("accounts") AccountsBean accountsBean,BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("accountTypeList", prepareAccountTypeList(accountTypeService.listAccountTypes()));
		model.put("stateList", prepareStateBeanListL(stateService.listStates()));
		model.put("routeCodeList", PrepareRouteCodeBeanList(routeCodeService.listRouteCodes()));
		model.put("accounts", new Accounts());
		return new ModelAndView("accounts",model);
	}

	@RequestMapping(value = "/saveAccounts", method = RequestMethod.POST)
	public ModelAndView saveAccounts(@ModelAttribute("accounts") AccountsBean accountsBean,
			PhoneBean phoneBean,EmailBean emailBean,BindingResult result,Model model) {
			
		Accounts account=prepareAccount(accountsBean);
		accountsService.addAccount(account);  
		List<String> dataBasePhoneBeanList=prepareDbPhoneBeanList(phoneService.listPhones(),accountsBean.getAccount_id());
		String phone_id_db[]=new String[dataBasePhoneBeanList.size()];
		
		System.out.println("From List of it: "+dataBasePhoneBeanList);
//		for(String phoneBeanD:dataBasePhoneBeanList)
		for(int i=0;i<dataBasePhoneBeanList.size();i++)
		{
			phone_id_db[i]=dataBasePhoneBeanList.get(i);
			System.out.println("values from database: phone_id :"+phone_id_db[i]);
		}
		
		String phone_no[]=phoneBean.getPhone_no().split(",");
		String phone_type[]=phoneBean.getPhone_type().split(",");
		String[] phoneIdList=phoneBean.getPhone_id().split(",");
		System.out.println("Length of phone: "+phone_no.length);
		
		for(int i=0;i<phone_no.length;i++)
		{
			if(!phoneIdList[i].equals("0")&&!phoneIdList[i].equals(null))
			{
				for(int j=0;j<phone_id_db.length;j++)
				{
					String delete=prepareDelete(phone_id_db[j],phoneIdList);
					if(!delete.equals("null"))
					{
						System.out.println(delete+" Value is deleting from database not present from front end");
						phoneService.deletePhone(Integer.parseInt(delete));			
					}else
					{
						System.out.println("setting for update Phone_id: "+phoneIdList[i]);
						phoneBean.setPhone_id(phoneIdList[i]);
					}
				}
			}
			System.out.println("phone_no: "+phone_no[i]);
			System.out.println("Phone Type: "+phone_type[i]);
			phoneBean.setAccount_id(Integer.toString(account.getAccount_id()));
			phoneBean.setPhone_no(phone_no[i]);
			phoneBean.setPhone_type(phone_type[i]);
			Phone phone=preparePhone(phoneBean);
			phoneService.addPhone(phone);
		}
		
		/*String email_id[]=emailBean.getEmail_id().split(",");
		String email[]=emailBean.getEmail().split(",");
		String email_type[]=emailBean.getEmail_type().split(",");
		for(int i=0;i<email_id.length;i++)
		{
			System.out.println("email_id: "+email_id[i]);
			System.out.println("email: "+email[i]);
			System.out.println("email_type: "+email_type[i]);
			EmailBean email_bean=new EmailBean();
			if(!email_id[i].equals("0"))
			{
				System.out.println("emailId updaatee: "+email_id[i]);
				email_bean.setAccount_id(email_id[i]);
			}
			email_bean.setEmail(email[i]);
			email_bean.setEmail_type(email_type[i]);
			email_bean.setAccount_id(Integer.toString(account.getAccount_id()));
			Email addEmail=prepareEmail(email_bean);
			emailService.addEmail(addEmail);
		}*/
		
		List<String> dataBaseemailBeanList=prepareDbemailBeanList(emailService.listEmail(),accountsBean.getAccount_id());
		String email_id_db[]=new String[dataBaseemailBeanList.size()];
		
		System.out.println("From List of it: "+dataBaseemailBeanList);
//		for(String emailBeanD:dataBaseemailBeanList)
		for(int i=0;i<dataBaseemailBeanList.size();i++)
		{
			email_id_db[i]=dataBaseemailBeanList.get(i);
			System.out.println("values from database: email_id :"+email_id_db[i]);
		}
		
		String email[]=emailBean.getEmail().split(",");
		String email_type[]=emailBean.getEmail_type().split(",");
		String[] emailIdList=emailBean.getEmail_id().split(",");
		System.out.println("Length of email: "+email.length);
		
		for(int i=0;i<email.length;i++)
		{
			if(!emailIdList[i].equals("0")&&!emailIdList[i].equals(null))
			{
				for(int j=0;j<email_id_db.length;j++)
				{
					String delete=prepareDeleteEmail(email_id_db[j],emailIdList);
					if(!delete.equals("null"))
					{
						System.out.println(delete+" Value is deleting from database not present from front end");
						emailService.deleteEmail(Integer.parseInt(delete));			
					}else
					{
						System.out.println("setting for update email_id: "+emailIdList[i]);
						emailBean.setEmail_id(emailIdList[i]);
					}
				}
			}
			System.out.println("email_no: "+email[i]);
			System.out.println("email Type: "+email_type[i]);
			emailBean.setAccount_id(Integer.toString(account.getAccount_id()));
			emailBean.setEmail(email[i]);
			emailBean.setEmail_type(email_type[i]);
			Email email_bean=prepareemail(emailBean);
			emailService.addEmail(email_bean);
		}
		return new ModelAndView("redirect:accounts.html");
	}
	
/*	private Email prepareEmail(EmailBean email_bean) {
		Email email=new Email();
		email.setAccount_id(Integer.parseInt(email_bean.getAccount_id()));
		email.setEmail(email_bean.getEmail());
		email.setEmail(email_bean.getEmail());
//		email.setEmail_id(Integer.parseInt(email_bean.getEmail_id()));
//		email_bean.setAccount_id(null);
		return email;
	}*/

	private String prepareDeleteEmail(String email_id, String[] emailIdList) {
		String delete_email_id=email_id;
		for(int j=0;j<emailIdList.length;j++)
		{
			if(email_id.equals(emailIdList[j]))
			{
				System.out.println("Selected for Update phone_id: "+email_id);
				delete_email_id="null";
			}
		}
		return delete_email_id;
	}

	private List<String> prepareDbemailBeanList(List<Email> listEmail, Integer account_id) {
		List<String> emailListBean=new ArrayList<String>();
		for(Email email:listEmail)
		{
			if(email.getAccount_id().equals(account_id))
			{
				emailListBean.add(Integer.toString(email.getEmail_id()));
			}
		}
		return emailListBean;
	}

	private Email prepareemail(EmailBean emailBean) {
		Email email=new Email();
		email.setAccount_id(Integer.parseInt(emailBean.getAccount_id()));
		email.setEmail_id(Integer.parseInt(emailBean.getEmail_id()));
		email.setEmail(emailBean.getEmail());
		email.setEmail_type(emailBean.getEmail_type());
		return email;
	}

	private String prepareDelete(String phone_id, String[] phone_id_ui) {
		String delete_phone_id=phone_id;
		for(int j=0;j<phone_id_ui.length;j++)
		{
			if(phone_id.equals(phone_id_ui[j]))
			{
				System.out.println("Selected for Update phone_id: "+phone_id);
				delete_phone_id="null";
			}
		}
		return delete_phone_id;
	}

	private List<String> prepareDbPhoneBeanList(List<Phone> listPhones,int account_id) {
		List<String> phoneBeanList=new ArrayList<String>();
		for(Phone phone:listPhones)
		{
			if(phone.getAccount_id().equals(account_id))
			{
				PhoneBean phoneBean=new PhoneBean();
				phoneBean.setAccount_id(Integer.toString(phone.getAccount_id()));
				phoneBean.setPhone_id(Integer.toString(phone.getPhone_id()));
				phoneBean.setPhone_no(Long.toString(phone.getPhone_no()));
				phoneBean.setPhone_type(phone.getPhone_type());
			    phoneBeanList.add(phoneBean.getPhone_id());	
			}
		}
/*		List<PhoneBean> phoneBeanList=new ArrayList<PhoneBean>();
		for(Phone phone:listPhones)
		{
			if(phone.getAccount_id().equals(account_id))
			{
				PhoneBean phoneBean=new PhoneBean();
				phoneBean.setAccount_id(Integer.toString(phone.getAccount_id()));
				phoneBean.setPhone_id(Integer.toString(phone.getPhone_id()));
				phoneBean.setPhone_no(Long.toString(phone.getPhone_no()));
				phoneBean.setPhone_type(phone.getPhone_type());
				phoneBeanList.add(phoneBean);	
			}
		}
*/		return phoneBeanList;
	}

	private Phone preparePhone(PhoneBean phoneBean) {
		Phone phone=new Phone();
		phone.setPhone_id(Integer.parseInt(phoneBean.getPhone_id()));	
		phone.setPhone_no(Long.parseLong(phoneBean.getPhone_no()));
		phone.setAccount_id(Integer.valueOf(phoneBean.getAccount_id()));
		phone.setPhone_type(phoneBean.getPhone_type());
		phoneBean.setPhone_id("0");
		return phone;
	}

	@RequestMapping(value = "/accountsList", method = RequestMethod.POST)
	public ModelAndView accountsList(@ModelAttribute("accounts") AccountsBean accountsBean,BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		/*model.put("accountTypeList", prepareAccountTypeList(accountTypeService.listAccountTypes()));
		model.put("stateList", prepareStateBeanListL(stateService.listStates()));
		model.put("routeCodeList", PrepareRouteCodeBeanList(routeCodeService.listRouteCodes()));
		Accounts account=prepareAccount(accountsBean);
		accountsService.addAccount(account);*/
		model.put("accountsList", prepareAccountsBeanList(accountsService.listAccounts()));
		return new ModelAndView("accountsList",model);
	}
	
	@RequestMapping(value = "/deleteAccount", method = RequestMethod.POST)
	public ModelAndView deleteAccount(@ModelAttribute("accounts") AccountsBean accountsBean,BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		accountsService.deleteAccount(accountsBean.getAccount_id());
		model.put("accountsList", prepareAccountsBeanList(accountsService.listAccounts()));
		return new ModelAndView("accountsList",model);
	}
	
	@RequestMapping(value = "/editAccount", method = RequestMethod.POST)
	public ModelAndView editAccounts(@ModelAttribute("accounts") AccountsBean accountsBean,BindingResult result,Model model) {
		AccountsBean accounts=prepareAccountsBean(accountsService.getAccount(accountsBean.getAccount_id()));
		List<DistrictBean> districtsListBean=prepareDistrictListBean(districtService.listDistricts(accounts.getState_id()));
		Map<Integer,String> districtList = new LinkedHashMap<Integer,String>();
		for(DistrictBean districtBean:districtsListBean)
		{
			districtList.put(districtBean.getDistrict_id(), districtBean.getDistrict_name());
		}
		//List<PhoneBean> phoneList=preparePhoneList(accountPhoneService.listAccountPhones());
//		model.addAttribute("phoneList", phoneList);
		List<PhoneBean> phoneList=preparePhoneBeanList(phoneService.listPhones(),accountsBean.getAccount_id());
		List<EmailBean> emailList=prepareEmailBeanList(emailService.listEmail(),accountsBean.getAccount_id());
		model.addAttribute("phoneList", phoneList);
		model.addAttribute("emailList", emailList);
		model.addAttribute("accountTypeList", prepareAccountTypeList(accountTypeService.listAccountTypes()));
		model.addAttribute("stateList", prepareStateBeanListL(stateService.listStates()));
		model.addAttribute("routeCodeList", PrepareRouteCodeBeanList(routeCodeService.listRouteCodes()));
		model.addAttribute("districtList", districtList);
		model.addAttribute("accounts", accounts);
		return new ModelAndView("accounts");
	}
	

    private List<EmailBean> prepareEmailBeanList(List<Email> listEmail, Integer account_id) {
    	List<EmailBean> emailBeanList=new ArrayList<EmailBean>();
    	for(Email email:listEmail)
    	{
    		System.out.println("email account id: "+email.getAccount_id());
    	if(email.getAccount_id().equals(account_id))
    	{
    		EmailBean emailBean=new EmailBean();
    		emailBean.setAccount_id(Integer.toString(account_id));
    		emailBean.setEmail_id(Integer.toString(email.getEmail_id()));
    		emailBean.setEmail(email.getEmail());
    		emailBean.setEmail_type(email.getEmail_type());
    		emailBeanList.add(emailBean);
    	}
    	}
		return emailBeanList;
	}

	private List<PhoneBean> preparePhoneBeanList(List<Phone> listPhones, Integer account_id) {
	    List<PhoneBean> phoneBeanList=new ArrayList<PhoneBean>();
	    if(listPhones !=null && !listPhones.isEmpty())
	    {
	    for(Phone phone:listPhones)
	    {
	    	if(phone.getAccount_id().equals(account_id))
	    	{
		    	PhoneBean phoneBean=new PhoneBean();
		    	phoneBean.setPhone_no(Long.toString(phone.getPhone_no()));
		    	phoneBean.setPhone_type(phone.getPhone_type());
		    	phoneBean.setPhone_id(Integer.toString(phone.getPhone_id()));
		    	phoneBeanList.add(phoneBean);	
	    	}
	    }
	    }
		return phoneBeanList;
	}

   private AccountsBean prepareAccountsBean(Accounts account) {
	   AccountsBean bean=new AccountsBean();
   	   bean.setAccount_id(account.getAccount_id());
   	   bean.setAccount_code(account.getAccount_code());
   	   System.out.println("account name:"+account.getAccount_name());
   	   bean.setAccount_name(account.getAccount_name());
   	   bean.setAccount_type_id(account.getAccount_type_id());
   	   bean.setContact_person(account.getContact_person());
       bean.setHouse_no(account.getHouse_no());
   	   bean.setStreet_name(account.getStreet_name());
   	   bean.setArea(account.getArea());
   	   bean.setState_id(account.getState_id());
   	   bean.setDistrict_id(account.getDistrict_id());
   	   bean.setPin_code(account.getPin_code());
   	   bean.setRoute_code_id(account.getRoute_code_id());
   	   bean.setApgst_no(account.getApgst_no());
   	   bean.setCst_no(account.getCst_no());
   	   bean.setPan_no(account.getPan_no());
   	   bean.setVat_no(account.getVat_no());
   	   bean.setTin_no(account.getTin_no());
   	   bean.setPl_no(account.getPl_no());
   	   bean.setCredit_limit(account.getCredit_limit());
   	   bean.setCredit_days(account.getCredit_days());
	   return bean;
	}

    private Object prepareAccountsBeanList(List<Accounts> listAccounts) {
	    List<AccountsBean> beans=new ArrayList<AccountsBean>();
	    for(Accounts account:listAccounts)
	    {
	    	AccountsBean bean=new AccountsBean();
	    	bean.setAccount_id(account.getAccount_id());
	    	bean.setAccount_name(account.getAccount_name());
	    	bean.setAccount_type_id(account.getAccount_type_id());
	    	bean.setContact_person(account.getContact_person());
	    	bean.setHouse_no(account.getHouse_no());
	    	bean.setStreet_name(account.getStreet_name());
	    	bean.setArea(account.getArea());
	    	bean.setState_id(account.getState_id());
	    	bean.setDistrict_id(account.getDistrict_id());
	    	bean.setPin_code(account.getPin_code());
	    	bean.setRoute_code_id(account.getRoute_code_id());
	    	bean.setApgst_no(account.getApgst_no());
	    	bean.setCst_no(account.getCst_no());
	    	bean.setPan_no(account.getPan_no());
	    	bean.setVat_no(account.getVat_no());
	    	bean.setTin_no(account.getTin_no());
	    	bean.setPl_no(account.getPl_no());
	    	bean.setCredit_limit(account.getCredit_limit());
	    	bean.setCredit_days(account.getCredit_days());
	    	beans.add(bean);
	    }
		return beans;
	}

   private Accounts prepareAccount(AccountsBean accountsBean) {
	    Accounts account=new Accounts();
	    account.setAccount_id(accountsBean.getAccount_id());
	    account.setAccount_code(accountsBean.getAccount_code());
	    account.setAccount_name(accountsBean.getAccount_name());
	    account.setAccount_type_id(accountsBean.getAccount_type_id());
	    account.setContact_person(accountsBean.getContact_person());
	    account.setHouse_no(accountsBean.getHouse_no());
	    account.setStreet_name(accountsBean.getStreet_name());
	    account.setArea(accountsBean.getArea());
	    account.setState_id(accountsBean.getState_id());
	    account.setDistrict_id(accountsBean.getDistrict_id());
	    account.setPin_code(accountsBean.getPin_code());
	    account.setRoute_code_id(accountsBean.getRoute_code_id());
	    account.setApgst_no(accountsBean.getApgst_no());
	    account.setCst_no(accountsBean.getCst_no());
	    account.setPan_no(accountsBean.getPan_no());
	    account.setVat_no(accountsBean.getVat_no());
	    account.setTin_no(accountsBean.getTin_no());
	    account.setPl_no(accountsBean.getPl_no());
	    account.setCredit_limit(accountsBean.getCredit_limit());
	    account.setCredit_days(accountsBean.getCredit_days());
		return account;
	}

     private Object PrepareRouteCodeBeanList(List<RouteCode> listRouteCodes) {
	    Map<Integer,String> routeCodeList = new LinkedHashMap<Integer,String>();
		for(RouteCode routeCode:listRouteCodes)
		{
			routeCodeList.put(routeCode.getRoute_code_id(), routeCode.getRoute_code_name());
		}
		return routeCodeList;
	}

	private Object prepareAccountTypeList(List<AccountType> listAccountTypes) {
		Map<Integer,String> accountTypeList = new LinkedHashMap<Integer,String>();
		for(AccountType accountType:listAccountTypes)
		{
			accountTypeList.put(accountType.getAccount_type_id(), accountType.getAccount_type_name());
		}
		return accountTypeList;
	}

	@RequestMapping(value = "/journalVouchersEntry", method = RequestMethod.POST)
	public ModelAndView journalVoucher() {
		return new ModelAndView("journalVouchersEntry");
	}
	
	@RequestMapping(value = "/productOpeningStockEntry", method = RequestMethod.POST)
	public ModelAndView productOpeningStockEntry(@ModelAttribute("productOpeningStock") ProductOpeningStockBean productOpeningStockBean,Model model) {
		model.addAttribute("productOpeningStock", new ProductOpeningStock());
		return new ModelAndView("productOpeningStockEntry");
	}
	
	@RequestMapping(value = "/saveProductOpeningStockEntry", method = RequestMethod.POST)
	public ModelAndView saveProductOpeningStockEntry(@ModelAttribute("productOpeningStock") ProductOpeningStockBean productOpeningStockBean,
			BindingResult result,Model model) {
		ProductOpeningStock productOpeningStock=prepareProductOpeningStock(productOpeningStockBean);
		productOpeningStockService.addProductOpeningStock(productOpeningStock);
		return new ModelAndView("productOpeningStockEntry");
	}
	
	@RequestMapping(value = "/editProductOpeningStockEntry", method = RequestMethod.POST)
	public ModelAndView editProductOpeningStockEntry(@ModelAttribute("productOpeningStock") ProductOpeningStockBean productOpeningStockBean,
			BindingResult result,Model model) {
		ProductOpeningStockBean productOpeningStock=prepareProductOpeningStockBean(productOpeningStockService.getProductOpeningStock(productOpeningStockBean.getProduct_opening_stock_id()));
		model.addAttribute("productOpeningStock", productOpeningStock);
		return new ModelAndView("productOpeningStockEntry");
	}
	
	@RequestMapping(value = "/deleteProductOpeningStockEntry", method = RequestMethod.POST)
	public ModelAndView deleteProductOpeningStockEntry(@ModelAttribute("productOpeningStock") ProductOpeningStockBean productOpeningStockBean,
			BindingResult result,Model model) {
		productOpeningStockService.deleteProductOpeningStock(productOpeningStockBean.getProduct_opening_stock_id());
		List<ProductOpeningStockBean> productOpeningStockList=prepareProductOpeningStockBean(productOpeningStockService.listProductOpeningStocks());
		model.addAttribute("productOpeningStockList", productOpeningStockList);
		return new ModelAndView("productOpeningStockEntryList");
	}
	
	@RequestMapping(value = "/productOpeningStockEntryList", method = RequestMethod.POST)
	public ModelAndView productOpeningStockEntryList(@ModelAttribute("productOpeningStock") ProductOpeningStockBean productOpeningStockBean,
			BindingResult result,Model model) {
		List<ProductOpeningStockBean> productOpeningStockList=prepareProductOpeningStockBean(productOpeningStockService.listProductOpeningStocks());
		model.addAttribute("productOpeningStockList", productOpeningStockList);
		return new ModelAndView("productOpeningStockEntryList");
	}
	
	@RequestMapping(value="/getProductName", method = RequestMethod.POST)
	public @ResponseBody void getProductName(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out=response.getWriter();
//		System.out.println("Value from jquery: "+request.getParameter("name"));
		String product_code=request.getParameter("product_code");
		System.out.println("product_code: "+product_code);
		List<ProductBean> country=new ArrayList<ProductBean>();
		country=prepareListofProductBean(productService.listProducts(product_code));
		JsonArray jsonArray = null;
		if(country != null && !country.isEmpty())
		{
			Gson gson = new Gson();
			JsonElement element = gson.toJsonTree(country, new TypeToken<List<Product>>() {}.getType());
			jsonArray = element.getAsJsonArray();
			response.setContentType("application/json");
			System.out.println(jsonArray);
			out.print(jsonArray);
		} 
		else{
			jsonArray=new JsonArray();
			out.print(jsonArray);	
		}
		
	}
	private List<ProductOpeningStockBean> prepareProductOpeningStockBean(
			List<ProductOpeningStock> listProductOpeningStocks) {
		List<ProductOpeningStockBean> beans=new ArrayList<ProductOpeningStockBean>();
		for(ProductOpeningStock productOpeningStock:listProductOpeningStocks)
		{
			ProductOpeningStockBean bean=new ProductOpeningStockBean();
			bean.setProduct_opening_stock_id(productOpeningStock.getProduct_opening_stock_id());
			bean.setProduct_code(productOpeningStock.getProduct_code());
			bean.setProduct_name(productOpeningStock.getProduct_name());
			bean.setBatch_no(productOpeningStock.getBatch_no());
			bean.setMfg_date(productOpeningStock.getMfg_date());
			bean.setExp_date(productOpeningStock.getExp_date());
			bean.setOpening_qty(productOpeningStock.getOpening_qty());
			bean.setOpening_rate(productOpeningStock.getOpening_rate());
			System.out.println("data: "+bean.getOpening_qty());
            beans.add(bean);			
		}
		return beans;
	}

	private ProductOpeningStockBean prepareProductOpeningStockBean(ProductOpeningStock productOpeningStock) {
		ProductOpeningStockBean bean=new ProductOpeningStockBean();
		bean.setProduct_opening_stock_id(productOpeningStock.getProduct_opening_stock_id());
		bean.setProduct_code(productOpeningStock.getProduct_code());
		bean.setProduct_name(productOpeningStock.getProduct_name());
		bean.setBatch_no(productOpeningStock.getBatch_no());
		bean.setMfg_date(productOpeningStock.getMfg_date());
		bean.setExp_date(productOpeningStock.getExp_date());
		bean.setOpening_qty(productOpeningStock.getOpening_qty());
		bean.setOpening_rate(productOpeningStock.getOpening_rate());
		return bean;
	}

	private ProductOpeningStock prepareProductOpeningStock(ProductOpeningStockBean productOpeningStockBean) {
		ProductOpeningStock productOpeningStock=new ProductOpeningStock();
		productOpeningStock.setProduct_opening_stock_id(productOpeningStockBean.getProduct_opening_stock_id());
		productOpeningStock.setProduct_code(productOpeningStockBean.getProduct_code());
		productOpeningStock.setProduct_name(productOpeningStockBean.getProduct_name());
		productOpeningStock.setBatch_no(productOpeningStockBean.getBatch_no());
		productOpeningStock.setMfg_date(productOpeningStockBean.getMfg_date());
		productOpeningStock.setExp_date(productOpeningStockBean.getExp_date());
		productOpeningStock.setOpening_qty(productOpeningStockBean.getOpening_qty());
		productOpeningStock.setOpening_rate(productOpeningStockBean.getOpening_rate());
		return productOpeningStock;
	}

	
		
	@RequestMapping(value="/catagory", method= RequestMethod.POST)
	public ModelAndView Catagory(@ModelAttribute("catagory") CatagoryBean catagoryBean){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("catagory", new Catagory());
		return new ModelAndView("catagory",model);
	} 
	
	@RequestMapping(value="/saveCatagory", method= RequestMethod.POST)
	public ModelAndView saveCatagory(@ModelAttribute("catagory") CatagoryBean catagoryBean){
//		Map<String, Object> model = new HashMap<String, Object>();
		Catagory catagory=prepareModel(catagoryBean);
		catagoryService.addCatagory(catagory);
//		model.put("catagory", new Catagory());
//		model.put("catagoryList", prepareListCatagoryBean(catagoryService.listCatagory()));
		return new ModelAndView("redirect:catagory.html");
	} 
	
	@RequestMapping(value="/catagoryList", method= RequestMethod.POST)
	public ModelAndView listCatagory(@ModelAttribute("catagory") CatagoryBean catagoryBean){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("catagoryList", prepareListCatagoryBean(catagoryService.listCatagory()));
		return new ModelAndView("catagoryList",model);
	} 
	
	@RequestMapping(value="/deleteCatagory", method= RequestMethod.POST)
	public ModelAndView deleteCatagory(@ModelAttribute("catagory") CatagoryBean catagoryBean){
		Map<String, Object> model = new HashMap<String, Object>();
		catagoryService.deleteCatagory(catagoryBean.getCatagory_id());
		model.put("catagoryList", prepareListCatagoryBean(catagoryService.listCatagory()));
		return new ModelAndView("catagoryList",model);
	} 

	@RequestMapping(value="/editCatagory", method= RequestMethod.POST)
	public ModelAndView editCatagory(@ModelAttribute("catagory") CatagoryBean catagoryBean){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("catagory", PrepareCatagoryBean(catagoryService.getCatagory(catagoryBean.getCatagory_id())));
//		model.put("catagoryList", prepareListCatagory(catagoryService.listCatagory()));
		return new ModelAndView("catagory",model);
	} 
	
	private Catagory PrepareCatagoryBean(Catagory catagory) {
		CatagoryBean catagoryBean=new CatagoryBean();
		catagoryBean.setCatagory_id(catagory.getCatagory_id());
		catagoryBean.setCatagory_name(catagory.getCatagory_name());
		return catagory;
	}

	
	private Object prepareListCatagoryBean(List<Catagory> listCatagory) {
	 	List<CatagoryBean> listCatagoryBean=new ArrayList<CatagoryBean>();
		for(Catagory catagory:listCatagory)
		{
			CatagoryBean catagoryBean=new CatagoryBean();
			catagoryBean.setCatagory_id(catagory.getCatagory_id());
			catagoryBean.setCatagory_name(catagory.getCatagory_name());
			System.out.println(catagory.getCatagory_id()+"id");
			System.out.println(catagory.getCatagory_name()+"name");
			listCatagoryBean.add(catagoryBean);
		}
		return listCatagoryBean;
	}

	private Catagory prepareModel(CatagoryBean catagoryBean) {
		Catagory catagory=new Catagory();
		catagory.setCatagory_id(catagoryBean.getCatagory_id());
		catagory.setCatagory_name(catagoryBean.getCatagory_name());
		return catagory;
	}

	@RequestMapping(value="/accountType", method= RequestMethod.POST)
	public ModelAndView accountType(@ModelAttribute("accountType") AccountTypeBean accountTypeBean){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("accountType", new AccountType());
		return new ModelAndView("accountType",model);
	} 
	
	@RequestMapping(value="/saveAccountType", method= RequestMethod.POST)
	public ModelAndView saveAccountType(@ModelAttribute("accountType") AccountTypeBean accountTypeBean){
		AccountType accountType=prepareAccountType(accountTypeBean);
		accountTypeService.addAccountType(accountType);
		return new ModelAndView("redirect:accountType.html");
	} 
	
	@RequestMapping(value="/editAccountType", method= RequestMethod.POST)
	public ModelAndView editAccountType(@ModelAttribute("accountType") AccountTypeBean accountTypeBean){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("accountType", prepareAccountTypeBean(accountTypeService.getAccountType(accountTypeBean.getAccount_type_id())));
		return new ModelAndView("accountType",model);
	} 
	
	@RequestMapping(value="/accountTypeList", method= RequestMethod.POST)
	public ModelAndView accountTypeList(@ModelAttribute("accountType") AccountType accountType){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("accountTypeList", prepareAccountTypeBeanList(accountTypeService.listAccountTypes()));
		return new ModelAndView("accountTypeList",model);
	} 
	
	@RequestMapping(value="/deleteAccountType", method= RequestMethod.POST)
	public ModelAndView deleteAccountType(@ModelAttribute("accountType") AccountTypeBean accountTypeBean){
		Map<String, Object> model = new HashMap<String, Object>();
		accountTypeService.deleteAccountType(accountTypeBean.getAccount_type_id());
		model.put("accountTypeList", prepareAccountTypeBeanList(accountTypeService.listAccountTypes()));
		return new ModelAndView("accountTypeList",model);
	} 
	
	private List<AccountTypeBean> prepareAccountTypeBeanList(List<AccountType> listAccountTypes) {
		List<AccountTypeBean> accountTypeBeanList=null;
		if(listAccountTypes != null && !listAccountTypes.isEmpty())
		{
			accountTypeBeanList=new ArrayList<AccountTypeBean>();
			for(AccountType accountType:listAccountTypes)
			{
				AccountTypeBean accountTypeBean=new AccountTypeBean();
				accountTypeBean.setAccount_type_id(accountType.getAccount_type_id());
				accountTypeBean.setAccount_type_name(accountType.getAccount_type_name());
				accountTypeBeanList.add(accountTypeBean);
			}
		}
		return accountTypeBeanList;
	}

	private AccountTypeBean prepareAccountTypeBean(AccountType accountType) {
		AccountTypeBean accountTypeBean=new AccountTypeBean();
		accountTypeBean.setAccount_type_id(accountType.getAccount_type_id());
		accountTypeBean.setAccount_type_name(accountType.getAccount_type_name());
		return accountTypeBean;
	}

	private AccountType prepareAccountType(AccountTypeBean accountTypeBean) {
		AccountType accountType=new AccountType();
		accountType.setAccount_type_id(accountTypeBean.getAccount_type_id());
		accountType.setAccount_type_name(accountTypeBean.getAccount_type_name());
		return accountType;
	}

	@RequestMapping(value="/district", method= RequestMethod.POST)
	public ModelAndView district(@ModelAttribute("district") DistrictBean districtBean){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stateList", prepareStateBeanListL(stateService.listStates()));
		model.put("district", new District());
		return new ModelAndView("district",model);
	} 
	
	private Object prepareStateBeanListL(List<State> listStates) {
		Map<Integer, String> stateList= new LinkedHashMap<Integer, String>();
		for(State state:listStates)
		{
			stateList.put(state.getState_id(),state.getState_name());
		}
		return stateList;
	}

	/*private Object prepareStateList(List<Catagory> listCatagory) {
		Map<Integer,String> catagoryList = new LinkedHashMap<Integer,String>();
		for(Catagory catgory:listCatagory)
		{
			catagoryList.put(catgory.getCatagory_id(),catgory.getCatagory_name());
		}
		return catagoryList;
	}*/
	
	@RequestMapping(value="/saveDistrict", method= RequestMethod.POST)
	public ModelAndView saveDistrict(@ModelAttribute("district") DistrictBean districtBean){
		District district=prepareDistrict(districtBean);
		districtService.addDistrict(district);
		return new ModelAndView("redirect:district.html");
	} 
	

	@RequestMapping(value="/districtList", method= RequestMethod.POST)
	public ModelAndView districtList(@ModelAttribute("district") DistrictBean districtBean){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("districtList", prepareDistrictListBean(districtService.listDistricts()));
		return new ModelAndView("districtList",model);
	} 
	
	@RequestMapping(value="/deleteDistrict", method= RequestMethod.POST)
	public ModelAndView deleteDistrict(@ModelAttribute("district") DistrictBean districtBean){
		districtService.deleteDistrict(districtBean.getDistrict_id());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("districtList", prepareDistrictListBean(districtService.listDistricts()));
		return new ModelAndView("districtList",model);
	} 
	
	@RequestMapping(value="/editDistrict", method= RequestMethod.POST)
	public ModelAndView editDistrict(@ModelAttribute("district") DistrictBean districtBean,BindingResult result, Model model1){
		//model.put("stateList", prepareStateBeanListKey(stateService.listStates()));
//		model.put("district", prepareDistrictListBean(districtService.getDistrict(districtBean.getDistrict_id())));
		model1.addAttribute("stateList", prepareStateBeanListKey(stateService.listStates()));
		model1.addAttribute("district", prepareDistrictListBean(districtService.getDistrict(districtBean.getDistrict_id())));
		return new ModelAndView("district");
	} 
	
	private Object prepareStateBeanListKey(List<State> listStates) {
		Map<Integer,String> stateList = new LinkedHashMap<Integer,String>();
		for(State state:listStates)
		{
		   stateList.put(state.getState_id(), state.getState_name());	
		}
		return stateList;
	}

	private DistrictBean prepareDistrictListBean(District district) {
		DistrictBean districtBean=new DistrictBean();
		districtBean.setState_id(district.getState_id());
		System.out.println("state Id is: "+district.getState_id());
		districtBean.setDistrict_id(district.getDistrict_id());
		districtBean.setDistrict_name(district.getDistrict_name());
	    return districtBean;
	}

	private List<DistrictBean> prepareDistrictListBean(List<District> listDistricts) {
		List<DistrictBean> districtBeanList=new ArrayList<DistrictBean>();
		for(District district:listDistricts)
		{
			DistrictBean districtBean=new DistrictBean();
			districtBean.setDistrict_id(district.getDistrict_id());
			districtBean.setDistrict_name(district.getDistrict_name());
			districtBean.setState_id(district.getState_id());
			districtBeanList.add(districtBean);
		}
		return districtBeanList;
	}

	private District prepareDistrict(DistrictBean districtBean) {
		District district=new District();
		district.setDistrict_id(districtBean.getDistrict_id());
		district.setDistrict_name(districtBean.getDistrict_name());
		district.setState_id(districtBean.getState_id());
		return district;
	}
	
	@RequestMapping(value="/state", method= RequestMethod.POST)
	public ModelAndView state(@ModelAttribute("state") StateBean stateBean){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("state", new State());
		return new ModelAndView("state",model);
	} 
	
	@RequestMapping(value="/saveState", method= RequestMethod.POST)
	public ModelAndView saveState(@ModelAttribute("state") StateBean stateBean){
		State state=prepareState(stateBean);
		stateService.addState(state);
		return new ModelAndView("redirect:state.html");
	} 
	
	@RequestMapping(value="/editState", method= RequestMethod.POST)
	public ModelAndView editState(@ModelAttribute("state") StateBean stateBean){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("state", prepareStateBean(stateService.getState(stateBean.getState_id())));
		return new ModelAndView("state",model);
	} 
	
	@RequestMapping(value="/deleteState", method= RequestMethod.POST)
	public ModelAndView deleteState(@ModelAttribute("state") StateBean stateBean){
		Map<String, Object> model = new HashMap<String, Object>();
		stateService.deleteState(stateBean.getState_id());
		model.put("stateList", prepareStateBeanList(stateService.listStates()));
		return new ModelAndView("stateList",model);
	} 
	
	@RequestMapping(value="/stateList", method= RequestMethod.POST)
	public ModelAndView stateList(@ModelAttribute("state") StateBean stateBean){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stateList", prepareStateBeanList(stateService.listStates()));
		return new ModelAndView("stateList",model);
	} 
	
	private List<StateBean> prepareStateBeanList(List<State> listStates) {
		List<StateBean> stateBeanList=new ArrayList<StateBean>();
		for(State state:listStates)
		{
			StateBean stateBean=new StateBean();
			stateBean.setState_id(state.getState_id());
			stateBean.setState_name(state.getState_name());
			stateBeanList.add(stateBean);
		}
		return stateBeanList;
	}

	private StateBean prepareStateBean(State state) {
		StateBean stateBean=new StateBean();
		stateBean.setState_id(state.getState_id());
		stateBean.setState_name(state.getState_name());
		return stateBean;
	}

	private State prepareState(StateBean stateBean) {
		State state=new State();
		state.setState_id(stateBean.getState_id());
		state.setState_name(stateBean.getState_name());
		return state;
	}
	

	@RequestMapping(value="/routeCode", method= RequestMethod.POST)
	public ModelAndView routeCode(@ModelAttribute("routeCode") RouteCodeBean routeCodeBean){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("routeCode", new RouteCode());
		return new ModelAndView("routeCode",model);
	} 
	
	@RequestMapping(value="/saveRouteCode", method= RequestMethod.POST)
	public ModelAndView saveRouteCode(@ModelAttribute("routeCode") RouteCodeBean routeCodeBean,
			BindingResult result){
		System.out.println("route code Id: "+routeCodeBean.getRoute_code_id());
		System.out.println("Route Code Name: "+routeCodeBean.getRoute_code_name());
		RouteCode routeCode=new RouteCode();
		routeCode.setRoute_code_id(routeCodeBean.getRoute_code_id());
		routeCode.setRoute_code_name(routeCodeBean.getRoute_code_name());
		System.out.println("Rote code from route: "+routeCode.getRoute_code_name());
		routeCodeService.addRouteCode(routeCode);
		return new ModelAndView("redirect:routeCode.html");
	} 

	@RequestMapping(value="/editRouteCode", method= RequestMethod.POST)
	public ModelAndView editRouteCode(@ModelAttribute("routeCode") RouteCodeBean routeCodeBean){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("routeCode", prepareRouteCodeBean(routeCodeService.getRouteCode(routeCodeBean.getRoute_code_id())));
		return new ModelAndView("routeCode",model);
	} 
	
	@RequestMapping(value="/deleteRouteCode", method= RequestMethod.POST)
	public ModelAndView deleteRouteCode(@ModelAttribute("routeCode") RouteCodeBean routeCodeBean){
		routeCodeService.deleteRouteCode(routeCodeBean.getRoute_code_id());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("routeCodeList", prepareRouteCodeBeanList(routeCodeService.listRouteCodes()));
		return new ModelAndView("routeCodeList",model);
	} 
	
	@RequestMapping(value="/routeCodeList", method= RequestMethod.POST)
	public ModelAndView routeCodeList(@ModelAttribute("routeCode") RouteCodeBean routeCodeBean){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("routeCodeList", prepareRouteCodeBeanList(routeCodeService.listRouteCodes()));
		return new ModelAndView("routeCodeList",model);
	} 
	
	private List<RouteCodeBean> prepareRouteCodeBeanList(List<RouteCode> listRouteCodes) {
		List<RouteCodeBean> routeCodeBeanList=new ArrayList<RouteCodeBean>();
		for(RouteCode routeCode:listRouteCodes)
		{
			RouteCodeBean routeCodeBean=new RouteCodeBean();
			routeCodeBean.setRoute_code_id(routeCode.getRoute_code_id());
			routeCodeBean.setRoute_code_name(routeCode.getRoute_code_name());
			routeCodeBeanList.add(routeCodeBean);
		}
		return routeCodeBeanList;
	}

	private RouteCodeBean prepareRouteCodeBean(RouteCode routeCode) {
		RouteCodeBean routeCodeBean=new RouteCodeBean();
		routeCodeBean.setRoute_code_id(routeCode.getRoute_code_id());
		routeCodeBean.setRoute_code_name(routeCode.getRoute_code_name());
		return routeCodeBean;
	}


	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public ModelAndView welcome() {
		/*logger.info("This is an info log entry");
		logger.error("This is an error log entry");*/
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		/*logger.info("This is an info log entry");
		logger.error("This is an error log entry");*/
		return new ModelAndView("loginPage");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user") UserBean userBean,BindingResult result,Model model,HttpServletRequest request) {
		List<User> user=userService.listUser();
		String authenticate=validateAuthenticate(userBean,user);
		if(authenticate.equalsIgnoreCase("success"))
		{
			authenticate="index";
			HttpSession userSession=request.getSession();
			userSession.setAttribute("userAkshara", userBean.getUser_name());
//			model.addAttribute("index", new Tender());
		}else
		{
			authenticate="loginPage";
			model.addAttribute("error", "Incorrect User Name and Password");
		}
		/*logger.info("This is an info log entry");
		logger.error("This is an error log entry");*/
		return new ModelAndView(authenticate);
	}
	
	private String validateAuthenticate(UserBean userBean, List<User> users) {
		String message="fail";
		for(User user: users)
		{
			if(userBean.getUser_name().equalsIgnoreCase(user.getUser_name())&&userBean.getPassword().equalsIgnoreCase(user.getPassword()))
			{
			 message="success";
			}
		}
		return message;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logOut(Model model,HttpServletRequest request) {

		HttpSession userSession=request.getSession();
		userSession.removeAttribute("userAkshara");
		userSession.invalidate();
		model.addAttribute("message","You Sucessfully Logged out! Sign in to continue");
		return new ModelAndView("loginPage");
	}
	
	@RequestMapping(method= RequestMethod.GET)
    public ModelAndView get(Model model) {
       model.addAttribute("warning","Unable to access page please sign in to continue !");
       return new ModelAndView("loginPage"); 
     }
	

	
	
	@RequestMapping(value="/getDistricts", method = RequestMethod.POST)
	public @ResponseBody void pay(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out=response.getWriter();
		 String state_id=request.getParameter("state_id");
		 Map<Integer,String> districts = new LinkedHashMap<Integer,String>();
		 List<DistrictBean> districtList=prepareDistrictListBean(districtService.listDistricts(Integer.parseInt(state_id)));
		 for(DistrictBean districtBean:districtList)
		 {
			districts.put(districtBean.getDistrict_id(), districtBean.getDistrict_name());
		 }
		 Gson gson = new Gson();
		 String json = gson.toJson(districts);
		 response.setContentType("application/json");
//		 System.out.println(json);
		 out.print(json);
	}
	


	@RequestMapping(value="/purchaseInvoiceEntry", method = RequestMethod.POST)
	public ModelAndView purchaseInvoiceEntry(@ModelAttribute("materialReceivedEntry") MaterialReceivedEntry materialReceivedEntry ,
			BindingResult result,Model model) {
		model.addAttribute("materialReceivedEntry", new MaterialReceivedEntry());
		return new ModelAndView("purchaseInvoiceEntry");
	}
	
	@RequestMapping(value="/materialReceivedEntry", method = RequestMethod.POST)
	public ModelAndView materialReceivedEntry(@ModelAttribute("materialReceivedEntry") MaterialReceivedEntry materialReceivedEntry ,
			BindingResult result,Model model) {
		
		model.addAttribute("materialReceivedEntry", new MaterialReceivedEntry());
		return new ModelAndView("materialReceivedEntry");
	}
	
	@RequestMapping(value="/saveMaterialReceivedEntry", method = RequestMethod.POST)
	public ModelAndView saveMaterialReceivedEntry(@ModelAttribute("materialReceivedEntry") MaterialReceivedEntryBean materialReceivedEntryBean ,
			MaterialReceivedEntryProductBean materialReceivedEntryProductBean,BindingResult result,Model model) {
		MaterialReceivedEntry materialReceivedEntry=prepareMaterialReceivedEntryModel(materialReceivedEntryBean);
		materialReceivedEntryService.addMaterialReceivedEntry(materialReceivedEntry);
		String[] productIdList=materialReceivedEntryProductBean.getProduct_id().split(",");
		String[] rateList=materialReceivedEntryProductBean.getRate().split(",");
		String[] quantityList=materialReceivedEntryProductBean.getQuantity().split(",");
		String[] batchList=materialReceivedEntryProductBean.getBatch().split(",");
		String[] mfgdateList=materialReceivedEntryProductBean.getMfgdate().split(",");
		String[] expdateList=materialReceivedEntryProductBean.getExpdate().split(",");
		System.out.println("Length of products: "+productIdList.length);
		for(int i=0;i<productIdList.length;i++)
		{
			materialReceivedEntryProductBean.setProduct_id(productIdList[i]);
			materialReceivedEntryProductBean.setRate(rateList[i]);
			materialReceivedEntryProductBean.setQuantity(quantityList[i]);
			materialReceivedEntryProductBean.setBatch(batchList[i]);
			materialReceivedEntryProductBean.setMfgdate(mfgdateList[i]);
			materialReceivedEntryProductBean.setExpdate(expdateList[i]);
			MaterialReceivedEntryProduct product=prepareMaterialReceivedEntryProductModel(materialReceivedEntryProductBean);
			materialReceivedEntryProductService.addMaterialReceivedEntryProduct(product);
		}
		model.addAttribute("materialReceivedEntry", new MaterialReceivedEntry());
		return new ModelAndView("materialReceivedEntry");
	}
	
	
	private MaterialReceivedEntryProduct prepareMaterialReceivedEntryProductModel(
			MaterialReceivedEntryProductBean materialReceivedEntryProductBean) {
		    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		    MaterialReceivedEntryProduct model=new MaterialReceivedEntryProduct();
		    model.setProduct_id(Integer.parseInt(materialReceivedEntryProductBean.getProduct_id()));
		    model.setRate(Float.parseFloat(materialReceivedEntryProductBean.getRate()));
		    model.setQuantity(Long.parseLong(materialReceivedEntryProductBean.getQuantity()));
		    model.setBatch(materialReceivedEntryProductBean.getBatch());
		    try {
		    	System.out.println("Mfg Date: "+materialReceivedEntryProductBean.getMfgdate());
		    	System.out.println("Exp Date: "+materialReceivedEntryProductBean.getExpdate());
				model.setMfgdate(df.parse(materialReceivedEntryProductBean.getMfgdate()));
				model.setExpdate(df.parse(materialReceivedEntryProductBean.getExpdate()));
			} catch (Exception e) {
				System.out.println("Date parse Exception"+e);
				e.printStackTrace();
			}
		    
 		    return model;
	}

	private MaterialReceivedEntry prepareMaterialReceivedEntryModel(
			MaterialReceivedEntryBean materialReceivedEntryBean) {
		MaterialReceivedEntry model=new MaterialReceivedEntry();
		model.setMaterial_received_entry_id(materialReceivedEntryBean.getMaterial_received_entry_id());
		model.setSupplier_code(materialReceivedEntryBean.getSupplier_code());
		model.setDc_date(materialReceivedEntryBean.getDc_date());
		model.setDc_no(materialReceivedEntryBean.getDc_no());
		model.setVoucher_no(materialReceivedEntryBean.getVoucher_no());
		model.setTransaction_date(materialReceivedEntryBean.getTransaction_date());
		return model;
	}

	@RequestMapping(value="/materialRecievedEntryList", method = RequestMethod.POST)
	public ModelAndView materialReceivedEntryList(@ModelAttribute("materialReceivedEntry") MaterialReceivedEntry materialReceivedEntry ,
			BindingResult result,Model model) {
		List<MaterialReceivedEntryBean> beans=prepareMaterialReceivedEntryBeans(materialReceivedEntryService.listMaterialReceivedEntry());
		model.addAttribute("materialRecievedEntryList",beans);
		return new ModelAndView("materialReceivedEntryList");
	}

	private List<MaterialReceivedEntryBean> prepareMaterialReceivedEntryBeans(
			List<MaterialReceivedEntry> listMaterialReceivedEntry) {
		List<MaterialReceivedEntryBean> beans=new ArrayList<MaterialReceivedEntryBean>();
		for(MaterialReceivedEntry materialReceivedEntry:listMaterialReceivedEntry)
		{
			MaterialReceivedEntryBean bean=new MaterialReceivedEntryBean();
			bean.setMaterial_received_entry_id(materialReceivedEntry.getMaterial_received_entry_id());
//			System.out.println("Material Received Entry Id: "+materialReceivedEntry.getMaterial_received_entry_id());
			bean.setSupplier_code(materialReceivedEntry.getSupplier_code());
			bean.setSupplier_name(materialReceivedEntry.getSupplier_name());
			bean.setVoucher_no(materialReceivedEntry.getVoucher_no());
			bean.setTransaction_date(materialReceivedEntry.getTransaction_date());
			bean.setDc_no(materialReceivedEntry.getDc_no());
			bean.setDc_date(materialReceivedEntry.getDc_date());
			beans.add(bean);
		}
		return beans;
	}
	
	@RequestMapping(value="/getSupplierName", method = RequestMethod.POST)
	public @ResponseBody void getSupplierName(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out=response.getWriter();
//		System.out.println("Value from jquery: "+request.getParameter("name"));
		String product_code=request.getParameter("product_code");
		System.out.println("product_code: "+product_code);
		List<AccountsBean> country=new ArrayList<AccountsBean>();
		country=prepareListofAccountsBean(accountsService.listAccounts(product_code));
//		System.out.println("Data bean lIst: "+country);
		JsonArray jsonArray = null;
		if(country != null && !country.isEmpty())
		{
			Gson gson = new Gson();
			JsonElement element = gson.toJsonTree(country, new TypeToken<List<Accounts>>() {}.getType());
			jsonArray = element.getAsJsonArray();
			response.setContentType("application/json");
			System.out.println(jsonArray);
			out.print(jsonArray);
		} 
		else{
			jsonArray=new JsonArray();
			out.print(jsonArray);	
		}
		
	}

	private List<AccountsBean> prepareListofAccountsBean(List<Accounts> listAccounts) {
		List<AccountsBean> beans=new ArrayList<AccountsBean>();
	    for(Accounts account:listAccounts)
	    {
	    	AccountsBean bean=new AccountsBean();
	    	bean.setAccount_id(account.getAccount_id());
	    	bean.setAccount_code(account.getAccount_code());
	    	bean.setAccount_name(account.getAccount_name());
	    	bean.setAccount_type_id(account.getAccount_type_id());
	    	bean.setContact_person(account.getContact_person());
	    	bean.setHouse_no(account.getHouse_no());
	    	bean.setStreet_name(account.getStreet_name());
	    	bean.setArea(account.getArea());
	    	bean.setState_id(account.getState_id());
	    	bean.setDistrict_id(account.getDistrict_id());
	    	bean.setPin_code(account.getPin_code());
	    	bean.setRoute_code_id(account.getRoute_code_id());
	    	bean.setApgst_no(account.getApgst_no());
	    	bean.setCst_no(account.getCst_no());
	    	bean.setPan_no(account.getPan_no());
	    	bean.setVat_no(account.getVat_no());
	    	bean.setTin_no(account.getTin_no());
	    	bean.setPl_no(account.getPl_no());
	    	bean.setCredit_limit(account.getCredit_limit());
	    	bean.setCredit_days(account.getCredit_days());
	    	beans.add(bean);
	    }
		return beans;
	}


}
