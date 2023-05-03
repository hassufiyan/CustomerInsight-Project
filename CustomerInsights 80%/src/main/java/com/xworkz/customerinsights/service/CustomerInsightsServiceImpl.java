package com.xworkz.customerinsights.service;

import java.time.LocalTime;

import java.util.Date;
import java.util.Set;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.customerinsights.dao.CustomerInsightsDao;
import com.xworkz.customerinsights.dto.AccountStatus;
import com.xworkz.customerinsights.dto.CustomerInsightsDto;
import com.xworkz.customerinsights.entity.CustomerInsightsEntity;
import com.xworkz.customerinsights.util.EmailUtil;

import com.xworkz.customerinsights.util.PasswordEncryption;

@Service
public class CustomerInsightsServiceImpl implements CustomerInsightsService {

	private static final String LOGIN_FAILED = "LoginFailed";
	
	


	@Autowired
	CustomerInsightsDao dao;

	public CustomerInsightsServiceImpl() {
		System.out.println("CustomerInsights Service is running");
	}

	@Override
	public String save(CustomerInsightsDto dto, Model model) {
		if (dto != null) {

			if (dto.getPassword().equals(dto.getConfirmPassword())) {
				ValidatorFactory validaterFactory = Validation.buildDefaultValidatorFactory();
				Validator validator = validaterFactory.getValidator();
				Set<ConstraintViolation<CustomerInsightsDto>> validater = validator.validate(dto);
				if (validater != null) {
				
				CustomerInsightsEntity	isEmailIdExists = findByEmail(dto.getEmail(), model);
					if (isEmailIdExists!=null) {
						System.out.println("Email already exists");
						model.addAttribute("EmailInValid", "Email already exsists");
						System.out.println("Failed to create");
						model.addAttribute("Failed", "Account not created");
						
					} else {
						System.out.println("Email is valid");
						model.addAttribute("EmailValid", "Email is Valid");

						CustomerInsightsEntity entity = new CustomerInsightsEntity();
						BeanUtils.copyProperties(dto, entity);
						entity.getPassword();
//						calling encryption method,it will return encrpted pw,save it to entity...
//						after saving it to entity,while getting decrypt the pw...
//						String passwordEncryptor=dto.getPassword();
//						   Base64.Encoder encoder = Base64.getEncoder();
//						   String epw=encoder.encodeToString(passwordEncryptor.getBytes());
//						   System.out.println(epw);
//						   entity.setPassword(epw);
						String encryptedPassword = PasswordEncryption.encode(entity.getPassword());
						entity.setPassword(encryptedPassword);
						entity.setCreatedBy(dto.getFirstName());
						entity.setCreatedOn(LocalTime.now());
						entity.setWrongPasswordCount(0);
						entity.setAcc_Status(AccountStatus.UNBLOCKED.value);
						boolean res = dao.save(entity);
						mailSentSuccessfully(entity);
						model.addAttribute("mail","Mail sent successfully");
						if (res) {
							System.out.println("Account  is created");
							model.addAttribute("Success", "Account created Successfully");
							return "SignUp";

						}
					}
				}
					
					
				}
				

		else {
				System.out.println("Password doesnot match");
				model.addAttribute("Password", "password doesnot match");
				return "SignUp";
			}
		}
		return "SignUp";
	}


	@Override
	public CustomerInsightsEntity findByEmail(String email,Model model) {
		System.out.println("verifying email");
		if (email != null) {
			return dao.findByEmail(email);

		}
		return null;
	}
	
	@Override
	public String login(String email,String password, Model model) {
		if (email != null && password!=null) {
//			CustomerInsightsEntity entity = new CustomerInsightsEntity();
			int response = 0;
//			BeanUtils.copyProperties(dto, entity);
		CustomerInsightsEntity entity =findByEmail(email, model);
	String	encryptedPassword=	entity.getPassword();
			
			
		String	decryptedPassword=PasswordEncryption.decode(encryptedPassword);
		System.out.println(decryptedPassword);
				// boolean isValidPwd = false;
				
			
					int count=0;
					if(entity!=null) {
						if(decryptedPassword.equals(password)) {
							if(AccountStatus.UNBLOCKED.value.equals(entity.getAcc_Status())) {
//								entity.setWrongPasswordCount(0);
								count=entity.getWrongPasswordCount();
								if(count>=0) {
									response = updateByEmailId(entity.getEmail(),0, AccountStatus.UNBLOCKED.value);
									System.out.println("LoggedIn successfully and response is " + response);
									System.out.println(count + " a");
									model.addAttribute("Loggedin", "LoggedIn successfully");
									return "Welcome";								
									}
							}
						}
							else {
								if(AccountStatus.UNBLOCKED.value.equals(entity.getAcc_Status())) {
									count=entity.getWrongPasswordCount();
									if( count<2) {
										System.out.println(count + " B");
										response = updateByEmailId(entity.getEmail(),++count, AccountStatus.UNBLOCKED.value);	
										System.out.println("Login Failed due to invalid credentials! "+(3-count) + response);
//										model.addAttribute("Loggedin", "LoggedIn successfully");
										System.out.println("Logged Failed! and response is " + response);
										model.addAttribute(LOGIN_FAILED,
												"Login Failed due to invalid credentials, " + (3 - count) + " attempts left");
										return "SignIn";
									}
									else {
										if(count>=2) {
											response = updateByEmailId(entity.getEmail(), ++count, AccountStatus.BLOCKED.value);
											System.out.println("Logged Failed!---> login attempts exceeded, " + response);
											model.addAttribute(LOGIN_FAILED,
													"Your account is locked out as the login attempts are exceeded");
										}
									}
									
										
									}
								else if(AccountStatus.BLOCKED.value.equals(entity.getAcc_Status())) {
									if(encryptedPassword.equals(password)) {
										entity.setAcc_Status(AccountStatus.UNBLOCKED.value);
									System.out.println("LoggedIn Failed and account is blocked and response is" + response);
									model.addAttribute("Failed", "Your account is blocked");
									return "SignIn";
									}
									else {
										System.out.println("LoggedIn Failed and account is blocked and response is" + response);
										model.addAttribute("Failed", "Your account is blocked");
										return "SignIn";
									}
								}
								}
										
									}
					else {
						System.out.println("Email not found");
						model.addAttribute("entityNull","the given email Id doesnot exsist");
						return "SignIn";
					}
					
			}
		
		System.out.println("here");
		return "SignIn";
	}
//								else if(count<=2) {
//									System.out.println(count + " B");
//									response = updateByEmailId(entity.getEmail(),0, AccountStatus.UNBLOCKED.value);	
////									System.out.println("LoggedIn successfully and response is a" + response);
////									model.addAttribute("Loggedin", "LoggedIn successfully");
//									System.out.println("Logged Failed! and response is " + response);
//									model.addAttribute(LOGIN_FAILED,
//											"Login Failed due to invalid credentials, " + (3 - count) + " attempts left");
//									return "Welcome";
//								}
//							}
//								 if(AccountStatus.BLOCKED.value.equals(entity.getAcc_Status())) {
//									if(count==0) {
//									System.out.println(count + " C");
//									response = updateByEmailId(entity.getEmail(),0, AccountStatus.UNBLOCKED.value);	
//									System.out.println("LoggedIn Failed and account is blocked and response is" + response);
//									model.addAttribute("Failed", "Your account is blocked");
//									return "SignIn";
//								}
//									else if(AccountStatus.BLOCKED.value.equals(entity.getAcc_Status())) {
//										if(count>=3) {
//											
//											response = updateByEmailId(entity.getEmail(), ++count, AccountStatus.BLOCKED.value);
//											System.out.println("Logged Failed!---> login attempts exceeded, " + response);
//											model.addAttribute(LOGIN_FAILED,
//													"Your account is locked out as the login attempts are exceeded");
//											
//										}
//									}
//								}
		
//						else {
//							if(AccountStatus.UNBLOCKED.value.equals(entity.getAcc_Status())) {
//								if(count<=2) {
//									System.out.println(count + " B");
//									response = updateByEmailId(entity.getEmail(),0, AccountStatus.UNBLOCKED.value);	
////									System.out.println("LoggedIn successfully and response is a" + response);
////									model.addAttribute("Loggedin", "LoggedIn successfully");
//									System.out.println("Logged Failed! and response is " + response);
//									model.addAttribute(LOGIN_FAILED,
//											"Login Failed due to invalid credentials, " + (3 - count) + " attempts left");
//									return "SignIn";
//								}
//								
//									
//								}
//							else {
//								if(count<=2) {
//									response = updateByEmailId(entity.getEmail(), ++count, AccountStatus.BLOCKED.value);
//									System.out.println("Logged Failed!---> login attempts exceeded, " + response);
//									model.addAttribute(LOGIN_FAILED,
//											"Your account is locked out as the login attempts are exceeded");
//									
//								}
//							}
//						}

							
//							
//							else {
//								if (entity.getWrongPasswordCount() != null && entity.getWrongPasswordCount()<=1) {
//									count = entity.getWrongPasswordCount();
//									response = updateByEmailId(entity.getEmail(), ++count,AccountStatus.UNBLOCKED.value);
//									System.out.println("1st response");
//									System.out.println("Logged Failed! and response is " + response);
//									model.addAttribute(LOGIN_FAILED,
//											"Login Failed due to invalid credentials, " + (3 - count) + " attempts left");
//								}
//								else if(entity.getWrongPasswordCount()>=2) {
//									
//									count = entity.getWrongPasswordCount();
//									response = updateByEmailId(entity.getEmail(), ++count, AccountStatus.BLOCKED.value);
//									System.out.println("Logged Failed!---> login attempts exceeded, " + response);
//									model.addAttribute(LOGIN_FAILED,
//											"Your account is locked out as the login attempts are exceeded");
//
//								}
//								}
//							}
//					
//						else {
//							System.out.println("Email not found");
//							model.addAttribute("entityNull","the given email Id doesnot exsist");
//							return "SignIn";
//						}
//						
//						}
//				}
				
		
	
//	}
							
//								int count1 = 0;
								
								
									
//								}
//						
//						else if(entity.getAcc_Status().equals(AccountStatus.BLOCKED.value)) {
//							System.out.println("Your account has been blocked");
//							model.addAttribute("Blocked", "Account blocked");
//							return "SignIn";
//						}
//					}
		
						
										 
									 
						
//						
								
		
						

		
		
//	@Override
//	public CustomerInsightsEntity findByEmailAndPassword(String email,String password) {
//			return dao.findByEmailAndPassword(email);
//	}

	@Override
	public int updateByEmailId(String email, int wpc,String status) {
			return dao.updateByEmailId(email, wpc,status);
	}


//	@Override
//	public CustomerInsightsEntity findByEmailAndPassword(String email, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public CustomerInsightsEntity findByEmailAndPassword(String email, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public int updateAccounStatusByEmail(String status, String email) {
//		return dao.updateAccounStatusByEmail(status,email);
//		
//	}
//	
	
	

	public void mailSentSuccessfully(CustomerInsightsEntity entity) {
		
		Session session = EmailUtil.sendMail();
		MimeMessage msg = new MimeMessage(session);

		 
		 try {

			
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			  msg.addHeader("format", "flowed");
			  
		      msg.addHeader("Content-Transfer-Encoding", "8bit");
		      
		      msg.setFrom(new InternetAddress("hasansufiyan037@outlook.com"));
		      
		      msg.setReplyTo(InternetAddress.parse("no-reply@gmail.com"));

		      msg.setSubject("CustomerInsights", "Success");

		      msg.setText("Message ffrom CustomerInsights", "Hey "+entity.getFirstName()+" your account has been created successfully");
		      msg.setText("Hi, "+entity.getFirstName()+" ,Email Sent Succssfully");

		      msg.setSentDate(new Date());

		      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(entity.getEmail(),true));
		      System.out.println("Message is ready");
	    	  Transport.send(msg);  

		      System.out.println("Email Sent Successfully!!");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

	@Override
	public String forgotPassword(String email,Model model) {
		if(email!=null) {
CustomerInsightsEntity entity=findByEmail(email, model);
if(entity!=null) {
	System.out.println("Email found");
	System.out.println(email);
//	int res=GenerateOtp.generateOTP();
//	System.out.println(res);
	int otp=generateOtp();
	System.out.println(otp);
	  	

updateOtpByEmail(otp, email);
System.out.println("updated successfully");	
//sendOtpByEmail(email,otp);
System.out.println("otp sent successfully to your mail");
model.addAttribute("otpSuccess","OTP sent successfully");
model.addAttribute("getEmail",entity.getEmail());
String eid=entity.getEmail();
//return "EnterOtp";
//return "ForgotPassword";
return eid;

}
else {
	System.out.println("email is null");
	model.addAttribute("enull","Email is not entred,please check");
	return null;
}

		}
		return null;
	}

		@Override
		public int generateOtp() {
		int otp   =(int) (Math.random()*900000)+100000;
 			return otp;
	}

	@Override
	public boolean updateOtpByEmail(int otp, String email) {
	boolean	res=dao. updateOtpByEmail(otp,email);
		return true;
	}

	@Override
	public boolean sendOtpByEmail(String email, int otp) {
		System.out.println("sending mail");
		Session session = EmailUtil.sendMail();
		MimeMessage msg = new MimeMessage(session);	 
		 try {
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			  msg.addHeader("format", "flowed");
//		      msg.addHeader("Content-Transfer-Encoding", "8bit");
		      msg.setFrom(new InternetAddress("hasansufiyan037@outlook.com"));
		      msg.setReplyTo(InternetAddress.parse("no-reply@gmail.com"));
		      msg.setSubject("CustomerInsights", "Success");
		      msg.setText( "OTP sent successfully");
		      msg.setText("Hi,your otp is "+otp);
		      msg.setSentDate(new Date());
		      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		      System.out.println("Message is ready");
	    	  Transport.send(msg);  
		      System.out.println("Email Sent Successfully!!");
		      return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public int getOtpByEmail(String email) {
		if(email!=null) {
		int	res=dao. getOtpByEmail(email);
		return res;
		}
		return 0;
	}

	@Override
	public boolean validateOtpByEmail(String email, int otp,Model model) {
		if(email!=null && otp>0) {
		int	res=getOtpByEmail(email);
		if(res==otp) {
			System.out.println("validated Successfully");
			model.addAttribute("otpValid","OTP has been validated successfully");
			return true;
		}
		else {
			System.out.println("OTP Valdiation falied");
			model.addAttribute("otpInvalid","Your etered OTP doesnot match,please check and re-enter the OTP");
		}
		}
		
		return false;
	}

	@Override
	public boolean resetPasswordByEmail(String email, String password, String confirmPassword, Model model,CustomerInsightsEntity entity) {
		int res=0;
		if(email!=null && password!=null && confirmPassword!=null) {
		if(password.equals(confirmPassword))	{
			System.out.println(password);
			System.out.println(confirmPassword);
				
			String	encodedPw=PasswordEncryption.encode(entity.getPassword());
			
			updatePasswordByEmail(email,encodedPw);
		
System.out.println(encodedPw);
	
			
	res=updateByEmailId(email, 0,AccountStatus.UNBLOCKED.value);
	System.out.println("Updated "+res);
	model.addAttribute("resetSuccess","Your password has benn reset successfully");
	return true;		
		}
		model.addAttribute("resetFailed","NewPasswrod doesnot match with Confirm Password");
		}
		else {
			System.out.println("Eneterd email is null");
			model.addAttribute("nullEmail","You have not eneterd the email");
		}
		return false;
	}

	@Override
	public boolean updatePasswordByEmail(String email, String password) {
		if(email!=null && password!=null) {
		 return dao.updatePasswordByEmail(email,password);
	}
	return false;	
	}

}

	


	
	

