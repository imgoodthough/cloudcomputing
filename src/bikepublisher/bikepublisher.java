package bikepublisher;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import java.io.IOException;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;




public class bikepublisher {
	
	

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		
		
		
		String result = "";//json������ string ����
		String stationName = "";//��ġ�� �̸� ������ ����
		int parkingBikeTotCnt; // ������ ���� �� �Ǽ�
		String stationId = ""; //�뿩�� ID
		
		String result2 = "";//json������ string ����
		String stationName2 = "";//��ġ�� �̸� ������ ����
		int parkingBikeTotCnt2; // ������ ���� �� �Ǽ�
		String stationId2 = ""; //�뿩�� ID
		while(true) {
			try {
		//���� ���� �ð� �����
				Date date = new Date();
				SimpleDateFormat time= new SimpleDateFormat("yyyy/MM/dd HH:mm");
				String recordtime = time.format(date); // ���� �ð� ����
				DBConnect db = new DBConnect();
				DBConnect db2 = new DBConnect();
				
		//�ǽð� api���� ������ ������ �Ľ� �� ���
		
			
				URL url = new URL("http://openapi.seoul.go.kr:8088/6649487853726c613131336750435046/json/bikeList/90/90/"); //���ǳ��翪 1���ⱸ �� ������ �뿩��
				URL url2 = new URL("http://openapi.seoul.go.kr:8088/6649487853726c613131336750435046/json/bikeList/109/109/"); //����1 �������� ������ �뿩��
				BufferedReader bf;
				BufferedReader bf2;
				
				bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
				bf2 = new BufferedReader(new InputStreamReader(url2.openStream(), "UTF-8"));
				
				result = bf.readLine();
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
				JSONObject rentBikeStatus = (JSONObject)jsonObject.get("rentBikeStatus");
				JSONArray row = (JSONArray)rentBikeStatus.get("row");
				JSONObject rowinfo = (JSONObject)row.get(0); 
				
				stationName = rowinfo.get("stationName").toString(); // �뿩�� �̸� ����
				parkingBikeTotCnt = Integer.parseInt(rowinfo.get("parkingBikeTotCnt").toString()); // ������ ���� �� �Ǽ� int�� ����
				stationId = rowinfo.get("stationId").toString(); // �뿩�� ID ����
				
				
				result2 = bf2.readLine();
				JSONParser jsonParser2 = new JSONParser();
				JSONObject jsonObject2 = (JSONObject)jsonParser2.parse(result2);
				JSONObject rentBikeStatus2 = (JSONObject)jsonObject2.get("rentBikeStatus");
				JSONArray row2 = (JSONArray)rentBikeStatus2.get("row");
				JSONObject rowinfo2 = (JSONObject)row2.get(0); 
				
				stationName2 = rowinfo2.get("stationName").toString(); // �뿩�� �̸� ����
				parkingBikeTotCnt2 = Integer.parseInt(rowinfo2.get("parkingBikeTotCnt").toString()); // ������ ���� �� �Ǽ� int�� ����
				stationId2 = rowinfo2.get("stationId").toString(); // �뿩�� ID ����
				System.out.println(stationName2 + stationName);
				
				db.DBConnct(recordtime, stationName, parkingBikeTotCnt, stationId);
				db2.DBConnct(recordtime, stationName2, parkingBikeTotCnt2, stationId2);
				Thread.sleep(60000);
				//Thread.sleep(1800000);//30�п� �ѹ��� ����
				
	        	/*��¹� ����
	        	 * 
	        	 * System.out.println(stationName);//rowinfo.get("���⼭ ����") 
	        	System.out.println(parkingBikeTotCnt);
	        	System.out.println(stationId);
	        	System.out.println(recordtime);*/
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		//MongoClient mongoClient = new MongoClient(new ServerAddress("127.0.0.1", 27017));
		//DB db = mongoClient.getDB("bikeDB");
		
		

		
		/*while(true) {
    		String[] TRAIN_data  = get_TRAIN_data();  //�ǽð� ����ö api
    		System.out.println("{\"UPtrainLineNm\": \""+TRAIN_data[0]+"\"}"); 
        	System.out.println("{\"DNtrainLineNm\": \""+TRAIN_data[1]+"\"}"); 
        	System.out.println("{\"UPbravIDt\": "+TRAIN_data[2]+"}"); 
        	System.out.println("{\"DNbravIDt\": "+TRAIN_data[3]+"}"); 
        	System.out.println("{\"recptnDt\": \""+TRAIN_data[4]+"\"}"); 
        	try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}*/
		
	}
	

}
