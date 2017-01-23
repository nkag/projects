import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


public class Login {
public LoginBean loginValidator(String uname,String pwd)
{

	MongoClient mongo = null;
	try {
		mongo = new MongoClient( "localhost" , 27017 );
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	DB database = mongo.getDB("test");
	DBCollection coll = database.getCollection("login");
	BasicDBObject query=new BasicDBObject();
	query.append("uname", uname);
	query.append("pwd", pwd);
//{ $or: [ { quantity: { $lt: 20 } }, { price: 10 } ] } 	
	DBCursor results = coll.find(query);
	LoginBean lb= new LoginBean();
	
	for(DBObject t:results)
	{
		System.out.println(t);
		lb.setCorrect(true);
		String validated=(String) t.get("approved");
		
		if(validated.equals("yes"))
		{
			lb.setValidated(true);
		}
		else
		{
			lb.setValidated(false);
		}
		return lb;
	}
return new LoginBean()	;

}
public static void main(String s[])
{
	Login l= new Login();
	 LoginBean t = l.loginValidator("neha", "578578");
	System.out.println(t);
}
public void register(String uname, String pwd) {
	// TODO Auto-generated method stub
	MongoClient mongo = null;
	try {
		mongo = new MongoClient( "localhost" , 27017 );
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	DB database = mongo.getDB("test");
	DBCollection coll = database.getCollection("login");
	BasicDBObject query=new BasicDBObject();
	query.append("uname", uname);
	query.append("pwd", pwd);
	query.append("approved", "no");
	coll.insert(query);
}
}
