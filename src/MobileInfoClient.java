import example.cn.com.webxml.MobileCodeWSSoap;
import example.cn.com.webxml.MobileCodeWS;

import java.util.Scanner;

public class MobileInfoClient {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("�����������ֻ�����: ");
            String mobileCode = scanner.nextLine();

            if(mobileCode.equals("-1")){
                break;
            }
            String mobileCodeInfo = getMobileCodeInfo(mobileCode);
            System.out.println("��ѯ�ɹ���������ϢΪ: " + mobileCodeInfo);
        }


        scanner.close();
    }


    private static String getMobileCodeInfo(String mobileCode) {
        try {

            MobileCodeWS mobileCodeWS = new MobileCodeWS();
            MobileCodeWSSoap mobileCodeWSSoap = mobileCodeWS.getMobileCodeWSSoap();

            return mobileCodeWSSoap.getMobileCodeInfo(mobileCode, "");
        } catch (Exception e) {
            e.printStackTrace();
            return "��ѯʧ��,ʧ����Ϣ��" + e.getMessage();
        }
    }
}