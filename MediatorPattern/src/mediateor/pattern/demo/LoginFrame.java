package mediateor.pattern.demo;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Color;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueCheckbox checkMember;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueTextField textNumber;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;


    public LoginFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
 
        setLayout(new GridLayout(5, 3));
     
        createColleagues();
     
        add(checkGuest);
        add(checkLogin);
        add(checkMember);
        add(new Label("Username : "));
        add(textUser);
        add(new Label(""));
        add(new Label("Password : "));
        add(textPass);
        add(new Label(""));
        add(new Label("IDnumber : "));
        add(textNumber);
        add(new Label(""));
        add(buttonOk);
        add(buttonCancel);

        colleagueChanged();

        pack();
        show();
    }


    public void createColleagues() {
  
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);
        checkMember = new ColleagueCheckbox("Member", g, false);
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textNumber = new ColleagueTextField("", 13);
        textPass.setEchoChar('*');
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");
       
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        checkMember.setMediator(this);
        textUser. setMediator(this);
        textPass. setMediator(this);
        textNumber.setMediator(this);
        buttonOk. setMediator(this);
        buttonCancel.setMediator(this);
        
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        checkMember.addItemListener(checkMember);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        textNumber.addTextListener(textNumber);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    public void colleagueChanged() {                          
        if (checkGuest.getState()) { 
        	textUser.setText("");
        	textPass.setText("");
        	textNumber.setText("");
            textUser.setColleagueEnabled(false);                
            textPass.setColleagueEnabled(false);   
            textNumber.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);               
        } else if (checkLogin.getState()){ 						
            textUser.setColleagueEnabled(true);   
            textPass.setColleagueEnabled(false);
            textNumber.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
            userpassChanged();                              
        } else {
        	textUser.setColleagueEnabled(true);
        	textPass.setColleagueEnabled(true);
        	textNumber.setColleagueEnabled(true);
        	buttonOk.setColleagueEnabled(false);
        	usermemberChanged();
        }
    }                                                       

    private void userpassChanged() {
    	char tmp = 0;
        if (textUser.getText().length() > 0) { // 아이디 입력시
            textPass.setColleagueEnabled(true);
            if (textPass.getText().length() > 0) { // 아이디 + 비밀번호 입력
                textNumber.setColleagueEnabled(true);
                if (textNumber.getText().length() == 13) { // 아이디 + 비밀번호 + 주민번호 13자리 입력
                	for (int i=0; i<textNumber.getText().length(); i++) {
                		tmp = textNumber.getText().charAt(i);
                	}
                	if (Character.isDigit(tmp) == false) { // 아이디 + 비밀번호 + 주민번호 13자리, 숫자로 입력
                		buttonOk.setColleagueEnabled(true);
                	} else {
                		buttonOk.setColleagueEnabled(false); // 아이디 + 비밀번호 + 주민번호 13자리 숫자 아님 입력
                	}
                } else { //아이디 + 비밀번호 + 주민번호 13자리 이하 입력
//                	textNumber.setColleagueEnabled(false);
                	buttonOk.setColleagueEnabled(false);
                }
            } else { // 아이디만 입력
            	textNumber.setColleagueEnabled(false);
            	buttonOk.setColleagueEnabled(false);
            }
        } else { // 아무것도 입력 x
        	buttonOk.setColleagueEnabled(false);
        }
    	
    }
    private void usermemberChanged() {
    	char tmp;
    	String num;
    	boolean flag = true;
    	if (textNumber.getText().length() == 13) { // 아이디 + 비밀번호 + 주민번호 13자리 입력
        	num = textNumber.getText();
        	for (int i=0; i<num.length(); i++) {
        		tmp = num.charAt(i);
        		if (Character.isDigit(tmp) == false) { // 아이디 + 비밀번호 + 주민번호 13자리, 숫자로 입력
 						flag = false;
 						break;
				}
        	}
        	if (flag) {
        		buttonOk.setColleagueEnabled(true);
        	}
        	else {
        		buttonOk.setColleagueEnabled(false); // 아이디 + 비밀번호 + 주민번호 13자리 숫자 아님 입력
        	}
    	}
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}
