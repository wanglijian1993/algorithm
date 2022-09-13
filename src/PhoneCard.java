public class PhoneCard {

    private String cardNum; //卡号
    private String pwd; //密码
    private double balance; //余额

    private boolean isConnectPhone; //连接卡号

    public PhoneCard(String cardNum, String pwd, double balance) {
        this.cardNum = cardNum;
        this.pwd = pwd;
        this.balance = balance;
    }

    /**
     * 输入卡号
     */
    public void inputCardNum(String cardNum,String pwd){
        if(cardNum.equals(pwd)){
           isConnectPhone=true;
            System.out.println("连接成功");

        }else{
            System.out.println("输入的卡号密码不正确");
        }
    }

    public void callPhone(){
        if(isConnectPhone) {
            balance -= 0.5;
        }else{
            System.out.println("未连接卡号");

        }

    }
}
